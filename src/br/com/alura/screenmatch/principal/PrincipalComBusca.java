package br.com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.Gson;

import br.com.alura.screenmatch.modelos.Titulo;

public class PrincipalComBusca {
        public static void main (String[] args) throws IOException, InterruptedException {
        
        Scanner S = new Scanner(System.in);

        System.out.println("Digite um filme para busca: ");
        var busca = S.nextLine();

        String endereco = "https://www.omdbapi.com/?t="+busca+"&apikey=53bfe1ed";
    
            HttpClient client = HttpClient.newHttpClient();
               HttpRequest request = HttpRequest.newBuilder()
             .uri(URI.create(endereco))
             .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);

        Gson gson = new Gson();
        Titulo meuTitulo = gson.fromJson(json, Titulo.class);
        System.out.println(meuTitulo);

        }
}