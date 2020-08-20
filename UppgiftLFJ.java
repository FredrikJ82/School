import java.util.Scanner;

public class UppgiftLFJ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int inloggningsF = 0;

		while (inloggningsF != 3) {
			Scanner reader = new Scanner(System.in);
			System.out.println("Vad är Lösenordet? ");
			String Pass = reader.nextLine();
			if (Pass.equals("Fredrik")) {
				System.out.println("Välkommen Fredrik");
				reader.close();
			} else {
				System.out.println("Fel lösenord, försök igen");
				inloggningsF++;
				System.out.println("Antalet försök : " + inloggningsF);
			}

		}

		System.out.println("För många inloggningsförsök");
	}
}
