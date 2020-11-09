package statelessunittesting;

import static com.sg.statelessunittesting.arrays.ArrayExerciseA.maxOfArray;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayExerciseATest {
    
    /* Test plan:
    ** maxOfArray( {1}  ) ->  1
    ** maxOfArray( {3,4,5}  ) ->  5
    ** maxOfArray( {-9000, -700, -50, -3}  ) ->  -3
    */
    
    public ArrayExerciseATest() {
    }
    
    @Test
    public void testOneNumber(){
        // ARRANGE
        int[] arrayNumbers = {1};
        
        // ACT 
        int maxNumber = maxOfArray(arrayNumbers);
        
        // ASSERT
        int expectedMaxNumber = 1;
        assertEquals(expectedMaxNumber, maxNumber, "Expected 1 as max number.");
    }
    
    @Test
    public void testPositiveNubmers(){
        // ARRANGE
        int[] arrayNumbers = {3,4,5};
        
        // ACT
        int maxNumber = maxOfArray(arrayNumbers);
        
        // ASSERT
        int expectedMaxNumber = 5;
        assertEquals(expectedMaxNumber, maxNumber, "Expected 5 as max number.");
    }
    
    @Test
    public void testNegativeNumbers(){
        // ARRANGE
        int[] arrayNumbers = {-9000, -700, -50, -3};
        
        // ACT
        int maxNumber = maxOfArray(arrayNumbers);
        
        // ASSERT
        int expectedMaxNumber = -3;
        assertEquals(expectedMaxNumber, maxNumber, "Expected -3 as max number.");
    }
}
