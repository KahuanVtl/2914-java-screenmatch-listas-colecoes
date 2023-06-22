package br.com.alura.screenmatch.principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

public class PrincipalComListas {
    public static void main(String[] args) {
        
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.avalia(9);
        var filmeDoPaulo = new Filme("Dogville", 2003);
        filmeDoPaulo.avalia(5);
        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.avalia(10);
        Serie lost = new Serie("Lost", 2000);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoPaulo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);
    
        for (Titulo item : lista){
            System.out.println(item.getNome());
                if(item instanceof Filme){
                    Filme filme = (Filme) item;
                    System.out.println("Classificação "+filme.getClassificacao()+" "+"Estrelas");
            }
        }
        
        System.out.println("Lista de titulos ordanados:");
        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(lista);


    }
}
