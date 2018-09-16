package giggles.giggle.api.controller.v1;

import javax.servlet.http.HttpServletRequest;

import giggles.giggle.app.service.FileService;
import giggles.giggle.infra.util.interfaces.Permission;
import giggles.giggle.infra.util.result.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zty
 *
 * <p>upload file</p>
 */
@RestController
@Api("file upload controller")
@CrossOrigin
@RequestMapping("/v1/files")
public class FileUploadController {
    private static final Logger logger = Logger.getLogger(FileUploadController.class);

    @Autowired
    private FileService fileService;

    @PostMapping
    @Permission
    @ApiOperation("receive a file")
    public Object uploadOneFile(MultipartFile file, String description, HttpServletRequest request) {
        logger.info("upload file");
        if (file != null && description != null) {
            if (!file.isEmpty()) {
                return Results.created(fileService.uploadOne(file, description, request));
            }
        }
        return Results.invalid();
    }
}
