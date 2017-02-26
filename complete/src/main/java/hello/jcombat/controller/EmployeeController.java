package hello.jcombat.controller;

import hello.jcombat.bean.Employee;
import hello.jcombat.bean.ErrorResponse;
import hello.jcombat.exception.EmployeeException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

	/*
	 * http://localhost:8080/RESTWithSpringMVCException/Ramesh?empId=1234
	 * https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/http/HttpStatus.html
	 */
	@RequestMapping(value = "/{firstName}", method = RequestMethod.GET)
	public ResponseEntity<Employee> showMessage(
			@PathVariable("firstName") String firstName,
			@RequestParam(value = "empId", required = false, defaultValue = "00000") final String empId) throws EmployeeException {

		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setFirstName(firstName);

		if (StringUtils.isNumeric(firstName)) {
			throw new EmployeeException("Invalid employee name requested");
		}

		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
}