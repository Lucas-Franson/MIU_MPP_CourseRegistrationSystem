package miu.registration.prioritization;

import miu.registration.block.Block;
import miu.registration.student.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrioritizationRepository extends CrudRepository<Prioritization, Long> {
    List<Prioritization> findAllByBlockAndStudent(Block block, Student student);
}