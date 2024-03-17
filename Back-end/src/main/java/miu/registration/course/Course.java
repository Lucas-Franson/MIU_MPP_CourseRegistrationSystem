package miu.registration.course;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "COURSE")
public class Course {

    @Id
    private String id;
    private String title;

}