package miu.registration.course;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import miu.registration.student.Student;
import miu.registration.teacher.Teacher;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class BlockCourse extends Course {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long blockCourseId;
    private int capacity;
    private LocalDate startDate;
    private LocalDate endDate;
    private String campusOrDE;

    @OneToMany
    private List<Student> enrolledStudents;

    @OneToOne
    private Teacher teacher;

    @OneToOne
    private Block block;
}
