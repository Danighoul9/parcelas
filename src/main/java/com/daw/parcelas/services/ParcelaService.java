package com.daw.parcelas.services;

import com.daw.parcelas.model.Parcela;
import com.daw.parcelas.model.TipoCultivo;

import java.util.List;

public interface ParcelaService {
    List<Parcela> listarTodas();
    Parcela buscarPorId(Long id);
    Parcela guardar(Parcela parcela);
    void eliminar(Long id);
    // EXTRA 1: Calcula la superficie total de todas las parcelas
    double calcularSuperficieTotal();
    //EXTRA 2: Filtrar parcelas por tipo de cultivo
    List<Parcela> filtrarPorCultivo(TipoCultivo tipo);
    //EXTRA 3: Listar parcelas ordenadas por nombre
    List<Parcela> listarOrdenadas();
}
