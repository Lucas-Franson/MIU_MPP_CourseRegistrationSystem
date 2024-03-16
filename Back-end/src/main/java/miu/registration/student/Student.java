package miu.registration.student;

import miu.registration.course.Block;
import miu.registration.course.Course;
import java.util.List;

public class Student {
    private long id;
    private String name;
    private String email;
    private List<Course> courses;
    private List<Block> blocks;

    public Student(long id, String name, String email, List<Course> courses, List<Block> blocks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.courses = courses;
        this.blocks = blocks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
}