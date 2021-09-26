package seedu.parser;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import seedu.module.Mod;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class JsonParser {

    private static final String MODULE_URI = "https://api.nusmods.com/v2/2021-2022/modules/";

    public static void parseSearch(String searchTerm) {
        // rest of search here:
        System.out.println("Searching for term instead");
    }

    public static void parseFetch(String moduleCode) {
        try {
            fetchModule(moduleCode);
        } catch (IOException | InterruptedException e) {
            parseSearch(moduleCode);
        }
    }

    private static void fetchModule(String moduleCode) throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();

        //create a request
        var request = HttpRequest.newBuilder()
                .uri(URI.create(MODULE_URI + moduleCode + ".json"))
                .header("accept", "application/json")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        fetchFromJson(response.body().getBytes(), moduleCode);
    }

    private static void fetchFromJson(byte[] response, String moduleCode) {
        InputStream inputStream = new ByteArrayInputStream(response);
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream));
        Mod mod = new Gson().fromJson(reader, Mod.class);
        System.out.println(mod);
        String description =
        System.out.println("*------------------------*");
    }
}
