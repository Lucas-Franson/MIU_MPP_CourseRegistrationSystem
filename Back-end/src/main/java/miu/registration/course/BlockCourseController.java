package miu.registration.course;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Block API")
@RestController
@RequestMapping("blockCourse")
public class BlockCourseController {

    private final BlockCourseService blockCourseService;

    public BlockCourseController(BlockCourseService blockCourseService) {
        this.blockCourseService = blockCourseService;
    }

    @GetMapping
    @Operation(summary = "Get Campus Course Offerings")
    public ResponseEntity<List<BlockCourse>> getCampusCourseOfferings() {
        return ResponseEntity.ok(blockCourseService.getCampusCourseOfferings());
    }

}
