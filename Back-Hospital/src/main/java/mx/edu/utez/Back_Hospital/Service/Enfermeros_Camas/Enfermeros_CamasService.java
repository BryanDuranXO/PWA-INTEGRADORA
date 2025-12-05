package mx.edu.utez.Back_Hospital.Service.Enfermeros_Camas;

import mx.edu.utez.Back_Hospital.Config.ApiResponse;
import mx.edu.utez.Back_Hospital.Model.Cama.CamaBean;
import mx.edu.utez.Back_Hospital.Model.Cama.CamaRepository;
import mx.edu.utez.Back_Hospital.Model.Enfermero.EnfermeroBean;
import mx.edu.utez.Back_Hospital.Model.Enfermero.EnfermeroRepository;
import mx.edu.utez.Back_Hospital.Model.Enfermeros_Camas.Enfermeros_Camas;
import mx.edu.utez.Back_Hospital.Model.Enfermeros_Camas.Enfermeros_CamasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class Enfermeros_CamasService {
    @Autowired
    private Enfermeros_CamasRepository repository;

    @Autowired
    private CamaRepository camaRepository;

    @Autowired
    private EnfermeroRepository enfermeroRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getAll(){
        List<Enfermeros_Camas> enfermerosCamasList = repository.findAll();
        return new ResponseEntity<>(new ApiResponse(enfermerosCamasList, HttpStatus.OK, "obteniendo enfermeros y sus camas asignadas"), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> save(Enfermeros_Camas enfermeros_Camas){

        EnfermeroBean enf = enfermeroRepository.findById(3L).orElse(null);
        System.out.println(enf);

        Optional<CamaBean> camaOptional = camaRepository.findById(enfermeros_Camas.getCama().getId());
        Optional<EnfermeroBean> enfermeroOptional = enfermeroRepository.findById(enfermeros_Camas.getEnfermero().getId());

        if(!enfermeroOptional.isPresent()){
            return new ResponseEntity<>(new ApiResponse(HttpStatus.CONFLICT, "Enfermero no encontrado", true), HttpStatus.CONFLICT);
        }

        if(!camaOptional.isPresent()){
            return new ResponseEntity<>(new ApiResponse(HttpStatus.CONFLICT, "Cama no encontrada", true), HttpStatus.CONFLICT);
        }

        CamaBean cama = camaOptional.get();
        EnfermeroBean enfermero = enfermeroOptional.get();

        enfermeros_Camas.setCama(cama);
        enfermeros_Camas.setEnfermero(enfermero);

        return new ResponseEntity<>(new ApiResponse(repository.saveAndFlush(enfermeros_Camas), HttpStatus.CREATED, "Enfermero asignado"), HttpStatus.CREATED);

    }
}
