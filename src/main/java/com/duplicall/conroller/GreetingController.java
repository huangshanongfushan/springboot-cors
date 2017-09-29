package com.duplicall.conroller;

import com.duplicall.model.Greeting;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletResponse;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting")
    public Greeting greeting(@RequestParam(required = false, defaultValue = "World") String name, ServletResponse response) {
        System.out.println("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
