package unimoove.users;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import unimoove.api.users.UserRegistrationRequest;
import unimoove.api.users.UserResponse;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserResponse userToUserResponse(User user);
	
	@Mapping(target = "authorities", ignore = true)
	@Mapping(target = "cars", ignore = true)
	@Mapping(target = "trips", ignore = true)
	User userRegistrationRequestToUser(UserRegistrationRequest userRegistrationRequest);

}
