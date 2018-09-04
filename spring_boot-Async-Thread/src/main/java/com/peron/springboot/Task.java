package com.peron.springboot;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Task {

	private static Random random = new Random();
	
	@Async("taskExecutor")
	//taskExecutor为线程池的名称
	public void doTaskOne() throws Exception {
		log.info("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务一，耗时：" + (end - start) + "毫秒");
	}
	
	@Async("taskExecutor")
	//taskExecutor为线程池的名称
	public void doTaskTwo() throws Exception {
		log.info("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务二，耗时：" + (end - start) + "毫秒");
	}
	
	@Async("taskExecutor")
	//taskExecutor为线程池的名称
	public void doTaskThree() throws Exception {
		log.info("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务三，耗时：" + (end - start) + "毫秒");
	}
	@Async("taskExecutor")
	//taskExecutor为线程池的名称
	public void doTaskfour() throws Exception {
		log.info("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务一，耗时：" + (end - start) + "毫秒");
	}
	
	@Async("taskExecutor")
	//taskExecutor为线程池的名称
	public void doTaskfive() throws Exception {
		log.info("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务二，耗时：" + (end - start) + "毫秒");
	}
	
	@Async("taskExecutor")
	//taskExecutor为线程池的名称
	public void doTasksix() throws Exception {
		log.info("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务三，耗时：" + (end - start) + "毫秒");
	}
}
