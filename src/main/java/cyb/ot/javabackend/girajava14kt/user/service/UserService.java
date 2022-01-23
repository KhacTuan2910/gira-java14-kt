package cyb.ot.javabackend.girajava14kt.user.service;

import javax.validation.Valid;

import cyb.ot.javabackend.girajava14kt.user.dto.CreateUserDTO;
import cyb.ot.javabackend.girajava14kt.user.model.User;

public interface UserService {
	User getUserById(long id);

	CreateUserDTO create(@Valid CreateUserDTO dto);
}
