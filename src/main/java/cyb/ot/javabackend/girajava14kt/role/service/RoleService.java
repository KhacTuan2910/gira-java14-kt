package cyb.ot.javabackend.girajava14kt.role.service;

import java.util.List;

import cyb.ot.javabackend.girajava14kt.role.dto.RoleDTO;

public interface RoleService {
	List<RoleDTO> findAllDTO();

	RoleDTO create(RoleDTO dto);
}
