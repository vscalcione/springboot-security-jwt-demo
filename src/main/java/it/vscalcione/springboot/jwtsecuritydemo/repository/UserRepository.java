package it.vscalcione.springboot.jwtsecuritydemo.repository;

import it.vscalcione.springboot.jwtsecuritydemo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
