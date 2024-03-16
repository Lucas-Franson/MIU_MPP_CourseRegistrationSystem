package miu.registration.course;

import java.time.LocalDate;
import java.util.List;

public class Block {
    private long blockId;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<BlockCourse> blockCourses;

    public Block(long blockId, LocalDate startDate, List<BlockCourse> blockCourses) {
        this.blockId = blockId;
        this.startDate = startDate;
        this.endDate = startDate.plusMonths(1);
        this.blockCourses = blockCourses;
    }

    public long getBlockId() {
        return blockId;
    }

    public void setBlockId(long blockId) {
        this.blockId = blockId;
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

    public List<BlockCourse> getBlockCourses() {
        return blockCourses;
    }

    public void setBlockCourses(List<BlockCourse> blockCourses) {
        this.blockCourses = blockCourses;
    }
}
