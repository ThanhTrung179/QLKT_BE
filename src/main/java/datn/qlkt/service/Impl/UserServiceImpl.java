package datn.qlkt.service.Impl;
import datn.qlkt.dto.dtos.UserFilter;
import datn.qlkt.dto.request.SignUpForm;
import datn.qlkt.model.Role;
import datn.qlkt.model.RoleName;
import datn.qlkt.model.User;
import datn.qlkt.page.Ipage;
import datn.qlkt.repository.CustomerBaseRepository;
import datn.qlkt.repository.UserRepository;
import datn.qlkt.service.RoleService;
import datn.qlkt.service.UserService;
import datn.qlkt.ultis.DataPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleServiceImpl roleService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public Optional<User> findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Boolean existsByUsername(String name) {
        return userRepository.existsByUsername(name);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Page<User> searchUser(UserFilter userFilter) throws Exception{
        log.info("--------- search workname -----------");
        Pageable pageable = PageRequest.of(userFilter.page(), userFilter.size());
        var result = userRepository.getAllUserList(pageable,userFilter.name(), userFilter.email());
        return result;
    }

    @Override
    public User updateUser(SignUpForm user, Long id) throws Exception {
        log.info("--------update user---------");
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()) {
            throw new Exception("User không được update");
        }
        User user1 = optionalUser.get();
        Set<String> strRoles = user.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role ->{
            switch (role) {
                case "admin":
                    var test = RoleName.ADMIN;
                    Role adminRole = roleService.findByName(RoleName.ADMIN).orElseThrow(
                            ()-> new RuntimeException("Role not fount")
                    );
                    roles.add(adminRole);
                    break;
                case "pm":
                    Role pmRole = roleService.findByName(RoleName.PM).orElseThrow(
                            ()-> new RuntimeException("Role not fount")
                    );
                    roles.add(pmRole);
                    break;
                default:
                    Role userRole = roleService.findByName(RoleName.USER).orElseThrow(
                            ()-> new RuntimeException("Role not fount")
                    );
                    roles.add(userRole);
            }
        });
        user1.setRoles(roles);
        user1.setAddress(user.getAddress());
        user1.setBirth(user.getBirth());
        user1.setUsername(user.getUsername());
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        user1.setEmail(user.getEmail());
        user1.setName(user.getName());
        return userRepository.save(user1);
    }


}
