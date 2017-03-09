package interactionCrocoTracks.service.jsonsForRequest;

import interactionCrocoTracks.tracksProvider.TracksBunch;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Класс для генерации Json строк запросов УДАЛЕНИЯ треков с сервера.
 */
public class JsonStringsDeleteTrack implements JsonStringsGenerator {

    private static Logger log = Logger.getLogger(JsonStringsDeleteTrack.class);

    private int task_timings_id;

    public JsonStringsDeleteTrack(int task_timings_id) {
        this.task_timings_id = task_timings_id;
    }

    /*
    * Метод генерации Json строк типа:
    *   {
    *   "server_token": "...",
    *   "app_version": "...",
    *   "controller": "WorkspaceActionController",
    *   "action": "remove",
    *   "query": {
    *       "domain": "task_timings",
    *       "filter": {
    *           "task_timing_id": 1 или [1]
    *           }
    *       }
    *   }
    */
    @Override
    public ArrayList<String> generateJson(TracksBunch tracksBunch) {

        log.info("Генерация Json строк запросов для удаления треков с task_timings_id: " + task_timings_id);

        JSONObject jsonObject = new JSONObject();
        ArrayList<String> result = new ArrayList<>();

        jsonObject.put("server_token", tracksBunch.getServer_token());
        jsonObject.put("app_version", "5.3.0");
        jsonObject.put("controller", "WorkspaceActionController");
        jsonObject.put("action", "remove");

        JSONObject queryObject = new JSONObject();
        queryObject.put("domain", "task_timings");

        JSONObject filterObject = new JSONObject();
        filterObject.put("task_timing_id", task_timings_id);

        queryObject.put("filter", filterObject);

        jsonObject.put("query", queryObject);

        result.add(jsonObject.toString());

        return result;
    }
}
