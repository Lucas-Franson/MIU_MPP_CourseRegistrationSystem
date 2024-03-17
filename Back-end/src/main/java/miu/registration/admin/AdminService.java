package miu.registration.admin;

import lombok.RequiredArgsConstructor;
import miu.registration.block.BlockCourse;
import miu.registration.block.BlockCourseRepository;
import miu.registration.prioritization.Prioritization;
import miu.registration.prioritization.PrioritizationRepository;
import miu.registration.student.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final PrioritizationRepository prioritizationRepository;
    private final BlockCourseRepository blockRepository;
    private final StudentRepository studentRepository;

    public List<BlockCourse> processRegistrations() {
        var prioritizations = getPrioritizations();
        var blockCourses = getBlockCourses();

        for (BlockCourse blockCourse : blockCourses) {
            for (int priority = 1; priority <= 4; priority++) {
                final int finalPriority = priority;
                var prioritizationList = prioritizations.stream()
                        .filter(p -> p.getBlockCourse().equals(blockCourse))
                        .filter(p -> p.getPriority() == finalPriority)
                        .collect(Collectors.toList());

                int remaining = Math.subtractExact(
                        blockCourse.getCapacity(),
                        blockCourse.getEnrolled());
                // If there is more students than remaining, randomize
                if (prioritizationList.size() > remaining) {
                    Collections.shuffle(prioritizationList);
                    prioritizationList = prioritizationList.subList(0, remaining);
                }

                for (Prioritization prioritization : prioritizationList) {
                    var student = prioritization.getStudent();
                    // Check if student is already enrolled in a course for the same block
                    if (student.getRegisteredCourses().stream()
                            .anyMatch(c -> c.getBlock().equals(blockCourse.getBlock()))) {
                        continue;
                    }

                    blockCourse.setEnrolled(blockCourse.getEnrolled() + 1);
                    // Set enrolled students in block course
                    var alreadyEnrolled = blockCourse.getEnrolledStudents();
                    alreadyEnrolled.add(student);
                    blockCourse.setEnrolledStudents(alreadyEnrolled);
                    blockRepository.save(blockCourse);

                    // Set registered courses for student
                    var alreadyRegisteredCourses = student.getRegisteredCourses();
                    alreadyRegisteredCourses.add(blockCourse);
                    student.setRegisteredCourses(alreadyRegisteredCourses);
                    studentRepository.save(student);

                    prioritizations.remove(prioritization);
                    prioritizationRepository.delete(prioritization);
                }
            }
        }
        return blockCourses;
    }

    private List<Prioritization> getPrioritizations() {
        List<Prioritization> prioritizations = new ArrayList<>();
        prioritizationRepository.findAll()
                .iterator()
                .forEachRemaining(prioritizations::add);
        return prioritizations;
    }

    private List<BlockCourse> getBlockCourses() {
        List<BlockCourse> blockCourses = new ArrayList<>();
        blockRepository.findAll()
                .iterator()
                .forEachRemaining(blockCourses::add);
        return blockCourses;
    }
}
