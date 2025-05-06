package trabalho.conclusao;//
// Simulação do modelo de controle da porta baseado no ACD
//

import simula.manager.*;

public class SimulationSCCI_v4 {
    public static void main(String args[]) {
        //ONE GENERATE FOR EACH SENSOR
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
        queue.SetId("Q_3");
        queue.setObsid("Q_3_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("Q_4");
        queue.setObsid("Q_4_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("Q_5");
        queue.setObsid("Q_5_OBS");
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
        queue.SetId("Q_8");
        queue.setObsid("Q_8_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("Q_9");
        queue.setObsid("Q_9_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("Q_10");
        queue.setObsid("Q_10_OBS");
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
        queue.SetId("Q_16");
        queue.setObsid("Q_16_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("Q_17");
        queue.setObsid("Q_17_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("Q_18");
        queue.setObsid("Q_18_OBS");
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
        resource.SetId("N_TRAFFIC_SENSOR_1");
        resource.setInit((short) 1);
        resource.setObsid("N_TRAFFIC_SENSOR_1_OBS");
        man.AddResource(resource);

        resource = new ResourceEntry();
        resource.SetId("N_TRAFFIC_SENSOR_2");
        resource.setInit((short) 1);
        resource.setObsid("N_TRAFFIC_SENSOR_2_OBS");
        man.AddResource(resource);

        resource = new ResourceEntry();
        resource.SetId("P_TRAFFIC_SENSOR_1");
        resource.setInit((short) 1);
        resource.setObsid("P_TRAFFIC_SENSOR_1_OBS");
        man.AddResource(resource);

        resource = new ResourceEntry();
        resource.SetId("P_TRAFFIC_SENSOR_2");
        resource.setInit((short) 1);
        resource.setObsid("P_TRAFFIC_SENSOR_2_OBS");//observer
        man.AddResource(resource);

        resource = new ResourceEntry();
        resource.SetId("INTERSECTION");
        resource.setInit((short) 4);
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
        externalActivity.SetId("GENERATE_VEHICLES_N_1");
        externalActivity.setQID("Q_1");
        externalActivity.setServiceDist(ActiveEntry.CONST);
        externalActivity.setDistP1(0.5f);
        man.AddActiveState(externalActivity);

        externalActivity = new ExternalActiveEntry(true);
        externalActivity.SetId("GENERATE_VEHICLES_N_2");
        externalActivity.setQID("Q_16");
        externalActivity.setServiceDist(ActiveEntry.CONST);
        externalActivity.setDistP1(0.5f);
        man.AddActiveState(externalActivity);

        externalActivity = new ExternalActiveEntry(true);
        externalActivity.SetId("GENERATE_VEHICLES_P_1");
        externalActivity.setQID("Q_17");
        externalActivity.setServiceDist(ActiveEntry.CONST);
        externalActivity.setDistP1(0.5f);
        man.AddActiveState(externalActivity);

        externalActivity = new ExternalActiveEntry(true);
        externalActivity.SetId("GENERATE_VEHICLES_P_2");
        externalActivity.setQID("Q_18");
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
        internalActivity.setDistP1(0.1f);
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
        internalActivity.setDistP1(1.0f); //RESOLVER TEMPOS
        internalActivity.addFromQueue("Q_1");
        internalActivity.addFromQueue("Q_15");
        internalActivity.addToQueue("Q_2");
        internalActivity.addToResource("INTERSECTION");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("INTERSECTION");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("FB_8");
        internalActivity.setObsid("FB_8_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(1.0f); //RESOLVER TEMPOS
        internalActivity.addFromQueue("Q_16");
        internalActivity.addFromQueue("Q_15");
        internalActivity.addToQueue("Q_3");
        internalActivity.addToResource("INTERSECTION");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("INTERSECTION");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("FB_9");
        internalActivity.setObsid("FB_9_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(1.0f); //RESOLVER TEMPOS
        internalActivity.addFromQueue("Q_17");
        internalActivity.addFromQueue("Q_15");
        internalActivity.addToQueue("Q_4");
        internalActivity.addToResource("INTERSECTION");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("INTERSECTION");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("FB_10");
        internalActivity.setObsid("FB_10_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(1.0f); //RESOLVER TEMPOS
        internalActivity.addFromQueue("Q_18");
        internalActivity.addFromQueue("Q_15");
        internalActivity.addToQueue("Q_5");
        internalActivity.addToResource("INTERSECTION");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("INTERSECTION");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("FB_2");
        internalActivity.setObsid("FB_2_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.3f); //RESOLVER TEMPOS
        internalActivity.addFromQueue("Q_15");
        internalActivity.addToQueue("Q_3");
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
        internalActivity.addToResource("N_TRAFFIC_SENSOR_1");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("N_TRAFFIC_SENSOR_1");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("FB_4");
        internalActivity.setObsid("FB_4_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.2f); //RESOLVER TEMPOS
        internalActivity.addFromQueue("Q_3");
        internalActivity.addToQueue("Q_8");
        internalActivity.addToResource("N_TRAFFIC_SENSOR_2");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("N_TRAFFIC_SENSOR_2");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("FB_5");
        internalActivity.setObsid("FB_5_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.2f); //RESOLVER TEMPOS
        internalActivity.addFromQueue("Q_4");
        internalActivity.addToQueue("Q_9");
        internalActivity.addToResource("P_TRAFFIC_SENSOR_1");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("P_TRAFFIC_SENSOR_1");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("FB_6");
        internalActivity.setObsid("FB_6_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.2f); //RESOLVER TEMPOS
        internalActivity.addFromQueue("Q_5");
        internalActivity.addToQueue("Q_10");
        internalActivity.addToResource("P_TRAFFIC_SENSOR_2");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("P_TRAFFIC_SENSOR_2");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("FB_1");
        internalActivity.setObsid("FB_1_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.5f);
        internalActivity.addFromQueue("Q_6");
        internalActivity.addFromQueue("Q_7");
        internalActivity.addFromQueue("Q_8");
        internalActivity.addFromQueue("Q_9");
        internalActivity.addFromQueue("Q_10");
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

        observer = new ObserverEntry(ObserverEntry.QUEUE, "Q_3");
        observer.SetId("Q_3_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "Q_4");
        observer.SetId("Q_4_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "Q_5");
        observer.SetId("Q_5_OBS");
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

        observer = new ObserverEntry(ObserverEntry.QUEUE, "Q_8");
        observer.SetId("Q_8_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "Q_9");
        observer.SetId("Q_9_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "Q_10");
        observer.SetId("Q_10_OBS");
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

        observer = new ObserverEntry(ObserverEntry.QUEUE, "Q_16");
        observer.SetId("Q_16_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "Q_17");
        observer.SetId("Q_17_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "Q_18");
        observer.SetId("Q_18_OBS");
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

        observer = new ObserverEntry(ObserverEntry.RESOURCE, "N_TRAFFIC_SENSOR_1");
        observer.SetId("N_TRAFFIC_SENSOR_1_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.RESOURCE, "N_TRAFFIC_SENSOR_2");
        observer.SetId("N_TRAFFIC_SENSOR_2_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.RESOURCE, "P_TRAFFIC_SENSOR_1");
        observer.SetId("P_TRAFFIC_SENSOR_1_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.RESOURCE, "P_TRAFFIC_SENSOR_2");
        observer.SetId("P_TRAFFIC_SENSOR_2_OBS");
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

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "FB_4");
        observer.SetId("FB_4_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "FB_5");
        observer.SetId("FB_5_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "FB_6");
        observer.SetId("FB_6_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "FB_7");
        observer.SetId("FB_7_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "FB_8");
        observer.SetId("FB_8_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "FB_9");
        observer.SetId("FB_9_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "FB_10");
        observer.SetId("FB_10_OBS");
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
        man.OutputSimulationResults("SimulationSCCI_v4.out");
        System.out.println("\nProcess finished!");
    }
}
