package com.ankit.admin.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ankit.admin.model.Counter;



public class UserPrincipal implements UserDetails {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
    private String counterName;  
     
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long id, String counterName, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
      
        this.counterName = counterName;        
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrincipal create(Counter counter) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(counter.getCounterType().getCounterType()));
       

        return new UserPrincipal(
        		counter.getId(),             
        		counter.getCounterName(),
        		counter.getPassword(),
                authorities
        );
    }

    public Long getId() {
        return id;
    }

    

   

  

    public String getCounterName() {
		return counterName;
	}

	public void setCounterName(String counterName) {
		this.counterName = counterName;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return counterName;
	}

   
}
