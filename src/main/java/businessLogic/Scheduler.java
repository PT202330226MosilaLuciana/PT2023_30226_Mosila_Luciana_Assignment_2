package businessLogic;
import model.*;
import java.util.*;
import java.lang.*;

public class Scheduler extends Thread{

    private List<Server> servers;
    private int maxNoServers;
    private int maxTasksPerServer;
    private Strategy strategy;

    public Scheduler(int maxNoServers, int maxTasksPerServer){
        //for maxNoServers
        //create servers objecrs
        //create thread with the object

      //  this.maxNoServers=maxNoServers;
       // this.maxTasksPerServer=maxTasksPerServer;

        servers = new ArrayList<>();
        // Create servers with maxTasksPerServer and add them to the list
        for (int i = 0; i < maxNoServers; i++) {
            Server server = new Server();
            servers.add(server);
        }

        // Create a thread for each server and start them
        for (Server server : servers) {
            Thread thread = new Thread(server);
            thread.start();
        }

    }


    public void changeStrategy(SelectionPolicy policy) {
        //apply strategy pattern to instantiate the strategy with the concrete
        //strategy corresponding to policy
        if (policy == SelectionPolicy.SHORTEST_QUEUE) {
            strategy = new ConcreteStrategyQueue();
        }
        if (policy == SelectionPolicy.SHORTEST_TIME) {
            strategy = new ConcreteStrategyTime();
        }
    }

//    public void dispatchTask(Task t){
//        //call the strategy addTask method
//        strategy.addTask();
//    }

    public List<Server> get_Servers(){
        return servers;
    }
}

