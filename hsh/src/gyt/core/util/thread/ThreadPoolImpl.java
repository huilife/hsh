package gyt.core.util.thread;

import java.util.*;

/**
 * 线程池对象(基本思想是:在一个线程池中执行所有任务)
 * @author yangyuanjiang
 * @version 2014-08-18
 */
public class ThreadPoolImpl implements ThreadPool {
    /** 是否退出标志 */
    private boolean closed = false;
    /** 线程列表 */
    private List<TaskThread> threadList = new ArrayList();
    /** 当前需要执行的任务 */
    private LinkedList<Runnable> taskList = new LinkedList();

    /**
     * 构造方法,生成指定线程个数的线程池对象
     *
     * @param poolSize 线程池个数
     */
    ThreadPoolImpl(int poolSize) {
        setPoolSize(poolSize);
    }


    /**
     * 设置线程池的个数,如果当前线程池的个数小于要求的个数则增加线程数量,反之则减小线程池中的线程数量
     *
     * @param poolSize 线程池个数(必须为正)
     */
    public void setPoolSize(int poolSize) {
        if (poolSize <= 0)
            throw new IllegalArgumentException("poolSize should be positive.");

        synchronized (threadList) {
            int currentPoolSize = threadList.size();
            for (int i = 0; i < poolSize - currentPoolSize; i++) {
                TaskThread thread = new TaskThread();
                thread.start();
                threadList.add(thread);
            }
            for (int i = 0; i < currentPoolSize - poolSize; i++) {
                if (!threadList.isEmpty()) {
                    TaskThread thread = threadList.remove(0);
                    thread.close();
                }
            }
        }
    }

    /**
     * 停止并清空线程池中的所有线程
     */
    public void close() {
        if (closed)
            return;
        closed = true;

        synchronized (threadList) {
            for (TaskThread thread : threadList) {
                thread.close();
            }
            threadList.clear();
        }

        synchronized (taskList) {
            taskList.clear();
        }
    }

    /**
     * 增加一个新的任务到任务列表中
     *
     * @param task 待执行的任务
     */
    public void addTask(Runnable task) {
        synchronized (taskList) {
            boolean empty = taskList.isEmpty();
            taskList.addLast(task);
            if (empty)
                taskList.notifyAll();
        }
    }

    /**
     * 从任务列表中获得一个任务
     *
     * @return 待执行的任务
     * @throws InterruptedException 等待过程中可能会抛出此异常
     */
    private Runnable popTask() throws InterruptedException {
        synchronized (taskList) {
            while (taskList.isEmpty())
                taskList.wait();
            return taskList.removeFirst();
        }
    }

    /**
     * 判断是否线程池已经关闭, 调用stop方法后,会设置成true
     *
     * @return true:已经关闭 false:未关闭
     */
    public boolean isClosed() {
        return closed;
    }

    /**
     * 获得线程池的大小
     *
     * @return 线程池中线程个数
     */
    public int getPoolSize() {
        synchronized (threadList) {
            return threadList.size();
        }
    }

    /**
     * 获得等待处理的任务个数
     *
     * @return 待处理的业务个数
     */
    public int taskSize() {
        synchronized (taskList) {
            return taskList.size();
        }
    }

    /**
     * 获得线程池中的所有任务
     *
     * @return 线程池中的所有任务
     */
    public List<Runnable> getTaskList() {
        return taskList;
    }

    private class TaskThread extends Thread {
        private boolean bQuit = false;

        public TaskThread() {
            super("util.TaskThread");
        }

        public void close() {
            if (bQuit)
                return;
            bQuit = true;
            interrupt();
        }

        public void run() {
            while (!bQuit) {
                try {
                    sleep(1);
                    Runnable task = popTask();
                    task.run();
                }
                catch (Exception ex) {
                }
            }
        }
    }
}


