package org.carworkshop.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name = "sesion")
public class Sesion {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dt_iniciosesion", nullable = false)
    private Date dtIniciosesion;

    @Column(name = "dt_finsesion", nullable = false)
    private Date dtFinsesion;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false, referencedColumnName = "id")
    private Cliente idCliente;

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

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

//    @Override
//    public String toString() {
//        return "Sesion{" +
//                "id=" + id + '\'' +
//                "dtIniciosesion=" + dtIniciosesion + '\'' +
//                "dtFinsesion=" + dtFinsesion + '\'' +
//                "idCliente=" + idCliente + '\'' +
//                '}';
//    }
}
