package ru.shome.web.beans;

import java.util.Date;

/**
 * Smart Homne Project.
 * ilya.golovachev9@gmail.com
 *
 * @author ILYA_GOLOVACHEV.
 */
public class Property {

    private String programTitle;
    private String arduinoURL;
    private Integer runUpdateTime;
    private Integer updateTime;
    private Double temperatureBoilerOn;
    private Double temperatureBoilerOff;
    private String gmailAccaunt;
    private String gmailAccauntPassword;
    private String smsruAccauntToSendSMS;
    private Integer hoursToSendReports;
    private Date lastUpdate;

    //  private Integer intervalToSendReports;
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getSmsruAccauntToSendSMS() {
        return smsruAccauntToSendSMS;
    }

    public void setSmsruAccauntToSendSMS(String smsruAccauntToSendSMS) {
        this.smsruAccauntToSendSMS = smsruAccauntToSendSMS;
    }

    public Double getTemperatureBoilerOn() {
        return temperatureBoilerOn;
    }

    public void setTemperatureBoilerOn(Double temperatureBoilerOn) {
        this.temperatureBoilerOn = temperatureBoilerOn;
    }

    public Double getTemperatureBoilerOff() {
        return temperatureBoilerOff;
    }

    public void setTemperatureBoilerOff(Double temperatureBoilerOff) {
        this.temperatureBoilerOff = temperatureBoilerOff;
    }


    public Integer getRunUpdateTime() {
        return runUpdateTime;
    }

    public void setRunUpdateTime(Integer runUpdateTime) {
        this.runUpdateTime = runUpdateTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }



    public String getProgramTitle() {
        return programTitle;
    }

    public void setProgramTitle(String programTitle) {
        this.programTitle = programTitle;
    }

    public String getArduinoURL() {
        return arduinoURL;
    }

    public void setArduinoURL(String arduinoURL) {
        this.arduinoURL = arduinoURL;
    }

    public String getGmailAccaunt() {
        return gmailAccaunt;
    }

    public void setGmailAccaunt(String gmailAccaunt) {
        this.gmailAccaunt = gmailAccaunt;
    }

    public String getGmailAccauntPassword() {
        return gmailAccauntPassword;
    }

    public void setGmailAccauntPassword(String gmailAccauntPassword) {
        this.gmailAccauntPassword = gmailAccauntPassword;
    }

//    public Integer getIntervalToSendReports() {
//        return intervalToSendReports;
//    }
//
//    public void setIntervalToSendReports(Integer intervalToSendReports) {
//        this.intervalToSendReports = intervalToSendReports;
//    }
    public Integer getHoursToSendReports() {
        return hoursToSendReports;
    }

    public void setHoursToSendReports(Integer hoursToSendReports) {
        this.hoursToSendReports = hoursToSendReports;
    }

}
