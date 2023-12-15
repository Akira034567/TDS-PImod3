/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade3.pi3.service;
import com.atividade3.PI3.Model.Lembrete;
import com.atividade3.PI3.repository.LembreteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class LembreteService {
    
    @Autowired 
    LembreteRepository lembreteRepository;
    
    public Lembrete criarLembrete(Lembrete lembrete) { 
    lembrete.setId(null);
    lembrete.setRealizado(false);
    lembrete.setPaciente(null);
    lembreteRepository.save(lembrete); 
    return lembrete; 
    }
    
    public Lembrete atualizarLembrete(Integer lembreteId, Lembrete lembreteRequest) { 
    Lembrete lembrete = getLembreteId(lembreteId); 
    lembrete.setDescricao(lembreteRequest.getDescricao()); 
    lembrete.setData_Hora(lembreteRequest.getData_Hora()); 
    lembrete.setRealizado(lembreteRequest.getRealizado());
    lembrete.setPaciente(lembreteRequest.getPaciente()); 
    lembreteRepository.save(lembrete); 
    return lembrete; 
    }
    
    public Lembrete getLembreteId(Integer lembreteId) { 
    return lembreteRepository.findById(lembreteId).orElse(null); 
    }
    
    public List<Lembrete> getLembretePacienteId(Integer pacienteId) { 
    return lembreteRepository.findByPacienteId(pacienteId); 
    }
    
    public List<Lembrete> listarTodosLembretes() { 
    return lembreteRepository.findAll(); 
    }
    
    public void deletarLembrete(Integer lembreteId) { 
    Lembrete lembrete = getLembreteId(lembreteId); 
    lembreteRepository.deleteById(lembrete.getId()); 
    }
}