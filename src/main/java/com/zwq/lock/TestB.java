package com.zwq.lock;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zwq  wenqiang.zheng@jdxiaokang.cn
 * @project: redis-lock
 * @description:
 * @date 2020/2/16
 */
@Data
@Accessors(chain = true)
public class TestB {
    private String name;

    public static String test(String d) {
        return d;
    }

}
