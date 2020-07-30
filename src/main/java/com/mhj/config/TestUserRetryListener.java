package com.mhj.config;

import com.github.rholder.retry.Attempt;
import com.github.rholder.retry.RetryListener;

/**
 * @author mahuijian
 * @since 2020-07-30 13:57
 **/
public class TestUserRetryListener implements RetryListener {

    @Override
    public <V> void onRetry(Attempt<V> attempt) {
        // 距离上一次重试的时间间隔
        System.out.println("距上一次重试的间隔时间为:" + attempt.getDelaySinceFirstAttempt());
        // 重试次数
        System.out.println("重试次数: " + attempt.getAttemptNumber());
        // 重试过程是否有异常
        System.out.println("重试过程是否有异常:" + attempt.hasException());
        if (attempt.hasException()) {
            System.out.println("异常的原因:" + attempt.getExceptionCause().toString());
        }
        //重试正常返回的结果
        System.out.println("重试结果为:" + attempt.hasResult());
    }
}
