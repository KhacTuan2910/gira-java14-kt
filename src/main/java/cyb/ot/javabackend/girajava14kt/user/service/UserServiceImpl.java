package cyb.ot.javabackend.girajava14kt.user.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cyb.ot.javabackend.girajava14kt.user.dto.CreateUserDTO;
import cyb.ot.javabackend.girajava14kt.user.dto.UserMapper;
import cyb.ot.javabackend.girajava14kt.user.model.User;
import cyb.ot.javabackend.girajava14kt.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repository;
	
	@Override
	public User getUserById(long id) {
		Optional<User> userOpt = repository.findById(id);
		
		if (userOpt.isPresent()) 
			return userOpt.get();
		
		return null;
	}

	@Override
	public CreateUserDTO create(@Valid CreateUserDTO dto) {
		User user  = UserMapper.INSTANCE.createUserDTOToUserEntity(dto);
		
		User createdUser = repository.save(user);
		
		return UserMapper.INSTANCE.userEntityToCreateUserDTO(createdUser);
	}

}
