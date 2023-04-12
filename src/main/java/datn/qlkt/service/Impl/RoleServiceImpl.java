package datn.qlkt.service.Impl;

import datn.qlkt.model.Role;
import datn.qlkt.model.RoleName;
import datn.qlkt.repository.RoleRepository;
import datn.qlkt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
