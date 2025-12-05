package mx.edu.utez.Back_Hospital.Model.Enfermeros_Camas.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import mx.edu.utez.Back_Hospital.Model.Cama.CamaBean;
import mx.edu.utez.Back_Hospital.Model.Enfermero.EnfermeroBean;
import mx.edu.utez.Back_Hospital.Model.Enfermeros_Camas.Enfermeros_Camas;

@Data
public class DTOEnfermeros_Camas {
    private Long id;

    private Long enfermero;
    private Long cama;

    private boolean activo = true;

//    public Enfermeros_Camas toEntity(){
//        return new Enfermeros_Camas(enfermero, cama, activo);
//    }
}
