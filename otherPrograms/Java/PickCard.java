public class PickCard {
    public static void main(String[] args){
        final int number_cards = 52;
        
        int card = (int)(Math.random() * number_cards) + 1;
        
        System.out.print("The card you picked is (" + card + ") ");
        
        if(card % 13 == 0)
            System.out.print("Ace of ");
        else if(card % 13 == 10)
            System.out.print("Jack of ");
        else if(card % 13 == 11)
            System.out.print("Quenn of ");
        else if(card % 13 == 12)
            System.out.print("King of ");
        else
            System.out.print((card % 13) + " of ");
        
        if(card % 4 == 0)
            System.out.println("Clubs");
        if(card % 4 == 1)
            System.out.println("Diamonds");
        if(card % 4 == 2)
            System.out.println("Hearts");
        if(card % 4 == 3)
            System.out.println("Spades");
        
       /* switch(card){
            case 1: System.out.println("Ace of Clubs");
            break;
            case 2: System.out.println("Ace of Diamonds");
            break;
            case 3: System.out.println("Ace of Hearts");
            break;
            case 4: System.out.println("Ace of Spades");
            break;
            case 5: System.out.println("2 of Clubs");
            break;
            case 6: System.out.println("2 of Diamonds");
            break;
            case 7: System.out.println("2 of Hearts");
            break;
            case 8: System.out.println("2 of Spades");
            break;
            case 9: System.out.println("3 of Clubs");
            break;
            case 10: System.out.println("3 of Diamonds");
            break;
            case 11: System.out.println("3 of Hearts");
            break;
            case 12: System.out.println("3 of Spades");
            break;
            case 13: System.out.println("4 of Clubs");
            break;
            case 14: System.out.println("4 of Diamonds");
            break;
            case 15: System.out.println("4 of Hearts");
            break;
            case 16: System.out.println("4 of Spades");
            break;
            case 17: System.out.println("5 of Clubs");
            break;
            case 18: System.out.println("5 of Diamonds");
            break;
            case 19: System.out.println("5 of Hearts");
            break;
            case 20: System.out.println("5 of Spades");
            break;
            case 21: System.out.println("6 of Clubs");
            break;
            case 22: System.out.println("6 of Diamonds");
            break;
            case 23: System.out.println("6 of Hearts");
            break;
            case 24: System.out.println("6 of Spades");
            break;
            case 25: System.out.println("7 of Clubs");
            break;
            case 26: System.out.println("7 of Diamonds");
            break;
            case 27: System.out.println("7 of Hearts");
            break;
            case 28: System.out.println("7 of Spades");
            break;
            case 29: System.out.println("8 of Clubs");
            break;
            case 30: System.out.println("8 of Diamonds");
            break;
            case 31: System.out.println("8 of Hearts");
            break;
            case 32: System.out.println("8 of Spades");
            break;
            case 33: System.out.println("9 of Clubs");
            break;
            case 34: System.out.println("9 of Diamonds");
            break;
            case 35: System.out.println("9 of Hearts");
            break;
            case 36: System.out.println("9 of Spades");
            break;
            case 37: System.out.println("10 of Clubs");
            break;
            case 38: System.out.println("10 of Diamonds");
            break;
            case 39: System.out.println("10 of Hearts");
            break;
            case 40: System.out.println("10 of Spades");
            break;
            case 41: System.out.println("Jack of Clubs");
            break;
            case 42: System.out.println("Jack of Diamonds");
            break;
            case 43: System.out.println("Jack of Hearts");
            break;
            case 44: System.out.println("Jack of Spades");
            break;
            case 45: System.out.println("Queen of Clubs");
            break;
            case 46: System.out.println("Queen of Diamonds");
            break;
            case 47: System.out.println("Queen of Hearts");
            break;
            case 48: System.out.println("Queen of Spades");
            break;
            case 49: System.out.println("King of Clubs");
            break;
            case 50: System.out.println("King of Diamonds");
            break;
            case 51: System.out.println("King of Hearts");
            break;
            case 52: System.out.println("King of Spades");
            break;
            default: System.out.println("Error: invalid card");
                     System.exit(1);
        } 
        */
    }
    
}