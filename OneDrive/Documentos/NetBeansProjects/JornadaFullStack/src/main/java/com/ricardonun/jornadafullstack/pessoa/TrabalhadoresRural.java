/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ricardonun.jornadafullstack.pessoa;

import java.time.LocalDate;

/**
 *
 * @author Ricardo
 */
public class TrabalhadoresRural extends Pessoa {

    final int salarioBase = 4800;
     
    public TrabalhadoresRural(String nome, LocalDate dDeNascimento) {
        super(nome, dDeNascimento);
        calculoIdade();
        setTrabalham(false);
        
        
        System.out.println("Seu nome: " + this.getNome() + " Idade: " + this.getIdade()+ " Trabalha: " + this.isTrabalham() + " Salario: " + this.salarioBase + " Tipo de trabalho: " + " Rural" );

    }

    
    
}
