package Hangman;

import java.util.Scanner;

public class Hangman {
	private static Scanner select = new Scanner(System.in);
	public static Integer tries = 0;
	static boolean win = true;

//Initiate a new char array that gets one star per index, relative to the length of the secret word.
	public void game() {

		Secret.L = new char[Secret.GAMEWORD.length()];
		for (int i = 0; i < Secret.L.length; i++) {
			Secret.L[i] = '*';
		}

	}

//Method to get user input but it only takes the first letter from the input, if the user writes more than one letter.
		public void play() {

			String g = select.next().toLowerCase();
			if (g.length() > 1) {
				g = g.substring(0, 1);
			}
			userGuess(g);
		}
	
	
//This method takes the input from the user and compares it with the secret word.
//If the letter exists in the secret word, it replaces the star in the char array with that letter in the same position as the character have in the secret word.
//If the character doesn't exist in the secret word, the number of tries will increase.
	public void userGuess(String letter) {
		if (!Secret.GAMEWORD.contains(letter)) {
			tries++;
		}
		if (Secret.GAMEWORD.contains(letter)) {
			int index = Secret.GAMEWORD.indexOf(letter);
			while (index >= 0) {
				Secret.L[index] = letter.charAt(0);
				index = Secret.GAMEWORD.indexOf(letter, index + 1);
			}
		}

	}

//This method takes the letters stored in the char array and displays them at their current spot in the array index.
	private Object LContains() {
		StringBuilder currentIndex = new StringBuilder();
		for (int i = 0; i < Secret.L.length; i++) {
			currentIndex.append(Secret.L[i]);
			if (i < Secret.L.length - 1) {
				currentIndex.append(" ");
			}
		}
		return currentIndex.toString();

	}


//Method to handle when the used wants to guess the whole word, if user guesses correctly it's a win. Otherwise it's a loss.
	public void wholeWord() {
		String WW = select.next().toLowerCase();
		if (!Secret.GAMEWORD.contains(WW)) {			
			System.out.println(Secret.hanger());
			System.out.println("Sorry you guessed the wrong word, you lose!\n the secret word was" + Secret.GAMEWORD);
			win = false;
		} else if (Secret.GAMEWORD.contains(WW)) {
			System.out.println("Congratulations you guessed the word right, you win!");
			win = false;
		}
	}
	
	public static void main(String[] args) {
		Secret sClass = new Secret();
		Hangman hangman = new Hangman();
		hangman.game();
		sClass.draw();		
		System.out.println("Welcome to hangman Rimworld edition, the game is to guess something in the game Rimworld!");
		System.out.println("\nCurrent progress:" + hangman.LContains());
		while (win) {
            //String initialized with the full index of the charArray.
			//Later it's used as a boolean to stop the game if it's equal to the secret word.
			String gWin = new String(Secret.L).toString();
			//Integer initialized with the total remainder of the maximum tries allowed for each run.
			int attemptsLeft = Secret.MAX_TRY - tries;			
			System.out.println(
					"\nSelect a game option:\n(1)to guess a letter:\n(2)guess the whole word:\n(3)Game status:");
			try {
				//Menu that also handles the exception of inputs that is something else than an integer
				if(select.hasNextInt())				
				{
				int choice = Integer.parseInt(select.next());			
				switch (choice) {
				case 1:
					hangman.play();
					System.out.println("\nCurrent progress:" + hangman.LContains());
					System.out.println(Secret.H.get(tries-1));
					break;
				case 2:
					System.out.println("\nOBS! If you guess the wrong word you lose!" + "\n:");
					hangman.wholeWord();
					break;
				case 3:
					System.out.println("You have guessed incorrectly " + tries + " times! " + "\nYou have " + attemptsLeft + " attempts left!");
					break;
				}
				}
				else{
					System.out.println("You have to select one of the alternativs 1 , 2 or 3!");
					select.next();					
				}
			} catch (Exception e) {
				
			}
			if (tries >= 6) {
				System.out.println("To many incorrect guesses, game over!\n the secret word was " + Secret.GAMEWORD);
				win = false;				
			}
			if(gWin.equals(Secret.GAMEWORD)) {				
				System.out.println("Congratulations you guessed the correct word, you win!");
				win = false;
			}
		}
	}
}