/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ferart.informx.models.domain.thread;



import com.ferart.informx.models.domain.common.Interactor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Executor implementation based on ThreadPoolExecutor. ThreadPoolExecutorConfig:
 *
 * Core pool size: 3.
 * Max pool size: 5.
 * Keep alive time: 120.
 * Time unit: seconds.
 * Work queue: LinkedBlockingQueue.
 *
 * @author Pedro Vicente Gómez Sánchez
 * taken from https://github.com/pedrovgs/EffectiveAndroidUI/
 */
public class ThreadExecutor implements Executor {

  private static final int CORE_POOL_SIZE = 3;
  private static final int MAX_POOL_SIZE = 5;
  private static final int KEEP_ALIVE_TIME = 120;
  private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
  private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<Runnable>();

  private ThreadPoolExecutor threadPoolExecutor;

  //@Inject
  public ThreadExecutor() {
    int corePoolSize = CORE_POOL_SIZE;
    int maxPoolSize = MAX_POOL_SIZE;
    int keepAliveTime = KEEP_ALIVE_TIME;
    TimeUnit timeUnit = TIME_UNIT;
    BlockingQueue<Runnable> workQueue = WORK_QUEUE;
    threadPoolExecutor =
        new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, timeUnit, workQueue);
  }



  @Override
  public void run(final Interactor interactor) {
    if (interactor == null) {
      throw new IllegalArgumentException("Interactor to execute can't be null");
    }
    threadPoolExecutor.submit(()->interactor.run());
  }

  public ThreadPoolExecutor getThreadPoolExecutor() {
    return threadPoolExecutor;
  }
}
