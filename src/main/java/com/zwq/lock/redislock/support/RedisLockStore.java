package com.zwq.lock.redislock.support;

import com.zwq.lock.redislock.registry.RedisLockRegistry;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Lock;

/**
 * 锁工具
 *
 * @author Administrator
 */
@Component
public class RedisLockStore implements LockStore {


    private RedisLockRegistry redisLockRegistry;

    public RedisLockStore(RedisLockRegistry redisLockRegistry) {
        this.redisLockRegistry = redisLockRegistry;
        LockUtils.setLockStore(this);
    }



    @Override
    public Lock getLock(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        return redisLockRegistry.obtain(key);
    }

}
