package miu.registration.teacher;

import lombok.RequiredArgsConstructor;
import miu.registration.block.BlockCourse;
import miu.registration.block.BlockCourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final BlockCourseService blockCourseService;

    public Iterable<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public List<BlockCourse> getTeacherCourses(String teacherEmail) {
        return blockCourseService.getBlockCoursesByTeacherId(teacherRepository.findByEmail(teacherEmail).getId());
    }

}
