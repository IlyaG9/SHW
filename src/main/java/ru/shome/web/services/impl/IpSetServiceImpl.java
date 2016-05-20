package ru.shome.web.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import ru.shome.web.services.RunnubleService;
import ru.shome.web.services.IpSetSerive;

public class IpSetServiceImpl extends RunnubleService implements IpSetSerive {

	public IpSetServiceImpl() {
		super();
		ServiceFactory.reqisterService(this);
	}

	@Override
	public void go() {
		Timer timer = new Timer();
        timer.schedule(new MyTimerTask(), 0, 600000);
	}

	@Override
	public String getCurrentIp() {
		String result = null;
		try {
			BufferedReader reader = null;
			try {
				URL url = new URL("http://myip.by/");
				InputStream inputStream = null;
				inputStream = url.openStream();
				reader = new BufferedReader(new InputStreamReader(inputStream));
				StringBuilder allText = new StringBuilder();
				char[] buff = new char[1024];

				int count = 0;
				while ((count = reader.read(buff)) != -1) {
					allText.append(buff, 0, count);
				}
				// Строка содержащая IP имеет следующий вид
				// <a href="whois.php?127.0.0.1">whois 127.0.0.1</a>
				Integer indStart = allText.indexOf("\">whois ");
				Integer indEnd = allText.indexOf("</a>", indStart);

				String ipAddress = new String(allText.substring(indStart + 8,
						indEnd));
				if (ipAddress.split("\\.").length == 4) { // минимальная
															// (неполная)
					// проверка что выбранный текст является ip адресом.
					result = ipAddress;
				}
			} catch (MalformedURLException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public void updateIp() {
		String ip = getCurrentIp();
		InputStream inputStream = null;
		try {
			URL url = new URL("http://shweb.hol.es/hol.es.db/addIP.php?ip="
					+ ip);
			inputStream = url.openStream();
		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

	}

	private class MyTimerTask extends TimerTask {

		@Override
		public void run() {
			updateIp();
		}
	}

	@Override
	public boolean isEnabled() {

		return false;
	}

}
