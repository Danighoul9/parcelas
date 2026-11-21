package com.daw.parcelas.controller;

import com.daw.parcelas.model.Calidad;
import com.daw.parcelas.model.Produccion;
import com.daw.parcelas.model.Producto;
import com.daw.parcelas.services.ProduccionServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/producciones")
public class ProduccionController {

    private final ProduccionServiceImpl produccionService;

    public ProduccionController(
            ProduccionServiceImpl produccionService) {
        this.produccionService = produccionService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute(
                "producciones",
                produccionService.listarTodas()
        );
        return "producciones/lista";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("produccion", new Produccion());
        model.addAttribute("productos", Producto.values());
        model.addAttribute("calidades", Calidad.values());
        return "producciones/formulario";
    }

    @PostMapping
    public String guardar(@ModelAttribute("produccion") Produccion produccion) {
        produccionService.guardar(produccion);
        return "redirect:/producciones";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        produccionService.eliminar(id);
        return "redirect:/producciones";
    }

    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("produccion",produccionService.buscarPorId(id));
        model.addAttribute("productos", Producto.values());
        model.addAttribute("calidades", Calidad.values());
        return "producciones/formulario";
    }
}