package Lab_01;

public class Task3 {
	    private int n; // So buoc dich(dich sang phai)

	    public Task3(int shiftSteps) {
	        this.n = shiftSteps;
	    }

	    // Ma hoa theo buoc dich chuyen da cho
	    public char encryptChar(char c) {
	        if (Character.isLetter(c)) { // kiem tra xem c co phai ki tu chu
	            char base = Character.isUpperCase(c) ? 'A' : 'a';  // if true base='A' else ='a'
	            int index = (c - base + n) % 26;
	            if (index < 0) {
	                index += 26;
	            }
	            return (char) (base + index);
	        } else {
	            return c; // Giu nguyen cac ki tu khong phai chu cai
	        }
	    }

	    // Ma hoa van ban.
	    public String encrypt(String input) {
	        String result = "";
			if (input.trim().equals("")) {
				return result;
			}

			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				result += encryptChar(ch);
			}
			return result;
		}

	    //Giai ma theo buoc dich chuyen da cho
	    public char decryptChar(char c) {
	        if (Character.isLetter(c)) {
	            char base = Character.isUpperCase(c) ? 'A' : 'a';
	            int index = (c - base - n) % 26;
	            if (index < 0) {
	                index += 26;
	            }
	            return (char) (base + index);
	        } else {
	            return c; 
	        }
	        
	    }

	    // Giai ma van ban
	    public String decrypt(String input) {
	        String result = "";
			if (input.trim().equals("")) {
				return result;
			}

			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				result += decryptChar(ch);
			}
			return result;
	    }

	    public static void main(String[] args) {
	    	Task3 caesar = new Task3(3); 

	        String originalText = "Hello, World! 123";
	        System.out.println("Original Text: " + originalText);
	        
	        String encryptedText = caesar.encrypt(originalText);
	        System.out.println("Encrypted Text: " + encryptedText);

	        String decryptedText = caesar.decrypt(encryptedText);
	        System.out.println("Decrypted Text: " + decryptedText);
	    }
	}




