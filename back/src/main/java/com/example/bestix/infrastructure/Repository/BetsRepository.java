package com.example.bestix.infrastructure.Repository;

import com.example.bestix.infrastructure.Entity.BetEntity;
import com.example.bestix.infrastructure.Entity.FavoritePlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BetsRepository extends JpaRepository<BetEntity, Integer> {

    @Query("select p from BetEntity p where p.idUser = :userIdentifier")
    List<BetEntity> getBetsByUserId(@Param("userIdentifier") int idUser);

    @Query("select p.idMatch from BetEntity p where p.idUser = :userIdentifier")
    List<Integer> getMatchesIdByUserId(@Param("userIdentifier") int userId);
}
