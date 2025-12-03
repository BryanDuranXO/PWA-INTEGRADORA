package mx.edu.utez.Back_Hospital.security.model;

import mx.edu.utez.Back_Hospital.Model.Paciente.PacienteBean;
import mx.edu.utez.Back_Hospital.Model.Isla.IslaBean;
import mx.edu.utez.Back_Hospital.Model.Enfermero.EnfermeroBean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class UserDetailsImpl implements UserDetails {

    private String username;
    private String password;
    private boolean enabled;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(String username, String password, boolean enabled,
                           Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    public UserDetailsImpl(String username, String password,
                           Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.enabled = true;
    }


    /* ============================================================
     *    1) BUILD PARA PACIENTE
     * ============================================================ */
    public static UserDetailsImpl buildPaciente(PacienteBean user) {
        Set<GrantedAuthority> authorities =
                Collections.singleton(new SimpleGrantedAuthority("ROLE_PACIENTE"));

        return new UserDetailsImpl(
                user.getUsuario(),          // username
                user.getPassword(),        // contrasenia o campo equivalente
                true,                      // enabled (puedes cambiar si tienes campo)
                authorities
        );
    }


    /* ============================================================
     *    2) BUILD PARA ENFERMERO
     * ============================================================ */
    public static UserDetailsImpl buildEnfermero(EnfermeroBean user) {
        Set<GrantedAuthority> authorities =
                Collections.singleton(new SimpleGrantedAuthority("ROLE_ENFERMERO"));

        return new UserDetailsImpl(
                user.getUsuario(),
                user.getPassword(),
                true,
                authorities
        );
    }


    /* ============================================================
     *    3) BUILD PARA ISLA
     * ============================================================ */
    public static UserDetailsImpl buildIsla(IslaBean user) {
        Set<GrantedAuthority> authorities =
                Collections.singleton(new SimpleGrantedAuthority("ROLE_ISLA"));

        return new UserDetailsImpl(
                user.getUsuario(),
                user.getPassword(),
                true,
                authorities
        );
    }





    /* ============================================================
     *    MÉTODOS DE UserDetails
     * ============================================================ */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return enabled; }
}
