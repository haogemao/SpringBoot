package com.peron.springboot;

import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAsync //开启异步配置
public class SpringBootAsyncApplicationTests {

    @Autowired
    private TaskWithSync taskWithSync;

    @Autowired
    private TaskWithAsync taskWithAsync;

    @Test
    public void testSync() throws Exception {
        taskWithSync.doTaskOne();
        taskWithSync.doTaskThree();
        taskWithSync.doTaskTwo();
    }

    @Test
    public void testAsync() throws Exception {
        long start = System.currentTimeMillis();

        Future<String> task1 = taskWithAsync.doTaskOne();
        Future<String> task2 = taskWithAsync.doTaskTwo();
        Future<String> task3 = taskWithAsync.doTaskThree();

        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                break;
            }
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

}
