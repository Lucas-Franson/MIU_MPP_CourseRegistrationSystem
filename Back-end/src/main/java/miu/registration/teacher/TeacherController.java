package miu.registration.teacher;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import miu.registration.course.BlockCourse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Teacher API")
@RestController
@RequestMapping("teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("{teacherName}")
    @Operation(summary = "Get courses of the Teacher")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<BlockCourse>> getMyCourses(@PathVariable @Parameter(example = "Obinna Kalu") String teacherName) {
        return ResponseEntity.ok(teacherService.getTeacherCourses(teacherName));
    }
}
