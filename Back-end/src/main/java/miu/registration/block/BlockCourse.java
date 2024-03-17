package miu.registration.block;

import jakarta.persistence.*;
import lombok.Data;
import miu.registration.course.Course;
import miu.registration.student.Student;
import miu.registration.teacher.Teacher;

import java.util.List;

@Data
@Entity(name = "BlOCK_COURSE")
public class BlockCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long blockCourseId;

    @ManyToOne
    private Course course;

    private int capacity;
    private int enrolled;
    private String campusOrDE;

    @ManyToMany
    private List<Student> enrolledStudents;

    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private Block block;

}
