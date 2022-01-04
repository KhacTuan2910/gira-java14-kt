package cyb.ot.javabackend.girajava14kt.role.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cyb.ot.javabackend.girajava14kt.common.exception.NotFoundException;
import cyb.ot.javabackend.girajava14kt.role.dto.RoleDTO;
import cyb.ot.javabackend.girajava14kt.role.dto.UpdateRoleDTO;
import cyb.ot.javabackend.girajava14kt.role.exception.InvalidRoleException;
import cyb.ot.javabackend.girajava14kt.role.model.Role;
import cyb.ot.javabackend.girajava14kt.role.repository.RoleRepository;
import cyb.ot.javabackend.girajava14kt.role.util.RoleConverter;

@Service
public class RoleServiceImpl implements RoleService {
	private RoleRepository repository;
	
	public RoleServiceImpl(RoleRepository roleRepository) {
		repository = roleRepository;
	}

	@Override
	public List<RoleDTO> findAllDTO() {
		List<Role> roles = repository.findAll();
		
		if (roles.isEmpty()) {
			throw new NotFoundException("This is for test only.");
		}
		
//		List<RoleDTO> roleDTOs = new ArrayList<RoleDTO>();
//		for(Role role :roles) {
//			roleDTOs.add(RoleConverter.toRoleDTO(role));
//		}
		
		return RoleConverter.toRoleDTOs(roles);
	}

	@Override
	public RoleDTO create(RoleDTO dto) {
		Role role = RoleConverter.toRole(dto);
//		role.setId(dto.getId());
		
		Role createdRole = repository.save(role);
		
		return RoleConverter.toRoleDTO(createdRole);
	}

	@Override
	public Optional<Role> findByName(String roleName) {
		return repository.findByName(roleName);
	}

	@Override
	public Optional<Role> findByCode(String roleCode) {
		
		return repository.findByCode(roleCode);
	}

	@Override
	public RoleDTO updateRole(long id, UpdateRoleDTO dto) {
		Optional<Role> roleOpt = repository.findById(id);
		
		if (!roleOpt.isPresent()) {
			throw new InvalidRoleException("Role id is invalid");
		}

		Role role = roleOpt.get();
		
		if (!role.getName().equals(dto.getName())) {
			if (repository.findByName(dto.getName()).isPresent()) {
				throw new InvalidRoleException("Role name has been used.");
			
			}
			role.setName(dto.getName());;
		}
		
		if (!role.getCode().equals(dto.getCode())) {
			if (repository.findByCode(dto.getCode()).isPresent()) {
				throw new InvalidRoleException("Role code has been used.");
			
			}
			role.setCode(dto.getCode());;
		}
		
		role.setDescription(dto.getDescription());
		
		Role updatedRole = repository.save(role);
		
		String errors = "";
		
		return RoleConverter.toRoleDTO(updatedRole);
	}

	@Override
	public void deleteRole(long id) {
		Optional<Role> roleOpt = repository.findById(id);
		
		if (!roleOpt.isPresent()) {
			throw new InvalidRoleException("role ID is not existed.");
		}
		
		repository.delete(roleOpt.get());
		
	}
	
	
	
}
