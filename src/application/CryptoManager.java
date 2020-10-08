/**
 * This class is CyptoManager with five declared methods for encrypting and decrypting texts based on Ceasar and Bellaso Cipher rules  
 * and one method for checking if the input text is within the bounds of ASCII characters.
 * 
 * @author Derya O. Kurin
 */

package application;

public class CryptoManager {
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {

		for(int i = 0; i < plainText.length(); i++) {
			if (plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		String result = "";
		key %= RANGE;
		int size = plainText.length();
		for (int i = 0; i < size; i++) {
			int ch = (int)plainText.charAt(i) + key;
			while(ch > UPPER_BOUND) {
				ch -= RANGE;
			}
			result += (char)ch;
		}
		return result;	
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String result = "";
		int size = plainText.length();
		
		for (int i = 0; i < size; i++) {
			int j = i % bellasoStr.length();
			int ch = plainText.charAt(i) + bellasoStr.charAt(j);
			
			while (ch > UPPER_BOUND) {
				ch -= RANGE;
			}
			result += (char)ch;
		}
		return result;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		String result = "";
		key %= RANGE;
		int size = encryptedText.length();
		for (int i = 0; i < size; i++) {
			int ch = (char)(encryptedText.charAt(i) - key);
			while (ch < LOWER_BOUND) {
				ch += RANGE;
			}
			result += (char)ch;
		}
		return result;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String result = "";
		int size = encryptedText.length();
		
		for (int i = 0; i < size; i++) {
			int j = i % bellasoStr.length();
			int ch = encryptedText.charAt(i) - bellasoStr.charAt(j);
			
			while (ch < LOWER_BOUND) {
				ch += RANGE;
			}
			result += (char)ch;
		}
		return result;
	}

}
