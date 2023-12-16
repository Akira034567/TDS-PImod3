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
import com.atividade3.PI3.Model.Medico;
import com.atividade3.PI3.Model.Paciente;
import com.atividade3.pi3.service.MedicoService;
import com.atividade3.pi3.service.PacienteService;
import com.atividade3.pi3.service.LembreteService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@CrossOrigin(origins = "*")
public class PacienteController {
    
    @Autowired
    PacienteService pacienteService;
    @Autowired
    MedicoService medicoService;
    @Autowired
    LembreteService lembreteService;

    @GetMapping("/login")
    public String viewLoginPage(Model model) {
        return "login";
    }
    
    @PostMapping("/login")
        public String gravaPreferencias(@ModelAttribute Paciente paciente, @ModelAttribute Medico medico, Model model){
            if("medico".equals(paciente.getRG())){
                List<Medico> medicos = medicoService.listarTodosMedicos();
                for(Medico m: medicos){
                    if((m.getNome().equals(medico.getNome())) && (m.getSenha().equals(medico.getSenha()))){
                        
                        List<Paciente> pacientes = pacienteService.getPacienteMedicoId(m.getId());
                        Medico med = medicoService.getMedicoId(m.getId());
                        model.addAttribute("pacientes", pacientes);
                        model.addAttribute("medico", med);
                        return "pacientes";
                    }
                }
            } else {
                List<Paciente> pacientes = pacienteService.listarTodosPacientes();
                for(Paciente p: pacientes){
                    if((p.getNome().equals(paciente.getNome())) && (p.getSenha().equals(paciente.getSenha()))){
                        
                        List<Lembrete> lembretes = lembreteService.getLembretePacienteId(p.getId());
                        Lembrete lembretea = new Lembrete();
                        model.addAttribute("lembretes", lembretes);
                        model.addAttribute("lembretea", lembretea);
                        
                        return "lembretesPaciente";
                    }
                }
            }
            return "erro";
    }
        
    @GetMapping("/cadastrarPaciente")
    public String criarPacienteForm(Model model) {
        Paciente paciente = new Paciente();
        model.addAttribute("paciente", paciente);
        return "cadastroPaciente";
    }    
        
    @PostMapping("/salvarPaciente")
    public String salvarPaciente(@Valid @ModelAttribute Paciente paciente) {
        if(paciente.getNome() != null){
        pacienteService.criarPaciente(paciente);
        return "lembretesPaciente";
    }
        return "login";
    }
    
    @GetMapping("/todosPacientes/{idMedico}")
    public String listarTodosPacientes(@PathVariable(value = "idMedico") Integer idMedico, Model model) {
        List<Paciente> pacientes = pacienteService.listarTodosPacientes();
        Medico medico = medicoService.getMedicoId(idMedico);
        model.addAttribute("pacientes", pacientes);
        model.addAttribute("medico", medico);
        return "pacientesall";
    }    
    
    @PostMapping("/pacienteMedico/{idPaciente}/{idMedico}")
    public String salvarPacienteMedico(@ModelAttribute("idPaciente") Integer idPaciente, @ModelAttribute("idMedico") Integer idMedico, Model model) {
        Paciente paciente = pacienteService.getPacienteId(idPaciente);
        Medico medico = medicoService.getMedicoId(idMedico);
        paciente.setMedico(medico);
        pacienteService.atualizarPaciente(paciente.getId(), paciente);
        
        List<Lembrete> lembretes = lembreteService.getLembretePacienteId(idPaciente);
        model.addAttribute("lembretes", lembretes);
        model.addAttribute("paciente", paciente);
        return "lembretesMedico";
    }
}

