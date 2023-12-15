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
import jakarta.servlet.http.HttpServletResponse;
import static java.awt.SystemColor.window;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@CrossOrigin(origins = "*")
public class PacienteController {
    
    @Autowired
    PacienteService pacienteService;
    @Autowired
    MedicoService medicoService;

    @GetMapping("/login")
    public String viewLoginPage(Model model) {
        Paciente paciente = new Paciente();
        Medico medico = new Medico();
        model.addAttribute("usuario", paciente);
        model.addAttribute("medico", medico);
        return "login";
    }
    
      @PostMapping("/login")
        public String gravaPreferencias(@ModelAttribute Paciente paciente, @ModelAttribute Medico medico, HttpServletResponse response){
            if("medico".equals(paciente.getRG())){
                List<Medico> medicos = medicoService.listarTodosMedicos();
                for(Medico m: medicos){
                    if((m.getNome().equals(medico.getNome())) && (m.getSenha().equals(medico.getSenha()))){
                        return "cadastroMedico";
                    }
                }
            } else {
                List<Paciente> pacientes = pacienteService.listarTodosPacientes();
                for(Paciente p: pacientes){
                    if((p.getNome().equals(paciente.getNome())) && (p.getSenha().equals(paciente.getSenha()))){
                        return "cadastroPaciente";
                    }
                }
            }
            return "login";
    }
}

