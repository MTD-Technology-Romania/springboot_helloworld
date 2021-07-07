package ro.sorin.pocs.java.springframework.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sorin.pocs.java.springframework.usermanagement.service.User;

public interface UserSpringJpa extends JpaRepository<User, Long> {

}
