package template.mianshi.ThreadPool;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Five在努力
 * 自定义线程池
 */
public class ThreadPool {

    /** 默认线程池中的线程的数量 */
    private static final int WORK_NUM = 5;

    /** 默认处理任务的数量 */
    private static final int TASK_NUM = 100;

    /** 存放任务 */
    private final BlockingQueue<Runnable> taskQueue;

    private final Set<WorkThread> workThreads;//保存线程的集合

    private int workNumber;//线程数量

    private int taskNumber;//任务数量

    public ThreadPool(){
        this(WORK_NUM , TASK_NUM);
    }

    public ThreadPool(int workNumber , int taskNumber) {
        if (taskNumber<=0){
            taskNumber = TASK_NUM;
        }
        if (workNumber<=0){
            workNumber = WORK_NUM;
        }
        this.taskQueue = new ArrayBlockingQueue<Runnable>(taskNumber);
        this.workNumber = workNumber;
        this.taskNumber = taskNumber;

        workThreads = new HashSet<>();

        //工作线程准备好了
        //启动一定数量的线程数，从队列中获取任务处理
        for (int i=0;i<workNumber;i++) {
            WorkThread workThread = new WorkThread("thead_"+i);
            workThread.start();
            workThreads.add(workThread);
        }
    }

    /**
     * 线程池执行任务的方法，其实就是往BlockingQueue中添加元素
     * @param task
     */
    public void execute(Runnable task) throws InterruptedException {
        taskQueue.put(task);
    }


    /**
     * 销毁线程池
     */
    public void destroy(){
        System.out.println("ready close pool...");
        for (WorkThread workThread : workThreads) {
            workThread.stopWorker();
            workThread = null;//help gc
        }
        workThreads.clear();
    }

    /** 内部类，工作线程的实现 */
    private class WorkThread extends Thread{
        public WorkThread(String name){
            super();
            setName(name);
        }
        @Override
        public void run() {
            while (!interrupted()) {
                try {
                    Runnable runnable = taskQueue.take();//获取任务
                    if (runnable !=null) {
                        System.out.println(getName()+" ready execute:"+runnable.toString());
                        runnable.run();//执行任务
                    }
                    runnable = null;//help gc
                } catch (Exception e) {
                    interrupt();
                    e.printStackTrace();
                }
            }
        }

        public void stopWorker(){
            interrupt();
        }
    }
}


