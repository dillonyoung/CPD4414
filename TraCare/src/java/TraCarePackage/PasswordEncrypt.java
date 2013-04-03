package TraCarePackage;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Dillon
 */
public class PasswordEncrypt {

    /**
     * Generate a hash string for a password
     * @param input The string to be hashed
     * @return Returns the new hash string
     */
    public static String generateHash(String input) {
        
        // Declare variables
        StringBuilder hash = new StringBuilder();

        // Attempt to generate the hashed string
        try {
            
            // Get the hashed version of the string
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] hashedBytes = sha.digest(input.getBytes());
            
            // Convert the string
            char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'};
            for (int idx = 0; idx < hashedBytes.length; idx++) {
                byte b = hashedBytes[idx];
                hash.append(digits[(b & 0xf0) >> 4]);
                hash.append(digits[b & 0x0f]);
            }
        } catch (NoSuchAlgorithmException e) {
            // handle error here.
        }

        // Return the hashed string
        return hash.toString();
    }
}
