package template.mianshi.ThreadPool;

public class TestThreadPool {
    private static final int TASK_NUM = 50090888;//任务的个数

    public static void main(String[] args) throws InterruptedException {
        ThreadPool myPool = new ThreadPool(3,50);
        for (int i=0;i<TASK_NUM;i++) {
            myPool.execute(new MyTask("task_"+i));
        }

    }

    static class MyTask implements Runnable{

        private String name;
        public MyTask(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("task :"+name+" end...");

        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "name = "+name;
        }
    }
}
