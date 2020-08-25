
import java.util.*;
public class ArrayCount {
    public static void main(String[] args){
        ArrayList<String> ary = new ArrayList<String>();
                int countA = 0;
                int countB = 0;
                int countC = 0;

      ary.add("a");
      ary.add("a");
      ary.add("a");
      ary.add("b");
      ary.add("b");
      ary.add("c");
      ary.add("c");
      ary.add("c");
      
      for (int i = 0; i < ary.size(); i++){
          if(ary.get(i) == "a")
              countA++;
          if(ary.get(i) == "b")
              countB++;
          if(ary.get(i) == "c")
              countC++;
      }
      
        if(countA % 2 != 0 ){
            ary.remove(countA-1);
            countA--;
        }
        
        if(countB % 2 != 0 ){
            ary.remove((countA+countB)-1);
            countB--;
        }
                  
        if(countC % 2 != 0 ){
            ary.remove((countA+countB+countC)-1);
            countC--;
        }
     
              System.out.println("Total count is " + ary.size());
    }
}
