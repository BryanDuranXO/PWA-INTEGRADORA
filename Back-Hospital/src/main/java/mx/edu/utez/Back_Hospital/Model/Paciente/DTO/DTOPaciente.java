package mx.edu.utez.Back_Hospital.Model.Paciente.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mx.edu.utez.Back_Hospital.Model.Paciente.PacienteBean;
import mx.edu.utez.Back_Hospital.Model.Pacientes_Camas.Pacientes_Camas;
import mx.edu.utez.Back_Hospital.Model.Rol.RolBean;

import java.util.List;

@Data
public class DTOPaciente {

    @NotNull(groups = {Modify.class, ChangeStatus.class})
    private Long id;

    @NotBlank(groups = {Modify.class, Register.class})
    private String nombre;

    @NotBlank(groups = {Modify.class, Register.class})
    private String materno;

    @NotBlank(groups = {Modify.class, Register.class})
    private String paterno;

    @NotBlank(groups = {Modify.class, Register.class})
    private String padecimientos;

    @NotBlank(groups = {Modify.class, Register.class})
    private String telefono;

    @NotBlank(groups = {Modify.class, Register.class})
    private String curp;

    private String token;

    @NotNull(groups = {Modify.class, Register.class})
    private Boolean status;

    @NotNull(groups = {ChangeStatus.class})
    private Boolean alta;

    @NotNull(groups = {Register.class, Modify.class})
    private String usuario;

    @NotNull(groups = {Register.class, Modify.class})
    private String password;

    private RolBean rolpaciente;

    private List<Pacientes_Camas> pacientesCamas;

    public PacienteBean toEntity() {
        return new PacienteBean(nombre, materno, paterno, padecimientos, telefono, curp, status, alta, usuario,password, rolpaciente);
    }

    public interface Register{}
    public interface Modify{}
    public interface ChangeStatus{}
}
