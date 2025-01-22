package trabalho.conclusao;

import simula.*;
import simula.manager.SimulationManager;

public class Main {
    public static void main(String[] args) {
        // executive objects
        Scheduler s;
// scheduler
// modelling objects
        FifoQ wait0, B0; // Queues
        ResourceQ idle;
// resource queue (clerk)
        Generate arrival, call;
// Arrival states
// Customers and calls
        Destroy dep0, dep1;
// Departure states
        Activity service, talk;
// Active states for customers
// and phone calls
        QueueObserver w0, w1; // observers for waiting queues
        ResourceObserver idleO; // resource observer (clerk)
        Statistics sw0, sw1, sidle; // statistics of the observers
        ActiveObserver arrO, callO; //observer of Generate´s
        Statistics sarr, scall;
//and their statistics objects
// distributions
        Sample sp;
// random number generator
        NegExp arrdist, calldist; // interval between arrivals
        Uniform servdist, talkdist; // service time


// Object creation
// Must follow this order (of categories)
// Scheduler is always first
        s = new Scheduler();

// then the distributions (model parameters)
        sp = new Sample();
        servdist = new Uniform(sp, 10, 100);
// the generator first
        arrdist = new NegExp(sp, 5); // negative exponential with
// an average of five time units
// ... suppressed the code for the other distributions
// model
// dead states first
        wait0 = new FifoQ(s);
        B0 = new FifoQ(s);
        // ... suppressed the code for the other queues
        idle = new ResourceQ(s, 2); // 2 clerks
// then the active states and the connections
        service = new Activity(s);
        service.SetServiceTime(servdist);
        service.ConnectQueues(wait0, B0);
        service.ConnectResources(idle, idle, 1); // 1 clerk/service
// ... suppressed the code for the other activity
// finally the observers and statistics
        sw0 = new Statistics(s);
        w0 = new QueueObserver(s, wait0, sw0, true);
// ... suppressed the code for the other queue observer
        sidle = new Statistics(s);
        idleO = new ResourceObserver(s, idle, sidle);
// ... suppressed the code for the generate observers
// now we execute
        s.Run(500); // for 500 time units
// ... suppressed the polling code
// the simulation runs in its own thread
// results
        System.out.println("\n\nHarassed Booking Clerk Results");
        System.out.println("\nTermination instant: " + s.GetClock());
        System.out.println("\nQueues:");
        System.out.println("Wait0: average " + sw0.Mean() +" stddev " + sw0.StdDev());

        // other result Prints go here
    }
}

