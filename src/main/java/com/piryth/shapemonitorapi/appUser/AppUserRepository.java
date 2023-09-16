package com.piryth.shapemonitorapi.appUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface AppUserRepository extends JpaRepository<AppUser, String> {
    Optional<AppUser> findByEmail(String email);

    @Query("SELECT u FROM AppUser u LEFT JOIN FETCH u.role WHERE u.username= :username")
    Optional<AppUser> findUserWithRolesByEmail(@Param("username") String username);
}
