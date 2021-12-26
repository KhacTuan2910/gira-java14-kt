package cyb.ot.javabackend.girajava14kt.role.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cyb.ot.javabackend.girajava14kt.role.dto.RoleDTO;
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
		// TODO Auto-generated method stub
		return repository.findByCode(roleCode);
	}
	
	
	
}
