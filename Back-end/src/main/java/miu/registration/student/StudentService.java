package miu.registration.student;

import lombok.RequiredArgsConstructor;
import miu.registration.block.BlockCourse;
import miu.registration.block.BlockCourseRepository;
import miu.registration.block.BlockRepository;
import miu.registration.prioritization.Prioritization;
import miu.registration.prioritization.PrioritizationBody;
import miu.registration.prioritization.PrioritizationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepo;
    private final PrioritizationRepository prioritizationRepo;
    private final BlockCourseRepository blockCourseRepo;
    private final BlockRepository blockRepo;

    public Iterable<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public List<BlockCourse> getCourses(String studentEmail) {
        return studentRepo.findByEmail(studentEmail)
                .orElse(new Student())
                .getRegisteredCourses();
    }

    public PrioritizationBody prioritizeCourses(String studentEmail, PrioritizationBody body) {
        var student = studentRepo.findByEmail(studentEmail);
        if (student.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");

        for (PrioritizationBody.PriorityBlock priorityBlock : body.getBlocks()) {
            var first = blockCourseRepo.findById(priorityBlock.getOne());
            var second = blockCourseRepo.findById(priorityBlock.getTwo());
            var third = blockCourseRepo.findById(priorityBlock.getThree());
            var fourth = blockCourseRepo.findById(priorityBlock.getFour());
            var block = blockRepo.findById(priorityBlock.getBlockId());
            if (first.isEmpty() ||
                    second.isEmpty() ||
                    third.isEmpty() ||
                    fourth.isEmpty() ||
                    block.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Block / Block course not found");

            if (!first.get().getBlock().equals(block.get()) ||
                    !second.get().getBlock().equals(block.get()) ||
                    !third.get().getBlock().equals(block.get()) ||
                    !fourth.get().getBlock().equals(block.get()))
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Block course doesn't match its Block");

            // Delete previous block prioritizations
            var deleteData = prioritizationRepo.findAllByBlockAndStudent(block.get(), student.get());
            prioritizationRepo.deleteAll(deleteData);

            prioritizationRepo.saveAll(List.of(
                    new Prioritization(1, student.get(), first.get(), block.get()),
                    new Prioritization(2, student.get(), second.get(), block.get()),
                    new Prioritization(3, student.get(), third.get(), block.get()),
                    new Prioritization(4, student.get(), fourth.get(), block.get())));
        }
        return body;
    }

}