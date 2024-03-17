package miu.registration.student;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import miu.registration.block.BlockCourse;
import miu.registration.prioritization.PrioritizationBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Student APIs")
@RestController
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    @Operation(summary = "Get list of all students",
            description = "This API will return all preloaded students. Lucas ID = 26, David ID = 27")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Iterable<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("{studentEmail}")
    @Operation(summary = "Get registered courses",
            description = "This API will return registered courses for the studentEmail after Admin process registrations.  Lucas ID = 26, David ID = 27")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<BlockCourse>> getMyCourses(@PathVariable("studentEmail") @Parameter(example = "e.davaatulga@miu.edu") String studentEmail) {
        return ResponseEntity.ok(studentService.getCourses(studentEmail));
    }

    @PutMapping("{studentEmail}")
    @Operation(summary = "Prioritize courses",
            description = "This API will prioritize courses from 1 - 4. 1 - top priority, 4 - lowest priority")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<PrioritizationBody> prioritizeCourses(@PathVariable @Parameter(example = "e.davaatulga@miu.edu") String studentEmail, @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The body to prioritize courses", content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = PrioritizationBody.class),
            examples = {@ExampleObject(name = "default", value = PrioritizationBody.ExampleBody)}))
    @RequestBody PrioritizationBody body) {
        return ResponseEntity.ok(studentService.prioritizeCourses(studentEmail, body));
    }

}
