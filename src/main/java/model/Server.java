package model;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.LinkedBlockingQueue;

public class Server implements Runnable{

    private BlockingQueue<Task> tasks;  //lista de clienti
    private AtomicInteger waitingPeriod;

    public Server(){
        this.tasks = new LinkedBlockingQueue<>();
        waitingPeriod = new AtomicInteger(0);
    }

    public void addTask(Task newTask){
        tasks.add(newTask);
        waitingPeriod.incrementAndGet();
    }

    public void run(){
        while(true) {
            //take next tasks from queue
            //stop the thread for a time equal with the task's processing time
            //decrement the waitingPeriod

            try {
                // Take the next task from the queue
                Task task = tasks.take();
                // Simulate processing the task
                Thread.sleep(task.getServiceTime()*1000);

                // Decrement the waiting period
                waitingPeriod.decrementAndGet();
                } catch (InterruptedException e) {
                // If the thread is interrupted, break out of the loop
                break;
                }
            }

        }


    public Task[] getTasks(){

         int numTasks = tasks.size();
        Task[] taskArray = new Task[numTasks];
        tasks.toArray(taskArray);

        return taskArray;
    }
    public int getServiceTime(){
        int sum = 0;
        for(Task t:tasks){
            sum = sum+ (int)t.getServiceTime();
        }
        return sum;
    }
}


