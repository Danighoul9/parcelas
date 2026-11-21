package com.daw.parcelas.repository;

import com.daw.parcelas.model.Parcela;
import com.daw.parcelas.model.TipoCultivo;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParcelaRepository extends JpaRepository<Parcela, Long> {
    // EXTRA2 - Buscar parcelas por tipo de cultivo
    List<Parcela> findByTipoCultivo(TipoCultivo tipo);
    //EXTRA 3- Listar parcelas ordenadas por nombre
    List<Parcela> findAllByOrderByNombreAsc();

    // Para el filtrado de parcelar por nombre y tipo de cultivo
    public List<Parcela> findAllByNombreContainingIgnoreCaseAndTipoCultivoEquals(String nombre, TipoCultivo tipoCultivo);
}
