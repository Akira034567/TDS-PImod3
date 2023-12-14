/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade3.PI3.Model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component 
public class Paciente {
    int id;
    String nome;
    String RG;
    String senha;
    Date dataNasc;
    
    @ManyToOne
    @JoinColumn(name = "Medico_responsavel_id")
    Medico medico;

    public Paciente(int id, String nome, String RG, String senha) {
        this.id = id;
        this.nome = nome;
        this.RG = RG;
        this.senha = senha;
    }

    public Paciente(int id, String nome, String RG, String senha, Date dataNasc, Medico medico) {
        this.id = id;
        this.nome = nome;
        this.RG = RG;
        this.senha = senha;
        this.dataNasc = dataNasc;
        this.medico = medico;
    }

    public Paciente(int id, String nome, String RG, String senha, Date dataNasc) {
        this.id = id;
        this.nome = nome;
        this.RG = RG;
        this.senha = senha;
        this.dataNasc = dataNasc;
    }

    public Paciente() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

   
}