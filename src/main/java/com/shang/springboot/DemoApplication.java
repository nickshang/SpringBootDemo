package com.shang.springboot;

import com.shang.springboot.readinglist.config.DataSourceConfig;
import com.shang.springboot.readinglist.config.YmlConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableConfigurationProperties({DataSourceConfig.class,YmlConfig.class})
@Slf4j
public class DemoApplication {

	public static void main(String[] args) {

		log.info("--------------------------服务{}启动","DemoApplication");		// 使用{}占位符。避免字符串连接操作，减少String对象（不可变）带来的内存开销

		SpringApplication.run(DemoApplication.class, args);
	}
}
