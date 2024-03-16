package miu.registration.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Admin APIs")
@RestController
@RequestMapping("admin")
public class AdminController {

    @PostMapping("process-registrations")
    @Operation(summary = "Process the registrations")
    public ResponseEntity<?> processRegistrations() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("reset-registrations")
    @Operation(summary = "Reset the registrations - for test")
    public ResponseEntity<?> resetRegistrations() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
