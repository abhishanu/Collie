package frnds.collie.services.collie.security.configs;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import frnds.collie.services.collie.dao.Login;
import frnds.collie.services.collie.dao.UserDetailsImpl;

public class UserPrincipal implements UserDetails {
	private String userId;

	private String name;

	private String username;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserPrincipal(String useId, String name, String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.userId = useId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserPrincipal create(Login login, UserDetailsImpl user) {
		List<GrantedAuthority> authorities = login.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());

		String name = user.getFirstName() + " " + user.getMiddleName() + " " + user.getLastName();

		return new UserPrincipal(user.getUserId(), name, user.getUserName(), login.getPass(), authorities);
	}

	public String getId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserPrincipal that = (UserPrincipal) o;
		return Objects.equals(userId, that.userId);
	}

	@Override
	public int hashCode() {

		return Objects.hash(userId);
	}
}