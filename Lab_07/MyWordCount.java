package Lab_07;

import java.util.*;
import java.io.*;

public class MyWordCount {
	public static final String fileName = "data/fit.txt"; // Change to your file path

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWord(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<WordCount> getWordCounts() {
		List<WordCount> re = new ArrayList<>();
		for (String w : words) {
			WordCount wc = new WordCount(w, count(w));
			if (!re.contains(wc)) {
				re.add(wc);
			}

		}
		return re;
	}

	private int count(String w) {
		int count = 0;
		for (int i = 0; i < words.size(); i++) {
			if (w.equals(words.get(i)))
				count++;
		}
		return count;
	}

	public Set<String> getUniqueWords() {
		Set<String> re = new HashSet<>();
		for (WordCount wc : getWordCounts()) {
			if (wc.getCount() == 1) {
				re.add(wc.getWord());
			}

		}
		return re;
	}

	public Set<String> getDistinctWords() {
		Set<String> re = new HashSet<>();
		for (WordCount wc : getWordCounts()) {
			if (wc.getCount() > 1) {
				re.add(wc.getWord());
			}

		}
		return re;
	}

	public Set<WordCount> exportWordCounts() {
		Set<WordCount> re = new TreeSet<>(new Comparator<WordCount>() {
			public int compare(WordCount wc1, WordCount wc2) {
				int re = wc1.getCount() - wc2.getCount();
				if (re == 0)
					return wc1.getWord().compareTo(wc2.getWord());
				return re;
			}
		});
		re.addAll(this.getWordCounts());
		return re;
	}

	public Set<WordCount> exportWordCountsOrderByOccurrence() {
		Set<WordCount> re = new TreeSet<>(new Comparator<WordCount>() {
			public int compare(WordCount wc1, WordCount wc2) {
				int re = -(wc1.getCount() - wc2.getCount());
				if (re == 0)
					return wc1.getWord().compareTo(wc2.getWord());
				return re;
			}
		});
		re.addAll(this.getWordCounts());
		return re;
	}

	public Set<WordCount> filterWords(String pattern) {
		Set<WordCount> re = new TreeSet<>(new Comparator<WordCount>() {
			public int compare(WordCount wc1, WordCount wc2) {
				int re = wc1.getCount() - wc2.getCount();
				if (re == 0) {
					return wc1.getWord().compareTo(wc2.getWord());
				}
				return re;
			}
		});

		for (WordCount wordCount : getWordCounts()) {
			if (!wordCount.getWord().startsWith(pattern)) {
				re.add(wordCount);
			}
		}

		return re;
	}

	public static void main(String[] args) {
		MyWordCount wordCounter = new MyWordCount();

		System.out.println("Word Counts: " + wordCounter.getWordCounts());
		// Get Unique Words
		System.out.println("Unique Words: " + wordCounter.getUniqueWords());

		// Get Distinct Words
		System.out.println("Distinct Words: " + wordCounter.getDistinctWords());

		// Export Word Counts
		System.out.println("exportWordCounts: " + wordCounter.exportWordCounts());

		// Export Word Counts Ordered by Occurrence
		System.out.println("exportWordCountsOrderByOccurrence: " + wordCounter.exportWordCountsOrderByOccurrence());

		// Filter Words
		String pattern = "L";
		System.out.println("Words filtered by pattern '" + pattern + "': " + wordCounter.filterWords(pattern));
	}
}
