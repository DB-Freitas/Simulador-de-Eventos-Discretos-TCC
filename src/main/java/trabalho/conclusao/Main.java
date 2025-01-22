package trabalho.conclusao;

import simula.Activity;
import simula.DeadState;
import simula.Scheduler;
import simula.manager.SimulationManager;

public class Main {
    public static void main(String[] args) {

        SimulationManager simu = new SimulationManager();
        Scheduler shed = new Scheduler(simu);

        Activity generateTrainMotionMessage = new Activity(shed);
        Activity generateTrainPositionMessage = new Activity(shed);
        Activity generateControlActionMessagesOtherControllers = new Activity(shed);


    }
}