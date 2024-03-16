package miu.registration.student;

import jakarta.persistence.*;
import lombok.Data;
import miu.registration.course.Block;
import miu.registration.course.BlockCourse;
import java.util.List;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String email;

    @OneToMany
    private List<BlockCourse> courses;

    @OneToMany
    private List<Block> blocks;
}