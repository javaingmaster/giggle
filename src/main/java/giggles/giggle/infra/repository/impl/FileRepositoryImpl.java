package giggles.giggle.infra.repository.impl;

import java.util.Date;

import giggles.giggle.domain.entity.Video;
import giggles.giggle.domain.repository.FileRepository;
import giggles.giggle.infra.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author zty
 *
 * <p>file repository</p>
 */
@Repository
public class FileRepositoryImpl implements FileRepository {
    @Autowired
    private FileMapper fileMapper;

    @Override
    public Video uploadFile(Video video) {
        video.setFileCheck(0);
        video.setUserVersion(0);
        fileMapper.insert(video);
        return video;
    }
}
