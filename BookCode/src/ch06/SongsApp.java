//---------------------------------------------------------------------
// SongsApp.java          by Dale/Joyce/Weems                 Chapter 6
//
// Allows user to enter a collection of songs.
// Keeps track of order and total time.
//----------------------------------------------------------------------
package ch06;

import java.text.DecimalFormat;
import java.util.Scanner;

import support.Song; // for Song
import ch06.lists.ArrayIndexedList;

public class SongsApp {
	public static void main(String[] args) {
		Scanner conIn = new Scanner(System.in);

		String name; // song name
		int minutes; // song duration
		int seconds; // song duration
		int number; // song number
		int totTime = 0; // total duration of songs entered so far

		DecimalFormat fmt = new DecimalFormat("00"); // to format seconds

		ArrayIndexedList<Song> songList = new ArrayIndexedList<Song>(20);
		Song song;

		System.out.print("Song name (press Enter to end): ");
		name = conIn.nextLine();
		while (!name.equals("")) {
			System.out.print("Minutes: ");
			minutes = conIn.nextInt();
			conIn.nextLine();
			System.out.print("Seconds: ");
			seconds = conIn.nextInt();
			conIn.nextLine();
			totTime = totTime + (minutes * 60) + seconds;

			song = new Song(name, minutes, seconds);

			System.out.print("Song number between 0 and " + songList.size()
					+ ": ");
			number = conIn.nextInt();
			conIn.nextLine();
			songList.add(number, song);

			System.out.println();
			System.out.println(songList);
			System.out.println("Total Time: " + (totTime / 60) + ":"
					+ fmt.format(totTime % 60));
			System.out.println();

			System.out.print("Song name (press Enter to end): ");
			name = conIn.nextLine();
		}
		System.out.println();
		System.out.println("The final result is \n");
		System.out.println(songList);
		System.out.println("Total Time: " + (totTime / 60) + ":"
				+ fmt.format(totTime % 60));
		System.out.println();
		conIn.close();
	}
}