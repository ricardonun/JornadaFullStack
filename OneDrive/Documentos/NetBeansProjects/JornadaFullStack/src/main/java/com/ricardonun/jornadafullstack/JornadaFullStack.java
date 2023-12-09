/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ricardonun.jornadafullstack;

import com.ricardonun.jornadafullstack.pessoa.Ladroes;
import com.ricardonun.jornadafullstack.pessoa.Pessoa;
import com.ricardonun.jornadafullstack.pessoa.Trabalhadores;
import com.ricardonun.jornadafullstack.pessoa.TrabalhadoresRural;
import java.time.LocalDate;

/**
 *
 * @author Ricardo
 */
public class JornadaFullStack {

    public static void main(String[] args) {
        
       //Exercicio 1 
       Trabalhadores trabalhador = new Trabalhadores("Ricardo Nunes", LocalDate.parse("1998-02-17"), LocalDate.parse("2000-02-17"));
       Ladroes ladrao = new Ladroes("Pietro Emmauel", LocalDate.parse("1998-06-09"));
       TrabalhadoresRural trabalhorRual = new TrabalhadoresRural("Kleytin Mach", LocalDate.parse("1985-02-11"));
    }
}
