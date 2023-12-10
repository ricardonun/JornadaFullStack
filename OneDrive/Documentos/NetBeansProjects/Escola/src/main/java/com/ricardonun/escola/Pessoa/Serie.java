/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.ricardonun.escola.Pessoa;

/**
 *
 * @author Ricardo
 */
public enum Serie {
    QUINTA("Quinta Serie",5,new String[] {"Matematica","Portugues"}),
    SEXTA("Sexta Serie",6,new String[]{"Matematica","Portugues","Fisica"}),
    SETETIMA("Setima Serie",7,new String[]{"Matematica","Portugues","Fisica","Quimica"}),
    OITAVA("Oitava Serie",8, new String[]{"Matematica","Portugues","Fisica","Quimica","Educaçao Fisica"});
    
    private String descricao;
    private Integer numeroSerie;
    private String[] materias;
    
    Serie(String _descricao, Integer _numeroSerie, String[] _materias){
        this.descricao = _descricao;
        this.numeroSerie = _numeroSerie;
        this.materias = _materias;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getNumeroSerie() {
        return numeroSerie;
    }

    public String[] getMaterias() {
        return materias;
    }
    
    
}
