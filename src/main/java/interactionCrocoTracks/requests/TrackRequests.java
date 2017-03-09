package interactionCrocoTracks.requests;

/**
 * Created by Vladimir on 09.03.2017.
 */

import interactionCrocoTracks.service.jsonsForRequest.JsonStringsAddTrack;
import interactionCrocoTracks.service.jsonsForRequest.JsonStringsDeleteTrack;
import interactionCrocoTracks.service.parsers.JsonParser;
import interactionCrocoTracks.tracksProvider.TracksBunch;

import java.util.ArrayList;

/**
 * Класс, реализующий методы взаимодействия с треками на сервере
 */
public class TrackRequests {

    /**
     * Запрос на добавление треков на сервер
     */
    public void requestsToAddTracks() {
        JsonStringsAddTrack jsonAddTrack = new JsonStringsAddTrack();
        JsonParser parser = new JsonParser();
        TracksBunch tracksBunch = parser.retrieveFromJsonFile("src/main/resources/track-configure");
        ArrayList<String> jsonRequestStrings = jsonAddTrack.generateJson(tracksBunch);

        // Отправка запросов
        executeRequest(jsonRequestStrings);
    }

    /**
     * Запрос на удаление трека с сервера
     */
    public void requestsToDeleteTracks(int task_timings_id) {
        JsonStringsDeleteTrack jsonDeleteTrack = new JsonStringsDeleteTrack(task_timings_id);
        JsonParser parser = new JsonParser();
        TracksBunch tracksBunch = parser.retrieveFromJsonFile("src/main/resources/track-configure");
        ArrayList<String> jsonRequestStrings = jsonDeleteTrack.generateJson(tracksBunch);

        // Отправка запроса
        executeRequest(jsonRequestStrings);
    }

    /**
     * Метод, отправляющий запросы на сервер
     */
    private void executeRequest(ArrayList<String> jsonRequestStrings) {
        for (String s : jsonRequestStrings) {
            HttpRequestConfiguration request = new HttpRequestConfiguration();
            request.postJsonRequest(s);
        }
    }
}
