package datn.qlkt.controller;

import datn.qlkt.dto.dtos.UserFilter;
import datn.qlkt.dto.request.SignUpForm;
import datn.qlkt.entities.ErrorCode;
import datn.qlkt.entities.MyResponse;
import datn.qlkt.model.User;
import datn.qlkt.service.Impl.UserServiceImpl;
import datn.qlkt.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Log4j2
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/search")
    public MyResponse<?> searchUser(UserFilter userFilter) throws Exception {
        var page = userService.searchUser(userFilter);
        return MyResponse.response(page);
    }

    @PutMapping("/update/{id}")
    public MyResponse<?> updateUser(@Valid @RequestBody SignUpForm user, @PathVariable Long id)throws Exception {
        try {
            userService.updateUser(user, id);
            return MyResponse.response(ErrorCode.UPDATED_OK.getCode(), ErrorCode.UPDATED_OK.getMsgError());
        }catch (Exception ex) {
            return MyResponse.response(ErrorCode.UPDATED_FAIL.getCode(),ErrorCode.UPDATED_FAIL.getMsgError());
        }
    }

    @GetMapping("/findId/{id}")
    public MyResponse<?> findById(@PathVariable Long id) throws Exception {
        var user = userService.findById(id);
        return MyResponse.response(user);
    }

}
