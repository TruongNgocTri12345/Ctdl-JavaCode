package Lab_01;

import java.util.Scanner;
public class Task4 {

	    private int n; // shift steps (right shift)

	    public Task4(int shiftSteps) {
	        this.n = shiftSteps;
	    }

	    // Encrypt a character according to the given shift steps.
	    public char encryptChar(char c) {
	        if (Character.isLetter(c)) {
	            char base = Character.isUpperCase(c) ? 'A' : 'a';
	            int index = (c - base + n) % 26;
	            if (index < 0) {
	                index += 26;
	            }
	            return (char) (base + index);
	        } else {
	            return c; // Keep non-letter characters unchanged
	        }
	    }

	    // Encrypt a text using the above function for encrypting a character.
	    public String encrypt(String input) {
	        StringBuilder result = new StringBuilder();
	        for (int i = 0; i < input.length(); i++) {
	            char ch = input.charAt(i);
	            result.append(encryptChar(ch));
	        }
	        return result.toString();
	    }

	    // Decrypt a character according to the given shift steps.
	    public char decryptChar(char c) {
	        if (Character.isLetter(c)) {
	            char base = Character.isUpperCase(c) ? 'A' : 'a';
	            int index = (c - base - n) % 26;
	            if (index < 0) {
	                index += 26;
	            }
	            return (char) (base + index);
	        } else {
	            return c; // Keep non-letter characters unchanged
	        }
	    }

	    // Decrypt an encrypted text using the above function for decrypting a character.
	    public String decrypt(String input) {
	        StringBuilder result = new StringBuilder();
	        for (int i = 0; i < input.length(); i++) {
	            char ch = input.charAt(i);
	            result.append(decryptChar(ch));
	        }
	        return result.toString();
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter text to encrypt: ");
	        String inputText = scanner.nextLine();

	        Task4 caesar = new Task4(3); // Example: shift 3 steps

	        // Encrypt the input text
	        String encryptedText = caesar.encrypt(inputText);
	        System.out.println("Encrypted Text: " + encryptedText);

	        // Decrypt the encrypted text
	        String decryptedText = caesar.decrypt(encryptedText);
	        System.out.println("Decrypted Text: " + decryptedText);

	        scanner.close();
	    }
}



