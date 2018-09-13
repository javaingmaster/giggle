package giggles.giggle.config;

import java.util.Properties;

import com.github.pagehelper.PageHelper;
import giggles.giggle.infra.util.interceptor.SqlCostInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zty
 * <p>
 * 分页插件配置
 * <p>
 * 分页参数详解:https://blog.csdn.net/caodongfang126/article/details/77853093
 */
@Configuration
public class MybatisPluginConfig {
    @Bean
    PageHelper pageHelper() {
        //分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);

        //添加插件
        new SqlSessionFactoryBean().setPlugins(new Interceptor[]{pageHelper,new SqlCostInterceptor()});
        return pageHelper;
    }
}
