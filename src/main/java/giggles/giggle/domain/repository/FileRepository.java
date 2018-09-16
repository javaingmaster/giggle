package giggles.giggle.domain.repository;

import giggles.giggle.domain.entity.Video;

/**
 * @author zty
 *
 * <p>file repository</p>
 */
public interface FileRepository {
    /**
     * <p>add a video file</p>
     *
     * @param video
     * @return
     */
    public Video uploadFile(Video video);
}
