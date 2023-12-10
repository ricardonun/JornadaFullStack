/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ricardonun.escola;

import com.ricardonun.escola.Pessoa.Alunos;
import com.ricardonun.escola.Pessoa.Professores;
import com.ricardonun.escola.Pessoa.Serie;

/**
 *
 * @author Ricardo
 */
public class Escola {

    
    public static void main(String[] args) {
        
        Alunos aluno = new Alunos("Jhon", "doe", "111.111.111-11", "111.111.11", Serie.OITAVA);
        System.out.println(aluno.getNome() + " " + aluno.getSerie().getDescricao());
        
        
        Professores professor = new Professores("Roberto", "Souza", "222.222.222-22", "5", "Matematica");
        System.out.println(professor.getNome() +" " +  professor.getMateria());
    }
}
