package org.carworkshop.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name = "sesion")
public class Sesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dt_iniciosesion")
    private Date dtIniciosesion;

    @Column(name = "dt_finsesion")
    private Date dtFinsesion;

    @ManyToOne(targetEntity = Cliente.class)
    @JoinColumn(name = "id_cliente")
    private Cliente id_cliente;

    public Cliente getCliente() {
        return id_cliente;
    }

    public void setCliente(Cliente cliente) {
        this.id_cliente = cliente;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setDtIniciosesion(Date dtIniciosesion) {
        this.dtIniciosesion = dtIniciosesion;
    }

    public Date getDtIniciosesion() {
        return dtIniciosesion;
    }

    public void setDtFinsesion(Date dtFinsesion) {
        this.dtFinsesion = dtFinsesion;
    }

    public Date getDtFinsesion() {
        return dtFinsesion;
    }


    @Override
    public String toString() {
        return "Sesion{" +
                "id=" + id + '\'' +
                "dtIniciosesion=" + dtIniciosesion + '\'' +
                "dtFinsesion=" + dtFinsesion + '\'' +
                "idCliente=" + id_cliente + '\'' +
                '}';
    }
}