package com.example.bestix.infrastructure.Repository;

import com.example.bestix.infrastructure.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    @Transactional
    @Modifying
    @Query("update Player p set p.playerName = :name where p.id = :id")
    void setPlayerName(@Param("name") String name, @Param("id") int id);


}
