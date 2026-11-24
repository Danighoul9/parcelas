package com.daw.parcelas.repository;

import com.daw.parcelas.model.Calidad;
import com.daw.parcelas.model.Produccion;
import com.daw.parcelas.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduccionRepository extends JpaRepository<Produccion, Long> {
    List<Produccion> findAllByOrderByFechaRecoleccionDesc();
    List<Produccion> findByProductoOrderByFechaRecoleccionDesc(Producto producto);
    List<Produccion> findByCalidadOrderByFechaRecoleccionDesc(Calidad calidad);
    List<Produccion> findByProductoAndCalidadOrderByFechaRecoleccionDesc(Producto producto, Calidad calidad);
    long countByCalidad(Calidad calidad);
    List<Produccion> findTop5ByOrderByFechaRecoleccionDesc();
}