

import javax.crypto.*;
import java.security.*;


public class AES{
	
	/** Stores a generated DES key */
	private Key key;
	
	/**
	 *	Gets the DES Key used for the encryption
	 *	@return DES Key generated, or null if none generated
	 */
	public Key getKey(){
		return key;
	}
	
	/**
	 *	Performs encryption using DES algorithm
	 *	@param data	The data to be encrypted
	 *	@return The encrypted data, or null if enryption fails
	 */
	public byte[] encrypt(byte[] data){
		key = null;
		try{
			Security.addProvider(new com.sun.crypto.provider.SunJCE());
			KeyGenerator kg = KeyGenerator.getInstance("AES");
			Cipher cipher = Cipher.getInstance("AES");

			key = kg.generateKey();
			cipher.init(Cipher.ENCRYPT_MODE, key);
			return (cipher.doFinal(data));
		}
		catch(Exception e){return null;}
	}
	
	/**
	 *	Performs decryption using DES algorithm and a Key
	 *	@param data	The data to be decrypted
	 *	@param key	The key to be used for decryption
	 *	@return The decrypted data, or null if decryption fails
	 */
	public byte[] decrypt(byte[] data, Key key){
		try{
			Security.addProvider(new com.sun.crypto.provider.SunJCE());
			KeyGenerator kg = KeyGenerator.getInstance("AES");
			Cipher cipher = Cipher.getInstance("AES");

			cipher.init(Cipher.DECRYPT_MODE, key);
			return(cipher.doFinal(data));
		}
		catch(Exception e){return null;}
	}		
}
 
