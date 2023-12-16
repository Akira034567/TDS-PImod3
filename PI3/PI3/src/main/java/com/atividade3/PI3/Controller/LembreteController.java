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
    
    @GetMapping("/criarLembrete/{pacienteId}")
    public String criarFilmeForm(@PathVariable(value = "pacienteId") Integer id, Model model) {
        Lembrete lembrete = new Lembrete();
        model.addAttribute("lembrete", lembrete);
        model.addAttribute("paciente", pacienteService.getPacienteId(id));
        return "cadastroLembrete";
    }
    
    @PostMapping("/salvarLembrete/{pacienteId}")
    public String salvarLembrete(@Valid @ModelAttribute("lembrete") Lembrete lembrete, @ModelAttribute("pacienteId") Integer pacienteId, Model model) {
        Paciente paciente = pacienteService.getPacienteId(pacienteId);
        lembrete.setPaciente(paciente);
        lembreteService.criarLembreteId(lembrete);
        
        List<Lembrete> lembretes = lembreteService.getLembretePacienteId(pacienteId);
        model.addAttribute("lembretes", lembretes);
        model.addAttribute("paciente", paciente);
        return "lembretesMedico";
    }
    
    @GetMapping("/lembretes/{id}")
    public String lembretesPorPaciente(@PathVariable(value = "id") Integer id, Model model) {
        List<Lembrete> lembretes = lembreteService.getLembretePacienteId(id);
        Paciente paciente = pacienteService.getPacienteId(id);
        model.addAttribute("lembretes", lembretes);
        model.addAttribute("paciente", paciente);
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
        model.addAttribute("paciente", p);
        return "lembretesMedico";
    }
    
    @GetMapping("/excluirLembrete/{id}")
    public String deletarLembrete(@PathVariable(value = "id") Integer id, Model model) {
        lembreteService.deletarLembrete(id);
        
        return "redirect:/login";
    }
    
}

