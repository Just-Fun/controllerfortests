package hello.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.lang.invoke.MethodHandles;
/**
 * Created by Serzh on 2/26/17.
 */
@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class GeneralRestExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


 /*   @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage("Please contact your administrator");
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
    }*/
 /*   @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomNotFoundException.class)
    public void handleNotFoundException(final Exception exception) {
        logException(exception);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(CustomForbiddenException.class)
    public void handleForbiddenException(final Exception exception) {
        logException(exception);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ CustomException.class, Exception.class })
    public void handleGeneralException(final Exception exception) {
        logException(exception);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ CustomBadRequestException.class, IllegalArgumentException.class })
    @ResponseBody
    public String handleBadRequestException(final Exception exception) {
        logException(exception);
        return exception.getMessage();
    }*/

    // Add more exception handling as needed…
    // …

    private void logException(final Exception exception) {
        // ...
    }

}