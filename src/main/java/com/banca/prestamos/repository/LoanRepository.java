package com.banca.prestamos.repository;

import com.banca.prestamos.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query("SELECT l FROM Loan l WHERE l.numeroOperacion = :numeroOperacion")
    Optional<Loan> findByNumeroOperacion(@Param("numeroOperacion") String numeroOperacion);

    boolean existsByNumeroOperacion(String numeroOperacion);

    java.util.List<Loan> findBySolicitanteId(String solicitanteId);

    java.util.List<Loan> findByEstado(String estado);
}