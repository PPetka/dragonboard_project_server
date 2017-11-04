package springboot.service;

import dragonboard.swig.gpio;
import org.springframework.stereotype.Service;

/**
 * Created by Przemyslaw Petka on 11/4/2017.
 */
@Service
public class LedService {
    public static final int LED_HIGH = 1;
    public static final int LED_LOW = 0;

    private final char pinNumber = (char) 33;

    private long pin;

    public LedService() throws IllegalStateException {
        pin = gpio.gpio_by_pin(pinNumber);
        if (gpio.gpio_open(pin, "out") != 0) {
            throw new IllegalStateException("Test");
        }
    }

    public String lightUp() {
        String result = String.valueOf(gpio.digitalWrite(pin, LED_HIGH));
        System.out.println(result);
        return result;
    }

    public String turnOff() {
        String result = String.valueOf(gpio.digitalWrite(pin, LED_LOW));
        System.out.println(result);
        return result;
    }
}
