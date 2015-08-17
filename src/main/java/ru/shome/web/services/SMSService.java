
package ru.shome.web.services;

import ru.shome.web.beans.Property;

/**
 * Smart Home Project.
 * ilya.golovachev9@gmail.com
 * @author ILYA_GOLOVACHEV.
 */
public interface SMSService {

    public void startReport();
    
    public void sendSMS(String text,Property property);
    
}
