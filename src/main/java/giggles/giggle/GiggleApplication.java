package giggles.giggle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author zty
 * 主类
 */
@ServletComponentScan(basePackages = "giggles.giggle.config")
@MapperScan("giggles.giggle.infra.mapper")
@ComponentScan(basePackages = {"giggles.giggle.config", "giggles.giggle.api", "giggles.giggle.app", "giggles.giggle.infra.repository", "giggles.giggle.infra.util"})
@SpringBootApplication
public class GiggleApplication {

    public static void main(String[] args) {
        SpringApplication.run(GiggleApplication.class, args);
    }
}
