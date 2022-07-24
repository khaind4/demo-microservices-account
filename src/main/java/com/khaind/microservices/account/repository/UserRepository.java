package com.khaind.microservices.account.repository;

import com.khaind.microservices.account.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findByNameLike(String name);

    List<UserEntity> findByGender(String gender);
}
