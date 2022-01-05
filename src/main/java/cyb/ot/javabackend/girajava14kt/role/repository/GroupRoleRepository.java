package cyb.ot.javabackend.girajava14kt.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cyb.ot.javabackend.girajava14kt.role.model.GroupRole;

@Repository
public interface GroupRoleRepository extends JpaRepository<GroupRole, Long>{

	
	
}
