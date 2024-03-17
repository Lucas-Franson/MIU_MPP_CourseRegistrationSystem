package miu.registration.block;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Block APIs")
@RestController
@RequestMapping("blockCourse")
@RequiredArgsConstructor
public class BlockCourseController {

    private final BlockCourseService blockCourseService;

    @Operation(summary = "Get Campus Course Offerings", description = "This API is used to get all the campus course offerings.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of campus course offerings"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Iterable<BlockCourse>> getCampusCourseOfferings() {
        return ResponseEntity.ok(blockCourseService.getCampusCourseOfferings());
    }

    @Operation(summary = "Get all blocks", description = "This API is used to get all the blocks.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of all blocks"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("all")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Iterable<Block>> getAllBlocks() {
        return ResponseEntity.ok(blockCourseService.getAllBlocks());
    }

}
