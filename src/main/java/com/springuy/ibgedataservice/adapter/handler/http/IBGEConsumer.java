package com.springuy.ibgedataservice.adapter.handler.http;

import com.google.gson.Gson;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

@Log
@RequiredArgsConstructor
class IBGEConsumer implements Consumer {

    private final ConnectionService connectionService;

    @Override
    public <T> T retrieveData(String urlParameter, Type typeOfT) {
        @Cleanup(value = "disconnect") HttpsURLConnection connector = connectionService.connect(urlParameter);

        StringBuilder response = new StringBuilder();

        try (BufferedReader rd = new BufferedReader(new InputStreamReader(connector.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new Gson().fromJson(response.toString(), typeOfT);
    }
}
