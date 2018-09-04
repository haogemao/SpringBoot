package com.peron.springboot;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class TaskWithSync {

	private static Random random = new Random();
	
	public void doTaskOne() throws Exception {
		System.out.println("开始做任务一");
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			
		}
		long end = System.currentTimeMillis();
		System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
	}
	
	public void doTaskTwo() throws Exception {
		System.out.println("开始做任务二");
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			
		}
		long end = System.currentTimeMillis();
		System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
	}
	
	public void doTaskThree() throws Exception {
		System.out.println("开始做任务三");
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			
		}
		long end = System.currentTimeMillis();
		System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
	}
}
