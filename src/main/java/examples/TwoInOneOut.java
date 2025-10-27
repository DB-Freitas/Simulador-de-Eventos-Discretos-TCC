package examples;

import simula.manager.*;

public class TwoInOneOut {

    public static void main(String args[]) {
        System.out.println("\nGenerating TwoInOneOut simulation model...");
        SimulationManager man = new SimulationManager();

        QueueEntry queue;
        ResourceEntry resource;
        ExternalActiveEntry externalActivity;
        InternalActiveEntry internalActivity;
        ObserverEntry observer;

        //Queues

        queue = new QueueEntry();
        queue.SetId("IN_1");
        queue.setObsid("IN_1_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("IN_2");
        queue.setObsid("IN_2_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("OUT");
        queue.setObsid("OUT_OBS");
        man.AddQueue(queue);

        //Resources

        resource = new ResourceEntry();
        resource.SetId("RESOURCE");
        resource.setInit((short) 1);
        man.AddResource(resource);


        //External Activity

        externalActivity = new ExternalActiveEntry(true);
        externalActivity.SetId("GENERATE_1");
        externalActivity.setQID("IN_1");
        externalActivity.setServiceDist(ActiveEntry.CONST);
        externalActivity.setDistP1(100);
        man.AddActiveState(externalActivity);

        externalActivity = new ExternalActiveEntry(true);
        externalActivity.SetId("GENERATE_2");
        externalActivity.setQID("IN_2");
        externalActivity.setServiceDist(ActiveEntry.CONST);
        externalActivity.setDistP1(1);
        man.AddActiveState(externalActivity);

        //Internal Activities

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("ACTIVITY");
        internalActivity.setObsid("ACTIVITY_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0);
        internalActivity.addFromQueue("IN_1");
        internalActivity.addFromQueue("IN_2");
        internalActivity.addToQueue("OUT");
        internalActivity.addToResource("RESOURCE");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("RESOURCE");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        //Observers

        //queues
        observer = new ObserverEntry(ObserverEntry.QUEUE, "IN_1"); //o_0
        observer.SetId("IN_1_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "IN_2"); //o_0
        observer.SetId("IN_2_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "OUT"); //o_0
        observer.SetId("OUT_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);


        //internal activities
        observer = new ObserverEntry(ObserverEntry.ACTIVE, "ACTIVITY");
        observer.SetId("ACTIVITY_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        //Generate model
        if (man.GenerateModel()) {
            System.out.println("\nModel successfully generated!");
        } else {
            System.out.println("\nError generating model! Exiting...");
            return;
        }

        //Execute simulation
        System.out.println("Starting simulation. Execution time: 500 units.");
        man.ExecuteSimulation(500);

        while (!man.Finished()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }

        System.out.println("Simulation completed!");
        man.OutputSimulationResults("TwoInOneOut.out");
        System.out.println("\nProcess finished!");
    }
}
