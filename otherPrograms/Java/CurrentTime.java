import java.util.Scanner;

public class CurrentTime {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        long totalMilliseconds, totalSeconds, currentSeconds, totalMinutes,
                currentMinutes, totalHours, currentHours, zoneHour = 0;
        
        System.out.print("Enter the time zone offset to GMT: ");
        
        zoneHour = input.nextLong();
        
        totalMilliseconds = System.currentTimeMillis();
        
        totalSeconds = totalMilliseconds / 1000;
        
        currentSeconds = totalSeconds % 60;
        
        totalMinutes = totalSeconds / 60;
        
        currentMinutes = totalMinutes % 60;
        
        totalHours = totalMinutes / 60;
        
        currentHours = (totalHours  + zoneHour) % 24;
        
        System.out.println("The current time is " + currentHours + " : " +
                currentMinutes + " : " + currentSeconds);
    }
}
