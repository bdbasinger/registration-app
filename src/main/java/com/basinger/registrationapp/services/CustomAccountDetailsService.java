package com.basinger.registrationapp.services;

import com.basinger.registrationapp.models.Account;
import com.basinger.registrationapp.repos.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


//This class is responsible for fetching user details from the database using the AccountRepository.

@Service
public class CustomAccountDetailsService implements UserDetailsService {
    private final AccountRepository accountRepository;

    @Autowired
    public CustomAccountDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Account not found with username: " + username));
        return new org.springframework.security.core.userdetails.User(account.getUsername(), account.getPassword(), new ArrayList<>());
        // This ArrayList is for roles. We're keeping it empty for now.
    }



}
