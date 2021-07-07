package ro.sorin.pocs.java.springframework.usermanagement.api;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import ro.sorin.pocs.java.springframework.usermanagement.service.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "created", ignore = true),
            @Mapping(target = "updated", ignore = true)
    })
    User toEntity(UserDto dto);

    UserDto toDto(User entity);
}
