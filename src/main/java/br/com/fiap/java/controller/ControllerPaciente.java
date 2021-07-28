package br.com.fiap.java.controller;

import br.com.fiap.java.model.Pacientes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class ControllerPaciente {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/pacientes")
    public String pacientes(Model model) {
        return "pacientes";
    }
}
