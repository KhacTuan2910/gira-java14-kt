package cyb.ot.javabackend.girajava14kt.role.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import cyb.ot.javabackend.girajava14kt.common.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "gira_role")
public class Role extends BaseEntity {
	@Column(name = "name", unique = true)
	private String name;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "code", unique = true)
	private String code;
	
	@ManyToMany(mappedBy = "roles")
	private Set<GroupRole> groups = new LinkedHashSet<GroupRole>();
}
