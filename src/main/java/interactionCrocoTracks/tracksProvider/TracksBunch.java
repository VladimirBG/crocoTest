package interactionCrocoTracks.tracksProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Класс, вкоторый описывает Json конфигурацию.
 * TrackBunch содержит один или несколько элементов TrackNode.
 */
public class TracksBunch {

    private ArrayList<TrackNode> trackNodes;
    private String host;
    private String server_token;

    public List<TrackNode> getTrackNodes() {
        return Collections.unmodifiableList(trackNodes);
    }

    public void setTrackNodes(ArrayList<TrackNode> trackNodes) {
        this.trackNodes = trackNodes;
    }

    public void addToTrackNodes(TrackNode trackNode) {
        this.trackNodes.add(trackNode);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getServer_token() {
        return server_token;
    }

    public void setServer_token(String server_token) {
        this.server_token = server_token;
    }

    @Override
    public String toString() {
        return host + " " + server_token + " " + trackNodes;
    }
}
