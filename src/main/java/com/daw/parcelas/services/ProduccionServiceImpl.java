package com.daw.parcelas.services;

import com.daw.parcelas.model.Produccion;
import com.daw.parcelas.repository.ProduccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduccionServiceImpl implements ProduccionService {

    private final ProduccionRepository produccionRepository;

    public ProduccionServiceImpl(
            ProduccionRepository produccionRepository) {
        this.produccionRepository = produccionRepository;
    }

    @Override
    public List<Produccion> listarTodas() {
        return produccionRepository.findAll();
    }

    @Override
    public Produccion buscarPorId(Long id) {
        return produccionRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public Produccion guardar(Produccion produccion) {
        return produccionRepository.save(produccion);
    }

    @Override
    public void eliminar(Long id) {
        produccionRepository.deleteById(id);
    }
}