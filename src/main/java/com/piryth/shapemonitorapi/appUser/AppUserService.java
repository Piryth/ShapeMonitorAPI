package com.piryth.shapemonitorapi.appUser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Provides services for AppUser
 */
@Service
@AllArgsConstructor
public class AppUserService {

    //private final IAppUserRepository appUserRepository;

    public void addAppUser(AppUser appUser) {
        //return appUserRepository.save(appUser);
    }

    public void getUser(String username) {
      //  return appUserRepository.getByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + " couldn't be found"));
    }




}
