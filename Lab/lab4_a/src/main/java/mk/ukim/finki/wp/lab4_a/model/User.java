//package mk.ukim.finki.wp.lab4_a.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import mk.ukim.finki.wp.lab4_a.model.enums.Role;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
////@Entity
////@Table(name = "customer")
//public class User implements UserDetails {
//    @Id
//    private String username;
//    private String password;
//
//    @Enumerated(EnumType.STRING)
//    private Role role;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singleton(role);
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
