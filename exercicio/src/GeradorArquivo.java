import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorArquivo {

    public void gerarArquivo(Endereco endereco){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try{
            FileWriter file = new FileWriter(endereco.cep()+".json");
            file.write(gson.toJson(endereco));
            file.close();
        }catch (IOException e){
            throw new RuntimeException("Erro ao criar arquivo");
        }

    }
}
