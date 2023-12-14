/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade3.pi3.service;
import com.atividade3.PI3.Model.Lembrete;
import com.atividade3.PI3.data.LembreteEntity;
import com.atividade3.PI3.data.LembreteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class LembreteService {
    
    @Autowired 
    LembreteRepository lembreteRepository;
    
    public LembreteEntity criarLembrete(LembreteEntity lembrete) { 
    lembrete.setId(null);
    lembrete.setPaciente(null);
    lembreteRepository.save(lembrete); 
    return lembrete; 
    }
    
    public LembreteEntity atualizarLembrete(Integer lembreteId, LembreteEntity lembreteRequest) { 
    LembreteEntity lembrete = getLembreteId(lembreteId); 
    lembrete.setDescricao(lembreteRequest.getDescricao()); 
    lembrete.setDataHora(lembreteRequest.getDataHora()); 
    lembrete.setRealizado(lembreteRequest.getRealizado());
    lembrete.setPaciente(lembreteRequest.getPaciente()); 
    lembreteRepository.save(lembrete); 
    return lembrete; 
    }
    
    public LembreteEntity getLembreteId(Integer lembreteId) { 
    return lembreteRepository.findById(lembreteId).orElse(null); 
    }
    
    public List<Lembrete> getLembretePacienteId(Integer lembreteId) { 
    return lembreteRepository.findByPacienteId(lembreteId); 
    } 
    
    public List<LembreteEntity> listarTodosLembretes() { 
    return lembreteRepository.findAll(); 
    }
    
    public void deletarLembrete(Integer lembreteId) { 
    LembreteEntity lembrete = getLembreteId(lembreteId); 
    lembreteRepository.deleteById(lembrete.getId()); 
    }
}