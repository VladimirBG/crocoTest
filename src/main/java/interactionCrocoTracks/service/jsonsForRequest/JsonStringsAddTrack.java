package interactionCrocoTracks.service.jsonsForRequest;

import interactionCrocoTracks.tracksProvider.TrackNode;
import interactionCrocoTracks.tracksProvider.TracksBunch;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Класс для генерации Json строк запросов ДОБАВЛЕНИЯ треков на сервер.
 */
public class JsonStringsAddTrack implements JsonStringsGenerator {

    private static Logger log = Logger.getLogger(JsonStringsAddTrack.class);

    /*
    * Метод генерации Json строк типа:
    *  {
    *    "server_token": "...",
    *    "app_version": "...",
    *    "controller": "WorkspaceActionController",
    *    "action": "insert",
    *    "query": {
    *        "domain": "task_timings",
    *        "record": {
    *            "task_id": 17,
    *            "employee_id": 1,
    *            "project_id": 1,
    *            "priority": 0,
    *            "begin": 1479283838,
    *            "end": 1479370245,
    *            "comment": "Комментарий  к задаче"
    *            }
    *        }
    *    }
    */
    @Override
    public ArrayList<String> generateJson(TracksBunch tracksBunch) {

        log.info("Генерация Json строк запросов для добавления треков");

        ArrayList<String> result = new ArrayList<>();

        for (TrackNode trackNode : tracksBunch.getTrackNodes()) {

            JSONObject jsonObject = new JSONObject();

            jsonObject.put("server_token", tracksBunch.getServer_token());
            jsonObject.put("app_version", "5.3.0");
            jsonObject.put("controller", "WorkspaceActionController");
            jsonObject.put("action", "insert");

            JSONObject queryObject = new JSONObject();
            queryObject.put("domain", "task_timings");


            JSONObject recordObject = new JSONObject();

            recordObject.put("task_id", trackNode.getTaskId());
            recordObject.put("employee_id", trackNode.getEmployeeId());
            recordObject.put("priority", 0);
            recordObject.put("begin", trackNode.getStart());
            recordObject.put("end", trackNode.getEnd());
            recordObject.put("comment", trackNode.getComment());

            queryObject.put("record", recordObject);

            jsonObject.put("query", queryObject);

            result.add(jsonObject.toString());
        }

        return result;
    }
}
