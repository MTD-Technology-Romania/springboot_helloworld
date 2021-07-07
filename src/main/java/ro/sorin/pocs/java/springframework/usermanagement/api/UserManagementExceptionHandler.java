package ro.sorin.pocs.java.springframework.usermanagement.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import ro.sorin.pocs.java.springframework.usermanagement.service.UserException;

@Slf4j
@ControllerAdvice
public class UserManagementExceptionHandler {

  @ExceptionHandler(value = {UserException.class})
  public ResponseEntity<ErrorDto> handleUserException(UserException ex, WebRequest request) {
    log.error("Error ", ex);
    final var error = new ErrorDto();
    error.setErrorId("1");
    error.setErrorMessage(ex.getMessage());

    return ResponseEntity.badRequest().body(error);
  }

  @ExceptionHandler(value = {RuntimeException.class})
  public ResponseEntity<ErrorDto> handleGenericException(RuntimeException ex, WebRequest request) {
    log.error("Error ", ex);
    final var error = new ErrorDto();
    error.setErrorId("2");
    error.setErrorMessage(ex.getMessage());

    return ResponseEntity.badRequest().body(error);
  }

}
