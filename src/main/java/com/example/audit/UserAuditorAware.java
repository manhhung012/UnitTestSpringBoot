package com.example.audit;

import com.example.entity.User;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class UserAuditorAware implements AuditorAware<User> {

    @Override
    public Optional<User> getCurrentAuditor() {
        return Optional.empty();
    }
}
