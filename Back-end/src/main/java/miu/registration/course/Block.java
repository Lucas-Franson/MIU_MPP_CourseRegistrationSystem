package miu.registration.course;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long blockId;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany
    private List<BlockCourse> blockCourses;

}
