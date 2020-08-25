
public class TestProgram {
    public static void main(String[] args){
        int ary[] = new int[5];
        ary[0] = 0;
        ary[1] = 3;
        ary[2] = 2;
        ary[3] = 5;
        ary[4] = 1;
        
        System.out.println("Recording values in each element of the array: ");
        
   
        
        /*    for(int i = 1; i < 5; i++){
            ary[i] = ary[i-1]+1;
        }
        */ 
        System.out.println("Display values of each element of the array with regular forloop: ");
        
       for(int i = 0; i < 5; i++){
        System.out.println("Love you " + i + " times!");
       }
      
        System.out.println("Display values of each element of the array with forEach loop: ");
        
        for(int i: ary){
        System.out.println("Love you " + i + " times!");
        }
    }
}
