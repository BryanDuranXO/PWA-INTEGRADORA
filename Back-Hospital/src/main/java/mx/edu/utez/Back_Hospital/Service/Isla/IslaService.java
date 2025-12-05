package mx.edu.utez.Back_Hospital.Service.Isla;

import mx.edu.utez.Back_Hospital.Config.ApiResponse;
import mx.edu.utez.Back_Hospital.Model.Isla.IslaBean;
import mx.edu.utez.Back_Hospital.Model.Isla.IslaRepository;
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
public class IslaService {

    @Autowired
    private IslaRepository islaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> getAll(){
        List<IslaBean> islaBeans = islaRepository.findAll();
        return new ResponseEntity<>(new ApiResponse(islaBeans, HttpStatus.OK, "Obteniendo todas las islas"),HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<ApiResponse> save(IslaBean islaBean){
        Optional<IslaBean> islaOptional = islaRepository.findByNumero(islaBean.getNumero());

        if(islaOptional.isPresent()){
            return new ResponseEntity<>(new ApiResponse(HttpStatus.CONFLICT, "Isla ya registrada", true), HttpStatus.CONFLICT);
        }

        islaBean.setPassword(passwordEncoder.encode(islaBean.getPassword()));
        return new ResponseEntity<>(new ApiResponse(islaRepository.saveAndFlush(islaBean), HttpStatus.CREATED, "Isla creada exitosamente"), HttpStatus.CREATED);
    }


}
