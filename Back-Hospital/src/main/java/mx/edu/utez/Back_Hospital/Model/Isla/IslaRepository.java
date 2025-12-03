package mx.edu.utez.Back_Hospital.Model.Isla;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IslaRepository extends JpaRepository<IslaBean,Long> {
    Optional<IslaBean> findByUsuario(String usuario);
}
