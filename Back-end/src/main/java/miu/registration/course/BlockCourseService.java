package miu.registration.course;

import miu.registration.teacher.Teacher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlockCourseService {
    public List<BlockCourse> getCampusCourseOfferings() {
        Teacher teacher3 = new Teacher(3, "Obinna Kalu");
        Teacher teacher2 = new Teacher(2, "Elinor Wolfe");
        Teacher teacher4 = new Teacher(4, "Tacettin Umur Inan");
        Teacher teacher5 = new Teacher(5, "Payman Salek");
        Teacher teacher6 = new Teacher(6, "Najeeb Najeeb");
        Teacher teacher9 = new Teacher(9, "Natasha Berkowitz");
        Teacher teacher10 = new Teacher(10, "Rujuan Xing");
        Teacher teacher11 = new Teacher(11, "Renuka Mohanraj");
        Teacher teacher12 = new Teacher(12, "Joseph Lerman");
        Teacher teacher13 = new Teacher(13, "Michael Zijlstra");
        Teacher teacher14 = new Teacher(14, "Assad Maalouf");
        Teacher teacher15 = new Teacher(15, "Talal Qaid");
        Teacher teacher16 = new Teacher(16, "Bright Varghese");
        Teacher teacher17 = new Teacher(17, "Thao Huy Vu");
        Teacher teacher18 = new Teacher(18, "Burmaa Enkhbat");
        Teacher teacher19 = new Teacher(19, "Ankhtuya Ochirbat");
        Teacher teacher20 = new Teacher(20, "Rene de Jong");
        Teacher teacher21 = new Teacher(21, "Asaad Saad");
        Teacher teacher22 = new Teacher(22, "Premchand Nair");
        Teacher teacher23 = new Teacher(23, "Sanad AbuRass");
        Teacher teacher24 = new Teacher(24, "Muhyieddin Khaled Al-Tarawneh");

        Block block8 = new Block(8, LocalDate.of(2024, 4, 1), new ArrayList<>());
        Block block9 = new Block(9, LocalDate.of(2024, 5, 1), new ArrayList<>());
        Block block10 = new Block(10, LocalDate.of(2024, 6, 1), new ArrayList<>());

        List<BlockCourse> blockCourses = new ArrayList<>();
        blockCourses.add(new BlockCourse(10, "MGT5341", "Career Strategies for Information Technology", 10, 100, LocalDate.of(2024, 3, 25), LocalDate.of(2024, 4, 30), "Campus", new ArrayList<>(), teacher9, block8));
        blockCourses.add(new BlockCourse(11, "SD545", "Web Application Development 1", 11, 25, LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 30), "Campus", new ArrayList<>(), teacher10, block8));
        blockCourses.add(new BlockCourse(12, "CS401", "Modern Programming Practices", 12, 20, LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 30), "Campus", new ArrayList<>(), teacher11, block8));
        blockCourses.add(new BlockCourse(13, "CS401", "Modern Programming Practices", 13, 20, LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 30), "Campus", new ArrayList<>(), teacher12, block8));
        blockCourses.add(new BlockCourse(14, "CS489", "Applied Software Development", 14, 20, LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 30), "Campus", new ArrayList<>(), teacher3, block8));
        blockCourses.add(new BlockCourse(15, "CS489", "Applied Software Development", 15, 20, LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 30), "Campus", new ArrayList<>(), teacher13, block8));
        blockCourses.add(new BlockCourse(16, "CS489", "Applied Software Development", 16, 20, LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 30), "Campus", new ArrayList<>(), teacher14, block8));
        blockCourses.add(new BlockCourse(17, "CS489", "Applied Software Development", 17, 20, LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 30), "Campus", new ArrayList<>(), teacher15, block8));
        blockCourses.add(new BlockCourse(18, "CS489", "Applied Software Development", 18, 20, LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 30), "Campus", new ArrayList<>(), teacher16, block8));
        blockCourses.add(new BlockCourse(19, "CS489", "Applied Software Development", 19, 20, LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 30), "Campus", new ArrayList<>(), teacher17, block8));
        blockCourses.add(new BlockCourse(20, "CS390", "Fundamental Programming Practices", 20, 25, LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 30), "Campus", new ArrayList<>(), teacher18, block8));
        blockCourses.add(new BlockCourse(21, "CS544", "Enterprise Architecture", 21, 25, LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 30), "Campus", new ArrayList<>(), teacher4, block8));
        blockCourses.add(new BlockCourse(22, "CS472", "Web Programming", 22, 25, LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 30), "Campus", new ArrayList<>(), teacher19, block8));
        blockCourses.add(new BlockCourse(23, "CS590", "Software Architecture", 23, 30, LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 30), "Campus", new ArrayList<>(), teacher20, block8));
        blockCourses.add(new BlockCourse(24, "CS572", "Modern Web Applications", 24, 25, LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 30), "Campus", new ArrayList<>(), teacher21, block8));
        blockCourses.add(new BlockCourse(25, "CS522", "Big Data", 25, 25, LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 30), "Campus", new ArrayList<>(), teacher22, block8));
        blockCourses.add(new BlockCourse(26, "CS582", "Machine Learning", 26, 25, LocalDate.of(2024, 4, 29), LocalDate.of(2024, 5, 31), "Campus", new ArrayList<>(), teacher23, block9));
        blockCourses.add(new BlockCourse(27, "CS422", "Database Management Systems", 27, 25, LocalDate.of(2024, 4, 29), LocalDate.of(2024, 5, 31), "Campus", new ArrayList<>(), teacher4, block9));
        blockCourses.add(new BlockCourse(28, "CS363", "Computer Organization and Architecture", 28, 25, LocalDate.of(2024, 4, 29), LocalDate.of(2024, 5, 31), "Campus", new ArrayList<>(), teacher13, block9));
        blockCourses.add(new BlockCourse(29, "CS472", "Web Programming", 29, 25, LocalDate.of(2024, 4, 29), LocalDate.of(2024, 5, 31), "Campus", new ArrayList<>(), teacher10, block9));
        blockCourses.add(new BlockCourse(30, "CS525", "Advanced Software Development", 30, 45, LocalDate.of(2024, 4, 29), LocalDate.of(2024, 5, 31), "Campus", new ArrayList<>(), teacher5, block9));
        blockCourses.add(new BlockCourse(31, "CS435", "Algorithms", 31, 25, LocalDate.of(2024, 4, 29), LocalDate.of(2024, 5, 31), "Campus", new ArrayList<>(), teacher22, block9));
        blockCourses.add(new BlockCourse(32, "MGT5341", "Career Strategies for Information Technology", 32, 50, LocalDate.of(2024, 4, 29), LocalDate.of(2024, 5, 31), "Campus", new ArrayList<>(), teacher9, block9));
        blockCourses.add(new BlockCourse(33, "SD550", "Web Application Development 2", 33, 25, LocalDate.of(2024, 4, 29), LocalDate.of(2024, 5, 31), "Campus", new ArrayList<>(), teacher17, block9));
        blockCourses.add(new BlockCourse(34, "STC506A", "STC Pt 1- ComPro (Science and Technology of Consciousness)", 34, 25, LocalDate.of(2024, 5, 13), LocalDate.of(2024, 5, 31), "Campus", new ArrayList<>(), teacher2, block9));
        blockCourses.add(new BlockCourse(35, "CS425", "Software Engineering", 35, 25, LocalDate.of(2024, 5, 27), LocalDate.of(2024, 6, 30), "Campus", new ArrayList<>(), teacher6, block10));
        blockCourses.add(new BlockCourse(36, "MGT5341", "Career Strategies for Information Technology", 36, 50, LocalDate.of(2024, 5, 27), LocalDate.of(2024, 6, 30), "Campus", new ArrayList<>(), teacher9, block10));
        blockCourses.add(new BlockCourse(37, "SD555", "Web Application Development 3", 37, 25, LocalDate.of(2024, 5, 27), LocalDate.of(2024, 6, 30), "Campus", new ArrayList<>(), teacher21, block10));
        blockCourses.add(new BlockCourse(38, "CS544", "Enterprise Architecture", 38, 30, LocalDate.of(2024, 5, 27), LocalDate.of(2024, 6, 30), "Campus", new ArrayList<>(), teacher5, block10));
        blockCourses.add(new BlockCourse(39, "CS401", "Modern Programming Practices", 39, 25, LocalDate.of(2024, 5, 27), LocalDate.of(2024, 6, 30), "Campus", new ArrayList<>(), teacher15, block10));
        blockCourses.add(new BlockCourse(40, "CS390", "Fundamental Programming Practices", 40, 25, LocalDate.of(2024, 5, 27), LocalDate.of(2024, 6, 30), "Campus", new ArrayList<>(), teacher11, block10));
        blockCourses.add(new BlockCourse(41, "CS390", "Fundamental Programming Practices", 41, 25, LocalDate.of(2024, 5, 27), LocalDate.of(2024, 6, 30), "Campus", new ArrayList<>(), teacher12, block10));
        blockCourses.add(new BlockCourse(42, "CS472", "Web Programming", 42, 25, LocalDate.of(2024, 5, 27), LocalDate.of(2024, 6, 30), "Campus", new ArrayList<>(), teacher13, block10));
        blockCourses.add(new BlockCourse(43, "CS545", "Web Application Architecture", 43, 35, LocalDate.of(2024, 5, 27), LocalDate.of(2024, 6, 30), "Campus", new ArrayList<>(), teacher24, block10));
        return blockCourses;
    }
}
