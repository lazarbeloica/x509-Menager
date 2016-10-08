package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.KeyStore;
import java.util.HashMap;

import keystores.LocalKeyPairStore;

//ovde se vodi evidencija svih potpisanih kljuceva
public class SignedCerts implements Serializable {

	static final String PATH = ".\\keys\\signedList.dat";
	static final String DIR = ".\\keys";

	static HashMap<String, String> map = null;

	static KeyStore ks = LocalKeyPairStore.getIstance();

	public static void init() {
		if (map == null) {
			Serializer ser = null;
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(PATH);
				ObjectInputStream ois = new ObjectInputStream(fis);
				ser = (Serializer) ois.readObject();
			} catch (FileNotFoundException e) {

				File dir = new File(DIR);
				if (!dir.exists()) {
					try {
						dir.mkdir();
					} catch (SecurityException se) {
						se.printStackTrace();
					}
				}

				File file = new File(PATH);

				ser = new Serializer();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				ser = new Serializer();
			}

			map = (HashMap<String, String>) ser.getObj();
		}
		
		if(map == null)
			map = new HashMap<String, String>();
		
	}

	public static void save() {
		try {
			FileOutputStream fos = new FileOutputStream(PATH);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.reset();
			Serializer ser = new Serializer();
			ser.setObj(map);
			oos.writeObject(ser);

			oos.close();
			fos.close();

		} catch (FileNotFoundException e) {
			File dir = new File(DIR);
			if (!dir.exists()) {
				try {
					dir.mkdir();
				} catch (SecurityException se) {
					se.printStackTrace();
				}
			}

			File file = new File(PATH);

			FileOutputStream fos;
			try {
				fos = new FileOutputStream(PATH);

				ObjectOutputStream oos = new ObjectOutputStream(fos);

				Serializer ser = new Serializer();
				ser.setObj(map);
				oos.writeObject(ser);

				oos.close();
				fos.close();

			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void addCert(String alias) {
		init();
		map.put(alias, alias);
		save();
	}

	public static String takeCert(String alias) {
		String res = map.remove(alias);
		if (res != null)
			save();
		return res;
	}

	public static String getCert(String alias) {
		init();
		return map.get(alias);
	}

	public static boolean chekCert(String alias) {
		init();
		return map.get(alias) == null ? false : true;
	}
}
