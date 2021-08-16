package com.elias.michalczuk.carApp.veiculo.repository;

import com.elias.michalczuk.carApp.veiculo.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

    @Query(value = "SELECT * from veiculo where" +
    " (?1 IS NOT NULL AND marca LIKE %?1%)" +
    " AND (?2 IS NOT NULL AND CAST(ano AS TEXT) LIKE CAST(?2 AS TEXT))" +
    " AND (?3 IS NOT NULL AND vendido = ?3)", nativeQuery = true)
    List<Veiculo> findVeiculoByQuery(String marca, Integer decada, Boolean vendido);
}
