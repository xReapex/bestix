package com.example.bestix.infrastructure.Repository;

import com.example.bestix.infrastructure.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<UserEntity, Integer> {

    @Query("select u.username from UserEntity u where u.id= :userIdentifier")
    String getUserById(@Param("userIdentifier") int userId);
}
