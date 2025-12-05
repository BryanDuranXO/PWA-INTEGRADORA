package mx.edu.utez.Back_Hospital.Model.Cama.DTO;

import jakarta.persistence.*;
import lombok.Data;
import mx.edu.utez.Back_Hospital.Model.Cama.CamaBean;
import mx.edu.utez.Back_Hospital.Model.Isla.IslaBean;

@Data
public class DTOCama {
    private Long id;

    private int cama;

    private boolean ocupada;

    private IslaBean islaBean;

    public CamaBean toEntity(){
        return new CamaBean(cama,ocupada,islaBean);
    }
}
