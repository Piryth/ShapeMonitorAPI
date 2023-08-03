package com.piryth.shapemonitorapi.repository;
import com.piryth.shapemonitorapi.model.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Component
@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<Account, Long> {

    public Optional<Account> getByEmail(String username);
}
