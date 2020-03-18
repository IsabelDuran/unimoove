package unimoove.users;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import unimoove.api.users.UserRegistrationRequest;
import unimoove.api.users.UserResponse;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserResponse userToUserResponse(User user);
	@Mapping(target = "cars", ignore = true)
	User userRegistrationRequestToUser(UserRegistrationRequest userRegistrationRequest);
}
