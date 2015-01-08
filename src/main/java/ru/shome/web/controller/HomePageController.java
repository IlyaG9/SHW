package ru.shome.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.shome.web.services.TemperatureService;

/**
 * Smart Homne Project. ilya.golovachev9@gmail.com
 *
 * @author ILYA_GOLOVACHEV.
 */
@Controller
public class HomePageController {

    @Autowired
    TemperatureService temperatureService;

    @RequestMapping(value = {"/", "/home", "/index"})
    public String showHomePage() {
        return "home";
    }
     @RequestMapping(value = "/temperature")
    public String showTemperaturePage(Model model) {
        model.addAttribute("boiler", temperatureService.getBoilerTemperature());
        model.addAttribute("liveroom", temperatureService.getLiveRoomTemperature());
        model.addAttribute("hole", temperatureService.getHoleTemperature());
        model.addAttribute("openweathermap", temperatureService.getOpenweathermapTemperature());
        return "temperature";
    }
     @RequestMapping(value = "/webcam")
    public String showWebcamPage() {
        return "webcam";
    }
}
