package unimoove.users;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import unimoove.api.users.UserResponse;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserResponse userToUserResponse(User user);
}
