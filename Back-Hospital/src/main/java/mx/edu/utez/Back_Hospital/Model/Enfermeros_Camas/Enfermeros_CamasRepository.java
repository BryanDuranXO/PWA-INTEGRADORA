package mx.edu.utez.Back_Hospital.Model.Enfermeros_Camas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Enfermeros_CamasRepository extends JpaRepository<Enfermeros_Camas, Long> {
    Optional<Enfermeros_Camas> findByActivo(Boolean activo);

}
