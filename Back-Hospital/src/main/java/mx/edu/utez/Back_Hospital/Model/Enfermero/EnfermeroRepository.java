package mx.edu.utez.Back_Hospital.Model.Enfermero;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnfermeroRepository extends JpaRepository<EnfermeroBean,Long> {

    Optional<EnfermeroBean> findByUsuario(String usuario);
}
