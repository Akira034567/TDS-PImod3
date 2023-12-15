/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade3.PI3.blablabla;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Component;

@Component 
public class Lembrete1 {
    int id;
    String descricao;
    String dataHora;
    Boolean realizado;
    
    @ManyToOne
    @JoinColumn(name = "pacienteId")
    Paciente1 paciente;

    public Lembrete1(int id, String descricao, String dataHora, Boolean realizado) {
        this.id = id;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.realizado = realizado;
    }

    public Lembrete1(int id, String descricao, String dataHora, Boolean realizado, Paciente1 paciente) {
        this.id = id;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.realizado = realizado;
        this.paciente = paciente;
    }

    public Lembrete1() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public Boolean getRealizado() {
        return realizado;
    }

    public void setRealizado(Boolean realizado) {
        this.realizado = realizado;
    }

    public Paciente1 getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente1 paciente) {
        this.paciente = paciente;
    }
    
    
}