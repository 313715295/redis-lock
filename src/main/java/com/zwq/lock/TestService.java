package com.zwq.lock;

import com.zwq.lock.redislock.support.RedisLock;
import org.springframework.stereotype.Component;

/**
 * @author zwq  wenqiang.zheng@jdxiaokang.cn
 * @project: redis-lock
 * @description:
 * @date 2020/2/16
 */
@Component
public class TestService {

    @RedisLock(lockKey = "buildSettlePromotionKey(#a0.name)",generatorKeyClass = RedisKeys.class)
//    @Cacheable(key = "#method")/
    public String testA(TestB testB) {
        return testB.getName();
    }
}
