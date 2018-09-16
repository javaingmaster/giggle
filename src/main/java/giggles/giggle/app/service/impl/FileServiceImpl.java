package giggles.giggle.app.service.impl;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import giggles.giggle.app.service.FileService;
import giggles.giggle.domain.entity.Video;
import giggles.giggle.domain.repository.FileRepository;
import giggles.giggle.infra.constant.FileType;
import giggles.giggle.infra.util.exception.SerFileNameAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zty
 *
 * <p>file service impl</p>
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class FileServiceImpl implements FileService {
    @Autowired
    private FileRepository fileRepository;

    @Override
    public Object uploadOne(MultipartFile file, String description, HttpServletRequest request) {

        String originName = file.getOriginalFilename();
        InputStream in = null;
        FileOutputStream fileOutputStream = null;
        Video video = null;

        try {
            if (file.getContentType().contains(FileType.VIDEO)) {
                //测试,实际用户名从token获取
                video = new Video(originName, "shit", description, new Date());
                String path = System.getProperty("user.dir");
                //测试path,实际从token中获取 todo
                request.setAttribute("username", "shit");
                File filePath = new File(path + "\\upload\\" + ((String) request.getAttribute("username")) + "\\videos");
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                File uploadFilePath = new File(filePath + "\\" + originName);
                in = file.getInputStream();
                fileOutputStream = new FileOutputStream(uploadFilePath);
                
                if (!uploadFilePath.exists()) {
                    uploadFilePath.createNewFile();
                } else {
                    throw new SerFileNameAlreadyExistsException("the name: " + originName + " already exists");
                }
                video.setFilePath(filePath + "\\" + originName);

            } else {
                // TODO: 2018/9/16 other file type 
            }

            video = fileRepository.uploadFile(video);

            byte[] bytes = new byte[1024];
            while (in.read(bytes) != -1) {
                fileOutputStream.write(bytes);
            }
            fileOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return video;
    }
}
