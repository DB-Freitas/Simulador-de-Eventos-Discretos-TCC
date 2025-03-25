package trabalho.conclusao;//
// Simulação do modelo de controle da porta baseado no ACD
//

import simula.manager.*;

public class Main {
    public static void main(String args[]) {
        System.out.println("\nGenerating door control simulation model...");
        SimulationManager man= new SimulationManager();

        QueueEntry queue;//queues
        ResourceEntry resource;//resource queues
        ExternalActiveEntry externalActivity;//generator and detroy
        InternalActiveEntry internalActivity;//activivity and router
        ObserverEntry observer;
        HistogramEntry he;

        // queues and observer queues

        queue = new QueueEntry();
        queue.SetId("WAIT_OPEN_DOOR");
        queue.setObsid("OPEN_DOOR_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("WAIT_DOOR_ACTUATOR");
        queue.setObsid("DOOR_ACTUATOR_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("WAIT_DOOR_SENSORS"); // Esperando sensores
        queue.setObsid("DOOR_SENSORS_OBS");
        man.AddQueue(queue);

        queue = new QueueEntry();
        queue.SetId("WAIT_FEEDBACK"); // Esperando feedback
        queue.setObsid("WAIT_FEEDBACK_OBS");
        man.AddQueue(queue);

        // 🔹 Definição de recursos

        resource = new ResourceEntry();
        resource.SetId("DOOR_ACTUATOR_AVAILABLE"); // Atuador disponível
        resource.setInit((short) 1);
        man.AddResource(resource);

        //external

        externalActivity = new ExternalActiveEntry(true);
        externalActivity.SetId("CONTROL_ACTION_MESSAGE");
        externalActivity.setQID("WAIT_OPEN_DOOR");
        externalActivity.setServiceDist(ActiveEntry.UNIFORM);
        externalActivity.setDistP1(1); // Min 1s
        externalActivity.setDistP2(5); // Max 5s
        man.AddActiveState(externalActivity);

        //internals (activities and routers)

        //abrindo
        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("OPEN_DOOR");
        internalActivity.setServiceDist(ActiveEntry.NORMAL);
        internalActivity.setDistP1(0.5f);
        internalActivity.setDistP2(0.1f);
        internalActivity.addToQueue("WAIT_DOOR_ACTUATOR");
        internalActivity.addFromQueue("WAIT_OPEN_DOOR");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        //atuador acionado
        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("DOOR_ACTUATOR");
        internalActivity.setServiceDist(ActiveEntry.NORMAL);
        internalActivity.setDistP1(0.3f);
        internalActivity.setDistP2(0.1f);
        internalActivity.addToQueue("WAIT_DOOR_SENSORS");
        internalActivity.addFromQueue("WAIT_DOOR_ACTUATOR");
        internalActivity.addToResource("IDLE");// mapped by next resource dead
        internalActivity.addResourceQty(new Integer(1));// mapped by init on resource dead
        internalActivity.addFromResource("DOOR_ACTUATOR_AVAILABLE");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        //sensores verificando posiçãão
        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("DOOR_SENSORS_FEEDBACK");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.1f);
        internalActivity.setDistP2(0.05f);
        internalActivity.addToQueue("WAIT_FEEDBACK");
        internalActivity.addFromQueue("WAIT_DOOR_SENSORS");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        // 🔸 Feedback da posição da porta
        internalActivity = new InternalActiveEntry(true);
        internalActivity.SetId("DOOR_POSITION_FEEDBACK");
        internalActivity.setServiceDist(ActiveEntry.CONST);
        internalActivity.setDistP1(0.2f);
        internalActivity.addToQueue("WAIT_OPEN_DOOR");
        internalActivity.addFromQueue("WAIT_FEEDBACK");
        internalActivity.addCond("true");
        man.AddActiveState(internalActivity);

        //observers

        observer = new ObserverEntry(ObserverEntry.QUEUE, "WAIT_OPEN_DOOR");
        observer.SetId("OPEN_DOOR_OBS");
        man.AddObserver(observer);

        observer = new ObserverEntry(ObserverEntry.QUEUE, "WAIT_FEEDBACK");
        observer.SetId("WAIT_FEEDBACK_OBS");
        man.AddObserver(observer);

        // 🔹 Gerando o modelo
        if (man.GenerateModel()) {
            System.out.println("\nModel successfully generated!");
        } else {
            System.out.println("\nError generating model! Exiting...");
            return;
        }

        // 🔹 Executando simulação
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
        man.OutputSimulationResults("DoorControlSimulation.out");
        System.out.println("\nProcess finished!");
    }
}
