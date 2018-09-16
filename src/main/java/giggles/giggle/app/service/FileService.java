package giggles.giggle.app.service;

import javax.servlet.http.HttpServletRequest;

import giggles.giggle.domain.entity.Video;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zty
 *
 * <p>file upload service</p>
 */
public interface FileService {
    /**
     * <p>upload a file</p>
     *
     * <p>this function must be optimised for uploading,
     * it should be changed to an async function,
     * because the speed of uploading depends on network,
     * we should put uploading action into another thread</p>
     *
     * @param file
     * @return
     */
    public Object uploadOne(MultipartFile file, String description, HttpServletRequest request);
}
