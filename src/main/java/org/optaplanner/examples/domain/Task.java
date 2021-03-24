package org.optaplanner.examples.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Task extends AbstractPersistable{

    private String requiredYarnType; //所需资源  任务类型
    private int amount;   //生产数量

    private Machine machine;
    //setter&getter
    public String getRequiredYarnType() {
        return requiredYarnType;
    }

    public void setRequiredYarnType(String requireYarnType) {
        this.requiredYarnType = requireYarnType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @PlanningVariable(valueRangeProviderRefs = {"machineRange"})
    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }
    //constructor
    public Task() {    }

    public Task(int id, String requiredYarnType, int amount) {
        super(id);
        this.requiredYarnType = requiredYarnType;
        this.amount = amount;
    }
}