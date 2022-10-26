package main.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "marcas")
public class Marca implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String descripcion;
    String codigo;

    public Marca() {
    }

    public Marca(String descripcion, String codigo) {
        this.descripcion = descripcion;
        this.codigo = codigo;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Marca{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
