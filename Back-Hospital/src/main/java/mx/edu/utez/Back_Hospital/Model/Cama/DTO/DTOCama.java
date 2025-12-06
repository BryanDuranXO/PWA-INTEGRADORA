package mx.edu.utez.Back_Hospital.Model.Cama.DTO;

import jakarta.persistence.*;
import lombok.Data;
import mx.edu.utez.Back_Hospital.Model.Cama.CamaBean;
import mx.edu.utez.Back_Hospital.Model.Isla.DTO.DTOIsla;
import mx.edu.utez.Back_Hospital.Model.Isla.IslaBean;

@Data
public class DTOCama {
    private Long id;

    private int cama;

    private boolean ocupada;

    private IslaBean islaBean;

    private DTOIsla isla;

    public CamaBean toEntity(){
        return new CamaBean(cama,ocupada,islaBean);
    }

    public DTOCama(CamaBean cama){
        this.id = cama.getId();
        this.cama = cama.getCama();
        this.ocupada = cama.isOcupada();
        this.isla = new DTOIsla(cama.getIslaBean()); // ahora sí es correcto
    }


}
