package springboot.service;

import dragonboard.swig.gpio;
import model.ActionStatus;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Przemyslaw Petka on 11/4/2017.
 */
@Service
public class LedService {
    public static final int LED_HIGH = 1;
    public static final int LED_LOW = 0;

    private long pin;

    @PostConstruct
    public void init() throws ExceptionInInitializerError {
        char pinNumber = (char) 33;
        pin = gpio.gpio_by_pin(pinNumber);
        if (gpio.gpio_open(pin, "out") != 0) {
            throw new IllegalStateException("Test");
        }
    }

    public ActionStatus lightUp() {
        boolean previousLedState = isLedLighted();
        gpio.digitalWrite(pin, LED_HIGH);
        return createActionStatus(previousLedState, LED_HIGH);
    }

    public ActionStatus turnOff() {
        boolean previousLedState = isLedLighted();
        gpio.digitalWrite(pin, LED_LOW);
        return createActionStatus(previousLedState, LED_LOW);
    }

    private boolean isLedLighted() {
        return gpio.digitalRead(pin) == 1;
    }

    public int getLedState() {
        return gpio.digitalRead(pin);
    }

    private ActionStatus createActionStatus(boolean ledPreviouslyLighted, int action) {
        int currentLedState = gpio.digitalRead(pin);
        boolean currentlyLighted = currentLedState == 1;

        ActionStatus status = new ActionStatus();
        status.setCurrentLedState(currentLedState);
        if (action == LED_HIGH) {//lighting led
            if (ledPreviouslyLighted == currentlyLighted) {
                status.setSuccess(false);
                status.setMessage("Led was already lighted");
            } else {
                status.setSuccess(true);
                status.setMessage("Led has been lighted");
            }
        } else {//turning off led
            if (ledPreviouslyLighted == currentlyLighted) {
                status.setSuccess(false);
                status.setMessage("Led was already turned off");
            } else {
                status.setSuccess(true);
                status.setMessage("Led has been turned off");
            }
        }
        return status;
    }
}
