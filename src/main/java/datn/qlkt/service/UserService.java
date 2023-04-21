package datn.qlkt.service;

import datn.qlkt.dto.dtos.UserFilter;
import datn.qlkt.dto.request.SignUpForm;
import datn.qlkt.model.User;
import datn.qlkt.page.Ipage;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String name); //Tim kiem User co ton tai trong db khong

    Optional<User> findById(Long id);
    Boolean existsByUsername(String name); //Kiem tra username co ton tai tong db
    Boolean existsByEmail(String email); //Kiem tra email co ton tai trong db
    User save(User user);

    Page<?> searchUser(UserFilter userFilter) throws Exception;


    public User updateUser(SignUpForm user, Long id) throws Exception ;
}
