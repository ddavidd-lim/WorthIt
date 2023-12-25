package com.david;

import java.io.StringReader;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            String apiKey = APIConstants.API_KEY;
            String apiId = APIConstants.API_ID;
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
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);

            System.out.println("Response from Nutritionix API (JSON Array):");
            JsonArray branded_foods = jsonObject.getAsJsonArray("branded");
            for (JsonElement food : branded_foods) {
                JsonObject brandedObject = food.getAsJsonObject();

                String name = brandedObject.get("food_name").getAsString();
                String brand = brandedObject.get("brand_name").getAsString();
                String calories = brandedObject.get("nf_calories").getAsString();

                System.out.println("Food name: " + name);
                System.out.println("Brand Name: " + brand);
                System.out.println("Calories: " + calories);
                System.out.println("-----------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
