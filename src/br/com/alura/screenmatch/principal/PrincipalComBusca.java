package br.com.alura.screenmatch.principal;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;

public class PrincipalComBusca {
        public static void main (String[] args) throws IOException, InterruptedException {
        String busca = "";
        Scanner S = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        while(!busca.equalsIgnoreCase("sair")){
        System.out.println("Digite um filme para busca: ");
        busca = S.nextLine();

        if(busca.equalsIgnoreCase("sair")){
           break;
        }

        String endereco = "https://www.omdbapi.com/?t="+busca.replace(" ", "+")+"&apikey=53bfe1ed";
    try{
           HttpClient client = HttpClient.newHttpClient();
           HttpRequest request = HttpRequest.newBuilder()
             .uri(URI.create(endereco))
             .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        //System.out.println(json);
        
        TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
        //System.out.println(meuTituloOmdb);
        //try {
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Titulo já convertido");
                System.out.println(meuTitulo);

                titulos.add(meuTitulo);

        } catch (NumberFormatException e){
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());

        } catch (IllegalArgumentException e){
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
        } catch (Exception e ){
                System.out.println(e.getMessage());
        }

        FileWriter s = new FileWriter("filmes.json"); 
        s.write(gson.toJson(titulos));
        s.close();
        System.out.println("Programa está funcionando");
}
}
}