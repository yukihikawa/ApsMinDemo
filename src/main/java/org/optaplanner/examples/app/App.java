package org.optaplanner.examples.app;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.examples.domain.Machine;
import org.optaplanner.examples.domain.Task;
import org.optaplanner.examples.domain.TaskAssignment;

public class App {

    public static void main(String[] args) {
        startPlan();
    }

    private static void startPlan(){
        //新建两个list，分别用来存放初始的任务数据和机台数据
        //现在这里暂时采用手工填入，后续这里改成从外部数据表自动获取
        List<Machine> machines = getMachines();
        List<Task> tasks = getTasks();

        //通过默认配置的xml文件创建一个solverFactory，然后创建一个solver求解器
//        InputStream ins = App.class.getResourceAsStream("./taskassignmentConfiguration.xml");
//        SolverFactory<TaskAssignment> solverFactory = SolverFactory.createFromXmlInputStream(ins);
        // Build the Solver
        SolverFactory<TaskAssignment> solverFactory = SolverFactory.createFromXmlResource("./taskassignmentConfiguration.xml");


        Solver<TaskAssignment> solver = solverFactory.buildSolver();

        //新建一个待求解对象，将初始数据传入
        TaskAssignment unassignment = new TaskAssignment(machines, tasks);
        //将带求解对象通过求解器求解
        TaskAssignment assigned = solver.solve(unassignment);//启动引擎

        //获取被分配出去的机台list
        List<Machine> machinesAssigned = assigned.getTaskList().stream().map(Task::getMachine).distinct().collect(Collectors.toList());
        //获取所有机台list
        //List<Machine> allMachines = assigned.getMachineList();

        System.out.println( "\n\"任务-机台\"排程结果如下:" );
        //输出每台机床上分配的任务
        for(Machine machine : machinesAssigned) {
            System.out.print(machine + ":");
            List<Task> tasksInMachine = assigned.getTaskList().stream().filter(x -> x.getMachine().equals(machine)).collect(Collectors.toList());
            for(Task task : tasksInMachine) {
                System.out.print("->" + task);
            }
            System.out.print("\n");
        }

    }


    private static List<Machine> getMachines() {
        // 六个机台
        Machine m1 = new Machine(1, "Type_A", 300, 100);
        Machine m2 = new Machine(2, "Type_A", 1000, 100);
        Machine m3 = new Machine(3, "TYPE_B", 1000, 300);
        Machine m4 = new Machine(4, "TYPE_B", 1000, 100);
        Machine m5 = new Machine(5, "Type_C", 1100, 100);
        Machine m6 = new Machine(6, "Type_D", 900, 100);

        List<Machine> machines = new ArrayList<Machine>();
        machines.add(m1);
        machines.add(m2);
        machines.add(m3);
        machines.add(m4);
        machines.add(m5);
        machines.add(m6);

        return machines;
    }

    private static List<Task> getTasks(){
        // 10个任务
        Task t1 = new Task(1, "Type_A", 100);
        Task t2 = new Task(2, "Type_A", 100);
        Task t3 = new Task(3, "Type_A", 100);
        Task t4 = new Task(4, "Type_A", 100);
        Task t5 = new Task(5, "TYPE_B", 800);
        Task t6 = new Task(6, "TYPE_B", 500);
        Task t7 = new Task(7, "Type_C", 800);
        Task t8 = new Task(8, "Type_C", 300);
        Task t9 = new Task(9, "Type_D", 400);
        Task t10 = new Task(10, "Type_D", 500);

        List<Task> tasks = new ArrayList<Task>();
        tasks.add(t1);
        tasks.add(t2);
        tasks.add(t3);
        tasks.add(t4);
        tasks.add(t5);
        tasks.add(t6);
        tasks.add(t7);
        tasks.add(t8);
        tasks.add(t9);
        tasks.add(t10);

        return tasks;
    }
}