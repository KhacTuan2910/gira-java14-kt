package cyb.ot.javabackend.girajava14kt.role.util;

import java.util.ArrayList;
import java.util.List;

import cyb.ot.javabackend.girajava14kt.role.dto.RoleDTO;
import cyb.ot.javabackend.girajava14kt.role.model.Role;

public class RoleConverter {
	public static RoleDTO toRoleDTO(Role role) {
		return RoleDTO.builder()
			.id(role.getId())
			.name(role.getName())
			.code(role.getCode())
			.description(role.getDescription())
			.build();
	}
	
	public static List<RoleDTO> toRoleDTOs(List<Role> roles) {
		List<RoleDTO> roleDTOs = new ArrayList<RoleDTO>();
		for(Role role :roles) {
			roleDTOs.add(RoleConverter.toRoleDTO(role));
		}
		
		return roleDTOs;
	}

	public static Role toRole(RoleDTO dto) {
		return Role.builder()
				.name(dto.getName())
				.code(dto.getCode())
				.description(dto.getDescription())
				.build();
	}
	
}
