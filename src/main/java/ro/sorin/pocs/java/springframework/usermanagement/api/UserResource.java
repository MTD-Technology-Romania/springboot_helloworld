package ro.sorin.pocs.java.springframework.usermanagement.api;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ro.sorin.pocs.java.springframework.usermanagement.service.UserException;
import ro.sorin.pocs.java.springframework.usermanagement.service.UserRepository;

@Slf4j
@RestController
@RequestMapping(path = "/users")
public class UserResource {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public UserResource(
      final UserRepository ur,
      final UserMapper um) {
    this.userRepository = ur;
    this.userMapper = um;
  }

  @PostMapping(path = "/",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.TEXT_PLAIN_VALUE)
  public ResponseEntity<String> create(@RequestBody final UserDto userDto) {
    log.info("Create user: {}", userDto);
    final var user = userMapper.toEntity(userDto);
    final var identifier = userRepository.create(user);
    final var location = ServletUriComponentsBuilder
        .fromCurrentRequest().path("/{id}")
        .buildAndExpand(identifier).toUri();

    return ResponseEntity.created(location).body("{}");
  }

  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserDto> findUser(@PathVariable Long id) {
    log.info("Find user by identifier: {}", id);
    return userRepository.findBy(id)
        .map(user ->
            ResponseEntity.ok().body(userMapper.toDto(user)))
        .orElseThrow(() -> new UserException("Unknown identifier: " + id));
  }

  @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<UserDto>> findAll() {
    log.info("Find all users");
    final var dtos = userRepository.find()
        .stream()
        .map(userMapper::toDto)
        .collect(Collectors.toList());

    return ResponseEntity.ok(dtos);
  }

  @PutMapping(path = "/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserDto> replaceUser(@RequestBody final UserDto newUserDto,
      @PathVariable Long id) {
    log.info("Update user with identifier: {}", id);
    return userRepository.findBy(id)
        .map(user -> {
          final var newUser = userMapper.toEntity(newUserDto);
          newUser.setId(user.getId());
          userRepository.create(newUser);
          log.debug("User {}, updated properly", newUser);

          return ResponseEntity.ok().body(newUserDto);
        })
        .orElseThrow(() -> new UserException("Unknown user: " + id));
  }


}
