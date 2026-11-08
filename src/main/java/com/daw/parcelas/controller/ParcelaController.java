package com.daw.parcelas.controller;

import com.daw.parcelas.model.Parcela;
import com.daw.parcelas.services.ParcelaServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/parcelas")
public class ParcelaController {

    //PARTE DE DANIEL DÍAZ CAMPOY

    private final ParcelaServiceImpl parcelaService;

    public ParcelaController(ParcelaServiceImpl parcelaService) {
        this.parcelaService = parcelaService;
    }

    @GetMapping
    public String listar(Model model) {
        //Obtenemos todas las parcelas con ayuda del metodo .listarTodas() del servicio
        // model.addAttribute("parcelas", parcelaService.listarTodas());

        //ACTUALIZACIÓN: Ahora se listan las parcelas ordenadas por nombre, esto es el EXTRA 3
        model.addAttribute("parcelas", parcelaService.listarOrdenadas());
        //Añadimos lo de superficie total al metodo para pasarselo a la vista, esto es el EXTRA 1
        model.addAttribute("superficieTotal", parcelaService.calcularSuperficieTotal());
        return "parcelas/lista"; // → templates/parcelas/lista.html
    }

    @GetMapping("/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        //Obtenemos todas las parcelas con ayuda del metodo .buscarPorId() del servicio
        model.addAttribute("parcela", parcelaService.buscarPorId(id));
        return "parcelas/detalle"; // → templates/parcelas/detalle.html (En este caso)
    }

    //PARTE DE MIRIAN GONZÁLEZ RODRÍGUEZ

    @GetMapping("/nueva")
    public String nueva(Model model) {
        //Creamos un nuevo objeto Parcela y lo añadimos al modelo para que el formulario pueda rellenarlo
        model.addAttribute("parcela", new Parcela());
        return "parcelas/formulario"; // → templates/parcelas/formulario.html
    }

    @PostMapping()
    public String guardar(Parcela parcela) {
        //Guardamos la parcela con ayuda del metodo .guardar() del servicio
        parcelaService.guardar(parcela);
        return "redirect:/parcelas"; // Redirigimos a la lista de parcelas después de guardar
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        //Eliminamos la parcela con ayuda del metodo .eliminar() del servicio
        parcelaService.eliminar(id);
        return "redirect:/parcelas"; // Redirigimos a la lista de parcelas después de eliminar


    }

    // EXTRA 2: Filtrar parcelas por tipo de cultivo
    @GetMapping("/cultivo/{tipo}")
    public String filtrarPorCultivo(@PathVariable com.daw.parcelas.model.TipoCultivo tipo, Model model) {
        model.addAttribute("parcelas", parcelaService.filtrarPorCultivo(tipo));
        return "parcelas/lista"; // → templates/parcelas/lista.html
    }

}
