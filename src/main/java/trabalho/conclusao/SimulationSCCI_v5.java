package trabalho.conclusao;

import simula.manager.*;

public class SimulationSCCI_v5 {

    public static void main(String[] args) {
        //ALL CAs and FB
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
        queue.SetId("Q_18");
        queue.setObsid("Q_18_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("Q_19");
        queue.setObsid("Q_19_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("Q_20");
        queue.setObsid("Q_20_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("Q_21");
        queue.setObsid("Q_21_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("OUT");
        queue.setObsid("OUT_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("OUT_2");
        queue.setObsid("OUT_2_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("OUT_3");
        queue.setObsid("OUT_3_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("OUT_4");
        queue.setObsid("OUT_4_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("OUT_5");
        queue.setObsid("OUT_5_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("OUT_6");
        queue.setObsid("OUT_6_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("QUEUE_C_ALG");
        queue.setObsid("QUEUE_C_ALG_OBS");
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
        resource.setInit((short) 1);
        resource.setObsid("INTERSECTION_OBS");//observer
        man.AddResource(resource);

        //External Activity

        externalActivity = new ExternalActiveEntry(true);
        externalActivity.SetId("GENERATE_CA");
        externalActivity.setQID("Q_8");
        externalActivity.setServiceDist(ActiveEntry.CONST);
        externalActivity.setDistP1(0.02f);
        externalActivity.setObsid("GENERATE_CA_OBS");
        man.AddActiveState(externalActivity);

        externalActivity = new ExternalActiveEntry(true);
        externalActivity.SetId("GENERATE_API_DATA");
        externalActivity.setQID("Q_9");
        externalActivity.setServiceDist(ActiveEntry.CONST);
        externalActivity.setDistP1(0.001f);
        externalActivity.setObsid("GENERATE_API_DATA_OBS");
        man.AddActiveState(externalActivity);

        externalActivity = new ExternalActiveEntry(true);
        externalActivity.SetId("GENERATE_VEHICLES");
        externalActivity.setQID("Q_1");
        externalActivity.setServiceDist(ActiveEntry.CONST);
        externalActivity.setDistP1(0.2f);
        externalActivity.setObsid("GENERATE_VEHICLES_OBS");
        man.AddActiveState(externalActivity);

        //Internal Activity

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("SET_VTL_TIMES_AND_N_OF_CYCLES");
        internalActivity.setObsid("SET_VTL_TIMES_AND_N_OF_CYCLES_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.05f);
        internalActivity.addFromQueue("Q_8");
        internalActivity.addToQueue("QUEUE_C_ALG");
        internalActivity.addToResource("TRAFFIC_AGENT");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("TRAFFIC_AGENT");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("CONTROL_ALGORITHM");
        internalActivity.setObsid("CONTROL_ALGORITHM_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.005f);
        internalActivity.addFromQueue("QUEUE_C_ALG");
        internalActivity.addToQueue("Q_10");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("OPEN_VTL");
        internalActivity.setObsid("OPEN_VTL_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.02f);
        internalActivity.addFromQueue("Q_9");
        internalActivity.addFromQueue("Q_10");
        internalActivity.addToQueue("Q_11");
        internalActivity.addToResource("SCCI_MODULE");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("SCCI_MODULE");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("OPEN_PTL");
        internalActivity.setObsid("OPEN_PTL_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.02f);
        internalActivity.addFromQueue("Q_9");
        internalActivity.addFromQueue("Q_10");
        internalActivity.addToQueue("Q_12");
        internalActivity.addToResource("SCCI_MODULE");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("SCCI_MODULE");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("CLOSE_VTL");
        internalActivity.setObsid("CLOSE_VTL_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.03f);
        internalActivity.addFromQueue("Q_9");
        internalActivity.addFromQueue("Q_10");
        internalActivity.addToQueue("Q_13");
        internalActivity.addToResource("SCCI_MODULE");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("SCCI_MODULE");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("YELLOW_FOR_VTL");
        internalActivity.setObsid("YELLOW_FOR_VTL_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.03f);
        internalActivity.addFromQueue("Q_9");
        internalActivity.addFromQueue("Q_10");
        internalActivity.addToQueue("Q_14");
        internalActivity.addToResource("SCCI_MODULE");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("SCCI_MODULE");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("CLOSE_PTL");
        internalActivity.setObsid("CLOSE_PTL_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.02f);
        internalActivity.addFromQueue("Q_9");
        internalActivity.addFromQueue("Q_10");
        internalActivity.addToQueue("Q_15");
        internalActivity.addToResource("SCCI_MODULE");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("SCCI_MODULE");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("FLASHING_RED_FOR_PTL");
        internalActivity.setObsid("FLASHING_RED_FOR_PTL_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.015f);
        internalActivity.addFromQueue("Q_9");
        internalActivity.addFromQueue("Q_10");
        internalActivity.addToQueue("Q_16");
        internalActivity.addToResource("SCCI_MODULE");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("SCCI_MODULE");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("SET_VTL_TIMES");
        internalActivity.setObsid("SET_VTL_TIMES_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.1f);
        internalActivity.addFromQueue("Q_9");
        internalActivity.addFromQueue("Q_10");
        internalActivity.addToQueue("OUT_6");
        internalActivity.addToResource("SCCI_MODULE");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("SCCI_MODULE");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("RELEASE_VEHICLE_FLOW");
        internalActivity.setObsid("RELEASE_VEHICLE_FLOW_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.1f);
        internalActivity.addFromQueue("Q_11");
        internalActivity.addToQueue("Q_18");
        internalActivity.addToResource("TRAFFIC_LIGHTS");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("TRAFFIC_LIGHTS");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("RELEASE_PEDESTRIAN_FLOW");
        internalActivity.setObsid("RELEASE_PEDESTRIAN_FLOW_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.1f);
        internalActivity.addFromQueue("Q_12");
        internalActivity.addToQueue("Q_19");
        internalActivity.addToResource("TRAFFIC_LIGHTS");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("TRAFFIC_LIGHTS");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("INTERRUPT_FLOW_OF_VEHICLES");
        internalActivity.setObsid("INTERRUPT_FLOW_OF_VEHICLES_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.1f);
        internalActivity.addFromQueue("Q_13");
        internalActivity.addFromQueue("Q_14");
        internalActivity.addToQueue("Q_20");
        internalActivity.addToResource("TRAFFIC_LIGHTS");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("TRAFFIC_LIGHTS");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("INTERRUPT_FLOW_OF_PEDESTRIAN");
        internalActivity.setObsid("INTERRUPT_FLOW_OF_PEDESTRIAN_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.1f);
        internalActivity.addFromQueue("Q_15");
        internalActivity.addFromQueue("Q_16");
        internalActivity.addToQueue("Q_21");
        internalActivity.addToResource("TRAFFIC_LIGHTS");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("TRAFFIC_LIGHTS");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("FB_ALL_VEHICLES");
        internalActivity.setObsid("FB_ALL_VEHICLES_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.1f);
        internalActivity.addFromQueue("Q_1");
        internalActivity.addFromQueue("Q_18");
        internalActivity.addFromQueue("Q_19");
        internalActivity.addFromQueue("Q_20");
        internalActivity.addFromQueue("Q_21");
        internalActivity.addToQueue("Q_2");
        internalActivity.addToResource("INTERSECTION");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("INTERSECTION");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

//        internalActivity = new InternalActiveEntry(true);
//        internalActivity.SetId("FB_VTL_AND_PTL_COLLOR");
//        internalActivity.setObsid("FB_VTL_AND_PTL_COLLOR_OBS");
//        internalActivity.setServiceDist(ActiveEntry.CONST);
//        internalActivity.setDistP1(0.3f);
//        internalActivity.addFromQueue("");  duvida de onde vem o sinal
//        internalActivity.addToQueue("Q_7");
//        internalActivity.addToResource("TRAFFIC_LIGHTS");
//        internalActivity.addResourceQty(1);
//        internalActivity.addFromResource("TRAFFIC_LIGHTS");
//        internalActivity.addCond("true");
//        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("FB_NUMBER_OF_EMERGENCY_VEHICLES_ROAD_1");
        internalActivity.setObsid("FB_NUMBER_OF_EMERGENCY_VEHICLES_ROAD_1_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.005f);
        internalActivity.addFromQueue("Q_2");
        internalActivity.addToQueue("Q_3");
        internalActivity.addToResource("P_TRAFFIC_SENSOR_1");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("P_TRAFFIC_SENSOR_1");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);


        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("FB_NUMBER_OF_EMERGENCY_VEHICLES_ROAD_2");
        internalActivity.setObsid("FB_NUMBER_OF_EMERGENCY_VEHICLES_ROAD_2_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.005f);
        internalActivity.addFromQueue("Q_2");
        internalActivity.addToQueue("Q_4");
        internalActivity.addToResource("P_TRAFFIC_SENSOR_2");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("P_TRAFFIC_SENSOR_2");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("FB_NUMBER_OF_VEHICLES_ROAD_1");
        internalActivity.setObsid("FB_NUMBER_OF_VEHICLES_ROAD_1_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.005f);
        internalActivity.addFromQueue("Q_2");
        internalActivity.addToQueue("Q_5");
        internalActivity.addToResource("N_TRAFFIC_SENSOR_1");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("N_TRAFFIC_SENSOR_1");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("FB_NUMBER_OF_VEHICLES_ROAD_2");
        internalActivity.setObsid("FB_NUMBER_OF_VEHICLES_ROAD_2_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.005f);
        internalActivity.addFromQueue("Q_2");
        internalActivity.addToQueue("Q_6");
        internalActivity.addToResource("N_TRAFFIC_SENSOR_2");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("N_TRAFFIC_SENSOR_2");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);


        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("FB_VTL_AND_PTL_COLLOR_FINAL");
        internalActivity.setObsid("FB_VTL_AND_PTL_COLLOR_FINAL_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.0003f);
        internalActivity.addFromQueue("Q_7");
        internalActivity.addToQueue("OUT");
        internalActivity.addToResource("SCCI_MODULE");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("SCCI_MODULE");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("FB_NUMBER_OF_N_VEHICLES_2");
        internalActivity.setObsid("FB_NUMBER_OF_N_VEHICLES_2_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.0004f);
        internalActivity.addFromQueue("Q_6");
        internalActivity.addToQueue("OUT_2");
        internalActivity.addToResource("SCCI_MODULE");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("SCCI_MODULE");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("FB_NUMBER_OF_N_VEHICLES_1");
        internalActivity.setObsid("FB_NUMBER_OF_N_VEHICLES_1_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.0005f);
        internalActivity.addFromQueue("Q_5");
        internalActivity.addToQueue("OUT_3");
        internalActivity.addToResource("SCCI_MODULE");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("SCCI_MODULE");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("FB_NUMBER_OF_E_VEHICLES_2");
        internalActivity.setObsid("FB_NUMBER_OF_E_VEHICLES_2_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.0006f);
        internalActivity.addFromQueue("Q_4");
        internalActivity.addToQueue("OUT_4");
        internalActivity.addToResource("SCCI_MODULE");
        internalActivity.addResourceQty(1);
        internalActivity.addFromResource("SCCI_MODULE");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("FB_NUMBER_OF_E_VEHICLES_1");
        internalActivity.setObsid("FB_NUMBER_OF_E_VEHICLES_1_OBS");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.007f);
        internalActivity.addFromQueue("Q_3");
        internalActivity.addToQueue("OUT_5");
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

        observer = new ObserverEntry(ObserverEntry.QUEUE, "Q_18");
        observer.SetId("Q_18_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "Q_19");
        observer.SetId("Q_19_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "Q_20");
        observer.SetId("Q_20_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "Q_21");
        observer.SetId("Q_21_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "QUEUE_C_ALG");
        observer.SetId("QUEUE_C_ALG_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "OUT");
        observer.SetId("OUT_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "OUT_2");
        observer.SetId("OUT_2_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "OUT_3");
        observer.SetId("OUT_3_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "OUT_4");
        observer.SetId("OUT_4_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "OUT_5");
        observer.SetId("OUT_5_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "OUT_6");
        observer.SetId("OUT_6_OBS");
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

        //external activity
        observer = new ObserverEntry(ObserverEntry.ACTIVE, "GENERATE_CA");
        observer.SetId("GENERATE_CA_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "GENERATE_API_DATA");
        observer.SetId("GENERATE_API_DATA_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "GENERATE_VEHICLES");
        observer.SetId("GENERATE_VEHICLES_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        //internal activity
        observer = new ObserverEntry(ObserverEntry.ACTIVE, "SET_VTL_TIMES_AND_N_OF_CYCLES");
        observer.SetId("SET_VTL_TIMES_AND_N_OF_CYCLES_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "CONTROL_ALGORITHM");
        observer.SetId("CONTROL_ALGORITHM_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "OPEN_VTL");
        observer.SetId("OPEN_VTL_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "OPEN_PTL");
        observer.SetId("OPEN_PTL_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "CLOSE_VTL");
        observer.SetId("CLOSE_VTL_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "YELLOW_FOR_VTL");
        observer.SetId("YELLOW_FOR_VTL_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "CLOSE_PTL");
        observer.SetId("CLOSE_PTL_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "FLASHING_RED_FOR_PTL");
        observer.SetId("FLASHING_RED_FOR_PTL_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "SET_VTL_TIMES");
        observer.SetId("SET_VTL_TIMES_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "RELEASE_VEHICLE_FLOW");
        observer.SetId("RELEASE_VEHICLE_FLOW_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "RELEASE_PEDESTRIAN_FLOW");
        observer.SetId("RELEASE_PEDESTRIAN_FLOW_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "INTERRUPT_FLOW_OF_VEHICLES");
        observer.SetId("INTERRUPT_FLOW_OF_VEHICLES_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "INTERRUPT_FLOW_OF_PEDESTRIAN");
        observer.SetId("INTERRUPT_FLOW_OF_PEDESTRIAN_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "FB_ALL_VEHICLES");
        observer.SetId("FB_ALL_VEHICLES_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

//        observer = new ObserverEntry(ObserverEntry.ACTIVE, "FB_VTL_AND_PTL_COLLOR");
//        observer.SetId("FB_VTL_AND_PTL_COLLOR_OBS");
//        observer.setName(observer.GetId());
//        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "FB_NUMBER_OF_EMERGENCY_VEHICLES_ROAD_1");
        observer.SetId("FB_NUMBER_OF_EMERGENCY_VEHICLES_ROAD_1_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "FB_NUMBER_OF_EMERGENCY_VEHICLES_ROAD_2");
        observer.SetId("FB_NUMBER_OF_EMERGENCY_VEHICLES_ROAD_2_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "FB_NUMBER_OF_VEHICLES_ROAD_1");
        observer.SetId("FB_NUMBER_OF_VEHICLES_ROAD_1_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "FB_NUMBER_OF_VEHICLES_ROAD_2");
        observer.SetId("FB_NUMBER_OF_VEHICLES_ROAD_2_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "FB_VTL_AND_PTL_COLLOR_FINAL");
        observer.SetId("FB_VTL_AND_PTL_COLLOR_FINAL_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "FB_NUMBER_OF_N_VEHICLES_2");
        observer.SetId("FB_NUMBER_OF_N_VEHICLES_2_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "FB_NUMBER_OF_N_VEHICLES_1");
        observer.SetId("FB_NUMBER_OF_N_VEHICLES_1_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "FB_NUMBER_OF_E_VEHICLES_2");
        observer.SetId("FB_NUMBER_OF_E_VEHICLES_2_OBS");
        observer.setName(observer.GetId());
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.ACTIVE, "FB_NUMBER_OF_E_VEHICLES_1");
        observer.SetId("FB_NUMBER_OF_E_VEHICLES_1_OBS");
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
        man.OutputSimulationResults("SimulationSCCI_v5.out");
        System.out.println("\nProcess finished!");
    }
}
