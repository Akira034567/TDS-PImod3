/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade3.PI3.Controller;

/**
 *
 * @author Pichau
 */

import com.atividade3.PI3.Model.Lembrete;
import com.atividade3.PI3.Model.Paciente;
import com.atividade3.pi3.service.LembreteService;
import com.atividade3.pi3.service.MedicoService;
import com.atividade3.pi3.service.PacienteService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@CrossOrigin(origins = "*")
public class LembreteController {
    
    @Autowired
    PacienteService pacienteService;
    @Autowired
    MedicoService medicoService;
    @Autowired
    LembreteService lembreteService;

    
    @PostMapping("/atualizarLembrete")
    public String atualizarLembrete(@Valid @ModelAttribute("lembretea") Lembrete lembretea, Model model) {
        
            Lembrete l = lembreteService.getLembreteId(lembretea.getId());
            
            lembretea.setPaciente(l.getPaciente());
            if(l.getRealizado() == false){
                lembretea.setRealizado(true);
            } else {
                lembretea.setRealizado(false);
            }
            
        
            lembreteService.atualizarLembrete(lembretea.getId(), lembretea);
        
        Paciente p = lembretea.getPaciente();
        List<Lembrete> lembretes = lembreteService.getLembretePacienteId(p.getId());
        model.addAttribute("lembretes", lembretes);
        return "lembretesPaciente";
    }
    
    @GetMapping("/criarLembrete")
    public String criarFilmeForm(Model model) {
        Lembrete lembrete = new Lembrete();
        model.addAttribute("lembrete", lembrete);
        return "cadastroLembrete";
    }
    
    @PostMapping("/salvarLembrete")
    public String salvarLembrete(@Valid @ModelAttribute("lembrete") Lembrete lembrete) {
        lembreteService.criarLembrete(lembrete);
        return "lembretesMedico";
    }
    
    @GetMapping("/lembretes/{id}")
    public String lembretesPorPaciente(@PathVariable(value = "id") Integer id, Model model) {
        List<Lembrete> lembretes = lembreteService.getLembretePacienteId(id);
        model.addAttribute("lembretes", lembretes);
        return "lembretesMedico";
    }
    
    @GetMapping("/atualizarLembrete/{id}")
    public String atualizarLembreteForm(@PathVariable(value = "id") Integer id, Model model) {
        Lembrete lembrete = lembreteService.getLembreteId(id);
        model.addAttribute("lembrete", lembrete);
        return "atualizarLembrete";
    }
    
    @PostMapping("/salvarAtualizaLembrete")
    public String salvarFilme(@Valid @ModelAttribute("lembrete") Lembrete lembrete, Model model) {
        lembreteService.atualizarLembrete(lembrete.getId(), lembrete);
        
        Paciente p = lembrete.getPaciente();
        List<Lembrete> lembretes = lembreteService.getLembretePacienteId(p.getId());
        model.addAttribute("lembretes", lembretes);
        return "lembretesMedico";
    }
    
    @GetMapping("/excluirLembrete/{id}")
    public String deletarLembrete(@PathVariable(value = "id") Integer id, Model model) {
        lembreteService.deletarLembrete(id);
        
        Lembrete lembrete = lembreteService.getLembreteId(id);
        Paciente p = lembrete.getPaciente();
        List<Lembrete> lembretes = lembreteService.getLembretePacienteId(p.getId());
        model.addAttribute("lembretes", lembretes);
        return "lembretesMedico";
    }
    
}

