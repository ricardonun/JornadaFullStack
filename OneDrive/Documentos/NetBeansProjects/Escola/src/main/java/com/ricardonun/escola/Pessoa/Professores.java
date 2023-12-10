/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ricardonun.escola.Pessoa;

/**
 *
 * @author Ricardo
 */
public class Professores extends Pessoa implements ControleSala{
    
    final String id;
    private String materia;
    private Integer sala;
    
    public Professores(String _nome, String _ultimoNome, String _cpf, String _id, String _materia) {
        super(_nome, _ultimoNome, _cpf);
        this.id = _id;
        this.materia = _materia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public void setSala(Integer _sala) {
        this.sala = _sala;
    }
    
}
