package ro.sorin.pocs.java.springframework.usermanagement.api;


import lombok.Data;

@Data
public class UserDto {

  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String phone;
}
