package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class AESCipher {

	public static final String ALGORITHM = "AES";
	public static final String TRANSFORMATION = "AES";

	public static void encrypt(String key, File inputFile, File outputFile) throws InvalidKeyException {

            try {
                crypter(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
            } catch (Exception ex) {
            }
	}

	public static void decrypt(String key, File inputFile, File outputFile) throws Exception {

		crypter(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
	}

	private static void crypter(int cipherMode, String key, File inputFile,
			File outputFile) throws Exception {

		byte[] b;
		try {
			b = key.getBytes("UTF-8");
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			b = sha.digest(b);
			b = Arrays.copyOf(b, 16);		//da bi bilo 64b
			worker(cipherMode, b, inputFile, outputFile);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}

	private static void worker(int cipherMode, byte[] key, File inputFile,
			File outputFile) throws Exception {

		
			Key secretKey = new SecretKeySpec(key, ALGORITHM);
			Cipher cipher;
			cipher = Cipher.getInstance(TRANSFORMATION);
			cipher.init(cipherMode, secretKey);

			FileInputStream inputStream = new FileInputStream(inputFile);
			byte[] inputBytes = new byte[(int) inputFile.length()];
			inputStream.read(inputBytes);

			byte[] outputBytes = cipher.doFinal(inputBytes);
                        inputStream.close();
                        
			FileOutputStream outputStream = new FileOutputStream(outputFile, false);
			outputStream.write(outputBytes);

			outputStream.close();
		 

	}

}
