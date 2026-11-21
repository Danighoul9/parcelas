package com.daw.parcelas.services;

import com.daw.parcelas.model.Produccion;

import java.util.List;

public interface ProduccionService {
    List<Produccion> listarTodas();
    Produccion buscarPorId(Long id);
    Produccion guardar(Produccion produccion);
    void eliminar(Long id);

    //Metodo para calcular el total de kilos de una lista de producciones
    double calcularTotalKilos(List<Produccion> producciones);
    // Filtrar producciones por producto y calidad
    List<Produccion> filtrarPorProductoYCalidad(String producto, String calidad);
}