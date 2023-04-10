package org.carworkshop.entities;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

@ToString
@Entity
@Table(name = "login", indexes = {
        @Index(name = "email_UNIQUE", columnList = "email", unique = true)
})
public class Login  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @OneToOne(mappedBy = "email", cascade = CascadeType.ALL)
    private Cliente cliente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {

        if(this.cliente != null) this.cliente = cliente;
        this.cliente = null;
    }

}