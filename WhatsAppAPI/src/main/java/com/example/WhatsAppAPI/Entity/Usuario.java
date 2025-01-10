package com.example.WhatsAppAPI.Entity;

import jakarta.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String celular;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "status", nullable = false)
    private String status = "A";

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

    @OneToMany(mappedBy = "usuario")
    private List<Estado> estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {

        if (!"A".equals(status) && !"I".equals(status)){
            throw new IllegalArgumentException("El status debe ser 'A' (Activo) o 'I' (Inactivo). ");
        }

        this.status = status;
    }

    public Long getUsuario_creacion() {
        return usuario_creacion;
    }

    public void setUsuario_creacion(Long usuario_creacion) {
        this.usuario_creacion = usuario_creacion;
    }

    public String getId_creacion() {
        return id_creacion;
    }

    public void setId_creacion(String id_creacion) {
        this.id_creacion = id_creacion;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Long getUsuario_modificacion() {
        return usuario_modificacion;
    }

    public void setUsuario_modificacion(Long usuario_modificacion) {
        this.usuario_modificacion = usuario_modificacion;
    }

    public String getId_modificacion() {
        return id_modificacion;
    }

    public void setId_modificacion(String id_modificacion) {
        this.id_modificacion = id_modificacion;
    }

    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public List<Estado> getEstado() {
        return estado;
    }

    public void setEstado(List<Estado> estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id,usuario.id) && Objects.equals(celular, usuario.celular)
                && Objects.equals(nombre, usuario.nombre)&& Objects.equals(usuario_creacion, usuario.usuario_creacion)
                && Objects.equals(id_creacion, usuario.id_creacion)&& Objects.equals(usuario_modificacion, usuario.usuario_modificacion)
                && Objects.equals(id_modificacion, usuario.id_modificacion);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, estado);
    }
}
