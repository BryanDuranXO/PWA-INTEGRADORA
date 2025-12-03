package mx.edu.utez.Back_Hospital.Model.Isla;

import jakarta.persistence.*;
import mx.edu.utez.Back_Hospital.Model.Cama.CamaBean;
import mx.edu.utez.Back_Hospital.Model.Enfermero.EnfermeroBean;
import mx.edu.utez.Back_Hospital.Model.Paciente.PacienteBean;
import mx.edu.utez.Back_Hospital.Model.Rol.RolBean;

import java.util.Set;

@Entity
@Table(name = "islas")
public class IslaBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero")
    private String numero;

    @Column(name = "token", columnDefinition = "TEXT")
    private String token;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "password", columnDefinition = "TEXT")
    private String password;

    @Column(name = "status", columnDefinition = "BOOL")
    private Boolean status;

    @OneToMany(mappedBy = "isla", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<EnfermeroBean> enfermeroBeanSet ;

    @OneToMany(mappedBy = "islaBean", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CamaBean> camaBeans ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol", nullable = false)
    private RolBean rolisla;


    public IslaBean(Long id, String numero, String token, String usuario, String password, Boolean status, Set<EnfermeroBean> enfermeroBeanSet, Set<CamaBean> camaBeans, RolBean rolisla) {
        this.id = id;
        this.numero = numero;
        this.token = token;
        this.usuario = usuario;
        this.password = password;
        this.status = status;
        this.enfermeroBeanSet = enfermeroBeanSet;
        this.camaBeans = camaBeans;
        this.rolisla = rolisla;
    }

    public IslaBean(String numero, String token, String usuario, String password, Boolean status, Set<EnfermeroBean> enfermeroBeanSet, Set<CamaBean> camaBeans, RolBean rolisla) {
        this.numero = numero;
        this.token = token;
        this.usuario = usuario;
        this.password = password;
        this.status = status;
        this.enfermeroBeanSet = enfermeroBeanSet;
        this.camaBeans = camaBeans;
        this.rolisla = rolisla;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public IslaBean() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Set<EnfermeroBean> getEnfermeroBeanSet() {
        return enfermeroBeanSet;
    }

    public void setEnfermeroBeanSet(Set<EnfermeroBean> enfermeroBeanSet) {
        this.enfermeroBeanSet = enfermeroBeanSet;
    }

    public Set<CamaBean> getCamaBeans() {
        return camaBeans;
    }

    public void setCamaBeans(Set<CamaBean> camaBeans) {
        this.camaBeans = camaBeans;
    }

    public RolBean getRolisla() {
        return rolisla;
    }

    public void setRolisla(RolBean rolisla) {
        this.rolisla = rolisla;
    }
}
