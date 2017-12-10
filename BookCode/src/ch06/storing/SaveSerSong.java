package ch06.storing;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import support.SerSong;

public class SaveSerSong {

	public static void main(String[] args) throws IOException {
		SerSong song1 = new SerSong("Penny Lane", 2, 57);

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				"song.dat"));
		out.writeObject(song1);
		out.close();
	}
}
