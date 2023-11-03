package Lab_07;

public class WordCount {
	private String word;
	private int count;

	public WordCount(String word, int count) {
		this.word = word;
		this.count = count;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + word.hashCode();
		result = prime * result + count;
		return result;
	}

	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass())
			return false;
		else {
			WordCount c = (WordCount) obj;
			return this.word.equals(c.word);
		}
	}

	public String getWord() {
		return word;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String toString() {
		return word + " - " + count;
	}
}
