package com.daw.parcelas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound(RecursoNoEncontradoException ex, Model model) {
        model.addAttribute("titulo", "Recurso no encontrado");
        model.addAttribute("mensaje", ex.getMessage());
        model.addAttribute("codigo", 404);
        return "error/pagina-error";   // templates/error/pagina-error.html
    }

    // 404 de rutas inexistentes (Spring Boot 3.2+)
    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoResource(Model model) {
        model.addAttribute("titulo", "Página no encontrada");
        model.addAttribute("mensaje", "La URL solicitada no existe.");
        model.addAttribute("codigo", 404);
        return "error/pagina-error";
    }

    // Red de seguridad para cualquier otra cosa
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleGeneral(Exception ex, Model model) {
        model.addAttribute("titulo", "Error interno");
        model.addAttribute("mensaje", "Ha ocurrido un error inesperado.");
        model.addAttribute("codigo", 500);
        return "error/pagina-error";
    }
}