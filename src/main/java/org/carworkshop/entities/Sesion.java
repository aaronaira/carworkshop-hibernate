package org.carworkshop.entities;

import jakarta.persistence.*;
import lombok.ToString;

import java.time.Instant;

@ToString
@Entity
@Table(name = "sesion", indexes = {
        @Index(name = "id_usuario_UNIQUE", columnList = "id_usuario", unique = true)
})
public class Sesion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private Cliente cliente;

    @Column(name = "dt_iniciosesion", nullable = false)
    private Instant dtIniciosesion;

    @Column(name = "dt_finsesion", nullable = false)
    private Instant dtFinsesion;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Instant getDtIniciosesion() {
        return dtIniciosesion;
    }

    public void setDtIniciosesion(Instant dtIniciosesion) {
        this.dtIniciosesion = dtIniciosesion;
    }

    public Instant getDtFinsesion() {
        return dtFinsesion;
    }

    public void setDtFinsesion(Instant dtFinsesion) {
        this.dtFinsesion = dtFinsesion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

}