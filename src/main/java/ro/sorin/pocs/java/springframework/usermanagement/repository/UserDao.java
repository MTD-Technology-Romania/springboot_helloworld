package ro.sorin.pocs.java.springframework.usermanagement.repository;

import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import ro.sorin.pocs.java.springframework.usermanagement.service.User;
import ro.sorin.pocs.java.springframework.usermanagement.service.UserRepository;

@Slf4j
public class UserDao implements UserRepository {

  private final UserSpringJpa userSpringJpa;

  public UserDao(
      final UserSpringJpa usJpa) {
    this.userSpringJpa = usJpa;
  }

  @Override
  public Long create(User user) {
    final var savedUser = userSpringJpa.save(user);
    log.debug("Create user with success");

    return savedUser.getId();
  }

  @Override
  public Optional<User> findBy(Long id) {
    final var userOpt = userSpringJpa.findById(id);
    log.debug("Find with success user with identifier: {}", id);

    return userOpt;
  }

  @Override
  public List<User> find() {
    final var users = userSpringJpa.findAll();
    final long usersNumber = users.size();
    log.debug("Retrieve {} users from storage", usersNumber);

    return users;
  }

  @Override
  public Optional<User> update(User user) {
    final var updatedUser = userSpringJpa.save(user);
    log.debug("Update with success user: {}", updatedUser);

    return Optional.ofNullable(updatedUser);
  }


  /*

  private final EntityManager entityManager;

  public UserDao(final EntityManager em) {
    this.entityManager = em;
  }

  @Transactional
  @Override
  public String create(User user) {
    try {
      entityManager.persist(user);
      log.debug("Persist user: {}", user);

      return "1";
    } catch (Exception x) {
      throw new UserException(x);
    }
  }

  @Transactional
  @Override
  public Optional<User> findBy(String id) {
    try {
      final var query = "SELECT u FROM User u WHERE u.id = ?1";
      final var user = entityManager.createQuery(query, User.class)
          .setParameter(1, id)
          .getSingleResult();
      log.debug("For id: {} find user: {}", id, user);

      return Optional.ofNullable(user);
    } catch (Exception x) {
      throw new UserException(x);
    }
  }

  @Transactional
  @Override
  public List<User> find() {
    try {
      final var query = "SELECT u FROM User u";
      final var users = entityManager.createQuery(query, User.class).getResultList();
      log.debug("Found {} users", users.size());

      return users;
    } catch (Exception x) {
      throw new UserException(x);
    }
  }

  @Transactional
  @Override
  public Optional<User> update(User user) {
    try {
      entityManager.persist(user);
      entityManager.merge(user);

      return Optional.empty();
    } catch (Exception x) {
      throw new UserException(x);
    }
  }

  */

}
