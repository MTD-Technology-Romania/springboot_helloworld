package ro.sorin.pocs.java.springframework.usermanagement.api;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorDto {

    private String errorId;
    private String errorMessage;
}
