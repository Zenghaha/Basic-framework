package com.ud.basic.common.core.async;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration  
@EnableAsync  
public class ExecutorConfig {

	/** Set the ThreadPoolExecutor's core pool size. */  
    private int corePoolSize = 20;  
    /** Set the ThreadPoolExecutor's maximum pool size. */  
    private int maxPoolSize = 200;  
    /** Set the capacity for the ThreadPoolExecutor's BlockingQueue. */  
    private int queueCapacity = 500;  
    
    @Bean  
    public Executor callerAsync() {  
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();  
        executor.setCorePoolSize(corePoolSize);  
        executor.setMaxPoolSize(maxPoolSize);  
        executor.setQueueCapacity(queueCapacity);  
        executor.setThreadNamePrefix("CallerAsync-");  
  
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务  
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行  
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());  
        executor.initialize();  
        return executor;  
    }  
    
}
