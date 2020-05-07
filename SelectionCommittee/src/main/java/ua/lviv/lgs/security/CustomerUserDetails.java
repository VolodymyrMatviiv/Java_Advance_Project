package ua.lviv.lgs.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import ua.lviv.lgs.domain.User;

public class CustomerUserDetails extends User implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	List<String> userRoles;
	
	 public CustomerUserDetails(User user, List<String> userRoles) {
		super(user);
		this.userRoles = userRoles;
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		String roles = StringUtils.collectionToCommaDelimitedString(userRoles);		
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}
	
	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}