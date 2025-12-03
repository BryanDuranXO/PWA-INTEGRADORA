package mx.edu.utez.Back_Hospital.Controller.Paciente;

import mx.edu.utez.Back_Hospital.Config.ApiResponse;
import mx.edu.utez.Back_Hospital.Model.Paciente.DTO.DTOPaciente;
import mx.edu.utez.Back_Hospital.Model.Paciente.PacienteBean;
import mx.edu.utez.Back_Hospital.Model.Paciente.PacienteRepository;
import mx.edu.utez.Back_Hospital.Service.Paciente.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paciente")
@CrossOrigin(origins = {"*"})
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/")
    public ResponseEntity<ApiResponse> findAll() {
        return pacienteService.getAllPacientes();
    }

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> save(@Validated(DTOPaciente.Register.class) @RequestBody DTOPaciente dtoPaciente) {
        return pacienteService.addPaciente(dtoPaciente.toEntity());
    }
}
