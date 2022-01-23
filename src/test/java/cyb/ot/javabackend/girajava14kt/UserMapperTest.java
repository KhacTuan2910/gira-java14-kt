package cyb.ot.javabackend.girajava14kt;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import cyb.ot.javabackend.girajava14kt.user.dto.CreateUserDTO;
import cyb.ot.javabackend.girajava14kt.user.dto.UserMapper;
import cyb.ot.javabackend.girajava14kt.user.model.User;

public class UserMapperTest {

	@Test
	public void shouldMapCreateUseDTOToUserEntity() {
		CreateUserDTO dto = new CreateUserDTO();
		dto.setUsername("user123");
		dto.setEmail("example@ex.com");
		dto.setEmail("P1234567");
		dto.setFullname("MrExample");
		
		User user = UserMapper.INSTANCE.createUserDTOToUserEntity(dto);
		
		assertThat(user.getUsername()).isEqualTo(dto.getUsername());
		assertThat(user.getPassword()).isEqualTo(dto.getPassword());
		assertThat(user.getEmail()).isEqualTo(dto.getEmail());
		assertThat(user.getFullname()).isEqualTo(dto.getFullname());
	}
}
