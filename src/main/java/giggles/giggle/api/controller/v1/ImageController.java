package giggles.giggle.api.controller.v1;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import giggles.giggle.infra.util.interfaces.Permission;
import giggles.giggle.infra.util.jwt.ValidatorUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api("get images from here")
@CrossOrigin
@RequestMapping("/v1/images")
public class ImageController {

    @GetMapping(value = "/identify", produces = {"image/png"})
    @ApiOperation("get identify image")
    @Permission
    public void getIdentifyImage(HttpSession session, HttpServletResponse response) {
        response.setContentType("image/png");

        try {
            OutputStream outputStream = response.getOutputStream();

            Object[] objects = ValidatorUtil.createIdentifyImage();
            BufferedImage bufferedImage = (BufferedImage) objects[0];
            session.setAttribute("identifyCode", objects[1]);
            System.out.println((String)objects[1]);

            ImageIO.write(bufferedImage, "png", outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
