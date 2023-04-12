package datn.qlkt.service;

import datn.qlkt.model.Role;
import datn.qlkt.model.RoleName;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(RoleName name);
}
