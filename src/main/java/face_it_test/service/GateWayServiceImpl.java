package face_it_test.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import face_it_test.model.VacancyModel;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class GateWayServiceImpl implements GateWayService {

    public static final String URL_PATTER = "https://www.arbeitnow.com/api/job-board-api?page=%s";

    @Override
    public List<VacancyModel> readData() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<VacancyModel> vacancyModels = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();

        for (int i = 1; i < 6; i++) {
            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(String.format(URL_PATTER, i)))
                        .GET()
                        .header("Content-Type", "application/json")
                        .build();
                HttpResponse<String> response = client.send(
                        request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                JsonNode rootNode = objectMapper.readTree(json).path("data");
                vacancyModels.addAll(objectMapper.readValue(rootNode.toString(),
                        new TypeReference<List<VacancyModel>>() {}));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return vacancyModels;
    }
}
