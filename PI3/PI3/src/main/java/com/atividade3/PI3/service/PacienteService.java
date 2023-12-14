/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade3.pi3.service;
import com.atividade3.PI3.Model.Paciente;
import com.atividade3.PI3.data.PacienteEntity;
import com.atividade3.PI3.data.PacienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class PacienteService {
    
    @Autowired 
    PacienteRepository pacienteRepository;
    
    public PacienteEntity criarPaciente(PacienteEntity paciente) { 
    paciente.setId(null);
    paciente.setMedico(null);
    pacienteRepository.save(paciente); 
    return paciente; 
    }
    
    public PacienteEntity atualizarPaciente(Integer pacienteId, PacienteEntity pacienteRequest) { 
    PacienteEntity paciente = getPacienteId(pacienteId); 
    paciente.setNome(pacienteRequest.getNome()); 
    paciente.setRG(pacienteRequest.getRG()); 
    paciente.setSenha(pacienteRequest.getSenha());
    paciente.setDataNasc(pacienteRequest.getDataNasc());
    paciente.setMedico(pacienteRequest.getMedico()); 
    pacienteRepository.save(paciente); 
    return paciente; 
    }
    
    public PacienteEntity getPacienteId(Integer pacienteId) { 
    return pacienteRepository.findById(pacienteId).orElse(null); 
    }
    
    public List<Paciente> getPacienteMedicoId(Integer pacienteId) { 
    return pacienteRepository.findByMedicoId(pacienteId); 
    } 
    
    public List<PacienteEntity> listarTodosPacientes() { 
    return pacienteRepository.findAll(); 
    }
    
    public void deletarPaciente(Integer pacienteId) { 
    PacienteEntity paciente = getPacienteId(pacienteId); 
    pacienteRepository.deleteById(paciente.getId()); 
    }
}