package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;

@Entity
public class UsuarioTeste extends AbstractEntity {

    @Column
    private String username;
    @Email
    @Column
    private String email;
    @Column
    private String name;
    @Column
    private String hashedPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
    
    
   
    

    public UsuarioTeste() {
    }

    public UsuarioTeste(String username, String email, String name, String hashedPassword) {
        this.username = username;
        this.email = email;
        this.name = name;
        this.hashedPassword = hashedPassword;
    }

}
