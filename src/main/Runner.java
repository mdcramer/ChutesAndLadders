package main;

import java.util.Random;

public class Runner {
	
	private static final int NUMSIMS = 10000;

	public static void main(String[] args) {
		
		int numTurns, totalNumTurns = 0, minNumTurns= 0, maxNumTurns =0;
		
		for (int i = 0; i < NUMSIMS;  i++) {
			numTurns = play();
			totalNumTurns += numTurns;
			if (numTurns > maxNumTurns) maxNumTurns = numTurns;
			if (minNumTurns == 0) {
				minNumTurns = numTurns;
			} else {
				if (numTurns < minNumTurns) minNumTurns = numTurns;
			}
		}
		System.out.println("\nAve number of turns to win = " + ((float) totalNumTurns / NUMSIMS));
		System.out.println("Min number of turns to win = " + minNumTurns);
		System.out.println("Max number of turns to win = " + maxNumTurns);

	}
	
	private static int play() {
		int position = 0, spin, turnCounter = 0;
		Random spinner = new Random();
		
		while (position != 100) {

			spin = spinner.nextInt(6) + 1;
			if (position + spin <= 100) position += spin;
			
			// Ladders
			switch (position) {
				case 1: position = 38; break;
				case 4: position = 14; break;
				case 9: position = 31; break;
				case 21: position = 42; break;
				case 28: position = 84; break;
				case 36: position = 44; break;
				case 51: position = 67; break;
				case 71: position = 91; break;
				case 80: position = 100; break;
				default: break;
			}
			// Chutes
			switch (position) {
				case 16: position = 6; break;
				case 48: position = 26; break;
				case 49: position = 11; break;
				case 56: position = 53; break;
				case 62: position = 19; break;
				case 64: position = 60; break;
				case 87: position = 24; break;
				case 93: position = 73; break;
				case 95: position = 75; break;
				case 98: position = 78; break;
			}
			
			turnCounter++;
			System.out.print(position + " ");
			
		}
		
		System.out.println("--> "+ turnCounter);
		return (turnCounter);
	}

}
