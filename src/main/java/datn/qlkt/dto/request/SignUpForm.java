package datn.qlkt.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter @Setter
public class SignUpForm {
    private String name;
    private String username;
    private String email;
    private String password;
    private Set<String> roles;

    public SignUpForm() {
    }

    public SignUpForm(String name, String username, String email, String password, Set<String> roles) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }


}
