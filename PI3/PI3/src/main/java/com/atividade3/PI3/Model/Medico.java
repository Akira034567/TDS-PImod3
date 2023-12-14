/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade3.PI3.Model;

import org.springframework.stereotype.Component;

@Component 
public class Medico {
    int id;
    String Nome;
    String RG;
    String senha;
    String endereco;

    public Medico(int id, String Nome, String senha) {
        this.id = id;
        this.Nome = Nome;
        this.senha = senha;
    }

    public Medico(int id, String Nome, String RG, String senha, String endereco) {
        this.id = id;
        this.Nome = Nome;
        this.RG = RG;
        this.senha = senha;
        this.endereco = endereco;
    }

    public Medico() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
}
