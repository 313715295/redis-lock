package com.zwq.lock;

import com.zwq.lock.redislock.registry.RedisLockRegistry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class RedisLockApplicationTests {

	@Autowired
	private RedisLockRegistry lockRegistry;
	@Autowired
	private TestService testService;
	@Test
	void contextLoads() {
		Thread thread1 = new Thread(() -> testService.testA(new TestB().setName("dasdasd")));
		Thread thread2 = new Thread(() -> testService.testA(new TestB().setName("dasdasd")));
		thread1.start();
		thread2.start();
	}

}
