package cyb.ot.javabackend.girajava14kt.role.service;

import java.util.List;
import java.util.Optional;

import cyb.ot.javabackend.girajava14kt.role.dto.RoleDTO;
import cyb.ot.javabackend.girajava14kt.role.model.Role;

public interface RoleService {
	List<RoleDTO> findAllDTO();

	RoleDTO create(RoleDTO dto);

	Optional<Role> findByName(String roleName);

	Optional<Role> findByCode(String roleCode);
}
