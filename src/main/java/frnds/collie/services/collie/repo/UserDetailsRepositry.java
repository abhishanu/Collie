package frnds.collie.services.collie.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import frnds.collie.services.collie.dao.UserDetailsImpl;

public interface UserDetailsRepositry extends CrudRepository<UserDetailsImpl, String> {

	Optional<UserDetailsImpl> findByUserName(String userName);
}
