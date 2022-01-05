package cyb.ot.javabackend.girajava14kt.role.util;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import cyb.ot.javabackend.girajava14kt.role.dto.GroupRoleDTO;
import cyb.ot.javabackend.girajava14kt.role.model.GroupRole;

public class GroupRoleConverter {

	public static List<GroupRoleDTO> toGroupRoleDTOs(List<GroupRole> grouproles) {
		List<GroupRoleDTO> grouproleDTOs = new ArrayList<GroupRoleDTO>();
		for(GroupRole grouprole : grouproles) {
			grouproleDTOs.add(GroupRoleConverter.toGroupRoleDTO(grouprole));
		}
		
		return grouproleDTOs;
	}

	public static GroupRoleDTO toGroupRoleDTO(GroupRole grouprole) {
		return GroupRoleDTO.builder()
				.id(grouprole.getId())
				.name(grouprole.getName())
				.code(grouprole.getCode())
				.description(grouprole.getDescription())
				.build();
	}

	public static GroupRole toGroupRole(@Valid GroupRoleDTO dto) {
		return GroupRole.builder()
				.name(dto.getName())
				.code(dto.getCode())
				.description(dto.getDescription())
				.build();
	}

}
