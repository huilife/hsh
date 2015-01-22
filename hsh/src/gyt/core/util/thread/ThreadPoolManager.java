package gyt.core.util.thread;

import java.util.*;
import org.apache.log4j.*;

/**
 * 线程池管理器(负责各个线程池对象的创建和销毁)
 * @author yangyuanjiang
 * @version 2014-08-18
 */
public class ThreadPoolManager {
    private static List<ThreadPoolImpl> threadPoolList = new ArrayList();

    /**
     * 则创建线程个数为count的线程池对象
     * @param count 指定的线程个数
     * @return 线程池对象
     */
    public static ThreadPool getThreadPool(int count) {
        ThreadPoolImpl pool = new ThreadPoolImpl(count);
        synchronized (threadPoolList) {
            threadPoolList.add(pool);
        }

        return pool;
    }


    /**
     * 销毁所有的线程池对象
     */
    public static void destroyAll() {
        boolean exist = false;
        synchronized (threadPoolList) {
            for (ThreadPoolImpl pool : threadPoolList) {
                if (pool.isClosed())
                    continue;
                pool.close();
                exist = true;
            }
            threadPoolList.clear();
        }
        if (exist)
            Logger.getLogger("util").info("ThreadPoolManager.destroyAll()成功");
    }
}


