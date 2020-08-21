import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: yongl
 * @DATE: 2020/8/2 19:10
 */
@SpringBootApplication
//扫描监听器
//@ServletComponentScan
//确保在后台创建一个任务执行者
@EnableSwagger2
@EnableFeignClients
@EnableDiscoveryClient
@EnableAutoDataSourceProxy
@ComponentScan(basePackageClasses = ProviderServiceStart.class)
@MapperScan(basePackages = {"com.provider.project.dao"})
public class ProviderServiceStart {

    public static void main(String[] args) {
        SpringApplication.run(ProviderServiceStart.class, args);
        System.out.println("提供者服务启动成功！");
    }

}