
import java.util.Random;

public class Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bank me = new Bank();
		me.sim();
	}
		
	public void sim() {
		int maxServiceTime = 4;			// maximum time to service customer
                int ServiceTime = 0;                    // actual time to serve one customer at Teller 0
                int ServiceTime1 = 0;                   // actual time to serve one customer at Teller 1    
                int previousServiceTime = 0;            // service time of the customer, who just was removed from the queue to Teller 0
                int previousServiceTime1 = 0;           // service time of the customer, who just was removed from the queue to Teller 1
		int maxArrival = 4;                     // maximum time between customer arrivals
		int simulationTime = 480;               // simulation time
		int systemTime = 0;                     // current time in simulation
		int nextService;			// the time when the next service be at Teller 0
		int nextService1;			// the time when the next service be at Teller 1
		int nextServiceQueued;                  // the time when the next customer arrives to the bank (next queued service)
                int nextServiceQueuedSecond = 0;        // the time when the second customer arrives to the bank
		Customer removee;			// a customer being removed from queue to go to the Tellers
		Customer tmp;				// temporary item
		int served = 0;                         // count of served customers at Teller 0
                int served1 = 0;                        // count of served customers at Teller 1
                int totalServed = 0;                    // total count of served customers at both Tellers
		boolean somebodyBeingServiced = false;	// is someone being serviced at teller 0?
		boolean somebodyBeingServiced1 = false;	// is someone being serviced at teller 1?
                int firstCustomerArrivalTime = 0;       // first customer arrival time
                int secondCustomerArrivalTime = 0;      // second customer arrival time
                int fistCustomerCompletionTime = 0;     // first customer completion time
                int secondCustomerCompletionTime = 0;   // second customer completion time
                int customerCompletionTime = 0;         // other customers completion time at Teller 0    
                int customerCompletionTime1 = 0;        // other customers completion time at Teller 1    
                int max = 0;                            // maximum amount of customers at any given time
                int tempMax = 0;                        // temporary holder to find the maximum number of customers
                int tempWait = 0;                       // temporary holder of the wait time of customers
                int longestWait = 0;                    // longest wait time any one customer experiences

		Random rand = new Random();

		LQueue lineOfCustomers = new LQueue();			// Queue of customers
		
		// Display the input data to the user
		System.out.println("Welcome to the bank simulation\n");
		System.out.println("The following information is available:");
		System.out.println("Maximum time to be serviced: " + maxServiceTime + " min.");
		System.out.println("Maximum time between arrivals: " + maxArrival + " min.");
		System.out.println("Simulation time: " + simulationTime + " min." + "\n");
		
		// Compute some preliminary data for the first and second customers
		nextServiceQueued = systemTime + rand.nextInt(maxArrival) + 1;
		nextServiceQueuedSecond = systemTime + rand.nextInt(maxArrival) + 1;
                firstCustomerArrivalTime = nextServiceQueued;
                secondCustomerArrivalTime = nextServiceQueuedSecond;
                ServiceTime = systemTime + rand.nextInt(maxServiceTime) + 1;
                ServiceTime1 = systemTime + rand.nextInt(maxServiceTime) + 1;
                fistCustomerCompletionTime = firstCustomerArrivalTime + ServiceTime;
                secondCustomerCompletionTime = secondCustomerArrivalTime + ServiceTime1;
		nextService = ServiceTime;
		nextService1 = ServiceTime1;
                
		// Run the simulation
		for (systemTime = 0; systemTime < simulationTime; systemTime++) {

			// add a customer to the queue if arrived
			if (systemTime == nextServiceQueued) {
				tmp = new Customer();
				tmp.qtime = systemTime;
				lineOfCustomers.add(tmp);
                                // Identify maximum amt of customers at any given time
                                tempMax = lineOfCustomers.size();
                                if(tempMax > max){
                                    max = tempMax;
                                }
                                
                                System.out.print("Customer arrived at minute: " + systemTime + "\n");
				nextServiceQueued = systemTime + rand.nextInt(maxArrival) + 1;
			}

                                // Teller 0: remove a customer from the queue if it is time
				if (somebodyBeingServiced == true) {
					// If someone is already being serviced, deal with them
					if (systemTime >= (nextService + ServiceTime)) {
						somebodyBeingServiced = false;
                                                previousServiceTime = ServiceTime;
                                                ServiceTime = rand.nextInt(maxServiceTime) + 1;
						nextService = systemTime + ServiceTime;
					}
				} else if (lineOfCustomers.size() > 0) {
					// removing a customer from the queue
					removee = lineOfCustomers.remove();
                                        if(served == 0){
                                        System.out.print("Teller 0 finished customer at minute: " + fistCustomerCompletionTime + "\n");
                                        } else{
                                            customerCompletionTime = systemTime + previousServiceTime;
                                        System.out.print("Teller 0 finished customer at minute: " + customerCompletionTime + "\n");
                                        }
                                        tempWait = (systemTime - removee.qtime);
                                        if(tempWait > longestWait){
                                        longestWait = tempWait;
                                        }
					somebodyBeingServiced = true;
					served++;
				}
                                
                                // Teller 1: remove a customer from the queue if it is time
				if (somebodyBeingServiced1 == true) {
					// If someone is already being serviced, deal with them
					if (systemTime >= (nextService1 + ServiceTime1)) {
						somebodyBeingServiced1 = false;
                                                previousServiceTime1 = ServiceTime1;
                                                ServiceTime1 = rand.nextInt(maxServiceTime) + 1;
						nextService1 = systemTime + ServiceTime1;
					}
				} else if (lineOfCustomers.size() > 0) {
					// removing a customer from the queue
					removee = lineOfCustomers.remove();
                                        if(served1 == 0){
                                        System.out.print("Teller 1 finished customer at minute: " + secondCustomerCompletionTime + "\n");
                                        } else{
                                            customerCompletionTime1 = systemTime + previousServiceTime1;
                                        System.out.print("Teller 1 finished customer at minute: " + customerCompletionTime1 + "\n");
                                        }
                                        tempWait = (systemTime - removee.qtime);
                                        if(tempWait > longestWait){
                                        longestWait = tempWait;
                                        }
					somebodyBeingServiced1 = true;
					served1++;
				}
                                
		}

                // total customers served at the bank
                totalServed = served + served1;             
                
		// Simulation is over, print out the statistics
		System.out.println("Simulation finished!\n");
		System.out.println("Simulation ran: " + simulationTime + " min.\n");
		System.out.println("Customers served: " + totalServed);
		System.out.println("Total Customers Still in Queue: " + lineOfCustomers.size());
		System.out.println("Maximum number of customers: " + max);
		System.out.println("Longest customer wait: " + longestWait + " min.");
		
	}

}
