package datn.qlkt.service.Impl;
import datn.qlkt.dto.dtos.UserFilter;
import datn.qlkt.model.User;
import datn.qlkt.page.Ipage;
import datn.qlkt.repository.CustomerBaseRepository;
import datn.qlkt.repository.UserRepository;
import datn.qlkt.service.UserService;
import datn.qlkt.ultis.DataPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public Optional<User> findByUsername(String name) {
        return userRepository.findByUsername(name);
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
}
