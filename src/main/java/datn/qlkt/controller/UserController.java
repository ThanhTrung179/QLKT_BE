package datn.qlkt.controller;

import datn.qlkt.dto.dtos.UserFilter;
import datn.qlkt.entities.MyResponse;
import datn.qlkt.model.User;
import datn.qlkt.service.Impl.UserServiceImpl;
import datn.qlkt.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
