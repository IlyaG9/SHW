package ru.shome.web.services.impl;

import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import ru.shome.web.beans.Property;
import ru.shome.web.services.BaseService;
import ru.shome.web.services.SMSService;
import ru.shome.web.services.TemperatureService;
import ru.shome.web.system.logger.SLogger;
import ru.shome.web.system.logger.SLogger.ErrLevel;

/**
 * Smart Home Project. ilya.golovachev9@gmail.com
 *
 * @author ILYA_GOLOVACHEV.
 */
public class SMSServiceImpl extends BaseService implements SMSService {

	private Properties props = null;
	@Autowired
	private Property property;
	@Autowired
	private TemperatureService temperatureService;

	public SMSServiceImpl() {
		props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		ServiceFactory.reqisterService(this);
	}

	@Override
	public void startReport() {
		Timer timer = new Timer();
		TimerTask ttask = new TimerTask() {
			@Override
			public void run() {
				String text = "Temp: LR="
						+ temperatureService.getLiveRoomTemperature() + "; H:"
						+ temperatureService.getHoleTemperature() + "; B:"
						+ temperatureService.getBoilerTemperature() + "; ST:"
						+ temperatureService.getStreetTemperature() + "; SH:"
						+ temperatureService.getStreetHumidity() + "%";
				sendSMS(text,property);
			}
		};
		// Текущая дата
		Date date = new Date();
		// Время, которое нужно добавить, чтоб получилось 10 часов следующего
		// дня
		long plus = (Math.abs(date.getHours() - ((long) 24)) + property
				.getHoursToSendReports()) * 3600000;
		long tomorrowLong = date.getTime() + plus;
		// Завтра 10 часов +-минуты
		Date tomorrow = new Date(tomorrowLong);
		// Запускаем таймер, отчет будет приходить раз в сутки (86400000
		// миллисекунд)
		timer.scheduleAtFixedRate(ttask, tomorrow, 86400000);

		sendSMS("System SHWeb started",property);
	}

	@Override
	public synchronized void sendSMS(String text,final Property pr) {
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(pr.getGmailAccaunt(),
						pr.getGmailAccauntPassword());
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("SHome"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(pr.getSmsruAccauntToSendSMS()));
			message.setSubject("SHWeb");
			message.setText(text);
			Transport.send(message);
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("kinokrim@ya.ru"));
			Transport.send(message);
			SLogger.getSLogger().log(ErrLevel.INFO, SMSServiceImpl.class,
					"SMS sent");
		} catch (MessagingException ex) {
			SLogger.getSLogger().log(ErrLevel.ERROR, SMSServiceImpl.class,
					ex.getMessage());
		}
	}

	@Override
	public void go() {
		startReport();
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
