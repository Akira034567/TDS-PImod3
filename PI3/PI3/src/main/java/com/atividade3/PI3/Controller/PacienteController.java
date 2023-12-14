/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade3.PI3.Controller;

/**
 *
 * @author Pichau
 */
/*import com.atividade3.PI3.Model.Medico;
import com.atividade3.PI3.Model.Paciente;
import com.atividade3.PI3.data.MedicoEntity;
import com.atividade3.PI3.data.PacienteEntity;
import com.atividade3.pi3.service.MedicoService;
import com.atividade3.pi3.service.PacienteService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@CrossOrigin(origins = "*")*/
public class PacienteController {
    
}
    
    /*
    @Autowired
    PacienteService filmeService;
    @Autowired
    MedicoService medicoService;

    @GetMapping("/login")
    public String viewLoginPage(Model model) {
        PacienteEntity paciente = new PacienteEntity();
        MedicoEntity medico = new MedicoEntity();
        model.addAttribute("paciente", paciente);
        model.addAttribute("medico", medico);
        return "login";
    }

    @PostMapping("/login") 
        public ModelAndView verificaCadastro(@ModelAttribute Usuario usuario, HttpServletResponse response){ 
            if("medico".equals(usuario.getTipoLogin())){
                return new ModelAndView("redirect:/");
            } else {
                return new ModelAndView("redirect:/");
        }
    }
    
    
    
    */
    
    
    
    
    
    
    
    
    
    
    
    /*
    @GetMapping("/deletarFilme/{id}")
    public String deletarFilme(@PathVariable(value = "id") Integer id) {
        filmeService.deletarFilme(id);
        return "redirect:/";
    }

    @GetMapping("/criarFilmeForm")
    public String criarFilmeForm(@CookieValue(name="pref-nome", defaultValue="")String nome, @CookieValue(name="pref-estilo", defaultValue="claro")String tema, Model model) { 
        model.addAttribute("nome", nome);   
        model.addAttribute("css", tema); 
        FilmeEntity filme = new FilmeEntity();
        model.addAttribute("filme", filme);
        return "inserir";
    }

    @PostMapping("/salvarFilme")
    public String salvarFilme(@Valid @ModelAttribute("filme") FilmeEntity filme, BindingResult result) {
        if (result.hasErrors()) {
            return "inserir";
        }
        if (filme.getId() == null) {
            filmeService.criarFilme(filme);
        } else {
            filmeService.atualizarFilme(filme.getId(), filme);
        }
        return "redirect:/";
    }
    
    @GetMapping("/atualizarFilmeForm/{id}")
    public String atualizarFilmeForm(@CookieValue(name="pref-nome", defaultValue="")String nome, @CookieValue(name="pref-estilo", defaultValue="claro")String tema, @PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("nome", nome);   
        model.addAttribute("css", tema); 
        FilmeEntity filme = filmeService.getFilmeId(id);
        model.addAttribute("filme", filme);
        return "atualizar";
    }
    
    @RequestMapping("/preferencias1")
        public String preferencias(){
        return "preferencias1";
    }
     
    @PostMapping("/preferencias1") 
        public ModelAndView gravaPreferencias(@ModelAttribute Preferencia pref, HttpServletResponse response){ 
        Cookie cookiePrefNome = new Cookie("pref-nome", pref.getNome()); 
        cookiePrefNome.setDomain("localhost");
        cookiePrefNome.setHttpOnly(true);
        cookiePrefNome.setMaxAge(86400);
        response.addCookie(cookiePrefNome);
        
        Cookie cookiePrefEstilo = new Cookie("pref-estilo", pref.getEstilo()); 
        cookiePrefEstilo.setDomain("localhost");
        cookiePrefEstilo.setHttpOnly(true);
        cookiePrefEstilo.setMaxAge(86400);
        response.addCookie(cookiePrefEstilo);
        
         return new ModelAndView("redirect:/");
    }
    }*/

