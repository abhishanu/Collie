package frnds.collie.services.collie.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import frnds.collie.services.collie.dao.Role;
import frnds.collie.services.collie.enums.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(RoleName roleName);

	Optional<Role> findByRoleId(Integer roleId);
}
