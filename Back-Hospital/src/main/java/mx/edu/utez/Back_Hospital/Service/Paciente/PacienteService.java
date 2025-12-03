package mx.edu.utez.Back_Hospital.Service.Paciente;

import mx.edu.utez.Back_Hospital.Config.ApiResponse;
import mx.edu.utez.Back_Hospital.Model.Paciente.PacienteBean;
import mx.edu.utez.Back_Hospital.Model.Paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getAllPacientes(){
        List<PacienteBean> pacientes = pacienteRepository.findAll();
        return new ResponseEntity<>(new ApiResponse(pacientes, HttpStatus.OK, "obteniendo a todos los pacientes"), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> addPaciente(PacienteBean paciente){

        Optional<PacienteBean> optionalPaciente = pacienteRepository.findByCurp(paciente.getCurp());

        if(optionalPaciente.isPresent()){
            PacienteBean pacienteExistente = optionalPaciente.get();

            // 1. Si el paciente ya está activo en el hospital (alta = FALSE)
            if (!pacienteExistente.getAlta()) {
                return new ResponseEntity<>(
                        new ApiResponse(HttpStatus.CONFLICT,
                                "El paciente ya está registrado y actualmente activo en el hospital.", true),
                        HttpStatus.CONFLICT
                );
            }

            // 2. Si el paciente existe pero estaba dado de alta (alta = TRUE) → reactivarlo
            pacienteExistente.setAlta(false); // vuelve a estar activo

            // Aquí podrías agregar registro en el historial si lo implementas
            // historialService.registrarIngreso(pacienteExistente);

            pacienteRepository.saveAndFlush(pacienteExistente);

            return new ResponseEntity<>(
                    new ApiResponse(pacienteExistente, HttpStatus.OK, "Paciente reactivado correctamente."),
                    HttpStatus.OK
            );

        } else {

            // 3. Crear un nuevo paciente si no existe, y marcarlo como ACTIVO
            paciente.setAlta(false);

            // ENCRIPTAR LA CONTRASEÑA antes de guardar
            paciente.setPassword(passwordEncoder.encode(paciente.getPassword()));

            PacienteBean nuevo = pacienteRepository.saveAndFlush(paciente);

            // Si manejas histórico:
            // historialService.registrarIngreso(nuevo);

            return new ResponseEntity<>(
                    new ApiResponse(nuevo, HttpStatus.CREATED, "Paciente registrado correctamente."),
                    HttpStatus.CREATED
            );
        }
    }
}