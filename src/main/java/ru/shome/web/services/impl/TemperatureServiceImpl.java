package ru.shome.web.services.impl;

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
import ru.shome.web.services.BaseService;
import ru.shome.web.services.TemperatureService;
import ru.shome.web.system.logger.SLogger;
import ru.shome.web.system.logger.SLogger.ErrLevel;

import com.google.gson.Gson;

/**
 * Smart Homne Project. ilya.golovachev9@gmail.com
 *
 * @author ILYA_GOLOVACHEV.
 */
@Service
public class TemperatureServiceImpl extends BaseService implements TemperatureService {


	private Double holeTemperature = 0.00;
	private Double boilerTemperature = 0.00;
	private Double liveRoomTemperature = 0.00;
	private Double openweathermapTemperature = 0.00;
	private Double streetTemperature = 0.00;
	private Double streetHumidity = 0.00;

	private Date lastUpdateTemperature = null;
	@Autowired
	private Property property;

	public TemperatureServiceImpl() {
		super();
		ServiceFactory.reqisterService(this);
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
			// T1
			Element t1 = document.select("t1").first();
			boilerTemperature = Double.valueOf(t1.text());
			// T2
			Element t2 = document.select("t2").first();
			liveRoomTemperature = Double.valueOf(t2.text());
			// T3
			Element t3 = document.select("t3").first();
			holeTemperature = Double.valueOf(t3.text());
			// T4
			Element t4 = document.select("t4").first();
			streetTemperature = Double.valueOf(t4.text());
			// Hum1
			Element hum1 = document.select("hum1").first();
			streetHumidity = Double.valueOf(hum1.text());

		} catch (IOException ex) {
			SLogger.getSLogger().log(ErrLevel.WARNING, TemperatureServiceImpl.class, "connect timed out");
		}
	}

	private void updateTemperature() {
		Timer timer = new Timer();
		TimerTask ttask = new TimerTask() {

			@Override
			public void run() {
				getSensorsValue();
				// updateOpenweathermapTemperature();
				lastUpdateTemperature = new Date();
			//	LOGGER.info("Update Temperature");
			}
		};
		timer.scheduleAtFixedRate(ttask, property.getRunUpdateTime(),
				property.getUpdateTime());
	}

	@Override
	public Date getLastUpdateTemperature() {
		return lastUpdateTemperature;
	}

	@Override
	public double getOpenweathermapTemperature() {
		return openweathermapTemperature;
	}

	private void updateOpenweathermapTemperature() {
		HttpURLConnection urlConnection = null;
		BufferedReader reader = null;
		String resultJson = "";

		try {
			URL url = new URL(
					"http://api.openweathermap.org/data/2.5/weather?q=Perevalnoe,ua");

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
		// Температура в кельвинах
		openweathermapTemperature = temp + (-272.15);
	}

	@Override
	public double getStreetTemperature() {
		return streetTemperature;
	}

	@Override
	public double getStreetHumidity() {
		return streetHumidity;
	}

	@Override
	public void run() {
	//	updateTemperature();
		
	}
}
