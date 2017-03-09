package interactionCrocoTracks;

import interactionCrocoTracks.requests.TrackRequests;
import org.apache.log4j.PropertyConfigurator;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        init();

        TrackRequests trackRequests = new TrackRequests();

        //Добавление треков на сервер
        trackRequests.requestsToAddTracks();

        //Удаление треков с сервера
        //trackRequests.requestsToDeleteTracks(2);
    }

    private static void init() {
        //logger
        PropertyConfigurator.configure(Main.class.getClassLoader().getResource("log4j.properties"));
    }

}
