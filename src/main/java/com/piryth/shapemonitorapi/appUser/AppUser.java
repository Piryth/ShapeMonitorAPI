package com.piryth.shapemonitorapi.appUser;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class AppUser implements UserDetails {
    @Id
    private String username;
    @Column(unique = true)
    private String email;
    private String password;

    //Contains the whole measurements history
    //@OneToMany
    //private List<Record> history;

    @JoinColumn
    @OneToOne
    private Role role;


    //@Column
    //private Record lastRecord() {
        //return history.get(history.size()-1);
    //}
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getName()));
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
