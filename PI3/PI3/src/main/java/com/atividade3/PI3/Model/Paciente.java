/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade3.PI3.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;
import lombok.Data;

@Data 
@Entity 
@Table(name="Paciente") 
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotBlank(message="Nome obrigatório")
    private String nome;
    
    @NotBlank(message="RG obrigatório")
    private String RG;
    
    @NotBlank(message="Senha obrigatória")
    private String senha;
    
    private String dataNasc;
    
    @ManyToOne
    @JoinColumn(name = "medicoId")
    private Medico medico;
} 