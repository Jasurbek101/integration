package com.example.integration.entity;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final String src = "https://api.opensensemap.org/boxes?model=homeWifi";

    public static void main(String[] args) throws IOException {

            URL url = new URL(src);
            JsonNode jsonNode = Json.parse(url);

            List<Wifi> wifiList= Json.fromJson(jsonNode, Wifi.class);

        List<Wifi> filteredWifis = wifiList.stream()
                .filter(wifi -> wifi.getCreatedAt() == null)
                .collect(Collectors.toList());

        System.out.println(filteredWifis);
    }
}
