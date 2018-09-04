package com.peron.springboot;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
public class SpringBootAsyncThreadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAsyncThreadApplication.class, args);
	}
	
	@Configuration
	@EnableAsync
	class TaskPoolConfig {
		
		@Bean("taskExecutor")
		public Executor taskExecutor() {
			ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
			//核心线程数
			executor.setCorePoolSize(10);
			//最大线程数
			executor.setMaxPoolSize(20);
			//允许线程的空闲时间
			executor.setKeepAliveSeconds(60);
			//缓冲队列
			executor.setQueueCapacity(200);
			//线程名前缀
			executor.setThreadNamePrefix("taskExecutor-");
			//线程池对拒绝任务的处理策略：这里采用了CallerRunsPolicy策略，当线程池没有处理能力的时候，该策略会直接在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
			executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
			return executor;
		}
	}
}
