package ro.sorin.pocs.java.springframework.usermanagement.service;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

  Long create(User user);

  Optional<User> findBy(Long id);

  List<User> find();

  Optional<User> update(User user);
}
