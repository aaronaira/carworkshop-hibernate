package org.carworkshop.entities;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@ToString
@Entity
@Table(name = "piezas", schema = "carworkshop")
public class Pieza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @OneToMany(mappedBy = "idPieza")
    private Set<PiezasOt> piezasOts = new LinkedHashSet<>();

  //  @OneToMany(mappedBy = "idPieza")
  //  private Set<FacturaLineaMo> facturaLineaMos = new LinkedHashSet<>();

   // @OneToMany(mappedBy = "idPieza")
   // private Set<FacturaLineaPieza> facturaLineaPiezas = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}