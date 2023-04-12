package datn.qlkt.dto.reponse;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter @Setter
public class JwtResponse {

    private long id;
    private String token;
    private String type = "Bearer";
    private String  name;
    private Collection<? extends GrantedAuthority> roles;

    public JwtResponse(){

    }

    public JwtResponse(long id, String token, String type, String name, Collection<? extends GrantedAuthority> roles) {
        this.id = id;
        this.token = token;
        this.type = type;
        this.name = name;
        this.roles = roles;
    }

    public JwtResponse(String token, String name, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.name = name;
        this.roles = authorities;
    }
}
