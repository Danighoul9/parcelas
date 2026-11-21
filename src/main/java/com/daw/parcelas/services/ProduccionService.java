package com.daw.parcelas.services;

import com.daw.parcelas.model.Produccion;

import java.util.List;

public interface ProduccionService {
    List<Produccion> listarTodas();
    Produccion buscarPorId(Long id);
    Produccion guardar(Produccion produccion);
    void eliminar(Long id);
}