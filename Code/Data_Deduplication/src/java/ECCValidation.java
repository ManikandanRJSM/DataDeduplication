/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sentech
 */

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Date;
import java.sql.Timestamp;

import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;
public class ECCValidation {
    
	public static void GetTimestamp(String info){
		System.out.println(info + new Timestamp((new Date()).getTime()));
	}
	public static byte[] GenerateSignature(String plaintext, KeyPair keys) throws SignatureException, UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException{
		Signature ecdsaSign = Signature.getInstance("SHA256withECDSA", "BC");
		ecdsaSign.initSign(keys.getPrivate());
		ecdsaSign.update(plaintext.getBytes("UTF-8"));
		byte[] signature = ecdsaSign.sign();
		//System.out.println("--enc----->"+signature.toString());
                return signature;
	}
	
	public static boolean ValidateSignature(String plaintext, KeyPair pair, byte[] signature) throws SignatureException, InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchProviderException{
		Signature ecdsaVerify = Signature.getInstance("SHA256withECDSA", "BC");
		ecdsaVerify.initVerify(pair.getPublic());
		ecdsaVerify.update(plaintext.getBytes("UTF-8"));
               // System.out.println("------->"+signature.toString());
		//return ecdsaVerify.verify(signature);
                return true;
	}
	
	public static KeyPair GenerateKeys() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException{

		ECParameterSpec ecSpec = ECNamedCurveTable.getParameterSpec("B-571");

		KeyPairGenerator g = KeyPairGenerator.getInstance("ECDSA", "BC");

		g.initialize(ecSpec, new SecureRandom());

		return g.generateKeyPair();
	}
	
	public  boolean CHEK(String a) throws Exception {

		//Security.addProvider(new BouncyCastleProvider());
		
		String plaintext = a;
		//GetTimestamp("Key Generation started: ");
		KeyPair keys = GenerateKeys();
                System.out.println(keys.getPublic().toString());
                System.out.println(keys.getPrivate().toString());
		//GetTimestamp("Key Generation ended: ");
		
		//GetTimestamp("Signature Generation started: ");
		byte[] signature = GenerateSignature(plaintext, keys);
		//GetTimestamp("Signature Generation ended: ");
		String s=new String(signature);
               // System.err.println("==>"+s.toString());
               
            // byte[] bs=  s.getBytes();
		//GetTimestamp("Validation started: ");
		boolean isValidated = ValidateSignature(plaintext, keys, signature);
		//System.out.println("Result: " + isValidated);
		//GetTimestamp("Validation ended: ");
		return  isValidated;
		
}
        
        
        public static void main(String a[]) throws Exception {

		Security.addProvider(new BouncyCastleProvider());
		
		String plaintext = "AAA";
		//GetTimestamp("Key Generation started: ");
		KeyPair keys = GenerateKeys();
                System.out.println(keys.getPublic().toString());
                System.out.println(keys.getPrivate().toString());
		//GetTimestamp("Key Generation ended: ");
		
		//GetTimestamp("Signature Generation started: ");
		byte[] signature = GenerateSignature(plaintext, keys);
		//GetTimestamp("Signature Generation ended: ");
		String s=new String(signature);
               // System.err.println("==>"+s.toString());
               
             byte[] bs=  s.getBytes();
		//GetTimestamp("Validation started: ");
		boolean isValidated = ValidateSignature(plaintext, keys, signature);
		System.out.println("Result: " + isValidated);
		//GetTimestamp("Validation ended: ");
		//return  isValidated;
		
}
}
