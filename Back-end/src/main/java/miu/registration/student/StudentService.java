package miu.registration.student;

import miu.registration.course.Block;
import miu.registration.course.BlockCourse;
import miu.registration.teacher.Teacher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    public List<BlockCourse> getCourses(long studentId) {
        List<BlockCourse> blockCourses = new ArrayList<>();
        Teacher teacher2 = new Teacher(2, "Elinor Wolfe");
        Teacher teacher3 = new Teacher(3, "Obinna Kalu");
        Teacher teacher4 = new Teacher(4, "Tacettin Umur Inan");
        Teacher teacher5 = new Teacher(5, "Payman Salek");
        Teacher teacher6 = new Teacher(6, "Najeeb Najeeb");
        Teacher teacher7 = new Teacher(7, "Clyde Ruby");
        Teacher teacher8 = new Teacher(8, "James Bagnola");
        Teacher teacher9 = new Teacher(9, "Natasha Berkowitz");

        Block block1 = new Block(1, LocalDate.of(2024, 2, 1), new ArrayList<>());
        Block block2 = new Block(2, LocalDate.of(2024, 3, 1), new ArrayList<>());
        Block block3 = new Block(3, LocalDate.of(2024, 4, 1), new ArrayList<>());
        Block block4 = new Block(4, LocalDate.of(2024, 5, 1), new ArrayList<>());
        Block block5 = new Block(5, LocalDate.of(2024, 6, 1), new ArrayList<>());
        Block block6 = new Block(6, LocalDate.of(2024, 7, 1), new ArrayList<>());
        Block block7 = new Block(7, LocalDate.of(2024, 8, 1), new ArrayList<>());

        blockCourses.add(new BlockCourse(2, "STC506A", "STC Pt 1- ComPro (Science and Technology of Consciousness)", 2, 30, LocalDate.of(2024, 2, 12), LocalDate.of(2024, 2, 28), "Campus", new ArrayList<>(), teacher2, block1));
        blockCourses.add(new BlockCourse(3, "CS401", "Modern Programming Practices", 3, 30, LocalDate.of(2024, 2, 26), LocalDate.of(2024, 3, 31), "Campus", new ArrayList<>(), teacher3, block2));
        blockCourses.add(new BlockCourse(4, "CS544", "Enterprise Architecture", 4, 30, LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 30), "Campus", new ArrayList<>(), teacher4, block3));
        blockCourses.add(new BlockCourse(5, "CS525", "Advanced Software Development", 5, 30, LocalDate.of(2024, 4, 29), LocalDate.of(2024, 5, 31), "Campus", new ArrayList<>(), teacher5, block4));
        blockCourses.add(new BlockCourse(6, "CS425", "Software Engineering", 6, 30, LocalDate.of(2024, 5, 27), LocalDate.of(2024, 6, 30), "Campus", new ArrayList<>(), teacher6, block5));
        blockCourses.add(new BlockCourse(7, "CS435", "Algorithms", 7, 30, LocalDate.of(2024, 6, 24), LocalDate.of(2024, 7, 31), "Campus", new ArrayList<>(), teacher7, block6));
        blockCourses.add(new BlockCourse(8, "STC506B", "STC Pt2 Leadership for Tech Managers", 8, 30, LocalDate.of(2024, 7, 22), LocalDate.of(2024, 8, 31), "Campus", new ArrayList<>(), teacher8, block7));
        blockCourses.add(new BlockCourse(9, "MGT5341", "Career Strategies for Information Technology", 9, 30, LocalDate.of(2024, 8, 5), LocalDate.of(2024, 8, 31), "Campus", new ArrayList<>(), teacher9, block7));
        return blockCourses;
    }

    public BlockCourse registerCourse() {
        Block block3 = new Block(3, LocalDate.of(2024, 4, 1), new ArrayList<>());
        Teacher teacher4 = new Teacher(4, "Tacettin Umur Inan");
        return new BlockCourse(4, "CS544", "Enterprise Architecture", 4, 30, LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 30), "Campus", new ArrayList<>(), teacher4, block3);
    }
}
