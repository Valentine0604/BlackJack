import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");

        scan.nextLine();

        int cardRandom1 = drawRandomCard();
        int cardRandom2 = drawRandomCard();
        String randomCard1 = cardString(cardRandom1);
        String randomCard2 = cardString(cardRandom2);
        
        System.out.print("\n You get a \n" + randomCard1 + "\n and \n" + randomCard2);

        int playerTotal = Math.min(cardRandom1,10) + Math.min(cardRandom2,10);

        System.out.println("Your total is " + playerTotal);

        int dealerCardRandom1 = drawRandomCard();
        int dealerCardRandom2 = drawRandomCard();
        String dealerCard1 = cardString(dealerCardRandom1);
        String dealerCard2 = cardString(dealerCardRandom2);
        int dealerTotal = Math.min(dealerCardRandom1,10) + Math.min(dealerCardRandom2,10);

        System.out.println("The dealer shows \n" + dealerCard1 + "\nand has a card facing down \n" + faceDown());
        System.out.println("\nThe dealer's total is hidden");
        String option = hitOrStay();



        while(option.equals("hit")){
            int randomCardNumber = drawRandomCard();
            String card = cardString(randomCardNumber);
            playerTotal += randomCardNumber;
            System.out.println("\nYou get a \n" + card);
            System.out.println("Your new total is " + playerTotal);

            option = hitOrStay();

            if(playerTotal>21){
                System.out.println("Bust! Player loses");
                showTotal(playerTotal, dealerTotal);
                System.exit(0);
            }
        }

        System.out.println("Dealer's turn");
        System.out.println("The dealer's cards are\n" + dealerCard1 + "\nand a\n" + dealerCard2);

        while(dealerTotal<17){
            int dealerCardNumber = drawRandomCard();
            String dealerCard = cardString(dealerCardNumber);
            System.out.println("\nDealer gets a\n" + dealerCard + "\n");
            dealerTotal += Math.min(dealerCardNumber,10);
            System.out.println("Dealer's total is " + dealerTotal);
        }

        if(dealerTotal>21){
            System.out.println("Bust! Dealer loses");
            showTotal(playerTotal, dealerTotal);
            System.exit(0);
        }

        if(playerTotal>dealerTotal){
            System.out.println("Player wins!");
            showTotal(playerTotal, dealerTotal);
        }
        else{
            System.out.println("Dealer wins!");
            showTotal(playerTotal, dealerTotal);
        }
        
         scan.close();

    }

    /** Function name – drawRandomCard
     * @return (int)
     *
     * Inside the function:
     *   1. Gets a random number between 1 and 13.
     *   2. Returns a card.
     */

     public static int drawRandomCard(){
        double randomNum = Math.random()*13;
        randomNum++;

        return (int)randomNum;
     }

    /** Function name – cardString
     * @param cardNumber (int)
     * @return (String)
     *
     * Inside the function:
     *   1. Returns a String drawing of the card.
     */

     public static String cardString(int cardNumber){
        switch(cardNumber){
            case 1:
            return "   _____\n"+
                   "  |A _  |\n"+ 
                   "  | ( ) |\n"+
                   "  |(_'_)|\n"+
                   "  |  |  |\n"+
                   "  |____V|\n";

            case 2:
            return "   _____\n"+              
                   "  |2    |\n"+ 
                   "  |  o  |\n"+
                   "  |     |\n"+
                   "  |  o  |\n"+
                   "  |____Z|\n";

            case 3:
            return "   _____\n" +
                   "  |3    |\n"+
                   "  | o o |\n"+
                   "  |     |\n"+
                   "  |  o  |\n"+
                   "  |____E|\n";

            case 4:
            return "   _____\n" +
                   "  |4    |\n"+
                   "  | o o |\n"+
                   "  |     |\n"+
                   "  | o o |\n"+
                   "  |____h|\n";

            case 5:
            return "   _____ \n" +
                   "  |5    |\n" +
                   "  | o o |\n" +
                   "  |  o  |\n" +
                   "  | o o |\n" +
                   "  |____S|\n";


            case 6:
            return "   _____ \n" +
                   "  |6    |\n" +
                   "  | o o |\n" +
                   "  | o o |\n" +
                   "  | o o |\n" +
                   "  |____6|\n";

            case 7:
            return "   _____ \n" +
                   "  |7    |\n" +
                   "  | o o |\n" +
                   "  |o o o|\n" +
                   "  | o o |\n" +
                   "  |____7|\n";

            case 8:
            return "   _____ \n" +
                   "  |8    |\n" +
                   "  |o o o|\n" +
                   "  | o o |\n" +
                   "  |o o o|\n" +
                   "  |____8|\n";

            case 9:
            return "   _____ \n" +
                   "  |9    |\n" +
                   "  |o o o|\n" +
                   "  |o o o|\n" +
                   "  |o o o|\n" +
                   "  |____9|\n";

            case 10:
            return "   _____ \n" +
                   "  |10  o|\n" +
                   "  |o o o|\n" +
                   "  |o o o|\n" +
                   "  |o o o|\n" +
                   "  |___10|\n";

            case 11:
            return "   _____\n" +
                   "  |J  ww|\n"+ 
                   "  | o {)|\n"+ 
                   "  |o o% |\n"+ 
                   "  | | % |\n"+ 
                   "  |__%%[|\n";

            case 12:
            return "   _____\n" +
                   "  |Q  ww|\n"+ 
                   "  | o {(|\n"+ 
                   "  |o o%%|\n"+ 
                   "  | |%%%|\n"+ 
                   "  |_%%%O|\n";

            case 13:
            return  "   _____\n" +
                    "  |K  WW|\n"+ 
                    "  | o {)|\n"+ 
                    "  |o o%%|\n"+ 
                    "  | |%%%|\n"+ 
                    "  |_%%%>|\n";
            
            default:
            return " ";
        }
     }

    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
    
    /**  Function name – hitOrStay
     * @return (String)
     *
     * Inside the function:
     *   1. Asks the user to hit or stay.
     *   2. If the user doesn't enter "hit" or "stay", keep asking them to try again by printing:
     *      Please write 'hit' or 'stay'
     *   3. Returns the user's option 
     */

    public static String hitOrStay(){
       
        System.out.println("Do you wish to hit or stay?");
        String ans = scan.nextLine();

        while(!((ans.equals("hit") || ans.equals("stay")))){
            System.out.println("Do you wish to hit or stay?");
            ans = scan.nextLine();
        }

        return ans;
    }
      
    /** Function name – showTotal
     * @param playerTotal (int) 
     * @param dealerTotal (int)
     *
     * Inside the function:
     *   1. Prints values of player's and dealer's total.
     */

    public static void showTotal(int playerTotal, int dealerTotal){
        System.out.println("Player's total " + playerTotal);
        System.out.println("Dealer's total " + dealerTotal);
    }
 }

