import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Http {
    public static void main(String[] args) {
        String json;
        try (
                CloseableHttpClient httpClient = HttpClientBuilder.create()
                        .setDefaultRequestConfig(RequestConfig.custom()
                                .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                                .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                                .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                                .build())
                        .build();
        ) {
            HttpGet request = new HttpGet("https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats");
            CloseableHttpResponse response = httpClient.execute(request);
            json = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Gson gson = new Gson();
            ClassCat[] facts = gson.fromJson(json, ClassCat[].class);
            List<String> textFacts = Arrays.stream(facts)
                    .filter(classCat -> (classCat.getUptoves() != null))
                    .map(ClassCat::getText)
                .collect(Collectors.toList());


            for (String text : textFacts) {
                System.out.println(text);

            }
        } catch (JsonSyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
