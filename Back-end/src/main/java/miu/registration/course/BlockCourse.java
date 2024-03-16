package miu.registration.course;

import miu.registration.student.Student;
import miu.registration.teacher.Teacher;

import java.time.LocalDate;
import java.util.List;

public class BlockCourse extends Course {
    private long blockCourseId;
    private int capacity;
    private LocalDate startDate;
    private LocalDate endDate;
    private String campusOrDE;
    private List<Student> enrolledStudents;
    private Teacher teacher;
    private Block block;

    public BlockCourse(long id, String title, String description, long blockCourseId, int capacity, LocalDate startDate, LocalDate endDate, String campusOrDE, List<Student> enrolledStudents, Teacher teacher, Block block) {
        super(id, title, description);
        this.blockCourseId = blockCourseId;
        this.capacity = capacity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.campusOrDE = campusOrDE;
        this.enrolledStudents = enrolledStudents;
        this.teacher = teacher;
        this.block = block;
    }

    @Override
    public long getBlockCourseId() {
        return blockCourseId;
    }

    @Override
    public void setBlockCourseId(long blockCourseId) {
        this.blockCourseId = blockCourseId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCampusOrDE() {
        return campusOrDE;
    }

    public void setCampusOrDE(String campusOrDE) {
        this.campusOrDE = campusOrDE;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
}
