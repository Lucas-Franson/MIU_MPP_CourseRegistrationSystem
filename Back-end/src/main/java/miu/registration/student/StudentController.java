package miu.registration.student;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import miu.registration.course.BlockCourse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Student APIs")
@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{studentId}")
    @Operation(summary = "Get registered courses",
            description = "This API will return registered courses for the studentId after Admin process registrations.")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<BlockCourse>> getMyCourses(@PathVariable("studentId") @Parameter(example = "617561") long studentId) {
        return ResponseEntity.ok(studentService.getCourses(studentId));
    }

    @PostMapping("{studentId}/{blockCourseId}")
    @Operation(summary = "Register for a block course")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<?> registerForCourse(@PathVariable("studentId") @Parameter(example = "617561") long studentId,
                                               @PathVariable("blockCourseId") @Parameter(example = "4") long blockCourseId) {
        return ResponseEntity.ok(studentService.registerCourse());
    }


}
