package com.daw.parcelas.services;

import com.daw.parcelas.model.Parcela;
import com.daw.parcelas.model.TipoCultivo;
import com.daw.parcelas.repository.ParcelaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service

public class ParcelaServiceImpl implements ParcelaService {
    private final ParcelaRepository ParcelaRepository;

    public ParcelaServiceImpl(ParcelaRepository parcelaRepository) {
        this.ParcelaRepository = parcelaRepository;
    }


    //Lista todas las parcelas
    @Override
    public List<Parcela> listarTodas() {
        return ParcelaRepository.findAll();
    }

    //Busca una parcela por su ID
    @Override
    public Parcela buscarPorId(Long id) {
        return ParcelaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "No existe la parcela con id " + id));
    }

    //Guarda una parcela en la base de datos
    @Override
    public Parcela guardar(Parcela parcela) {
        return ParcelaRepository.save(parcela);
    }

    //Elimina una parcela por su ID
    @Override
    public void eliminar(Long id) {
        ParcelaRepository.deleteById(id);

    }

    // EXTRA 1: Calcula la superficie total de todas las parcelas
    @Override
    public double calcularSuperficieTotal() {
        return ParcelaRepository.findAll()
                                .stream()
                                .mapToDouble(Parcela::getSuperficie)
                                .sum();
    }

    //EXTRA 2: Filtrar parcelas por tipo de cultivo
    @Override
    public List<Parcela> filtrarPorCultivo(TipoCultivo tipo) {
        // Devolvemos solo las parcelas que coinciden con el tipo buscado.
        return ParcelaRepository.findByTipoCultivo(tipo);
    }
}
