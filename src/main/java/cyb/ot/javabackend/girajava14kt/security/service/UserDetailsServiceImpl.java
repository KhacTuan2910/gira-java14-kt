package cyb.ot.javabackend.girajava14kt.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cyb.ot.javabackend.girajava14kt.role.model.GroupRole;
import cyb.ot.javabackend.girajava14kt.security.dto.CustomUserDetails;
import cyb.ot.javabackend.girajava14kt.user.model.User;
import cyb.ot.javabackend.girajava14kt.user.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOpt = repository.findByUsername(username);
		
		if (!userOpt.isPresent()) {
			throw new UsernameNotFoundException("Username is not existed!");
		}
		
		User currUser = userOpt.get();
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.addAll(getAuthorities(currUser));
		
		return new CustomUserDetails(currUser.getUsername(), currUser.getPassword(), authorities);
	}

	private Collection<? extends GrantedAuthority> getAuthorities(final User currUser) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (GroupRole group : currUser.getGroups()) {
			authorities.add(new SimpleGrantedAuthority(group.getName()));
		}
		
		return authorities;
	}

}
