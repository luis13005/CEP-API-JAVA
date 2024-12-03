import com.google.gson.*;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import java.io.FileWriter;
import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o CEP");

        String cep = scanner.nextLine();

        Busca busca = new Busca();
        try{
            Endereco endereco = busca.buscaEndereco(cep);
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setPrettyPrinting()
                    .create();

            GeradorArquivo arquivo = new GeradorArquivo();
            arquivo.gerarArquivo(endereco);

            System.out.println(endereco);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}