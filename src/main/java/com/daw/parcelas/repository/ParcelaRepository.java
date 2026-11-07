package com.daw.parcelas.repository;

import com.daw.parcelas.model.Parcela;
import com.daw.parcelas.model.TipoCultivo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParcelaRepository extends JpaRepository<Parcela, Long> {
    // EXTRA2- Buscar parcelas por tipo de cultivo
    List<Parcela> findByTipoCultivo(TipoCultivo tipo);
}
