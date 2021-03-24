package org.optaplanner.examples.domain;

import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@PlanningSolution
public class TaskAssignment extends AbstractPersistable{
    private HardSoftScore score;

    public List<Machine> machineList;
    public List<Task> taskList;

    @PlanningScore
    public HardSoftScore getScore() {
        return score;
    }
    public void setScore(HardSoftScore score) {
        this.score = score;
    }

    @ProblemFactCollectionProperty
    @ValueRangeProvider(id = "machineRange")
    public List<Machine> getMachineList() {
        return machineList;
    }

    public void setMachineList(List<Machine> machineList) {
        this.machineList = machineList;
    }

    @PlanningEntityCollectionProperty
    @ValueRangeProvider(id = "taskRange")
    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public TaskAssignment(List<Machine> machineList, List<Task> taskList) {
        this.machineList = machineList;
        this.taskList = taskList;
    }

    public TaskAssignment(){}
}
