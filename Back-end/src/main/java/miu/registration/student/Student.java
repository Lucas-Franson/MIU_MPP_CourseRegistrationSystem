package miu.registration.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import miu.registration.block.Block;
import miu.registration.block.BlockCourse;

import java.util.List;

@Data
@Entity(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;

    @ManyToMany
    @JsonIgnore
    private List<BlockCourse> registeredCourses;

    @OneToMany
    @JsonIgnore
    private List<Block> blocks;

}