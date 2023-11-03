package Lab_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
	public static List<String> loadWord(String fileName) throws FileNotFoundException {
		List<String> words = new ArrayList<String>();
		Scanner input = new Scanner(new File(fileName));

		while (input.hasNext()) {
			String word = input.next();
			words.add(word);
		}
		return words;
	}

}
