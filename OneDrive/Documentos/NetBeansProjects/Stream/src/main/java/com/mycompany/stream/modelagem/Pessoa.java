package com.mycompany.stream.modelagem;

/**
 * Class: Pessoa.
 *
 * <p>
 * Insert description here.
 * </p>
 *
 * <p>
 * History:<br><br>
 * - william - 1 de fev de 2022: Criação do Arquivo<br>
 * <p>
 *
 * @author william
 * @since 1.0
 *
 */
public class Pessoa {

    String nome;
    Integer idade;

    public Pessoa(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void print() {
        System.out.println("Nome:".concat(this.nome));
        System.out.println("Idade:".concat(this.idade.toString()));
        System.out.println("");
    }
    
    public static void printCustom(String prop, String value) {
        System.out.println(prop.concat(": ").concat(value));
        System.out.println("");
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }
    
    
}
