package com.daw.parcelas.controller;

import com.daw.parcelas.model.Calidad;
import com.daw.parcelas.services.ParcelaService;
import com.daw.parcelas.services.ProduccionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
    private final ParcelaService parcelaService;
    private final ProduccionService produccionService;

    public InicioController(ParcelaService parcelaService, ProduccionService produccionService) {
        this.parcelaService = parcelaService;
        this.produccionService = produccionService;
    }

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("totalParcelas", parcelaService.contar());
        model.addAttribute("superficieTotal", parcelaService.calcularSuperficieTotal(parcelaService.listarTodas()));
        model.addAttribute("kilosTotales", produccionService.calcularTotalKilos(produccionService.listarTodas()));
        model.addAttribute("totalExtra", produccionService.contarPorCalidad(Calidad.EXTRA));
        model.addAttribute("totalPrimera", produccionService.contarPorCalidad(Calidad.PRIMERA));
        model.addAttribute("totalSegunda", produccionService.contarPorCalidad(Calidad.SEGUNDA));
        model.addAttribute("ultimas", produccionService.ultimas());

        return "dashboard";
    }
}
