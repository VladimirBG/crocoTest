package interactionCrocoTracks.requests;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Класс, выполняющий отправку на сервер запросов.
 */
public class HttpRequestConfiguration {

    private static Logger log = Logger.getLogger(HttpRequestConfiguration.class);

    public void postJsonRequest(String jsonRequest) {

        log.info("Отправка запроса на сервер");

        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()){
            HttpPost request = new HttpPost("https://saas.crocotime.net/3a5b02eb12694aeaade38924e180120b/");
            StringEntity params = new StringEntity(jsonRequest);
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            String json = EntityUtils.toString(response.getEntity(), "UTF-8");

            log.info("Ответ сервера: " + json);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
