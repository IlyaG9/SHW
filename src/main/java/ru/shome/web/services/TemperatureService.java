package ru.shome.web.services;

import java.util.Date;

/**
 * Smart Home Project. ilya.golovachev9@gmail.com
 *
 * @author ILYA_GOLOVACHEV.
 */
public interface TemperatureService {

    public Double getHoleTemperature();

    public Double getBoilerTemperature();

    public Double getLiveRoomTemperature();

    public Date getLastUpdateTemperature();

    public double getOpenweathermapTemperature();

    public double getStreetTemperature();

    public double getStreetHumidity();
}
