
import java.util.Scanner;
import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Driver me = new Driver();
		me.sim();
	}
		
	public void sim() {
		int timeToDepart;			// time to depart
		int averageDeparture;		// average departure time
		int simulationTime;		// max time in simulation
		int systemTime = 0;		// current time in simulation
		int nextDeparture;			// when will the next departure be
		int nextDepartureQueued;		// next queued departure
		Plane removee;			// item being removed from queue
		Plane tmp;				// tmp item
		int departed;			// departed count
		boolean somebodyDeparting;		// is someone departing?
		int totalDepartureTime = 0;	// Total time of departures

		String inputString;
		
		Random rand = new Random();

		Scanner kbd = new Scanner(System.in);
		LQueue departures = new LQueue();			// Queue of departures
		
		// Print out the banner and read the input.
		System.out.println( "Welcome to the airport simulation\n");
		System.out.println( "Please enter the following information.");
		System.out.print( "Time in minutes to Takeoff      : ");
		inputString = kbd.nextLine();
		timeToDepart = Integer.parseInt(inputString);
		System.out.print( "Average time between departures : ");
		inputString = kbd.nextLine();
		averageDeparture = Integer.parseInt(inputString);
		System.out.print("Number of minutes in Simulation : ");
		inputString = kbd.nextLine();
		simulationTime = Integer.parseInt(inputString);
		
		// Compute some preliminary data
		nextDepartureQueued = systemTime + rand.nextInt((int)(averageDeparture*2));
		nextDeparture = timeToDepart;

		// initialize some data
		somebodyDeparting = false;
		departed = 0;

		// Run the simulation
		for (systemTime = 0; systemTime < simulationTime; systemTime++) {

			// See if we need to add anyone to a queue
			// of departures
			if (systemTime == nextDepartureQueued) {
				tmp = new Plane();
				tmp.ttl = 0;
				tmp.qtime = systemTime;
				departures.add(tmp);
				nextDepartureQueued = systemTime + rand.nextInt(averageDeparture*2) + 1;
			}

			// See if we can remove anyone from a queue.
			// Handle departures.
				if (somebodyDeparting == true) {
					// If someone is already departing deal with them
					if (systemTime >= (nextDeparture + timeToDepart)) {
						somebodyDeparting = false;
						nextDeparture = systemTime + timeToDepart;
					}
				} else if (departures.size() > 0) {
					// as long as there are no landings in progress we can depart
					removee = departures.remove();
					totalDepartureTime += (systemTime - removee.qtime);
					somebodyDeparting = true;
					departed++;
				}
		}

		// Simulation is over, print out the statistics
		System.out.println( "Simulation finished!\n");
		System.out.println( "Simulation ran                  : " + simulationTime
		+ " Minutes\n");
		System.out.println( "Planes Departed                 : " + departed);
		if (departed > 0)
			System.out.println( "Average Time in Departure Queue : " + (float)
			((float)totalDepartureTime / departed));
		System.out.println( "Total Departures Still in Queue : " + departures.size());
		System.out.println( "Total departure time is         : " + totalDepartureTime);
		
		kbd.close();
	
	}

}
