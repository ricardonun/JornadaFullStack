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
public class Ladroes extends Pessoa {
    
    public Ladroes(String nome1, LocalDate dDeNascimento) {
        super(nome1, dDeNascimento);
        calculoIdade();
        setRoubam(false);
        
        
        System.out.println("Seu nome: " + this.getNome() + " Idade: " + this.getIdade()+ " Roubam: " + this.isRoubam());

    }

    @Override
    public void setRoubam(boolean roubam) {
        
        if(this.getIdade() > 11){
            super.setRoubam(true);
        }
    }
    
    
    
}
