package miu.registration.teacher;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import miu.registration.block.BlockCourse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Teacher APIs")
@RestController
@RequestMapping("teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    @Operation(summary = "Get list of all teachers")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Iterable<Teacher>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getTeachers());
    }

    @GetMapping("{teacherEmail}")
    @Operation(summary = "Get courses of the Teacher")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<BlockCourse>> getMyCourses(@PathVariable @Parameter(example = "kalu@miu.edu") String teacherEmail) {
        return ResponseEntity.ok(teacherService.getTeacherCourses(teacherEmail));
    }
}
