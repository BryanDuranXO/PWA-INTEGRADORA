package mx.edu.utez.Back_Hospital.Model.Enfermero;

import jakarta.persistence.*;
import mx.edu.utez.Back_Hospital.Model.Enfermeros_Camas.Enfermeros_Camas;
import mx.edu.utez.Back_Hospital.Model.Isla.IslaBean;
import mx.edu.utez.Back_Hospital.Model.Rol.RolBean;

import java.util.List;

@Entity
@Table(name = "enfermeros")
public class EnfermeroBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "materno")
    private String materno;

    @Column(name = "paterno")
    private String paterno;

    @Column(name = "telefono", length = 10)
    private String telefono;

    @Column(name = "token", columnDefinition = "TEXT")
    private String token;

    @Column(name = "status", columnDefinition = "BOOL")
    private Boolean status;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "password", columnDefinition = "TEXT")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol", nullable = false)
    private RolBean rolenfermero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_isla", nullable = false)
    private IslaBean isla;

    @OneToMany(mappedBy = "enfermero", fetch = FetchType.LAZY)
    private java.util.List<Enfermeros_Camas> asignacionesCamas;

    public EnfermeroBean() {
    }


    public EnfermeroBean(Long id, String nombre, String materno, String paterno, String telefono, String token, Boolean status, String usuario, String password, RolBean rolenfermero, IslaBean isla, List<Enfermeros_Camas> asignacionesCamas) {
        this.id = id;
        this.nombre = nombre;
        this.materno = materno;
        this.paterno = paterno;
        this.telefono = telefono;
        this.token = token;
        this.status = status;
        this.usuario = usuario;
        this.password = password;
        this.rolenfermero = rolenfermero;
        this.isla = isla;
        this.asignacionesCamas = asignacionesCamas;
    }

    public EnfermeroBean(String nombre, String materno, String paterno, String telefono, String token, Boolean status, String usuario, String password, RolBean rolenfermero, IslaBean isla, List<Enfermeros_Camas> asignacionesCamas) {
        this.nombre = nombre;
        this.materno = materno;
        this.paterno = paterno;
        this.telefono = telefono;
        this.token = token;
        this.status = status;
        this.usuario = usuario;
        this.password = password;
        this.rolenfermero = rolenfermero;
        this.isla = isla;
        this.asignacionesCamas = asignacionesCamas;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Enfermeros_Camas> getAsignacionesCamas() {
        return asignacionesCamas;
    }

    public void setAsignacionesCamas(List<Enfermeros_Camas> asignacionesCamas) {
        this.asignacionesCamas = asignacionesCamas;
    }

    public IslaBean getIsla() {
        return isla;
    }

    public void setIsla(IslaBean isla) {
        this.isla = isla;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public RolBean getRolenfermero() {
        return rolenfermero;
    }

    public void setRolenfermero(RolBean rolenfermero) {
        this.rolenfermero = rolenfermero;
    }
}
