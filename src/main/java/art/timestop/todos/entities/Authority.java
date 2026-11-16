package art.timestop.todos.entities;


import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;

import art.timestop.todos.enums.Role;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable 
public class Authority implements GrantedAuthority {

    private String authority;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Authority() {}

    
    public Authority(String authority, Role role) {
        this.authority = authority;
        this.role = role;
    }


    @Override
    public @Nullable String getAuthority() {
       return null;
    }


    public Role getRole() {
        return role;
    }

    
}
