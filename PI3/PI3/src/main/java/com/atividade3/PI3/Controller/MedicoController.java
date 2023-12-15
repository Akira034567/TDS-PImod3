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
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@CrossOrigin(origins = "*")
public class MedicoController {
    
    @Autowired
    PacienteService filmeService;
    @Autowired
    MedicoService medicoService;

    @GetMapping("/cadastrarMedico")
    public String criarMedicoForm(Model model) {
        Medico medico = new Medico();
        model.addAttribute("medico", medico);
        return "cadastroMedico";
    }    
        
    @PostMapping("/salvarMedico")
    public String salvarMedico(@Valid @ModelAttribute Medico medico) {
        if(medico.getNome() != null){
        medicoService.criarMedico(medico);
        return "lembretesPaciente";
    }
        return "login";
    }
}

