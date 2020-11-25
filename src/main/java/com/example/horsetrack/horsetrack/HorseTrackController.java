package com.example.horsetrack.horsetrack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HorseTrackController {
    private HorseTrackHandler horseTrackHandler = new HorseTrackHandler();

    @GetMapping("/start")
    @ResponseBody
    public String start(){
        return HorseTrackHelper.displayInitialInventory() + "<br/>" +
                HorseTrackHelper.displayInitialHorseInfo();
    }

    @GetMapping("/play/{param1}/{param2}")
    @ResponseBody
    public String play(@PathVariable("param1") String param1, @PathVariable("param2") String param2) {
        return horseTrackHandler.handle(param1, param2);
    }
}
