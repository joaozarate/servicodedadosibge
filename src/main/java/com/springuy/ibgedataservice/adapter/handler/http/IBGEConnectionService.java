package com.springuy.ibgedataservice.adapter.handler.http;

import lombok.extern.java.Log;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;

@Log
class IBGEConnectionService implements ConnectionService {

    @Override
    public HttpsURLConnection connect(String urlParameter) {

        try {
            URL url = new URL("https://servicodados.ibge.gov.br/api/v1" + urlParameter);
            HttpsURLConnection connector = (HttpsURLConnection) url.openConnection();
            connector.setRequestMethod("GET");
            connector.setConnectTimeout(500);//TODO: set in a parameterizable way.
            connector.setRequestProperty("Content-Type", "application/json");
            connector.setRequestProperty("User-Agent", "api-jar");//TODO: set in a parameterizable way.
            return connector;
        } catch (IOException e) {
            log.log(Level.SEVERE, "Error connecting to " + urlParameter, e);
            throw new RuntimeException(e);
        }

    }

}
