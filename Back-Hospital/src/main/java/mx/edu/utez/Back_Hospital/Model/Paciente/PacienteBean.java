package mx.edu.utez.Back_Hospital.Model.Paciente;

import jakarta.persistence.*;
import mx.edu.utez.Back_Hospital.Model.Cama.CamaBean;
import mx.edu.utez.Back_Hospital.Model.Enfermeros_Camas.Enfermeros_Camas;
import mx.edu.utez.Back_Hospital.Model.Pacientes_Camas.Pacientes_Camas;
import mx.edu.utez.Back_Hospital.Model.Rol.RolBean;

import java.util.List;

@Entity
@Table(name = "pacientes")
public class PacienteBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "materno")
    private String materno;

    @Column(name = "paterno")
    private String paterno;

    @Column(name = "padecimientos",columnDefinition = "TEXT")
    private String padecimientos;

    @Column(name = "telefono", length = 10)
    private String telefono;

    @Column(name = "token", columnDefinition = "TEXT")
    private String token;

    @Column(name = "status", columnDefinition = "BOOL")
    private Boolean status;

    @Column(name = "alta", columnDefinition = "BOOL")
    private Boolean alta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol", nullable = false)
    private RolBean rolpaciente;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    private java.util.List<Pacientes_Camas> pacientesCamas;



    public PacienteBean() {
    }

    public PacienteBean(Long id, String nombre, String materno, String paterno, String padecimientos, String telefono, String token, Boolean status, Boolean alta, RolBean rolpaciente, List<Pacientes_Camas> pacientesCamas) {
        this.id = id;
        this.nombre = nombre;
        this.materno = materno;
        this.paterno = paterno;
        this.padecimientos = padecimientos;
        this.telefono = telefono;
        this.token = token;
        this.status = status;
        this.alta = alta;
        this.rolpaciente = rolpaciente;
        this.pacientesCamas = pacientesCamas;
    }

    public PacienteBean(String nombre, String materno, String paterno, String padecimientos, String telefono, String token, Boolean status, Boolean alta, RolBean rolpaciente, List<Pacientes_Camas> pacientesCamas) {
        this.nombre = nombre;
        this.materno = materno;
        this.paterno = paterno;
        this.padecimientos = padecimientos;
        this.telefono = telefono;
        this.token = token;
        this.status = status;
        this.alta = alta;
        this.rolpaciente = rolpaciente;
        this.pacientesCamas = pacientesCamas;
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

    public String getPadecimientos() {
        return padecimientos;
    }

    public void setPadecimientos(String padecimientos) {
        this.padecimientos = padecimientos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public RolBean getRolpaciente() {
        return rolpaciente;
    }

    public void setRolpaciente(RolBean rolpaciente) {
        this.rolpaciente = rolpaciente;
    }

    public List<Pacientes_Camas> getPacientesCamas() {
        return pacientesCamas;
    }

    public void setPacientesCamas(List<Pacientes_Camas> pacientesCamas) {
        this.pacientesCamas = pacientesCamas;
    }
}
