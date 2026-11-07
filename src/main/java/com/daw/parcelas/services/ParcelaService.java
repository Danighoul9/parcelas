package com.daw.parcelas.services;

import com.daw.parcelas.model.Parcela;

import java.util.List;

public interface ParcelaService {
    List<Parcela> listarTodas();
    Parcela buscarPorId(Long id);
    Parcela guardar(Parcela parcela);
    void eliminar(Long id);
    // EXTRA 1: Calcula la superficie total de todas las parcelas
    double calcularSuperficieTotal();
}
