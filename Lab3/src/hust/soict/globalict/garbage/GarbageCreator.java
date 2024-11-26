package hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {

	public static void main(String[] args) {
		String filePath = "";
		byte[] inputBytes = { 0 };
		long start, end;

		try {
			inputBytes = Files.readAllBytes(Paths.get(filePath));
			start = System.currentTimeMillis();
			String outputString = "";
			for (byte b : inputBytes) {
				outputString += (char) b;
			}
			end = System.currentTimeMillis();
			System.out.println(end - start);

			start = System.currentTimeMillis();
			StringBuilder outputStringBuilder = new StringBuilder();
			for (byte b : inputBytes) {
				outputStringBuilder.append((char) b);
			}
			end = System.currentTimeMillis();
			System.out.println(end - start);
		} catch (IOException e) {
			System.err.println("No such file.");
		}
	}

}
