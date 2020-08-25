
import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Driver me = new Driver();
		me.sim();
	}
	
	public void sim() {
		int customerArrivalTime = 4;		// customer arrival time
                int customerServiceTime = 4;        // customer service time
		int simulationTime = 480;		// max time in simulation
		int systemTime = 0;		// current time in simulation
		int nextArrivalQueuedTeller1;		// when will the next queued arrival be to Teller 1
		int nextArrivalQueuedTeller2;		// when will the next queued arrival be to Teller 2
                int customerCompletionTimeTeller1;            // the customer completed to be served at teller 1
                int customerCompletionTimeTeller2;            // the customer completed to be served at teller 2
		Plane removee;			// item being removed from queue
		Plane tmp;				// tmp item
		int landed;			// landed count
		int departed;			// departed count
                boolean teller1Serving = false; // Is anyone being served at teller 1 ?
                boolean teller2Serving = false; // Is anyone being served at teller 2 ?

		Random rand = new Random();

		LQueue Teller1 = new LQueue();			// Queue of Teller 1
		LQueue Teller2 = new LQueue();			// Queue of Teller 2
		
		// Print out the banner and read the input.
		System.out.println( "Welcome to the Bank simulation\n");
		
		// Compute some preliminary data
		nextArrivalQueuedTeller1 = systemTime + rand.nextInt((int)(customerArrivalTime)+1);
                customerCompletionTimeTeller1 = 0;
		nextArrivalQueuedTeller2 = systemTime + rand.nextInt((int)(customerArrivalTime)+1);
                customerCompletionTimeTeller2 = 0;

		// initialize some data
		departed = 0;
		landed = 0;

		// Run the simulation
		for (systemTime = 0; systemTime < simulationTime; systemTime++) {

			// See if we need to add anyone to a queue of Teller 1
			if (systemTime == nextArrivalQueuedTeller1) {
				tmp = new Plane();
                                //customerCompletionTimeTeller1 = systemTime + rand.nextInt(customerServiceTime) + 1;
				tmp.ttl = 0;
				tmp.qtime = systemTime;
				Teller1.add(tmp);
		                System.out.println( "Customer arrived to Teller 1 at minute " + systemTime);
				nextArrivalQueuedTeller1 = systemTime + rand.nextInt(customerArrivalTime) + 1;
			}
			// See if we need to add anyone to a queue of Teller 2
			if (systemTime == nextArrivalQueuedTeller2) {
				tmp = new Plane();
                                //customerCompletionTimeTeller2 = systemTime + rand.nextInt(customerServiceTime) + 1;
				tmp.ttl = 0;
				tmp.qtime = systemTime;
				Teller2.add(tmp);
		                System.out.println( "Customer arrived to Teller 2 at minute " + systemTime);
				nextArrivalQueuedTeller2 = systemTime + rand.nextInt(customerArrivalTime) + 1;
			}

			// See if we can remove anyone from a queue of Teller 1.
				// If customer completed then remove from the queue of Teller 1
				 if (systemTime >= Teller1.peek().ttl) {
					removee = Teller1.remove();
		                        System.out.println( "Teller 1 finished customer, at minute " + systemTime);
						// they made it on the ground
						landed += 1;
				}

                        
			// See if we can remove anyone from a queue of Teller 2.
				// If customer completed then remove from the queue of Teller 2
				 if (systemTime >= Teller2.peek().ttl) {
					removee = Teller2.remove();
		                        System.out.println( "Teller 2 finished customer, at minute " + systemTime);
					departed++;
				}
		}

		// Simulation is over, print out the statistics
		System.out.println( "Simulation finished!\n");
		System.out.println( "Simulation ran                  : " + simulationTime
		+ " Minutes\n");
		System.out.println( "Planes Departed                 : " + departed);
		System.out.println( "Planes Landed                   : " + landed);
		System.out.println( "Total Arrivals Still in Queue   : " + Teller1.size());
		System.out.println( "Total Departures Still in Queue : " + Teller2.size());
		
	
	}

}
