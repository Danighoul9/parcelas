package com.daw.parcelas.controller;

import com.daw.parcelas.services.ParcelaServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ParcelaController {

    //PARTE DE DANIEL DÍAZ CAMPOY
    private final ParcelaServiceImpl parcelaService;

    public ParcelaController(ParcelaServiceImpl parcelaService) {
        this.parcelaService = parcelaService;
    }

    @GetMapping
    public String listar(Model model) {
        //Obtenemos todas las parcelas con ayuda del metodo .listarTodas() del servicio
        model.addAttribute("parcelas", parcelaService.listarTodas());
        return "parcelas/lista"; // → templates/parcelas/lista.html
    }

    @GetMapping("/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        //Obtenemos todas las parcelas con ayuda del metodo .buscarPorId() del servicio
        model.addAttribute("parcela", parcelaService.buscarPorId(id));
        return "parcelas/detalle"; // → templates/parcelas/detalle.html (En este caso)
    }


}
