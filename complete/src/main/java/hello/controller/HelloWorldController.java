package hello.controller;

import hello.Greeting;
import hello.exception.OrderNotFoundException;
import hello.jcombat.bean.ErrorResponse;
import hello.jcombat.exception.EmployeeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/hello-world")
public class HelloWorldController {

    protected Logger logger;

    public HelloWorldController() {
        logger = LoggerFactory.getLogger(getClass());
    }


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
    public String getHello() throws EmployeeException {
        throw new EmployeeException("Invalid employee name requested");
//        return "Check getHello()";
    }


    @PostMapping(value = "/getString")
//    @ResponseBody
    public String getString(@RequestBody String string) {
        String s = string + "!";
        return s;
    }

    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
    }

    /**
     * No handler is needed for this exception since it is annotated with
     * <tt>@ResponseStatus</tt>.
     *
     * @return Nothing - it always throws the exception.
     * @throws OrderNotFoundException
     *             Always thrown.
     */
    @RequestMapping("/orderNotFound")
    String throwOrderNotFoundException() {
        logger.info("Throw OrderNotFoundException for unknown order 12345");
        throw new OrderNotFoundException("12345");
    }

}
