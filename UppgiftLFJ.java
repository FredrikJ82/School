import java.util.Scanner;

public class UppgiftLFJ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int inloggningsF = 0;

		while (inloggningsF != 3) {
			Scanner reader = new Scanner(System.in);
			System.out.println("Vad �r L�senordet? ");
			String Pass = reader.nextLine();
			if (Pass.equals("Fredrik")) {
				System.out.println("V�lkommen Fredrik");
				reader.close();
			} else {
				System.out.println("Fel l�senord, f�rs�k igen");
				inloggningsF++;
				System.out.println("Antalet f�rs�k : " + inloggningsF);
			}

		}

		System.out.println("F�r m�nga inloggningsf�rs�k");
	}
}
