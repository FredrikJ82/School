package Hangman;

import java.util.ArrayList;
import java.util.Random;

public class Secret {
	//Array of strings with the predetermined words for the game.
	private static final String[] WORDS = { "rimworld", "pawn", "colonist", "randy", "cassandra", "phoebie", "warg", "muffalo", "tribe", "outlander" };
	
	//Method that's randomizes the secret word.
	private static final Random R = new Random();
	private static String newSW() {
		return WORDS[R.nextInt(WORDS.length)];
	}	
	
	//Max attempts allowed for each game round.
	public static final Integer MAX_TRY = 6;	
	
	//Initializing the gameword.
	public static final String GAMEWORD = newSW();
	
	//Char array for collection of guesses that the user does.
	public static char[] L;
	
	//Divided into 6 steps this string ArrayList stores the "drawing".
	public static ArrayList<String> H = new ArrayList<>();
	public void draw()
	{
		H.add(" |\n/|\\");
		H.add(" |\n |\n |\n/|\\ ");
		H.add(" |\n |\n |\n |\n |\n/|\\");
		H.add("  ______\n |\n |\n |\n |\n |\n/|\\");
		H.add("  ______\n |      |\n |      O\n |\n |\n |\n/|\\");
		H.add("  ______\n |      |\n |      O\n |     /|\\\n |     / \\\n |\n/|\\");

	}
	
	//method used to write the whole hanging man image in to the console.	
	public static final Object hanger() {
		String h = "  ___" + "___" + "\n |      " + "|" + "\n |      " + "O" + "\n |" + "     /|\\" + "\n |    " + " / \\" + "\n |" + "\n/|\\";
		return h;
	}	
}