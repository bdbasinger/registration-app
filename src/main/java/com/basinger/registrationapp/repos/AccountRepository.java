package com.basinger.registrationapp.repos;

import com.basinger.registrationapp.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findAccountById(Long id);
    Optional<Account> findAccountByEmail(String email);

    Optional<Account> findByUsername(String username);


    Optional<Account> findAccountByCellPhoneNumber(String cell);
}
