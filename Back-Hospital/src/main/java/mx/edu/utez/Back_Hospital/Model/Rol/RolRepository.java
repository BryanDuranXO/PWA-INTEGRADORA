package mx.edu.utez.Back_Hospital.Model.Rol;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<RolBean, Long> {

    boolean existsByRol(String rol);
}
