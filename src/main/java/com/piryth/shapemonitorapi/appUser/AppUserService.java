package com.piryth.shapemonitorapi.appUser;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Provides services for AppUser
 */
@Service
@RequiredArgsConstructor
public class AppUserService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    public void addAppUser(AppUser appUser) {
        //return appUserRepository.save(appUser);
    }


    /**
     *
     * @param username the username identifying the user whose data is required.
     * @return The user details
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.getReferenceById(username);

    }
}
