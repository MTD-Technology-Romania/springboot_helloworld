package ro.sorin.pocs.java.springframework.usermanagement.configuration;

//import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.sorin.pocs.java.springframework.usermanagement.repository.UserDao;
import ro.sorin.pocs.java.springframework.usermanagement.repository.UserSpringJpa;
import ro.sorin.pocs.java.springframework.usermanagement.service.UserRepository;

@Configuration
public class ApplicationBeansFactory {

//    @Inject
//    private EntityManager entityManager;


  @Bean
  public UserRepository userRepository(@Autowired UserSpringJpa userSpringJpa) {
    return new UserDao(userSpringJpa);
  }
}
