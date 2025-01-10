package com.example.WhatsAppAPI.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "ESTADOS")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USS")
    private Usuario usuario;

    private String contenido;

    private Long usuario_creacion;

    private String id_creacion;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_creacion;

    private Long usuario_modificacion;

    private String id_modificacion;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_modificacion;

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getId_creacion() {
        return id_creacion;
    }

    public void setId_creacion(String id_creacion) {
        this.id_creacion = id_creacion;
    }

    public String getId_modificacion() {
        return id_modificacion;
    }

    public void setId_modificacion(String id_modificacion) {
        this.id_modificacion = id_modificacion;
    }

    public Long getUsuario_modificacion() {
        return usuario_modificacion;
    }

    public void setUsuario_modificacion(Long usuario_modificacion) {
        this.usuario_modificacion = usuario_modificacion;
    }

    public Long getUsuario_creacion() {
        return usuario_creacion;
    }

    public void setUsuario_creacion(Long usuario_creacion) {
        this.usuario_creacion = usuario_creacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(id,estado.id) && Objects.equals(usuario, estado.usuario)
                && Objects.equals(contenido, estado.contenido) && Objects.equals(usuario_creacion, estado.usuario_creacion)
                && Objects.equals(id_creacion, estado.id_creacion) && Objects.equals(usuario_modificacion, estado.usuario_modificacion)
                && Objects.equals(id_modificacion, estado.id_modificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario);
    }
}
