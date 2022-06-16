package com.example.bestix.infrastructure.Repository;

import com.example.bestix.infrastructure.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Transactional
    @Modifying
    @Query("update UserEntity u set u.password = :new_password where u.id = :userIdentifier")
    void changeUserPasswordById(@Param("userIdentifier") int userId, @Param("new_password") String password);
}