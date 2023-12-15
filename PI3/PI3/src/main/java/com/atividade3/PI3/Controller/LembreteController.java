/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade3.PI3.Controller;

/**
 *
 * @author Pichau
 */

import com.atividade3.PI3.Model.Medico;
import com.atividade3.PI3.Model.Paciente;
import com.atividade3.pi3.service.MedicoService;
import com.atividade3.pi3.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "*")
public class LembreteController {
    
    @Autowired
    PacienteService filmeService;
    @Autowired
    MedicoService medicoService;

    @GetMapping("/login123")
    public String viewLoginPage(Model model) {
        Paciente paciente = new Paciente();
        Medico medico = new Medico();
        model.addAttribute("usuario", paciente);
        model.addAttribute("medico", medico);
        return "login";
    }
}

