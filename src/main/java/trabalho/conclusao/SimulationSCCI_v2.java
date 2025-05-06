package trabalho.conclusao;//
// Simulação do modelo de controle da porta baseado no ACD
//

import simula.manager.*;

public class SimulationSCCI_v2 {
    public static void main(String args[]) {
        //GROUPED SENSORS
        System.out.println("\nGenerating SCCI simulation model...");
        SimulationManager man = new SimulationManager();

        QueueEntry queue;
        ResourceEntry resource;
        ExternalActiveEntry externalActivity;
        InternalActiveEntry internalActivity;
        ObserverEntry observer;

        //Queues

        queue = new QueueEntry();
        queue.SetId("Q_1");
        queue.setObsid("Q_1_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("Q_2");
        queue.setObsid("Q_2_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("Q_6");
        queue.setObsid("Q_6_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("Q_7");
        queue.setObsid("Q_7_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("Q_11");
        queue.setObsid("Q_11_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("Q_12");
        queue.setObsid("Q_12_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("Q_13");
        queue.setObsid("Q_13_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("Q_14");
        queue.setObsid("Q_14_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("Q_15");
        queue.setObsid("Q_15_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("OUT");
        queue.setObsid("OUT_OBS");
        man.AddQueue(queue);

        //Resources

        resource = new ResourceEntry();
        resource.SetId("TRAFFIC_AGENT");
        resource.setInit((short) 1);
        resource.setObsid("TRAFFIC_AGENT_OBS");
        man.AddResource(resource);

        resource = new ResourceEntry();
        resource.SetId("SCCI_MODULE");
        resource.setInit((short) 1);
        resource.setObsid("SCCI_MODULE_OBS");
        man.AddResource(resource);

        resource = new ResourceEntry();
        resource.SetId("TRAFFIC_LIGHTS");
        resource.setInit((short) 1);
        resource.setObsid("TRAFFIC_LIGHTS_OBS");
        man.AddResource(resource);

        resource = new ResourceEntry();
        resource.SetId("SENSORS");
        resource.setInit((short) 1);
        resource.setObsid("SENSORS_OBS");
        man.AddResource(resource);

        resource = new ResourceEntry();
        resource.SetId("INTERSECTION");
        resource.setInit((short) 1);
        resource.setObsid("INTERSECTION_OBS");//observer
        man.AddResource(resource);

        //External Activity

        externalActivity = new ExternalActiveEntry(true);
        externalActivity.SetId("GENERATE_CA");
        externalActivity.setQID("Q_11");
        externalActivity.setServiceDist(ActiveEntry.CONST);
        externalActivity.setDistP1(1.0f);
        man.AddActiveState(externalActivity);

        externalActivity = new ExternalActiveEntry(true);
        externalActivity.SetId("GENERATE_API_DATA");
        externalActivity.setQID("Q_12");
        externalActivity.setServiceDist(ActiveEntry.CONST);
        externalActivity.setDistP1(0.01f);
        man.AddActiveState(externalActivity);

        externalActivity = new ExternalActiveEntry(true);
        externalActivity.SetId("GENERATE_VEHICLES");
        externalActivity.setQID("Q_1");
        externalActivity.setServiceDist(ActiveEntry.CONST);
        externalActivity.setDistP1(0.5f);
        man.AddActiveState(externalActivity);

        //Internal Activities

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("A_1");
        internalActivity.setObsid("A_1_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.3f);
        internalActivity.addFromQueue("Q_11");
        internalActivity.addToQueue("Q_13");
        internalActivity.addToResource("TRAFFIC_AGENT");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("TRAFFIC_AGENT");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("A_2");
        internalActivity.setObsid("A_2_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.4f);
        internalActivity.addFromQueue("Q_12");
        internalActivity.addFromQueue("Q_13");
        internalActivity.addToQueue("Q_14");
        internalActivity.addToResource("SCCI_MODULE");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("SCCI_MODULE");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("A_3");
        internalActivity.setObsid("A_3_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.2f);
        internalActivity.addFromQueue("Q_14");
        internalActivity.addToQueue("Q_15");
        internalActivity.addToResource("TRAFFIC_LIGHTS");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("TRAFFIC_LIGHTS");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("FB_7");
        internalActivity.setObsid("FB_7_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(1.0f);
        internalActivity.addFromQueue("Q_1");
        internalActivity.addFromQueue("Q_15");
        internalActivity.addToQueue("Q_2");
        internalActivity.addToResource("INTERSECTION");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("INTERSECTION");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("FB_2");
        internalActivity.setObsid("FB_2_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.3f);
        internalActivity.addFromQueue("Q_15");
        internalActivity.addToQueue("Q_6");
        internalActivity.addToResource("TRAFFIC_LIGHTS");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("TRAFFIC_LIGHTS");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("FB_3");
        internalActivity.setObsid("FB_3_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.2f);
        internalActivity.addFromQueue("Q_2");
        internalActivity.addToQueue("Q_7");
        internalActivity.addToResource("SENSORS");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("SENSORS");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("FB_1");
        internalActivity.setObsid("FB_1_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.5f);
        internalActivity.addFromQueue("Q_6");
        internalActivity.addFromQueue("Q_7");
        internalActivity.addToQueue("OUT");
        internalActivity.addToResource("SCCI_MODULE");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("SCCI_MODULE");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        //Observers

        //queues
        observer = new ObserverEntry(ObserverEntry.QUEUE, "Q_1");
        observer.SetId("Q_1_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "Q_2");
        observer.SetId("Q_2_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "Q_6");
        observer.SetId("Q_6_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "Q_7");
        observer.SetId("Q_7_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);


        observer = new ObserverEntry(ObserverEntry.QUEUE, "Q_11");
        observer.SetId("Q_11_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "Q_12");
        observer.SetId("Q_12_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "Q_13");
        observer.SetId("Q_13_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "Q_14");
        observer.SetId("Q_14_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "Q_15");
        observer.SetId("Q_15_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "OUT");
        observer.SetId("OUT_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        //resources
        observer = new ObserverEntry(ObserverEntry.RESOURCE, "TRAFFIC_AGENT");
        observer.SetId("TRAFFIC_AGENT_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.RESOURCE, "SCCI_MODULE");
        observer.SetId("SCCI_MODULE_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.RESOURCE, "TRAFFIC_LIGHTS");
        observer.SetId("TRAFFIC_LIGHTS_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.RESOURCE, "SENSORS");
        observer.SetId("SENSORS_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.RESOURCE, "INTERSECTION");
        observer.SetId("INTERSECTION_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        //internal activities
        observer = new ObserverEntry(ObserverEntry.ACTIVE, "A_1");
        observer.SetId("A_1_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "A_2");
        observer.SetId("A_2_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "A_3");
        observer.SetId("A_3_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "FB_1");
        observer.SetId("FB_1_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "FB_2");
        observer.SetId("FB_2_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "FB_3");
        observer.SetId("FB_3_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);


        observer = new ObserverEntry(ObserverEntry.ACTIVE, "FB_7");
        observer.SetId("FB_7_OBS");
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
        man.OutputSimulationResults("SimulationSCCI_v2.out");
        System.out.println("\nProcess finished!");
    }
}
