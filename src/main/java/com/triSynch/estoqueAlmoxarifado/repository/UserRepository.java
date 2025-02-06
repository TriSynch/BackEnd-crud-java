package com.triSynch.estoqueAlmoxarifado.repository;

import com.triSynch.estoqueAlmoxarifado.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByUsernameAndPasswordHash(String username, String passwordHash);

}
