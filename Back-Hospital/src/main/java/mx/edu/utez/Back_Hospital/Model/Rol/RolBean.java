package mx.edu.utez.Back_Hospital.Model.Rol;

import jakarta.persistence.*;
import mx.edu.utez.Back_Hospital.Model.Enfermero.EnfermeroBean;
import mx.edu.utez.Back_Hospital.Model.Isla.IslaBean;
import mx.edu.utez.Back_Hospital.Model.Paciente.PacienteBean;

import java.util.Set;

@Entity
@Table(name = "roles")
public class RolBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rol")
    private String rol;

    @OneToMany(mappedBy = "rolenfermero", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<EnfermeroBean> enfermeroBeanSet ;

    @OneToMany(mappedBy = "rolpaciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PacienteBean> pacienteBeanSet ;

    @OneToMany(mappedBy = "rolisla", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<IslaBean> islaBeans ;


    public RolBean() {
    }

    public RolBean(Long id, String rol, Set<EnfermeroBean> enfermeroBeanSet, Set<PacienteBean> pacienteBeanSet, Set<IslaBean> islaBeans) {
        this.id = id;
        this.rol = rol;
        this.enfermeroBeanSet = enfermeroBeanSet;
        this.pacienteBeanSet = pacienteBeanSet;
        this.islaBeans = islaBeans;
    }

    public RolBean(String rol, Set<EnfermeroBean> enfermeroBeanSet, Set<PacienteBean> pacienteBeanSet, Set<IslaBean> islaBeans) {
        this.rol = rol;
        this.enfermeroBeanSet = enfermeroBeanSet;
        this.pacienteBeanSet = pacienteBeanSet;
        this.islaBeans = islaBeans;
    }

    public Set<EnfermeroBean> getEnfermeroBeanSet() {
        return enfermeroBeanSet;
    }

    public void setEnfermeroBeanSet(Set<EnfermeroBean> enfermeroBeanSet) {
        this.enfermeroBeanSet = enfermeroBeanSet;
    }

    public Set<PacienteBean> getPacienteBeanSet() {
        return pacienteBeanSet;
    }

    public void setPacienteBeanSet(Set<PacienteBean> pacienteBeanSet) {
        this.pacienteBeanSet = pacienteBeanSet;
    }

    public Set<IslaBean> getIslaBeans() {
        return islaBeans;
    }

    public void setIslaBeans(Set<IslaBean> islaBeans) {
        this.islaBeans = islaBeans;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
