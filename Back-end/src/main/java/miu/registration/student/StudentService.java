package miu.registration.student;

import miu.registration.course.BlockCourse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    public List<BlockCourse> getCourses(long studentId) {
        List<BlockCourse> blockCourses = new ArrayList<>();
        return blockCourses;
    }

    public BlockCourse registerCourse() {
        return null;
    }
}
