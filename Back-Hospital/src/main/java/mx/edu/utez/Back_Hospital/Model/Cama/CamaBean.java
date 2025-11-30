package mx.edu.utez.Back_Hospital.Model.Cama;

import jakarta.persistence.*;
import mx.edu.utez.Back_Hospital.Model.Enfermeros_Camas.Enfermeros_Camas;
import mx.edu.utez.Back_Hospital.Model.Isla.IslaBean;
import mx.edu.utez.Back_Hospital.Model.Paciente.PacienteBean;

import java.util.List;

@Entity
@Table(name = "camas")
public class CamaBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cama")
    private int cama;

    @Column(name = "ocupada", columnDefinition = "BOOL")
    private boolean ocupada;


    @OneToOne(fetch = FetchType.LAZY)
    private PacienteBean paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_isla", nullable = false)
    private IslaBean islaBean;

    @OneToMany(mappedBy = "cama", fetch = FetchType.LAZY)
    private java.util.List<Enfermeros_Camas> asignacionesEnfermeros;

    public CamaBean(Long id, int cama, boolean ocupada, PacienteBean paciente, IslaBean islaBean, List<Enfermeros_Camas> asignacionesEnfermeros) {
        this.id = id;
        this.cama = cama;
        this.ocupada = ocupada;
        this.paciente = paciente;
        this.islaBean = islaBean;
        this.asignacionesEnfermeros = asignacionesEnfermeros;
    }

    public CamaBean(int cama, boolean ocupada, PacienteBean paciente, IslaBean islaBean, List<Enfermeros_Camas> asignacionesEnfermeros) {
        this.cama = cama;
        this.ocupada = ocupada;
        this.paciente = paciente;
        this.islaBean = islaBean;
        this.asignacionesEnfermeros = asignacionesEnfermeros;
    }

    public CamaBean(Long id, int cama, boolean ocupada, PacienteBean paciente, IslaBean islaBean) {
        this.id = id;
        this.cama = cama;
        this.ocupada = ocupada;
        this.paciente = paciente;
        this.islaBean = islaBean;
    }

    public CamaBean(int cama, boolean ocupada, PacienteBean paciente, IslaBean islaBean) {
        this.cama = cama;
        this.ocupada = ocupada;
        this.paciente = paciente;
        this.islaBean = islaBean;
    }

    public IslaBean getIslaBean() {
        return islaBean;
    }

    public void setIslaBean(IslaBean islaBean) {
        this.islaBean = islaBean;
    }

    public CamaBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCama() {
        return cama;
    }

    public void setCama(int cama) {
        this.cama = cama;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public PacienteBean getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteBean paciente) {
        this.paciente = paciente;
    }
}
