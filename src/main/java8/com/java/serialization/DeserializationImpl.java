package com.java.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationImpl {
	public static void main(String... strings) {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("abc.txt"));
			Employee e1 = (Employee) in.readObject();
			Employee e2 = (Employee) in.readObject();
			System.out.println(e1.getName());
			System.out.println(e2.getName());
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
