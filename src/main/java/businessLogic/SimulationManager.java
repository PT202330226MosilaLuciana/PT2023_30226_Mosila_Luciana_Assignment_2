package businessLogic;
import model.*;
import gui.*;
import java.util.*;

public class SimulationManager implements Runnable{

    public SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_TIME;

    private Scheduler scheduler; //entity responsible with queue management and clinet distribution
    private List<Task> generatedTasks; //pool of tasks (client shopping)
    private SimulationFrame frame; //frame from displaying simulation si contine toate datele de intrare

    public SimulationManager(){
        frame = new SimulationFrame();
        generateNRandomTasks();
        scheduler = new Scheduler(frame.getQ());
        generatedTasks = new ArrayList<>();
    }

    private void generateNRandomTasks(){
        for (int i = 1; i <= frame.getN(); i++) {
            int serviceTime = (int) (Math.random() * (frame.getMaxServiceTime() - frame.getMinServiceTime()) + frame.getMinServiceTime());
            int arrivalTime = (int) (Math.random() * (frame.getMaxArrivalTime() - frame.getMinArrivalTime()) + frame.getMinArrivalTime());
            Task task = new Task(i, serviceTime, arrivalTime);
            generatedTasks.add(task);
        }
      //  Collections.sort(generatedTasks);
    }

    public void run() {
        // Set the selection policy for the scheduler
        scheduler.changeStrategy(selectionPolicy);

        int currentTime = 0;
        System.out.println("Current Time:" + currentTime);
        while(currentTime < frame.getSimulationTime()){
            // iterate generatedTasks list and pick tasks that have the arrivalTime equal with the currentTime
            for(Task task : generatedTasks) {
                if (task.getArrivalTime() == currentTime) {
                    scheduler.dispatchTask(task);
                    generatedTasks.remove(task);
                    // Sleep before generating the next task
                    try {
                        Thread.sleep(task.getServiceTime() * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Current Time:" + currentTime);
                    List<Server> servers = scheduler.getServers();
                    for (int i = 1; i <= servers.size(); i++) {
                        System.out.print("    Queue:" + i);
                        Task[] t = servers.get(i).getTasks();
                        System.out.print("        Tasks: ");
                        for(int j=1; j<= servers.get(i).getTasks().length; j++)
                        System.out.print(t[j].TasksToString());
                        System.out.print("");
                        }

                    // Update the current time
                    currentTime++;

                }
            }
        }
    }

    public static void main(String[] args){
        SimulationManager gen=new SimulationManager();

        Thread t=new Thread(gen);
        t.start();
    }
}