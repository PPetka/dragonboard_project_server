package springboot.controller;

import dragonboard.swig.gpio;
import model.ActionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.service.LedService;

import javax.annotation.PostConstruct;

/**
 * Created by Przemyslaw Petka on 11/4/2017.
 */
@RestController
@RequestMapping("led")
public class LedController {

    @Autowired
    LedService ledService;


    @GetMapping("/changeState")
    public ActionStatus changeLedState(@RequestParam(value = "state") Integer state) {
        switch (state) {
            case LedService.LED_HIGH:
                return ledService.lightUp();
            case LedService.LED_LOW:
                return ledService.turnOff();
            default:
                return getErrorActionStatus();
        }
    }

    @GetMapping("/isLedLighted")
    public Boolean isLedLighted() {
        return ledService.getLedState() == 1;
    }

    private ActionStatus getErrorActionStatus() {
        ActionStatus errorActionStatus = new ActionStatus();
        errorActionStatus.setSuccess(false);
        errorActionStatus.setCurrentLedState(ledService.getLedState());
        errorActionStatus.setMessage("Error, state must be either 0 or 1");
        return errorActionStatus;
    }
}
