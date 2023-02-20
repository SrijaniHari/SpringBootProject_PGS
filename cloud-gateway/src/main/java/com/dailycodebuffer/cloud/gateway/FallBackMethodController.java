package com.dailycodebuffer.cloud.gateway;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class FallBackMethodController {
    @GetMapping("/userServiceFallBack")
    @CircuitBreaker(name="userService", fallbackMethod = "userServiceFallbackMethod")
    public String userServiceFallBackMethod(){
        return "User Service is not responding."+
                " Please Try again later";

    }

    @GetMapping("/departmentServiceFallBack")
    @CircuitBreaker(name="departmentService", fallbackMethod = "departmentServiceFallbackMethod")
    public String departmentServiceFallBackMethod(){
        return "Department Service is not responding."+
                " Please Try again later";

    }

}
