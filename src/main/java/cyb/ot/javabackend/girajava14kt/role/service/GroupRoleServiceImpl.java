package cyb.ot.javabackend.girajava14kt.role.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import cyb.ot.javabackend.girajava14kt.common.exception.NotFoundException;
import cyb.ot.javabackend.girajava14kt.role.dto.GroupRoleDTO;
import cyb.ot.javabackend.girajava14kt.role.model.GroupRole;
import cyb.ot.javabackend.girajava14kt.role.repository.GroupRoleRepository;
import cyb.ot.javabackend.girajava14kt.role.util.GroupRoleConverter;

@Service
public class GroupRoleServiceImpl implements GroupRoleService {
	private GroupRoleRepository repository;
	
	public GroupRoleServiceImpl(GroupRoleRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<GroupRoleDTO> findAllDTO() {
		List<GroupRole> grouproles = repository.findAll();
		
		if (grouproles.isEmpty()) {
			throw new NotFoundException("Grouprole is empty.");
		}
		
		return GroupRoleConverter.toGroupRoleDTOs(grouproles);
	}

	@Override
	public GroupRoleDTO create(@Valid GroupRoleDTO dto) {
		GroupRole groupRole = GroupRoleConverter.toGroupRole(dto);
		
		GroupRole createdGrouprole = repository.save(groupRole);
		return GroupRoleConverter.toGroupRoleDTO(createdGrouprole);
	}
	
}
