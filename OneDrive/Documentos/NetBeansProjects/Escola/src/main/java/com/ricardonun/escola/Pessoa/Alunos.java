/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ricardonun.escola.Pessoa;

/**
 *
 * @author Ricardo
 */
public class Alunos extends Pessoa implements ControleSala {
    
    final String ra;
    private Serie serie;
    private Integer sala;

    public Alunos(String _nome, String _ultimoNome, String _cpf, String _ra, Serie _serie ) {
        super(_nome, _ultimoNome, _cpf);
        this.ra = _ra;
        this.serie = _serie;
        
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public void setSala(Integer _sala) {
        this.sala = _sala;
    }
}
