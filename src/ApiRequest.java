import com.google.gson.Gson;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {
    public ApiResponse convertir(String moneda) throws IOException, InterruptedException {
        try {
            String api = "https://v6.exchangerate-api.com/v6/1671eb33c8aa66e877245fbf/latest/" + moneda;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(api)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            ApiResponse apiResponse = (ApiResponse)gson.fromJson((String)response.body(), ApiResponse.class);
            return apiResponse;
        } catch (NullPointerException e) {
            System.out.println("Hubo un problema con el token: " + e);
        } catch (ConnectException e) {
            System.out.println("Hubo un problema con la conexion: " + e);
        }

        return null;
    }
}
