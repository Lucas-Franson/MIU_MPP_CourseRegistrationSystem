package miu.registration.block;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlockCourseRepository extends CrudRepository<BlockCourse, Long> {
    List<BlockCourse> findAllByTeacherId(long id);
}