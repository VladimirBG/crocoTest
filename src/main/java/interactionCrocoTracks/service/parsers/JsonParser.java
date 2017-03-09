package interactionCrocoTracks.service.parsers;

import interactionCrocoTracks.tracksProvider.TrackNode;
import interactionCrocoTracks.tracksProvider.TracksBunch;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * Класс, выполняющий чтение Json файлов.
 */
public class JsonParser {

    private static Logger log = Logger.getLogger(JsonParser.class);

    /**
     * Получение объекта TracksBunch из Json файла .
     */
    public TracksBunch retrieveFromJsonFile(String path) {

        log.info("Парсинг Json файла: " + path);

        try {
            FileReader reader = new FileReader(path);
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject jsonObject = new JSONObject(tokener);

            return parseTracksBunch(jsonObject);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Получение объекта TracksBunch из JSONObject .
     */
    private TracksBunch parseTracksBunch(JSONObject jsonObject) {
        TracksBunch tracksBunch = new TracksBunch();
        tracksBunch.setHost(jsonObject.getString("host"));
        tracksBunch.setServer_token(jsonObject.getString("server_token"));

        JSONArray tracksArray = jsonObject.getJSONArray("tracks");
        Iterator<Object> iterator = tracksArray.iterator();
        ArrayList<TrackNode> d = new ArrayList<TrackNode>();

        while (iterator.hasNext()) {
            JSONObject trackNodeObject = (JSONObject) iterator.next();
            d.add(parseTrackNode(trackNodeObject));
        }

        tracksBunch.setTrackNodes(d);

        return tracksBunch;
    }

    /**
     * Получение объекта trackNode из JSONObject .
     */
    private TrackNode parseTrackNode(JSONObject trackNodeObject) {
        TrackNode trackNode = new TrackNode();

        trackNode.setEmployeeId(trackNodeObject.getInt("employee.id"));
        trackNode.setTaskId(trackNodeObject.getLong("task.id "));

        trackNode.setComment(trackNodeObject.getString("comment"));

        trackNode.setStart(parseDataStringToTimeStamp(trackNodeObject.getJSONObject("period").getString("start")));

        trackNode.setEnd(parseDataStringToTimeStamp(trackNodeObject.getJSONObject("period").getString("end")));


        return trackNode;
    }

    /**
     * Преобразование входной строки даты в Unix time stamp.
     */
    private long parseDataStringToTimeStamp(String stringData) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
            Date parseData = dateFormat.parse(stringData);
            long result = parseData.getTime();
            return result/1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
