/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade3.PI3.repository;

import com.atividade3.PI3.Model.Lembrete;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 

@Repository
public interface LembreteRepository extends JpaRepository<Lembrete, Integer>{
    
    List<Lembrete> findByPacienteId(Integer id);
}
