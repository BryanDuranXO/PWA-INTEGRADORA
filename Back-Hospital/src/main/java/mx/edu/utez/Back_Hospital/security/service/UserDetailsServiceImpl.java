package mx.edu.utez.Back_Hospital.security.service;



import mx.edu.utez.Back_Hospital.Model.Enfermero.EnfermeroBean;
import mx.edu.utez.Back_Hospital.Model.Enfermero.EnfermeroRepository;
import mx.edu.utez.Back_Hospital.Model.Isla.IslaBean;
import mx.edu.utez.Back_Hospital.Model.Isla.IslaRepository;
import mx.edu.utez.Back_Hospital.Model.Paciente.PacienteBean;
import mx.edu.utez.Back_Hospital.Model.Paciente.PacienteRepository;
import mx.edu.utez.Back_Hospital.security.model.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private EnfermeroRepository enfermeroRepository;

    @Autowired
    private IslaRepository islaRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {

        // 1. Buscar en PACIENTES
        Optional<PacienteBean> paciente = pacienteRepository.findByUsuario(usuario);
        if (paciente.isPresent()) {
            return UserDetailsImpl.buildPaciente(paciente.get());
        }

        // 2. Buscar en ENFERMEROS
        Optional<EnfermeroBean> enfermero = enfermeroRepository.findByUsuario(usuario);
        if (enfermero.isPresent()) {
            return UserDetailsImpl.buildEnfermero(enfermero.get());
        }

        // 3. Buscar en ISLAS
        Optional<IslaBean> isla = islaRepository.findByUsuario(usuario);
        if (isla.isPresent()) {
            return UserDetailsImpl.buildIsla(isla.get());
        }

        throw new UsernameNotFoundException("Usuario no encontrado");
    }
}

