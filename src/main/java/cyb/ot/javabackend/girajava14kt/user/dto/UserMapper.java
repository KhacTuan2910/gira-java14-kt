package cyb.ot.javabackend.girajava14kt.user.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cyb.ot.javabackend.girajava14kt.user.model.User;

@Mapper
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper (UserMapper.class);
	
	User createUserDTOToUserEntity (CreateUserDTO dto);
	
	CreateUserDTO userEntityToCreateUserDTO (User entity);

}
