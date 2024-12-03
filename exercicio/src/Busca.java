import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Busca {

    public Endereco buscaEndereco(String cep){

        String api = "https://viacep.com.br/ws/"+ URLEncoder.encode(cep)+"/json/";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(api))
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Endereco.class);
        }catch (Exception e){
            throw new RuntimeException("Não consegui obter o endereço com esse CEP");
        }
    }
}
