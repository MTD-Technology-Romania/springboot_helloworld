package ro.sorin.pocs.java.springframework.usermanagement.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "User", schema = "hello_world_poc")

@Getter
@Setter
//@RequiredArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

  @Column(name = "first_name")
  private @NonNull String firstName;
  @Column(name = "last_name")
  private @NonNull String lastName;
  @Column(name = "email")
  private @NonNull String email;
  @Column(name = "password")
  private @NonNull String password;
  @Column(name = "phone")
  private @NonNull String phone;

  @Id
  @SequenceGenerator(name = "userSequence", sequenceName = "hello_world_poc.user_identifier_seq",
      allocationSize = 1, initialValue = 1)
  @GeneratedValue(generator = "userSequence")
  public Long getId() {
    return id;
  }

    /*
    public void checkConstraints() {
        if (this.firstName.isBlank())
            throw new QuarkusHW_Exception("user first name is blank");
        if (this.lastName.isBlank())
            throw new QuarkusHW_Exception("user last name is blank");
        if (this.email.isBlank())
            throw new QuarkusHW_Exception("user email is blank");
        if (this.phone.isBlank())
            throw new QuarkusHW_Exception("user phone is blank");
    }
     */

    /*
    public boolean withSame(final String email){
        Objects.requireNonNull(email, "Email null");
        return this.email.equals(email);
    }
     */
}
