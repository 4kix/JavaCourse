package threadpool;


import java.util.concurrent.ThreadPoolExecutor;

import view.ProgressView;

public class MyMonitorThread implements Runnable
{
    private ThreadPoolExecutor executor;

    private int seconds;

    private boolean run=true;

    public MyMonitorThread(ThreadPoolExecutor executor, int delay)
    {
        this.executor = executor;
        this.seconds=delay;
    }

    public void shutdown(){
        this.run=false;
    }

    @Override
    public void run()
    {
    	ProgressView view = new ProgressView();
    	view.launchFrame();
    	int progress = 0;
    	
        while(run){
                System.out.println(
                    String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                        this.executor.getPoolSize(),
                        this.executor.getCorePoolSize(),
                        this.executor.getActiveCount(),
                        this.executor.getCompletedTaskCount(),
                        this.executor.getTaskCount(),
                        this.executor.isShutdown(),
                        this.executor.isTerminated()));
                
                double quotient = (double)(this.executor.getCompletedTaskCount())/(double)(this.executor.getTaskCount());
                progress = (int)(quotient*100 + 1);
                
                view.setProgress(progress);
                view.refresh();
                
                try {
                    Thread.sleep(seconds*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
        }

    }
}