package model;

import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Comparable<Task>{
   private int ID;
   private int arrivalTime;
   private AtomicInteger serviceTime;

    public Task(int ID, int arrivalTime, int serviceTime){
        this.ID=ID;
        this.arrivalTime=arrivalTime;
        this.serviceTime= new AtomicInteger(serviceTime);
    }

    public int getID(){return this.ID;}
    public int getArrivalTime(){return  this.arrivalTime;}
    public long getServiceTime(){return this.serviceTime.longValue();}

    public void setID(int ID){
        this.ID=ID;}

    public void setArrivalTime(int arrivalTime){
        this.arrivalTime = arrivalTime;}

    public void setServiceTime(int arrivalTime){
        this.arrivalTime = arrivalTime;}

    public String toString() {
        return "Task: arrivalTime: "+arrivalTime+ " serviceTime: "+ serviceTime;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.arrivalTime, other.arrivalTime);
    }
}


