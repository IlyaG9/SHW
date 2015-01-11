
package ru.shome.web.services;

/**
 * Smart Homne Project.
 * ilya.golovachev9@gmail.com
 * @author ILYA_GOLOVACHEV.
 */
public interface SMSService {

    public void startReport();
    
    public void sendSMS(String text);
    
}
