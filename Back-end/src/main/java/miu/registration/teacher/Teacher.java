package miu.registration.teacher;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "TEACHER")
public class Teacher {

    @Id
    private long id;
    private String name;
    private String email;

}