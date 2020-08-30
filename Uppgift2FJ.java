import java.util.Scanner;

public class Uppgift2FJ {

    public static Scanner   sc          = new Scanner(System.in);
	
	public static void main(String[] args) {

		greet();
        play();
        while (playAgain())
        {
            play();
        }
    }
	
    public static void play()												// Main part of the program. It takes the two inputs and checks them for validity and then determinates the winner.
    {
        String user1 = user1Choice();
        String user2 = user2Choice();
        determineWinner(user1, user2);
    }
	
    public static void greet()												// Small method for greeting the player.
    {
    	System.out.println("Hello and welcome to Rock Paper Scissors.");
    }
    
    public static boolean playAgain()										// Method for asking if the players wants to play again.
    {
        System.out.println("Play again?(y/n)");
        String input = sc.nextLine();
        if (input.toLowerCase().equals("y"))
        {
            return true;
        } else if (input.toLowerCase().equals("n"))
        {
            return false;
        } else
        {
            System.out.println("Invalid Input");
            return playAgain();
        }

    }

    public static String user1Choice()										// Asks the player for input.
    {

        String user1 = "default";
        do
        {
            System.out.println("Player 1 choose your weapon(Paper,Scissors or Rock)");
            user1 = sc.nextLine();
        } while (!isValidChoice(user1));
        return user1;
    }
    
    public static String user2Choice()										// Asks the second player for input.
    {

        String user2 = "default";
        do
        {
            System.out.println("Player 2 choose your weapon(Paper,Scissors or Rock)");
            user2 = sc.nextLine();
        } while (!isValidChoice(user2));
        return user2;
    }

    public static boolean isValidChoice(String choice)						// Checks the inputs.
    {
        boolean status;
        if (choice.equals("Rock"))
            status = true;
        else if (choice.equals("Paper"))
            status = true;
        else if (choice.equals("Scissors"))
            status = true;
        else
        {
            status = false;
            System.out.println("Error! Make sure you are capitalizing your choices");
        }

        return status;
    }
    
    public static void determineWinner(String user1, String user2)			// Method for comparing the two inputs with each other.
    {
        System.out.println(" First Player : " + user1);
        System.out.println(" Second Player : " + user2);
        
        if (user1.equals("Rock") && user2.equals("Scissors"))
        {
            System.out.println(" Player 2 wins! ");
        }
        if (user1.equals("Scissors") && user2.equals("Paper"))
        {
            System.out.println(" Player 2 wins! ");
        }
        if (user1.equals("Paper") && user2.equals("Rock"))
        {
            System.out.println(" Player 2 wins! ");
        }
        if (user1.equals("Rock") && user2.equals("Paper"))
        {
            System.out.println(" Player 1 wins! ");
        }
        if (user1.equals("Scissors") && user2.equals("Rock"))
        {
            System.out.println(" Player 1 wins!");
        }
        if (user1.equals("Paper") && user2.equals("Scissors"))
        {
            System.out.println(" Player 1 wins!");
        } else if (user1.equals(user2))
        {
            System.out.println(" Tie! the game must be played again.");
        }     
        return;
    }
}
		
		
