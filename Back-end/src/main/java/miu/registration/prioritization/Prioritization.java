package miu.registration.prioritization;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import miu.registration.block.Block;
import miu.registration.block.BlockCourse;
import miu.registration.student.Student;

@Data
@Entity
@RequiredArgsConstructor
public class Prioritization {

    @Id
    @GeneratedValue
    private long id;
    private int priority;

    @ManyToOne
    private Student student;

    @ManyToOne
    private BlockCourse blockCourse;

    @ManyToOne
    private Block block;

    public Prioritization(int priority, Student student, BlockCourse blockCourse, Block block) {
        this.priority = priority;
        this.student = student;
        this.blockCourse = blockCourse;
        this.block = block;
    }
}
