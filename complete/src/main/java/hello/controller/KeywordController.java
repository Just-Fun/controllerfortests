package hello.controller;

import hello.bean.ErrorDetail;
import hello.exception.KeywordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/keyword")
public class KeywordController {

    private final AtomicLong counter = new AtomicLong();

    @ExceptionHandler(KeywordNotFoundException.class)
    public ErrorDetail myError(HttpServletRequest request, Exception exception) {
        ErrorDetail error = new ErrorDetail();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getLocalizedMessage());
        error.setUrl(request.getRequestURL().append("/error/111").toString());
        return error;
    }

    @RequestMapping("/info")
    public String info(@RequestParam(value = "key") String key, Model model) {
        if (!"key101".equals(key)) {
            throw new KeywordNotFoundException(key);
        }
        return "success";
    }
//    }


    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> sayHelloPost(@RequestBody String string) {

        return ResponseEntity.ok(string);
    }

    @RequestMapping(value = "/getException", method = RequestMethod.GET)
    @ResponseBody
    public String getHello() {
        return "Check getHello()";
    }


    @PostMapping(value = "/getString")
//    @ResponseBody
    public String getString(@RequestBody String string) {
        String s = string + "!";
        return s;
    }

    /*@RequestMapping("/keyword")
public class KeywordController {
	@ExceptionHandler(KeywordNotFoundException.class)
	public ErrorDetail myError(HttpServletRequest request, Exception exception) {
	    ErrorDetail error = new ErrorDetail();
	    error.setStatus(HttpStatus.BAD_REQUEST.value());
	    error.setMessage(exception.getLocalizedMessage());
	    error.setUrl(request.getRequestURL().append("/error/111").toString());
	    return error;
	}
	@RequestMapping("/info")
    public String info(@RequestParam(value="key") String key, Model model) {
		if (!"key101".equals(key)) {
			throw new KeywordNotFoundException(key);
		}
        return "success";
    }
}*/

}
