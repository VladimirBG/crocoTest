package interactionCrocoTracks.service.jsonsForRequest;

import interactionCrocoTracks.tracksProvider.TracksBunch;

import java.util.ArrayList;

/**
 * Интерфейс для генерации Json строк запросов к серверу.
 */
public interface JsonStringsGenerator {
    public ArrayList<String> generateJson(TracksBunch tracksBunch);
}
