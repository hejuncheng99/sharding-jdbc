package com.wewin;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成器
 *
 * @author Juncheng He
 * @title: CodeGenerator
 * @projectName project-team
 * @description: 代码生成器
 * @date 2019/12/30  13:50
 */
public class CodeGenerator {

    /**
     * 驱动连接的URL
     */
    private static String dataBaseUrl = "jdbc:mysql://localhost:3306/ds0?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    /**
     * 数据库连接用户名
     */
    private static String username = "root";
    /**
     * 数据库连接密码
     */
    private static String password = "123456";
    /**
     * 父级包名
     */
    private static String parentPackageName = "com.wewin.modules";
    /**
     * 模块名称
     */
    private static String moduleName = "sys";
    /**
     * mapper包名
     */
    private static String mapperPackageName = "dao";
    /**
     * 需生成的数据库表名称，逗号分隔
     */
    private static String tableNames = "warehouse_info0";
    /**
     * 作者
     */
    private static String author = "JunCheng He";
//    private static String author = "PengFei Luo";

    /**
     * 生成结果保存文件夹
     * String projectPath = System.getProperty("user.dir") + "/src/main/java";
     */
    private static String outPutDir = "C:\\Users\\Juncheng He\\Desktop\\CodeGenerator";
//    private static String outPutDir = "D:\\generatorCode\\cqmrl";


    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局策略配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(outPutDir);
        gc.setAuthor(author);
        gc.setOpen(false);
        gc.setSwagger2(true);
        gc.setControllerName("Sys%sController");
        gc.setEntityName("Sys%sEntity");
        gc.setMapperName("Sys%sDao");
        gc.setServiceName("Sys%sService");
        gc.setServiceImplName("Sys%sServiceImpl");
        mpg.setGlobalConfig(gc);

        // 数据源配置，通过该配置，指定需要生成代码的具体数据库
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(dataBaseUrl);
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(username);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        // 包名配置，通过该配置，指定生成代码的包路径
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName);
        pc.setMapper(mapperPackageName);
        pc.setParent(parentPackageName);
        mpg.setPackageInfo(pc);

        // 自定义配置 注入配置，通过该配置，可注入自定义参数等操作以实现个性化操作
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return outPutDir + "/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 模板配置，可自定义代码生成的模板，实现个性化操作，
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
//        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
        //数据库表配置，通过该配置，可指定需要生成哪些表或者排除哪些表
//        strategy.setSuperEntityColumns("id");
        strategy.setInclude(tableNames.split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        //逻辑删除字段名
//        strategy.setLogicDeleteFieldName("status");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
