package org.optaplanner.examples.domain;

public class Machine extends AbstractPersistable{
    private String yarnType;
    private int capacity;
    private int cost;

    public String getYarnType() {
        return yarnType;
    }
    public void setYarnType(String yarnType) {
        this.yarnType = yarnType;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public Machine(int id, String yarnType, int capacity, int cost) {
        super(id);
        this.yarnType = yarnType;
        this.capacity = capacity;
        this.cost = cost;
    }
}