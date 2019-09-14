package com.tensquare.gathering;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;
@SpringBootApplication
public class GatheringApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatheringApplication.class, args);
        System.out.println("活动服务:9005-------------------------");
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}

}
