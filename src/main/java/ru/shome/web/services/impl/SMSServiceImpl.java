package ru.shome.web.services.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import ru.shome.web.beans.Weather.Main;
import ru.shome.web.services.SMSService;
import ru.shome.web.services.TemperatureService;

/**
 * Smart Homne Project. ilya.golovachev9@gmail.com
 *
 * @author ILYA_GOLOVACHEV.
 */
public class SMSServiceImpl implements SMSService {

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
    }

    @Override
    public void startReport() {
        Timer timer = new Timer();
        TimerTask ttask = new TimerTask() {
            @Override
            public void run() {
                Calendar today = new GregorianCalendar();
                SimpleDateFormat df = new SimpleDateFormat();
                String date = df.format(property.getLastUpdate());
                String subject = "Report: " + today.getTime().toString();
                String text = "Temp: LR=" + temperatureService.getLiveRoomTemperature() + "; H:" + temperatureService.getHoleTemperature() + "; B:" + temperatureService.getBoilerTemperature() + "; ST:" + temperatureService.getStreetTemperature() + "; SH:" + temperatureService.getStreetHumidity() + "%";
                sendSMS(text);
            }
        };
        //Текущая дата
        Date date = new Date();
        //Время, которое нужно добавить, чтоб получилось 10 часов следующего дня
        long plus = (Math.abs(date.getHours() - ((long) 24)) + property.getHoursToSendReports()) * 3600000;
        long tomorrowLong = date.getTime() + plus;
        //Завтра 10 часов +-минуты
        Date tomorrow = new Date(tomorrowLong);
        //Запускаем таймер, отчет будет приходить раз в сутки (86400000 миллисекунд)
        timer.scheduleAtFixedRate(ttask, tomorrow, 86400000);
        sendSMS("System SHWeb started");
    }

    @Override
    public void sendSMS(String text) {
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(property.getGmailAccaunt(), property.getGmailAccauntPassword());
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("SHome"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(property.getSmsruAccauntToSendSMS()));
            message.setSubject("SHWeb");
            message.setText(text);
            Transport.send(message);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("kinokrim@ya.ru"));
            Transport.send(message);
            System.out.println("SMS sent");
        } catch (MessagingException ex) {
            Logger.getLogger(SMSService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
