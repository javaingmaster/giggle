package giggles.giggle.infra.util.jwt;

import javax.validation.ConstraintValidatorContext;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import giggles.giggle.infra.constant.IdentifyChar;
import org.springframework.validation.BindingResult;

/**
 * @author zty
 *
 * <p>valid util</p>
 */
public class ValidatorUtil {
    public static boolean isThisValue(Object o, Object value, ConstraintValidatorContext context) {
        System.out.println(o.equals(value));
        return o.equals(value);
    }

    /**
     * <p>create identify code</p>
     *
     * @return object[0] is image and object[1] is code
     */
    public static Object[] createIdentifyImage() {

        StringBuffer stringBuffer = new StringBuffer();
        BufferedImage bufferedImage = new BufferedImage(IdentifyChar.WIDTH, IdentifyChar.HEIGHT, BufferedImage.TYPE_INT_RGB);

        Graphics g = bufferedImage.getGraphics();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, IdentifyChar.WIDTH, IdentifyChar.HEIGHT);

        Random random = new Random();
        for (int i = 0; i < IdentifyChar.CHAR_NUM; i++) {
            g.setColor(getRandomColor());
            int n = random.nextInt(IdentifyChar.IDENTIFY_CHARS.length);
            g.setFont(new Font(null, Font.BOLD + Font.ITALIC, IdentifyChar.FONT_SIZE));
            g.drawString(IdentifyChar.IDENTIFY_CHARS[n] + "", i * IdentifyChar.WIDTH / IdentifyChar.CHAR_NUM, IdentifyChar.HEIGHT * 2 / 3);
            stringBuffer.append(IdentifyChar.IDENTIFY_CHARS[n]);
        }

        for (int i = 0; i < IdentifyChar.CHAR_LINE; i++) {
            g.setColor(getRandomColor());
            g.drawLine(random.nextInt(IdentifyChar.WIDTH), random.nextInt(IdentifyChar.HEIGHT), random.nextInt(IdentifyChar.WIDTH), random.nextInt(IdentifyChar.HEIGHT));
        }

        return new Object[]{bufferedImage, stringBuffer.toString()};
    }

    /**
     * <p>get random color</p>
     *
     * @return
     */
    public static Color getRandomColor() {
        Random random = new Random();
        Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        return color;
    }
}
