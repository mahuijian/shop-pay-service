package com.mhj.config;

import com.github.rholder.retry.*;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 重试策略建造者
 */
public class ProductRetryerBuilder {
    public static Retryer<Boolean> build() {
        //定义重试机制
        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()

                //retryIf 重试条件
                .retryIfException()
                .retryIfRuntimeException()
                .retryIfExceptionOfType(Exception.class)
                .retryIfResult(aBoolean -> Objects.equals(aBoolean, false))

                //等待策略：第几次重试就是 2的n次方 *30000ms 后重试
                .withWaitStrategy(WaitStrategies.exponentialWait(3000, 1, TimeUnit.DAYS))

                //停止策略 : 尝试请求11次 不是重试11次 是加上第一次请求的次数
                .withStopStrategy(StopStrategies.stopAfterAttempt(11))

                //时间限制 : 某次请求不得超过120s , 类似: TimeLimiter timeLimiter = new SimpleTimeLimiter();
                .withAttemptTimeLimiter(AttemptTimeLimiters.fixedTimeLimit(120, TimeUnit.SECONDS))

                //默认的阻塞策略：线程睡眠
                // .withBlockStrategy(BlockStrategies.threadSleepStrategy())

                //自定义重试监听器
                .withRetryListener(new TestUserRetryListener())

                .build();

        return retryer;

    }

}
