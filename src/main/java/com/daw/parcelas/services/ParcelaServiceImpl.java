package com.daw.parcelas.services;

import com.daw.parcelas.model.Parcela;
import com.daw.parcelas.model.TipoCultivo;
import com.daw.parcelas.repository.ParcelaRepository;
import com.daw.parcelas.exceptions.RecursoNoEncontradoException;
import org.springframework.stereotype.Service;

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
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No existe la parcela con id " + id));
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
    public double calcularSuperficieTotal(List<Parcela> parcelas) {
        return parcelas.stream()
                .mapToDouble(Parcela::getSuperficie)
                .sum();
    }

    //EXTRA 2: Filtrar parcelas por tipo de cultivo
    @Override
    public List<Parcela> filtrarPorCultivo(TipoCultivo tipo) {
        // Devolvemos solo las parcelas que coinciden con el tipo buscado.
        return ParcelaRepository.findByTipoCultivo(tipo);
    }

    //EXTRA 3: Listar parcelas ordenadas por nombre
    @Override
    public List<Parcela> listarOrdenadas() {
        return ParcelaRepository.findAllByOrderByNombreAsc();
    }

    // Para el filtrado de parcelas por nombre y tipo de cultivo
    @Override
    public List<Parcela> filtrarParcelasPorNombreYTipo(String nombre, String tipo) {
        // Si el tipo es "TODOS", devolvemos todas las parcelas que contengan el nombre, ignorando mayúsculas y minúsculas
        if ("TODOS".equals(tipo)) {
            return ParcelaRepository.findAll().stream()
                    .filter(parcela -> parcela.getNombre()
                            .toLowerCase()
                            .contains(nombre.toLowerCase()))
                    .toList();
            // Si el tipo no es "TODOS", devolvemos las parcelas que contengan el nombre y coincidan con el tipo de cultivo
        }else {
            return ParcelaRepository.findAllByNombreContainingIgnoreCaseAndTipoCultivoEquals(nombre, TipoCultivo.valueOf(tipo));
        }
    }

    // Método para contar el número total de parcelas
    @Override
    public long contar() {
        return ParcelaRepository.count();
    }
}