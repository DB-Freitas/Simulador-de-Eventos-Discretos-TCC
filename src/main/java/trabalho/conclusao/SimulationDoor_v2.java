package trabalho.conclusao;//
// Simulação do modelo de controle da porta baseado no ACD
//

import simula.manager.*;

public class SimulationDoor_v2 {
    public static void main(String args[]) {
        System.out.println("\nGenerating door control simulation model...");
        SimulationManager man = new SimulationManager();

        QueueEntry queue;
        ResourceEntry resource;
        ExternalActiveEntry externalActivity;
        InternalActiveEntry internalActivity;
        ObserverEntry observer;

        //Queues

        queue = new QueueEntry();
        queue.SetId("CA_MESSAGE_1");
        queue.setObsid("CA_MESSAGE_1_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("CA_MESSAGE_2");
        queue.setObsid("CA_MESSAGE_2_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("FEEDBACK_MESSAGE_1");
        queue.setObsid("FEEDBACK_MESSAGE_1_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("FEEDBACK_MESSAGE_2");
        queue.setObsid("FEEDBACK_MESSAGE_2_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("FEEDBACK_MESSAGE_3");
        queue.setObsid("FEEDBACK_MESSAGE_3_OBS");
        man.AddQueue(queue);

        //Resources

        resource = new ResourceEntry();
        resource.SetId("DOOR_ACTUATOR");
        resource.setInit((short) 1);
        resource.setObsid("DOOR_ACTUATOR_OBS");
        man.AddResource(resource);

        resource = new ResourceEntry();
        resource.SetId("PHYSICAL_DOOR");
        resource.setInit((short) 1);
        resource.setObsid("PHYSICAL_DOOR_OBS");
        man.AddResource(resource);

        resource = new ResourceEntry();
        resource.SetId("DOOR_SENSORS");
        resource.setInit((short) 1);
        resource.setObsid("DOOR_SENSORS_OBS");//observer
        man.AddResource(resource);

        resource = new ResourceEntry();
        resource.SetId("DOOR_CONTROLLER");
        resource.setInit((short) 1);
        resource.setObsid("DOOR_CONTROLLER_OBS");//observer
        man.AddResource(resource);

        //External Activity

        externalActivity = new ExternalActiveEntry(true);
        externalActivity.SetId("GENERATE_ACTIVITY");
        externalActivity.setQID("CA_MESSAGE_1");
        externalActivity.setServiceDist(ActiveEntry.CONST);
        externalActivity.setDistP1(1.3f);
        man.AddActiveState(externalActivity);

        //Internal Activities

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("OPEN_DOOR");
        internalActivity.setObsid("OPEN_DOOR_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.5f);
        internalActivity.addFromQueue("CA_MESSAGE_1");
        internalActivity.addFromQueue("FEEDBACK_MESSAGE_2");
        internalActivity.addToQueue("CA_MESSAGE_2");
        internalActivity.addToResource("DOOR_CONTROLLER");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("DOOR_CONTROLLER");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("OPEN");
        internalActivity.setObsid("OPEN_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.3f);
        internalActivity.addFromQueue("CA_MESSAGE_2");
        internalActivity.addToQueue("FEEDBACK_MESSAGE_1");
        internalActivity.addToResource("DOOR_ACTUATOR");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("DOOR_ACTUATOR");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("DOOR_POSITION_FEEDBACK");
        internalActivity.setObsid("DOOR_POSITION_FEEDBACK_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.2f);
        internalActivity.addFromQueue("FEEDBACK_MESSAGE_1");
        internalActivity.addToQueue("FEEDBACK_MESSAGE_3");
        internalActivity.addToResource("PHYSICAL_DOOR");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("PHYSICAL_DOOR");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("DOOR_SENSORS_FEEDBACK");
        internalActivity.setObsid("DOOR_SENSORS_FEEDBACK_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.3f);
        internalActivity.addFromQueue("FEEDBACK_MESSAGE_3");
        internalActivity.addToQueue("FEEDBACK_MESSAGE_2");
        internalActivity.addToResource("DOOR_SENSORS");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("DOOR_SENSORS");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        //Observers

        //queues
        observer = new ObserverEntry(ObserverEntry.QUEUE, "CA_MESSAGE_1"); //o_0
        observer.SetId("CA_MESSAGE_1_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "CA_MESSAGE_2"); //o_0
        observer.SetId("CA_MESSAGE_2_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "FEEDBACK_MESSAGE_1"); //o_0
        observer.SetId("FEEDBACK_MESSAGE_1_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "FEEDBACK_MESSAGE_2"); //o_0
        observer.SetId("FEEDBACK_MESSAGE_2_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "FEEDBACK_MESSAGE_3"); //o_0
        observer.SetId("FEEDBACK_MESSAGE_3_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        //resources
        observer = new ObserverEntry(ObserverEntry.RESOURCE, "DOOR_ACTUATOR");
        observer.SetId("DOOR_ACTUATOR_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.RESOURCE, "PHYSICAL_DOOR");
        observer.SetId("PHYSICAL_DOOR_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.RESOURCE, "DOOR_SENSORS");
        observer.SetId("DOOR_SENSORS_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.RESOURCE, "DOOR_CONTROLLER");
        observer.SetId("DOOR_CONTROLLER_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        //internal activities
        observer = new ObserverEntry(ObserverEntry.ACTIVE, "OPEN_DOOR");
        observer.SetId("OPEN_DOOR_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "OPEN");
        observer.SetId("OPEN_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "DOOR_POSITION_FEEDBACK");
        observer.SetId("DOOR_POSITION_FEEDBACK_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "DOOR_SENSORS_FEEDBACK");
        observer.SetId("DOOR_SENSORS_FEEDBACK_OBS");
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
        man.OutputSimulationResults("DoorControlSimulation_v2.out");
        System.out.println("\nProcess finished!");
    }
}
