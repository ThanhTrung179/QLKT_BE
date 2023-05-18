package datn.qlkt.controller;

import datn.qlkt.dto.reponse.JwtResponse;
import datn.qlkt.dto.reponse.ResponseMessage;
import datn.qlkt.dto.request.SignInForm;
import datn.qlkt.dto.request.SignUpForm;
import datn.qlkt.entities.ErrorCode;
import datn.qlkt.entities.MyResponse;
import datn.qlkt.model.Role;
import datn.qlkt.model.RoleName;
import datn.qlkt.model.User;
import datn.qlkt.security.jwt.JwtProvider;
import datn.qlkt.security.userprical.UserPrinciple;
import datn.qlkt.service.Impl.RoleServiceImpl;
import datn.qlkt.service.Impl.UserServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@RequestMapping("/api/auth")
@RestController
@Log4j2
public class Authcontroller {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;
    @PostMapping("/signup")
    public MyResponse<?> register(@Valid @RequestBody SignUpForm singUpForm) {
        if(userService.existsByUsername(singUpForm.getUsername())) {
            return MyResponse.response(ErrorCode.CREATED_FAIL.getCode(), "username đã tồn tại");
        }
        if(userService.existsByEmail(singUpForm.getEmail())){
            return MyResponse.response(ErrorCode.CREATED_FAIL.getCode(), "email đã tồn tại");
        }
        try {
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = currentDate.format(formatter);
            LocalDateTime now = LocalDateTime.now();
            int minute = now.getMinute();
            int hour = now.getHour();
            var idUser = ("NV_" + formattedDate + hour + minute);
            User user = new User(singUpForm.getName(), singUpForm.getUsername(), singUpForm.getEmail(), passwordEncoder.encode(singUpForm.getPassword()), singUpForm.getAddress(), singUpForm.getGender(), singUpForm.getPhone(), singUpForm.getBirth(), idUser, singUpForm.getWorkingday());
            Set<String> strRoles = singUpForm.getRoles();
            Set<Role> roles = new HashSet<>();
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        var test = RoleName.ADMIN;
                        Role adminRole = roleService.findByName(RoleName.ADMIN).orElseThrow(
                                () -> new RuntimeException("Role not fount")
                        );
                        roles.add(adminRole);
                        break;
                    case "pm":
                        Role pmRole = roleService.findByName(RoleName.PM).orElseThrow(
                                () -> new RuntimeException("Role not fount")
                        );
                        roles.add(pmRole);
                        break;
                    default:
                        Role userRole = roleService.findByName(RoleName.USER).orElseThrow(
                                () -> new RuntimeException("Role not fount")
                        );
                        roles.add(userRole);
                }
            });
            user.setRoles(roles);
            user.setIsActive(1);
            userService.save(user);
            return MyResponse.response(ErrorCode.CREATED_OK.getCode(), ErrorCode.CREATED_OK.getMsgError());
        }
        catch (Exception e) {
            log.info(e);
            return MyResponse.response(ErrorCode.CREATED_FAIL.getCode(), "Thêm mới nhân viên thất bại");
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(token, userPrinciple.getName(), userPrinciple.getAuthorities()));
    }



}
