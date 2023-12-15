/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade3.PI3.blablabla;

import com.atividade3.PI3.blablabla.Medico1;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component 
public class Paciente1 {
    int id;
    String nome;
    String RG;
    String senha;
    Date dataNasc;
    
    @ManyToOne
    @JoinColumn(name = "medicoId")
    Medico1 medico;

    public Paciente1(int id, String nome, String RG, String senha) {
        this.id = id;
        this.nome = nome;
        this.RG = RG;
        this.senha = senha;
    }

    public Paciente1(int id, String nome, String RG, String senha, Date dataNasc, Medico1 medico) {
        this.id = id;
        this.nome = nome;
        this.RG = RG;
        this.senha = senha;
        this.dataNasc = dataNasc;
        this.medico = medico;
    }

    public Paciente1(int id, String nome, String RG, String senha, Date dataNasc) {
        this.id = id;
        this.nome = nome;
        this.RG = RG;
        this.senha = senha;
        this.dataNasc = dataNasc;
    }

    public Paciente1() {
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

    public Medico1 getMedico() {
        return medico;
    }

    public void setMedico(Medico1 medico) {
        this.medico = medico;
    }

   
}