package mx.edu.utez.Back_Hospital.Model.Rol;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertRoles {
    @Autowired
    private RolRepository  rolRepository;

    @PostConstruct
    public void init(){
        if(!rolRepository.existsByRol("isla")){
            rolRepository.save(new RolBean("isla"));
        }

        if(!rolRepository.existsByRol("enfermero")){
            rolRepository.save(new RolBean("enfermero"));
        }

        if(!rolRepository.existsByRol("paciente")){
            rolRepository.save(new RolBean("paciente"));
        }
    }
}
