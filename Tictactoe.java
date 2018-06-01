import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Tictactoe {
	static Scanner in;
	static String[] fusha;
	static String radha;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		fusha = new String[9];
		radha = "X";
		String fituesi = null;
		shtoFushen();

		System.out.println("Tic Tac Toe - Game");
		System.out.println();
		vizatoFushen();
		System.out.println("X luan i pari, shenoni nje kuti me numer ku deshironi te luani!");

		while (fituesi == null) {
			int numInput;
			try {
				numInput = in.nextInt();
				if (!(numInput > 0 && numInput <= 9)) {
					System.out.println("Gabim, shenoni nje numer te sakte...:");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("Gabim, shenoni ne hapesire te lire...:");
				continue;
			}
			if (fusha[numInput-1].equals(String.valueOf(numInput))) {
				fusha[numInput-1] = radha;
				if (radha.equals("X")) {
					radha = "O";
				} else {
					radha = "X";
				}
				vizatoFushen();
				fituesi = kontrolloFitoren();
			} else {
				System.out.println("Hapesira eshte e zene, ju lutem zgjedhni nje tjeter:");
				continue;
			}
		}
		if (fituesi.equalsIgnoreCase("barazim")) {
			System.out.println("Baraz! Falemnderit qe luajtet");
		} else {
			System.out.println("Urime " + fituesi + " ka fituar, falemnderit qe luajtet!");
		}
	}

	static String kontrolloFitoren() {
		for (int a = 0; a < 8; a++) {
			String line = null;
			switch (a) {
			case 0:
				line = fusha[0] + fusha[1] + fusha[2];
				break;
			case 1:
				line = fusha[3] + fusha[4] + fusha[5];
				break;
			case 2:
				line = fusha[6] + fusha[7] + fusha[8];
				break;
			case 3:
				line = fusha[0] + fusha[3] + fusha[6];
				break;
			case 4:
				line = fusha[1] + fusha[4] + fusha[7];
				break;
			case 5:
				line = fusha[2] + fusha[5] + fusha[8];
				break;
			case 6:
				line = fusha[0] + fusha[4] + fusha[8];
				break;
			case 7:
				line = fusha[2] + fusha[4] + fusha[6];
				break;
			}
			if (line.equals("XXX")) {
				return "X";
			} else if (line.equals("OOO")) {
				return "O";
			}
		}

		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(fusha).contains(String.valueOf(a+1))) {
				break;
			}
			else if (a == 8) return "Barazim";
		}

		System.out.println("Radha e; " +radha+" vendos ne cilen fushe deshiron te luaj:  " + radha );
		return null;
	}

	static void vizatoFushen() {
		System.out.println("		/---|---|---\\");
		System.out.println("		| " + fusha[0] + " | " + fusha[1] + " | " + fusha[2] + " |");
		System.out.println("		|-----------|");
		System.out.println("		| " + fusha[3] + " | " + fusha[4] + " | " + fusha[5] + " |");
		System.out.println("		|-----------|");
		System.out.println("		| " + fusha[6] + " | " + fusha[7] + " | " + fusha[8] + " |");
		System.out.println("		\\---|---|---/");
	}

	static void shtoFushen() {
		for (int a = 0; a < 9; a++) {
			fusha[a] = String.valueOf(a+1);
		}
	}
}