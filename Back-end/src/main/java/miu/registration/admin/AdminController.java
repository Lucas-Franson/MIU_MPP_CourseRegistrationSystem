package miu.registration.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Admin APIs")
@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @Operation(summary = "Process the registrations", description = "This API is used to process all the registrations.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Registrations processed successfully")
    })
    @PostMapping("process-registrations")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<?> processRegistrations() {
        return ResponseEntity.ok(adminService.processRegistrations());
    }

}
