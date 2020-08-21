package generator;
//import com.baomidou.mybatisplus.annotation.DbType;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 实用代码生成工具
 *
 * @author yongchao
 * @date 2018-03-17 12:15
 */
public class EntityGenerator {

    @Test
    public void entityGenerator() {
        AutoGenerator mpg = new AutoGenerator();
        //F:\personalDemoCode\personalProjectTest\src\main\java

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //F:\personalDemoCode\personalProjectTest\src\main\java
        gc.setOutputDir("F:\\mirco_service\\springcloud\\springcloud-provider-server\\src\\main\\java");//这里写你自己的java目录
        //gc.setOutputDir("D:\\zlpgcode\\zlpg\\guns-admin\\src\\main\\java\\");//这里写你自己的java目录
        gc.setFileOverride(true);//是否覆盖
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("yongli");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
//        dsc.setTypeConvert(new MySqlTypeConvert() {
//
//            // 自定义数据库表字段类型转换【可选】
//            @Override
//            public DbColumnType processTypeConvert(String fieldType) {
//                return super.processTypeConvert(fieldType);
//            }
//        });
        //dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC&characterEncoding=utf8");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
//        strategy.setTablePrefix(new String[]{"temporaryProjectdocs"});// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(new String[] {"person"}); // 需要生成的表
        // 排除生成的表
        // strategy.setInclude(new String[]{"activiti_task_node", "act_evt_log", " act_ge_bytearray", " act_ge_property", " act_hi_actinst", " act_hi_attachment", " act_hi_comment", " act_hi_detail", " act_hi_identitylink", " act_hi_procinst", " act_hi_taskinst", " act_hi_varinst", " act_id_bytearray", " act_id_group", " act_id_info", " act_id_membership", " act_id_priv", " act_id_priv_mapping", " act_id_property", " act_id_token", " act_id_user", " act_procdef_info", " act_re_deployment", " act_re_model", " act_re_procdef", " act_ru_deadletter_job", " act_ru_event_subscr", " act_ru_execution", " act_ru_history_job", " act_ru_identitylink", " act_ru_job", " act_ru_suspended_job", " act_ru_task", " act_ru_timer_job", " act_ru_variable"});
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(null);
        String src = "com.provider.project.";
        pc.setEntity(src + "model");
        pc.setMapper(src + "dao");
        pc.setXml(src + "dao.mapping");
        pc.setService(src + "service");
        pc.setServiceImpl(src + "service.impl");
        pc.setController(src + "controller");
        mpg.setPackageInfo(pc);

        // 注入自定义配置,可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        mpg.setCfg(cfg);

        // 执行生成
        mpg.execute();

        // 打印注入设置
        System.err.println(mpg.getCfg().getMap().get("abc"));
    }
}
