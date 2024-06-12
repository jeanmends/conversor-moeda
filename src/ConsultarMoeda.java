import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoeda {
public Moedas buscarMoedas(String tipoUm, String tipoDois){
    URI moeda = URI.create("https://v6.exchangerate-api.com/v6/API_KEY/pair/" +
            tipoUm + "/" + tipoDois);
    HttpRequest request = HttpRequest.newBuilder()
            .uri(moeda)
            .build();
    try {
        HttpResponse<String> response = HttpClient
                .newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        return new Gson().fromJson(response.body(), Moedas.class);
    } catch (IOException | InterruptedException e) {
        throw new RuntimeException ("Não funcionou.");
    }
}
}
