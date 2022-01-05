package cyb.ot.javabackend.girajava14kt.role.service;

import java.util.List;

import javax.validation.Valid;

import cyb.ot.javabackend.girajava14kt.role.dto.GroupRoleDTO;

public interface GroupRoleService {

	List<GroupRoleDTO> findAllDTO();

	GroupRoleDTO create(@Valid GroupRoleDTO dto);

}
