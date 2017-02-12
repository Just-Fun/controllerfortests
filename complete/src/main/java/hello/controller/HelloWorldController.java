package hello.controller;

import hello.Greeting;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/hello-world")
public class HelloWorldController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Greeting sayHello(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> sayHelloPost(@RequestBody String string) {
        Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, string));
        System.out.println(greeting.getContent() + " " + greeting.getId());
        return ResponseEntity.ok(string);
    }

    @RequestMapping(value = "/getHello", method = RequestMethod.GET)
    @ResponseBody
    public String getHello() {
        return "Check getHello()";
    }
}
