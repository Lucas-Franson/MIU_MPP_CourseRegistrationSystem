package miu.registration.teacher;

import miu.registration.course.Block;
import miu.registration.course.BlockCourse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    public List<BlockCourse> getTeacherCourses(String teacherName) {
        Teacher teacher3 = new Teacher(3, "Obinna Kalu");

        Block block2 = new Block(2, LocalDate.of(2024, 3, 1), new ArrayList<>());
        Block block8 = new Block(8, LocalDate.of(2024, 4, 1), new ArrayList<>());

        List<BlockCourse> blockCourses = new ArrayList<>();
        blockCourses.add(new BlockCourse(3, "CS401", "Modern Programming Practices", 3, 30, LocalDate.of(2024, 2, 26), LocalDate.of(2024, 3, 31), "Campus", new ArrayList<>(), teacher3, block2));
        blockCourses.add(new BlockCourse(14, "CS489", "Applied Software Development", 14, 20, LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 30), "Campus", new ArrayList<>(), teacher3, block8));
        return blockCourses;
    }

}
