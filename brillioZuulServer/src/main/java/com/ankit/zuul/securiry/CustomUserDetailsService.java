package com.ankit.zuul.securiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ankit.zuul.model.Counter;
import com.ankit.zuul.repository.CounterRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    CounterRepository counterRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String counterName)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        Counter counter = counterRepository.findByCounterName(counterName)
                .orElseThrow(() -> 
                        new UsernameNotFoundException("Counter not found : " + counterName)
        );

        return UserPrincipal.create(counter);
    }

    
}