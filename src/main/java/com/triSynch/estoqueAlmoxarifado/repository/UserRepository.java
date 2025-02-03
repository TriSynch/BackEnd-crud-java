package com.triSynch.estoqueAlmoxarifado.repository;

import com.triSynch.estoqueAlmoxarifado.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
