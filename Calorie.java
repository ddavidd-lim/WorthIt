import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class Calorie {
    public static void main(String[] args) {
        try {
            String apiKey = "INSERT_KEY";
            String apiId = "INSERT_ID";
            String query = "Taco Bell beefy Melt";

            String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
            String urlStr = "https://trackapi.nutritionix.com/v2/search/instant/?query=" + encodedQuery;
            
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlStr))
                    .header("x-app-id", apiId)
                    .header("x-app-key", apiKey)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Response from Nutritionix API:");
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
