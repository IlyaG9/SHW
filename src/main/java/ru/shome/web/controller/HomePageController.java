package ru.shome.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.shome.web.services.TemperatureService;

/**
 * Smart Home Project. ilya.golovachev9@gmail.com
 *
 * @author ILYA_GOLOVACHEV.
 */
@Controller
public class HomePageController {

    @Autowired
    TemperatureService temperatureService;

    @RequestMapping(value = {"/", "/home", "/index"})
    public String showHomePage(Model model) {
        model.addAttribute("streetTemperature", temperatureService.getStreetTemperature());
        model.addAttribute("streetHumidity", temperatureService.getStreetHumidity());
        model.addAttribute("openweathermap", temperatureService.getOpenweathermapTemperature());
        return "home";
    }

    @RequestMapping(value = "/temperature")
    public String showTemperaturePage(Model model) {
        model.addAttribute("boiler", temperatureService.getBoilerTemperature());
        model.addAttribute("liveroom", temperatureService.getLiveRoomTemperature());
        model.addAttribute("hole", temperatureService.getHoleTemperature());
        model.addAttribute("streetTemperature", temperatureService.getStreetTemperature());
        model.addAttribute("streetHumidity", temperatureService.getStreetHumidity());
        model.addAttribute("openweathermap", temperatureService.getOpenweathermapTemperature());
        return "temperature";
    }

    @RequestMapping(value = "/webcam")
    public String showWebcamPage(HttpServletRequest request, Model model) {
        String addr = request.getRemoteAddr();
        addr = addr.replace(".", "/");
        String[] split = addr.split("/");

        if ((split[0].equals("192") && split[1].equals("168")) || (split[0].equals("127") && split[1].equals("0"))) {
            model.addAttribute("local", true);
        } else {
            model.addAttribute("local", false);
        }
        return "webcam";
    }
}
