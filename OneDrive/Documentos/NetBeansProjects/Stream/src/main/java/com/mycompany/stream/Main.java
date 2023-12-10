package com.mycompany.stream;

import com.mycompany.stream.modelagem.Pessoa;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Class: Main.
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
public class Main {

    public static void main(String[] args) {
        Collection<Pessoa> pessoaList = doPopulaPessoa();

        showExemploAnyMatch(pessoaList);
        showExemploFiltereForeach(pessoaList);
        showExemploMapeFiltereForeach(pessoaList);
        showExemploMapReduce(pessoaList);
        showExemploFindFirsteFindAnyteOptional(pessoaList);
        showExemploCollect(pessoaList);
       showExemploOrderBy(pessoaList);
        showExemploCount(pessoaList);
    }

    public static Collection<Pessoa> doPopulaPessoa() {
        Collection<Pessoa> pessoaList = new ArrayList<>();
        pessoaList.add(new Pessoa("Jordionor", 20));
        pessoaList.add(new Pessoa("Bar abjones", 30));
        pessoaList.add(new Pessoa("Kirby", 15));
        pessoaList.add(new Pessoa("Enriqueta", 57));
        pessoaList.add(new Pessoa("Genetílides", 11));
        pessoaList.add(new Pessoa("Evódia", 57));
        pessoaList.add(new Pessoa("Egislaine", 60));
        return pessoaList;
    }

    //obs.: existe também o none match, que seja mesma premissa, claro que procurando de forma negada.
    public static void showExemploAnyMatch(Collection<Pessoa> pessoaList) {
        System.out.println("=============================");
        System.out.println("1 - AnyMatch:");

        Boolean condicao = pessoaList.stream()
                //anyMatch é muito utilizado em if.
                //Lembrando que é sempre uma boa prática verificar se a lista está != null antes de executar stream.
                .anyMatch(p -> p.getNome().equals("kirby") || p.getIdade().compareTo(30) == 0);
        Pessoa.printCustom("Condição", condicao.toString());

        System.out.println("=============================");
        System.out.println("1.1 - Exercícios:");

        System.out.println("=============================");
        System.out.println("a. Execute AnyMach para verificar se existe pessoa com nome igual José:");
        //codigo exercício a
        Boolean condicao2 = pessoaList.stream()
                .anyMatch(p -> p.getNome().equals("José"));
        Pessoa.printCustom("Condição", condicao2.toString() );
        System.out.println("=============================");

        System.out.println("=============================");
        System.out.println("b. Execute AnyMach para verificar se existe pessoa com idade menor igual a 20 anos:");
        //codigo exercício b
        Boolean condicaoB = pessoaList.stream()
                .anyMatch(p -> p.getIdade().compareTo(20) > 0);
        Pessoa.printCustom("Condição", condicaoB.toString());
        System.out.println("=============================");
        
        System.out.println("=============================");
        System.out.println(
                "c. Execute AnyMach para verificar se existe pessoa com nome iniciado por B no nome e 30 anos:");
        //codigo exercício c
        Boolean condicaoC = pessoaList.stream()
                .anyMatch(p -> p.getNome().startsWith("B") && p.getIdade().compareTo(30) == 0);
        Pessoa.printCustom("Condição", condicaoC.toString());
        System.out.println("=============================");
    }

    public static void showExemploFiltereForeach(Collection<Pessoa> pessoaList) {
        System.out.println("\n\n=============================");
        System.out.println("2 - Filter e forEach:");

        pessoaList.stream()
                //crio um filtro onde p é a variável que eu escolhi para ler cada elemento da lista.
                //o filter exige uma condição após a seta '->', mesma premissa do funcionamento do if, porém ele verifica cada elemento da lista.
                .filter(p -> p.getNome().equals("Barabjones") || p.getIdade().compareTo(15) == 0)
                //o foreach, vai percorrer tudo que tem na lista, se o filter foi feito antes dele, logo ele vai percorrer somente o que foi filtrado.
                .forEach(p -> {
                    // de acordo com exemplo, existem dois casos que satisfazem a condição do filter, ambos passarão dentro do foreach.
                    p.print();
                });

        System.out.println("=============================");
        System.out.println("2.1 - Exercícios:");

        System.out.println("=============================");
        System.out.println("a. Execute Filter e Imprima cada valor para a condição: nome = 'Kirby' ou idade = 15:");
        //codigo exercício a
        pessoaList.stream()
                .filter(p -> p.getNome().equals("Kirby") || p.getIdade().compareTo(15) == 0)
                .forEach(p ->{
                  p.print();  
                });
        System.out.println("=============================");

        System.out.println("=============================");
        System.out.println("b. Execute Filter e Imprima cada valor para a condição: idade menor que 30 anos:");
        //codigo exercício b
        pessoaList.stream()
                .filter(p -> p.getIdade().compareTo(30) < 0)
                .forEach(p -> p.print());
        System.out.println("=============================");

        System.out.println("=============================");
        System.out.println("c.  Execute Filter e Imprima cada valor para a condição: apenas idades pares:");
        //codigo exercício c
        pessoaList.stream()
                .filter(p -> p.getIdade() %2 == 0)
                .forEach(p -> p.print());
                
        System.out.println("=============================");
    }

    public static void showExemploMapeFiltereForeach(Collection<Pessoa> pessoaList) {
        System.out.println("\n\n=============================");
        System.out.println("3 - Map, filter e forEach:");

        pessoaList.stream()
                //o map serve para trazer apenas os valores que quero da lista
                .map(pessoa -> pessoa.getNome()) // List<String>
                .filter(nome -> nome.contains("j") || nome.contains("J"))
                //o foreach, vai percorrer tudo que tem na lista, se o filter foi feito antes dele, logo ele vai percorrer somente o que foi filtrado.
                .forEach(nome -> {
                    // de acordo com exemplo, existem dois casos que satisfazem a condição do filter, ambos passarão dentro do foreach.
                    Pessoa.printCustom("Nome", nome);
                });

        System.out.println("=============================");
        System.out.println("3.1 - Exercícios:");

        System.out.println("=============================");
        System.out.println("a. Mapeie o nome de todas as pessoas, cujo nome contém mais de 8 caracteres:");
        //codigo exercício a
        pessoaList.stream()
                .map(pessoa -> pessoa.getNome())
                .filter(nome -> nome.length() > 8)
                .forEach(nome -> Pessoa.printCustom("Nome", nome));
        System.out.println("=============================");

        System.out.println("=============================");
        System.out.println("b. Mapeie todas as idades ímpares:");
        //codigo exercício b
        pessoaList.stream()
                .map(pessoa -> pessoa.getIdade())
                .filter(idade -> idade %2 != 0)
                .forEach(idade -> Pessoa.printCustom("Idade", idade.toString()));
        System.out.println("=============================");
    }

    public static void showExemploMapReduce(Collection<Pessoa> pessoaList) {
        System.out.println("\n\n=============================");
        System.out.println("4 - Reduce:");

        Integer somaIdades = pessoaList.stream()
                //o reduce exige que antes seja mapeado qual valor será utilizado
                .map(p -> p.getIdade())
                //primeiro argumento é o valor inicial, 
                //o segundo arqumento é o nome do método que a classe Integer possue. Lembrando que somente é funcional se o método tiver dois argumentos.
                .reduce(0, Integer::sum);

        Pessoa.printCustom("Soma Idades", somaIdades.toString());

        System.out.println("=============================");
        System.out.println("4.1 - Exercícios:");

        System.out.println("=============================");
        System.out.println("a. Some todas idades pares:");
        //codigo exercício a
        Integer somarIdadesPares = pessoaList.stream()
                .map(p -> p.getIdade())
                .filter(idade -> idade %2 ==0)
                .reduce(0,Integer::sum);
        Pessoa.printCustom("Soma idades pares", somarIdadesPares.toString());
        System.out.println("=============================");

        System.out.println("=============================");
        System.out.println("b. Some idade de todas pessoa que tem 'i' no nome:");
        //codigo exercício b
        Integer somarIdadesI = pessoaList.stream()
                .filter(p -> p.getNome().contains("i"))
                .map(p -> p.getIdade())
                .reduce(0,Integer::sum);
        Pessoa.printCustom("Soma idade pessoas com letra I", somarIdadesI.toString());
        System.out.println("=============================");

        System.out.println("=============================");
        System.out.println("c. Mapeie a maior idade (obrigatório usar reduce):");
        //codigo exercício b
        Integer maiorIdade = pessoaList.stream()
                .map(p -> p.getIdade())
                .reduce(0, Integer::max);
        Pessoa.printCustom("Maior idade", maiorIdade.toString());
        System.out.println("=============================");
    }

    public static void showExemploFindFirsteFindAnyteOptional(Collection<Pessoa> pessoaList) {
        System.out.println("\n\n=============================");
        System.out.println("5 - Find First e Optional:");

        Optional<Pessoa> optPessoa = pessoaList.stream()
                //filtra as idades maiores que 30
                .filter(p -> p.getIdade() > 30)
                //traz o primeiro elemento filtrado
                .findFirst();

        //verifica se o valor pesquisado está presente, para evitar null pointer exception
        if (optPessoa.isPresent()) {
            optPessoa.get().print();
        }

        optPessoa = pessoaList.stream()
                //filtra as idades maiores que 30
                .filter(p -> p.getIdade() > 30)
                //pode trazer qualquer elemento filtrado, sem obedecer a ordem
                .findAny();

        //verifica se o valor pesquisado está presente, para evitar null pointer exception        
        if (optPessoa.isPresent()) {

            optPessoa.get().print();
        }

        System.out.println("=============================");
        System.out.println("5.1 - Exercícios:");

        System.out.println("=============================");
        System.out.println("a. Encontre o primeiro nome que contenha a letra 'c':");
        //codigo exercício a
        Optional<Pessoa> optPessoaA = pessoaList.stream()
                .filter(p -> p.getNome().contains("c"))
                .findFirst();

        //verifica se o valor pesquisado está presente, para evitar null pointer exception
        if (optPessoaA.isPresent()) {
            optPessoaA.get().print();
        }
        System.out.println("=============================");

        System.out.println("=============================");
        System.out.println("b. a. Encontre o primeiro nome que contenha a letra 'í':");
        //codigo exercício b
        Optional<Pessoa> optPessoaB = pessoaList.stream()
                .filter(p -> p.getNome().contains("í"))
                .findFirst();

        //verifica se o valor pesquisado está presente, para evitar null pointer exception
        if (optPessoaB.isPresent()) {
            optPessoaB.get().print();
        }
        System.out.println("=============================");
    }

    public static void showExemploCollect(Collection<Pessoa> pessoaList) {
        System.out.println("\n\n=============================");
        System.out.println("6 - Collect:");

        List<Pessoa> collectPessoas = pessoaList.stream()
                //filtra as idades menores que 36
                .filter(p -> p.getIdade() > 36)
                //Coleta e transforma numa lista.
                .collect(Collectors.toList());

        collectPessoas.stream().forEach(p -> {
            p.print();
        });

        System.out.println("=============================");
        System.out.println("6.1 - Exercícios:");

        System.out.println("=============================");
        System.out.println("a. Encontre o todos os nomes que contenham a letra 'q':");
        //codigo exercício a
        List<Pessoa> collectPessoasA = pessoaList.stream()
                .filter(p -> p.getNome().contains("q"))
                .collect(Collectors.toList());
        collectPessoasA.stream().forEach(p -> {
            p.print();
        });
        System.out.println("=============================");

        System.out.println("=============================");
        System.out.println(
                "b. a. Encontre todas idadades menores que 16 e faça o somatório (obrigatório usar collect e redure):");
        //codigo exercício b
        List<Pessoa> collectPessoasB = pessoaList.stream()
                .filter(p -> p.getIdade() < 16)
                .collect(Collectors.toList());
                
        Integer somaIdadeMenor16 = collectPessoasB.stream()
                .map(p -> p.getIdade())
                .reduce(0, Integer::sum);
        
        Pessoa.printCustom("Soma idade pessoas com menos de 16", somaIdadeMenor16.toString());
        System.out.println("=============================");
    }

    public static void showExemploOrderBy(Collection<Pessoa> pessoaList) {
        System.out.println("\n\n=============================");
        System.out.println("7 - Order By:");

        System.out.println("Ordena por Idade em ordem crescente");
        List<Pessoa> pessoaListSorted = pessoaList.stream()
                //ordena por idade
                .sorted(Comparator.comparingInt(Pessoa::getIdade))
                //coleta valores em uma 
                .collect(Collectors.toList());

        pessoaListSorted.stream().forEach(p -> {
            p.print();
        });

        System.out.println("Ordena por Idade e nome em ordem decrescente");
        pessoaListSorted = pessoaList.stream()
                //ordena de forma descrescente por idade e nome
                .sorted(Comparator
                        //primeiro compara idade, depois nome
                        .comparingInt(Pessoa::getIdade).thenComparing(Pessoa::getNome)
                        //decrescente
                        .reversed()
                )
                //coleta valores em uma 
                .collect(Collectors.toList());

        pessoaListSorted.stream().forEach(p -> {
            p.print();
        });

        System.out.println("=============================");
        System.out.println("6.1 - Exercícios:");

        System.out.println("=============================");
        System.out.println("a. Ordene por nome de forma crescente:");
        //codigo exercício a
        List<Pessoa> pessoaListSortedA = pessoaList.stream()
                .sorted(Comparator.comparing(Pessoa::getNome))
                .collect(Collectors.toList());

        pessoaListSortedA.stream().forEach(p -> {
            p.print();
        });

        System.out.println("=============================");

        System.out.println("=============================");
        System.out.println("b. Ordene por nome de forma descrescente:");
        //codigo exercício b
        List<Pessoa> pessoaListSortedB = pessoaList.stream()
                .sorted(Comparator.comparing(Pessoa::getNome).reversed())
                
                .collect(Collectors.toList());

        pessoaListSortedB.stream().forEach(p -> {
            p.print();
        });
        System.out.println("=============================");

        System.out.println("=============================");
        System.out.println("c. Ordene por nome de forma descrescente e idade descrescente:");
        //codigo exercício c
        List<Pessoa> pessoaListSortedC = pessoaList.stream()
                .sorted(Comparator.comparing(Pessoa::getNome).thenComparing(Pessoa::getIdade).reversed())
                
                .collect(Collectors.toList());

        pessoaListSortedB.stream().forEach(p -> {
            p.print();
        });
        System.out.println("=============================");
    }

    public static void showExemploCount(Collection<Pessoa> pessoaList) {
        System.out.println("\n\n=============================");
        System.out.println("7 - Count:");

        System.out.println("Conta todos elementos da lista. Claro que é muito mais fácil usar o pessoaList.size()");
        Long count = pessoaList.stream()
                //ordena por idade
                .count();
        Pessoa.printCustom("Count", count.toString());

        System.out.println("Conta todas idades distintas");
        count = pessoaList.stream()
                //mapeia apenas as idades
                .map(p -> p.getIdade())
                //filtra todas idades distintas mapeadas
                .distinct()
                //conta tudo
                .count();

        Pessoa.printCustom("Count Distinc Idade", count.toString());

        System.out.println("=============================");
        System.out.println("7.1 - Exercícios:");

        System.out.println("=============================");
        System.out.println("a. Conte todos nomes com a letra 'b':");
        //codigo exercício a
        Long countA = pessoaList.stream()
                .map(p -> p.getNome())
                .filter(n -> n.contains("b"))
                .distinct()
                .count();
        Pessoa.printCustom("Quantidade de pessoas com letra b", countA.toString());
        System.out.println("=============================");

        System.out.println("=============================");
        System.out.println("b. Conte todas as pessoas que tenham mais de 20 anos com o nome contendo a letra 'n':");
        //codigo exercício b
        Long countB = pessoaList.stream()
                .filter(p -> p.getIdade().compareTo(20) < 0 && p.getNome().contains("n"))
                .distinct()
                .count();
        Pessoa.printCustom("Quantidade de pessoas com mais de 20 e letra b no nome", countB.toString());
        System.out.println("=============================");
    }
}
