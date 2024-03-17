package miu.registration.block;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlockCourseService {

    private final BlockCourseRepository blockCourseRepository;
    private final BlockRepository blockRepository;

    public Iterable<BlockCourse> getCampusCourseOfferings() {
        return blockCourseRepository.findAll();
    }

    public List<BlockCourse> getBlockCoursesByTeacherId(long id) {
        return blockCourseRepository.findAllByTeacherId(id);
    }

    public Iterable<Block> getAllBlocks() {
        return blockRepository.findAll();
    }

}
