package unimoove.users;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import unimoove.api.users.UserRegistrationRequest;
import unimoove.api.users.UserResponse;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserResponse userToUserResponse(User user);
	@Mapping(target = "cars", ignore = true)
	User userRegistrationRequestToUser(UserRegistrationRequest userRegistrationRequest);

}
