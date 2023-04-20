package businessLogic;
import model.*;
import gui.*;
import java.util.*;

public class SimulationManager implements Runnable{

    public SelectionPolicy selectionPolicy=SelectionPolicy.SHORTEST_TIME;

    private Scheduler scheduler; //entity responsible with queue management and clinet distribution
    private List<Task> generatedTasks; //pool of tasks (client shopping)
    private SimulationFrame frame; //frame from displaying simulation si contine toate datele de intrare

    public SimulationManager(){

        frame = new SimulationFrame();
        generateNRandomTasks();
        scheduler = new Scheduler(frame.getQ(),);

        generatedTasks = new ArrayList<>();
    }

    private void generateNRandomTasks(){
        for (int i = 1; i <= frame.getN(); i++) {
            int serviceTime = (int) (Math.random() * (frame.getMaxServiceTime() - frame.getMinServiceTime()) + frame.getMinServiceTime());
            int arrivalTime = (int) (Math.random() * (frame.getMaxArrivalTime() - frame.getMinArrivalTime()) + frame.getMinArrivalTime());
            Task task = new Task(i, serviceTime, arrivalTime);
            generatedTasks.add(task);
        }
        Collections.sort(generatedTasks);
    }
    @Override
    public void run(){
        int currentTime=0;
        while(currentTime<frame.getSimulationTime()){
            //iterate generatedTasks list and pick tasks that have the
            //arrivalTime equal with the currentTime
            //  -send task to queue by calling the dispatchTask method
            //from Scheduler
            //delere client from list
            //update UI frame
             currentTime++;
             //wait an interval of 1 second
        }
    }

    public static void main(String[] args){
        SimulationManager gen=new SimulationManager();
        Thread t=new Thread(gen);
        t.start();
    }
}