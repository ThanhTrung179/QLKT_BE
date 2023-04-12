package datn.qlkt.service.Impl;

import datn.qlkt.dto.dtos.UserFilter;
import datn.qlkt.model.User;
import datn.qlkt.page.Ipage;
import datn.qlkt.repository.UserRepository;
import datn.qlkt.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public Page<?> searchUser(UserFilter userFilter) throws Exception{
        log.info("--------- search workname -----------");
        Pageable pageable = PageRequest.of(userFilter.page(), userFilter.size());
        Page<?> result;
//        result = userRepository.getAllUser(userFilter);
        result = null;
        return result;
    }
}
