package mx.edu.utez.Back_Hospital.Model.Enfermeros_Camas;

import jakarta.persistence.*;
import mx.edu.utez.Back_Hospital.Model.Cama.CamaBean;
import mx.edu.utez.Back_Hospital.Model.Enfermero.EnfermeroBean;

@Entity
@Table(name = "enfermeros_camas")
public class Enfermeros_Camas
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_enfermero", nullable = false)
    private EnfermeroBean enfermero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cama", nullable = false)
    private CamaBean cama;

    @Column(columnDefinition = "BOOL")
    private boolean activo = true;

    public Enfermeros_Camas() {

    }

    public void EnfermeroCamaBean() {}

    public void EnfermeroCamaBean(EnfermeroBean enfermero, CamaBean cama, boolean activo) {
        this.enfermero = enfermero;
        this.cama = cama;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public EnfermeroBean getEnfermero() {
        return enfermero;
    }

    public void setEnfermero(EnfermeroBean enfermero) {
        this.enfermero = enfermero;
    }

    public CamaBean getCama() {
        return cama;
    }

    public void setCama(CamaBean cama) {
        this.cama = cama;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
