package ru.shome.web.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import ru.shome.web.beans.Car;
import ru.shome.web.beans.Property;
import ru.shome.web.services.RunnubleService;
import ru.shome.web.services.ParseService;
import ru.shome.web.services.SMSService;

public class RstParseServiceImpl extends RunnubleService implements ParseService {
	@Autowired
	private Property property;
	@Autowired
	private SMSService smsService;

	public RstParseServiceImpl() {
		super();
		ServiceFactory.reqisterService(this);
	}

	@Override
	public void parse() {
		Timer timer = new Timer();
		TimerTask ttask = new TimerTask() {

			@Override
			public void run() {
				try {
					Document doc = Jsoup.connect(
							"http://rst.ua/oldcars/crimea/vaz/niva").get();
					Elements carBlock = doc.select(".rst-ocb-i ");
					String lastLink = getLastLink();
					List<Car> carList = new ArrayList<Car>();
					for (int i = 0; i < carBlock.size(); i++) {
						Car mashin = new Car();
						String href = null;
						String strName = null;

						Element car = carBlock.get(i);

						// Получаю ссылку
						Elements elementsHref = car.getElementsByTag("a");
						if (elementsHref.size() > 0) {
							Element elHref = elementsHref.get(0);
							href = "http://rst.ua" + elHref.attr("href");
							mashin.setLink(href);
							System.out.println(href);
						}
						// Получаю имя
						Elements name = car
								.getElementsByClass("rst-uix-b-item-head");
						if (name.size() > 0) {
							Element elName = name.get(0);
							strName = elName.text().trim();
							mashin.setName(strName);
							System.out.println(strName);
						}
						// Получаю цену
						Elements price = car.getElementsByClass("price");
						if (price.size() > 0) {
							String strPrice = price.get(0)
									.getElementsByTag("strong").text().trim();
							mashin.setPrice(strPrice);
							System.out.println(strPrice);
						}
						mashin.setSite("http://rst.ua");
						carList.add(mashin);
					}
					addCarToBase(carList.get(0), lastLink);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		timer.scheduleAtFixedRate(ttask, property.getRunUpdateTime(),
				property.getUpdateTime());

	}

	@Override
	public void go() {
		parse();

	}

	private void addCarToBase(Car car, String lastLink) throws IOException {
		boolean r = car.getLink().equals(lastLink);
		if (car.getLink() != null && !car.getLink().equals(lastLink)&&car.getPrice()!=null&&!car.getPrice().equals("торг")&&Integer.valueOf(car.getPrice())<1500) {
			String addLink = "http://shweb.hol.es/hol.es.db/addLink.php?link="
					+ car.getLink() + "&name=" + car.getName() + "&site="
					+ car.getSite() + "&price=" + car.getPrice();
			Document doc = Jsoup.connect(addLink).get();
			smsService.sendSMS(car.toString(), property);
		}
	}

	private static String getLastLink() throws IOException {
		Document doc = Jsoup.connect(
				"http://shweb.hol.es/hol.es.db/getLink.php").get();
		Elements linkBlock = doc.getElementsByTag("body");
		return linkBlock.get(0).text();
	}


	@Override
	public boolean isEnabled() {
		return false;
	}



}
