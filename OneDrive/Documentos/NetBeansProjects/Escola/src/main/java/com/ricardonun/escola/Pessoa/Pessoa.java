/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ricardonun.escola.Pessoa;

/**
 *
 * @author Ricardo
 */
public abstract class Pessoa {
    private String nome;
    private String ultimoNome;
    final String cpf;
    
    
    public Pessoa(String _nome,String _ultimoNome,String _cpf){
        this.nome = _nome;
        this.ultimoNome = _ultimoNome;
        this.cpf = _cpf;
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }
    
    
}
