package ru.shome.web.services.impl;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shome.web.beans.Property;
import ru.shome.web.beans.Weather;
import ru.shome.web.services.TemperatureService;

/**
 * Smart Homne Project. ilya.golovachev9@gmail.com
 *
 * @author ILYA_GOLOVACHEV.
 */
@Service
public class TemperatureServiceImpl implements TemperatureService {

    private Double holeTemperature = 0.00;
    private Double boilerTemperature = 0.00;
    private Double liveRoomTemperature = 0.00;
    private Date lastUpdateTemperature = null;
    @Autowired
    private Property property;

    public TemperatureServiceImpl() {
        super();

    }

    @Override
    public Double getHoleTemperature() {
        return holeTemperature;
    }

    @Override
    public Double getBoilerTemperature() {
        return boilerTemperature;
    }

    @Override
    public Double getLiveRoomTemperature() {
        return liveRoomTemperature;
    }

    private void getSensorsValue() {
        try {
            Document document = Jsoup.connect(property.getArduinoURL()).get();
            //T1
            Element t1 = document.select("t1").first();
            boilerTemperature = Double.valueOf(t1.text());
            //T2
            Element t2 = document.select("t2").first();
            liveRoomTemperature = Double.valueOf(t2.text());
            //T3
            Element t3 = document.select("t3").first();
            holeTemperature = Double.valueOf(t3.text());

        } catch (IOException ex) {
            System.out.println("connect timed out");
            //  Logger.getLogger(TemperatureService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateTemperature() {
        Timer timer = new Timer();
        TimerTask ttask = new TimerTask() {

            @Override
            public void run() {
                getSensorsValue();
                lastUpdateTemperature = new Date();
            }
        };
        timer.scheduleAtFixedRate(ttask, property.getRunUpdateTime(), property.getUpdateTime());
    }

    @Override
    public Date getLastUpdateTemperature() {
        return lastUpdateTemperature;
    }

    @Override
    public double getOpenweathermapTemperature() {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultJson = "";

        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Perevalnoe,ua");

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            resultJson = buffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Weather fromJson = gson.fromJson(resultJson, Weather.class);
        Double temp = fromJson.getMain().getTemp();
        //Температура в кельвинах
        return temp + (-272.15);
    }
}
