package gyt.core.util.thread;

import java.util.*;

/**
 *  线程池接口（基本思想是:在一个线程池中执行所有任务）
 * @author yangyuanjiang
 * @version 2014-08-018
 */
public interface ThreadPool {
    /**
     * 停止并清空线程池中的所有线程
     */
    public void close();

    /**
     * 设置线程池的个数,如果当前线程池的个数小于要求的个数则增加线程数量,反之则减小线程池中的线程数量
     *
     * @param poolSize 线程池个数(必须为正)
     */
    public void setPoolSize(int poolSize);

    /**
     * 增加一个新的任务到任务列表中
     *
     * @param task 待执行的任务
     */
    public void addTask(Runnable task);

    /**
     * 判断是否线程池已经关闭, 调用stop方法后,会设置成true
     *
     * @return true:已经关闭 false:未关闭
     */
    public boolean isClosed();

    /**
     * 获得线程池的大小
     *
     * @return 线程池中线程个数
     */
    public int getPoolSize();

    /**
     * 获得等待处理的任务个数
     *
     * @return 待处理的业务个数
     */
    public int taskSize();

    /**
     * 获得线程池中的所有任务
     *
     * @return 线程池中的所有任务
     */
    public List<Runnable> getTaskList();
}


