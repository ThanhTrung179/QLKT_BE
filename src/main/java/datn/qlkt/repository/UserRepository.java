package datn.qlkt.repository;

import datn.qlkt.dto.dtos.UserFilter;
import datn.qlkt.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String name); //Tim kiem User co ton tai trong db khong

    Boolean existsByUsername(String name); //Kiem tra username co ton tai tong db
    Boolean existsByEmail(String email); //Kiem tra email co ton tai trong db


    @Query(value = "SELECT u FROM User u where u.isActive = 1" +
     "And (:name IS NULL OR u.name like %:name%) " +
            "And (:email IS NULL OR u.email like %:email%) "
    )

    Page<User> getAllUserList(Pageable pageable, String name, String email);

}
