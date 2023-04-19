package model;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.LinkedBlockingQueue;


public class Server implements Runnable{

    private BlockingQueue<Task> tasks; //lista de cozi
    private AtomicInteger waitingPeriod; //

    public Server(){
        tasks = new LinkedBlockingQueue<>();
        waitingPeriod = new AtomicInteger(0);
    }

    public void addTask(Task newTask){
        //add task to queue
        //increment the waitingPer
        tasks.add(newTask);
       // waitingPeriod.addAndGet(newTask.getProcessingTime());
    }

    public void run(){
        while(true) {
            //take next from queue
            //stop the thread for a time equal with the task's processing time
            //decrement the waitingPeriod
            try {
                Task task = tasks.take();
             //   Thread.sleep(task.getProcessingTime() * 1000);
            //    waitingPeriod.addAndGet(-task.getProcessingTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //public Task[] getTasks(){
        //....
    //}

}
