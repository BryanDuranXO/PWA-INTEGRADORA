package mx.edu.utez.Back_Hospital.Controller.Cama;

import mx.edu.utez.Back_Hospital.Config.ApiResponse;
import mx.edu.utez.Back_Hospital.Model.Cama.CamaBean;
import mx.edu.utez.Back_Hospital.Model.Cama.DTO.DTOCama;
import mx.edu.utez.Back_Hospital.Service.Camas.CamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cama")
@CrossOrigin(origins = {"*"})
public class CamaController {
    @Autowired
    private CamaService service;

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getCamas(){
        return service.getAll();
    }

    @PostMapping("/new-cama")
    public ResponseEntity<ApiResponse> saveCama(@RequestBody DTOCama dtoCama){
        return service.save(dtoCama.toEntity());
    }


}
