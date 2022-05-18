package com.example.jediservice.repoistories;

import com.example.jediservice.models.Jedi;
import com.example.jediservice.models.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JediRepository extends JpaRepository<Jedi, Long> {

    @Query("SELECT J FROM Jedi J WHERE 1=1 " +
            "AND (:midi IS NULL OR J.midichlorians >= :midi) " +
            "AND (:mestre IS NULL OR J.mestre = :mestre) " +
            "AND (:status IS NULL OR J.status = :status)")
    List<Jedi> findAllByFilter(
            @Param("midi") Integer midi,
            @Param("mestre") String mestre,
            @Param("status") Status status
    );
}
