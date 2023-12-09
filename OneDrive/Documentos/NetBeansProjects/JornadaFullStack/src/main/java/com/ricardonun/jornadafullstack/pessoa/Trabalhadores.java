/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ricardonun.jornadafullstack.pessoa;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Ricardo
 */
public class Trabalhadores extends Pessoa{
    
    final int salarioBase = 5000;
    private double salarioAtual;
    private LocalDate dataDeInicioTrabalho;
    private int anosTrabalhados;
  
    public Trabalhadores(String nome, LocalDate dDeNascimento, LocalDate DataInicioTrabalho) {
        super(nome, dDeNascimento);
        this.dataDeInicioTrabalho = DataInicioTrabalho;
        anosTrabalhados();
        calculoIdade();
        setTrabalham(false);
        aumentoSalario(anosTrabalhados);
        
        System.out.println("Seu nome: " + this.getNome() + " Idade: " + this.getIdade()+ " Trabalha: " + this.isTrabalham() + " Salario: " + this.salarioAtual );

    }

    public int getSalarioBase() {
        return salarioBase;
    }

    @Override
    public void setTrabalham(boolean trabalham) {
        if(this.getIdade() > 15 && this.getIdade() <75){
            
            super.setTrabalham(true);
        }
    }
    
    public void anosTrabalhados(){
        final LocalDate dataAtual = LocalDate.now();
        final Period resultado = Period.between(dataDeInicioTrabalho, dataAtual);
        
        anosTrabalhados = resultado.getYears();
    }
    
    public void aumentoSalario(int AnosTrabalhados){
        if(AnosTrabalhados > 0){
           final int valorAumento = (AnosTrabalhados/5);
           double porcentagem = Double.valueOf(valorAumento)*10/100 + 1;
            if(valorAumento > 0){
                this.salarioAtual = this.salarioBase * porcentagem;
                System.out.println(salarioAtual);
            }
        }
    }
        

}
