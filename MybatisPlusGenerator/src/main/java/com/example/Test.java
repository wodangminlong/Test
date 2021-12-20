package com.example;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @author Administrator
 * @date 2021-12-17 17:40
 */
public class Test {

    /**
     * 运行这个main方法进行代码生成
     */
    public static void main(String[] args) {
        String url = "jdbc:mysql://192.168.17.131:3306/test?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&autoReconnectForPools=true&noAccessToProcedureBodies=true&testOnBorrow=true&validationQuery=select 1";
        String username = "test";
        String password = "test";

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    String projectPath = System.getProperty("user.dir");
                    builder.outputDir(projectPath + "/MybatisPlusGenerator/src/main/java")
                            .author("dml")
                            .disableOpenDir();
                })
                .packageConfig(builder -> builder.parent("com.example"))
                .templateConfig(builder -> builder.disable(TemplateType.XML)
                        .controller("templates/controller.java")
                        .service("templates/service.java")
                        .serviceImpl("templates/serviceimpl.java"))
                .strategyConfig(builder -> builder.likeTable(new LikeTable("tb_"))
                        .addTablePrefix("tb_")
                        .controllerBuilder()
                        .enableRestStyle()
                        .enableHyphenStyle()
                        .entityBuilder()
                        .enableLombok()
                        .naming(NamingStrategy.underline_to_camel)
                        .columnNaming(NamingStrategy.underline_to_camel)
                        .disableSerialVersionUID()
                        .enableTableFieldAnnotation())
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}
