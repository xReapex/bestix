package com.example.bestix.infrastructure.Repository;

import com.example.bestix.infrastructure.Entity.FavoritePlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FavoritesRepository extends JpaRepository<FavoritePlayer, Integer> {

    @Query("select p.playerId from FavoritePlayer p where p.userId = :userIdentifier")
    List<Integer> getFavoritesByUserId(@Param("userIdentifier") int userId);

    @Transactional
    @Modifying
    @Query("delete from FavoritePlayer p where p.userId = :userIdentifier and p.playerId = :playerIdentifier")
    void deleteByIds(@Param("playerIdentifier") int playerId, @Param("userIdentifier") int userId);
}
