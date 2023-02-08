package org.openweathermap.utils.resources;

import org.openweathermap.utils.constants.EndPoints;

public enum WebServicesEndPoints {
    URI(EndPoints.URL_WEATHER);

    private final String url;

    WebServicesEndPoints(String url) { this.url = url; }

    public String getUrl() { return this.url; }
}
