package com.sf;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 启动类
 * @author lijie.zh
 */
@EnableCaching
@EnableTransactionManagement
@SpringBootApplication
@MapperScan(basePackages = "com.sf.dao.mapper")
@ComponentScan("com.sf")
public class SfBootApplication implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("服务启动完成!");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SfBootApplication.class, args);
    }

}
