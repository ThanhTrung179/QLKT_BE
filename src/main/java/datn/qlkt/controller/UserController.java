package datn.qlkt.controller;

import datn.qlkt.dto.dtos.UserFilter;
import datn.qlkt.entities.ErrorCode;
import datn.qlkt.entities.MyResponse;
import datn.qlkt.model.User;
import datn.qlkt.service.Impl.UserServiceImpl;
import datn.qlkt.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/update/{id}")
    public MyResponse<?> updateUser(User user, Long id)throws Exception {
        try {
            userService.updateUser(user, id);
            return MyResponse.response(ErrorCode.UPDATED_OK.getCode(), ErrorCode.UPDATED_OK.getMsgError());
        }catch (Exception ex) {
            return MyResponse.response(ErrorCode.UPDATED_FAIL.getCode(),ErrorCode.UPDATED_FAIL.getMsgError());
        }
    }
}
