package art.timestop.todos.entities;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Embeddable;

@Embeddable 
public class Authority implements GrantedAuthority {

    private String authority;

    public Authority() {}

    

    public Authority(String authority) {
        this.authority = authority;
    }



    @Override
    public @Nullable String getAuthority() {
       return null;
    }

}
