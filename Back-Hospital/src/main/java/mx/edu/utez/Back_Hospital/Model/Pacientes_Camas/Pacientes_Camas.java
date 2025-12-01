package mx.edu.utez.Back_Hospital.Model.Pacientes_Camas;

import jakarta.persistence.*;
import mx.edu.utez.Back_Hospital.Model.Cama.CamaBean;
import mx.edu.utez.Back_Hospital.Model.Enfermero.EnfermeroBean;
import mx.edu.utez.Back_Hospital.Model.Paciente.PacienteBean;

@Entity
@Table(name = "pacientes_camas")
public class Pacientes_Camas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente", nullable = false)
    private PacienteBean paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cama", nullable = false)
    private CamaBean cama;

    @Column(columnDefinition = "BOOL")
    private boolean activo = true;
}
