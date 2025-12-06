package mx.edu.utez.Back_Hospital.Model.Pacientes_Camas;
import mx.edu.utez.Back_Hospital.Model.Cama.CamaBean;
import mx.edu.utez.Back_Hospital.Model.Paciente.PacienteBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Pacientes_CamasRepository extends JpaRepository<Pacientes_Camas, Long> {
    List<Pacientes_Camas> findByCamaAndActivoTrue(CamaBean cama);

    List<Pacientes_Camas> findByPacienteAndActivoTrue(PacienteBean paciente);
}
