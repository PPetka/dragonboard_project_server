package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.service.LedService;

/**
 * Created by Przemyslaw Petka on 11/4/2017.
 */
@RestController
@RequestMapping("led")
public class LedController {

    @Autowired
    LedService ledService;

    @GetMapping("/changeState")
    public String getRegisteredDevicesCount(@RequestParam(value = "state") Integer state) {
        final String errorMsg = "state must be either 1 or 0";
        switch (state) {
            case LedService.LED_HIGH:
                return ledService.lightUp();
            case LedService.LED_LOW:
                return ledService.turnOff();
            default:
                return errorMsg;
        }
    }

}
