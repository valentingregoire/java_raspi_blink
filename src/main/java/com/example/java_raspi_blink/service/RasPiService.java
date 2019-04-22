package com.example.java_raspi_blink.service;

import com.pi4j.io.gpio.*;
import org.springframework.stereotype.Service;

@Service
public class RasPiService {
    public String blink() {
        GpioController gpio = GpioFactory.getInstance();
        GpioPinDigitalOutput ledPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
        String status;
        if (ledPin.getState().isHigh()) {
            ledPin.setState(PinState.LOW);
            status = "off";
        } else {
            status = "on";
            ledPin.setState(PinState.HIGH);
        }
        gpio.shutdown();
        gpio.unprovisionPin(ledPin);

        return "The led is now " + status + "!";
    }
}
