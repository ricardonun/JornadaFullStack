/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ricardonun.jornadafullstack.pessoa;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 *
 * @author Ricardo
 */
public class Pessoa {
    
    
    public Pessoa(String nome1, LocalDate dDeNascimento){
        nome = nome1;
        dataDeNascimento = dDeNascimento;
    }
    
    
    private String nome;
    private LocalDate dataDeNascimento;
    private boolean trabalham;
    private boolean roubam;
    private int idade;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public boolean isTrabalham() {
        return trabalham;
    }

    public void setTrabalham(boolean trabalham) {
        this.trabalham = trabalham;
    }

    public boolean isRoubam() {
        return roubam;
    }

    public void setRoubam(boolean roubam) {
        this.roubam = roubam;
    }
    
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
 
    
        
    public void calculoIdade(){
       final LocalDate dataAtual = LocalDate.now();
       final Period resultado = Period.between(dataDeNascimento, dataAtual);      
       
       idade = resultado.getYears();
                  
    }
    


}
