package cyb.ot.javabackend.girajava14kt.role.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cyb.ot.javabackend.girajava14kt.role.dto.RoleDTO;
import cyb.ot.javabackend.girajava14kt.role.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	@Query("SELECT r.id as id, r.name as name, r.description as description FROM Role r")
	List<RoleDTO> findAllDTO();

	Optional<Role> findByName(String roleName);

	Optional<Role> findByCode(String roleCode);
}
