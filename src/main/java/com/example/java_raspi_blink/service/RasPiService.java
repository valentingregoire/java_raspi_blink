package com.example.java_raspi_blink.service;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import org.springframework.stereotype.Service;

@Service
public class RasPiService {
    public String blink() {
        GpioController gpio = GpioFactory.getInstance();
        GpioPinDigitalOutput ledPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
        ledPin.toggle();
        gpio.shutdown();
        gpio.unprovisionPin(ledPin);

        return "The led is now " + (ledPin.isHigh() ? "on" : "off") + "!";
    }
}
