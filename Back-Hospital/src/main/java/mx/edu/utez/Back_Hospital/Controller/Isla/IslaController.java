package mx.edu.utez.Back_Hospital.Controller.Isla;

import mx.edu.utez.Back_Hospital.Config.ApiResponse;
import mx.edu.utez.Back_Hospital.Model.Isla.DTO.DTOIsla;
import mx.edu.utez.Back_Hospital.Model.Isla.DTO.DtoPatchToken;
import mx.edu.utez.Back_Hospital.Model.Isla.IslaBean;
import mx.edu.utez.Back_Hospital.Model.Rol.RolBean;
import mx.edu.utez.Back_Hospital.Model.Rol.RolRepository;
import mx.edu.utez.Back_Hospital.Service.Isla.IslaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/isla")
@CrossOrigin(origins = {"*"})
public class IslaController {

    @Autowired
    private IslaService service;

    @Autowired
    private RolRepository rolRepository;

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getEnfermeros() {
        return service.getAll();
    }

    @PostMapping("/new-isla")
    public ResponseEntity<ApiResponse> saveIsla(@RequestBody DTOIsla  dtoIsla) {
        RolBean rol = rolRepository.findById(dtoIsla.getIdRol())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        IslaBean isla =dtoIsla.toEntity(rol);

        return service.save(isla);
    }

    @PatchMapping("/patch-token")
    public ResponseEntity<ApiResponse> updateToken(@RequestBody DtoPatchToken dto) {
        return service.tokenEnabled(dto.getId(), dto.getToken());
    }

}
