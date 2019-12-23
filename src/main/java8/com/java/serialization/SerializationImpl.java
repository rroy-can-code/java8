package com.java.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializationImpl {
	public static void main(String... strings) {
		try {
			Employee e1 = new Employee(1, "ABC");
			Employee e2 = new Employee(2, "DEF");
			FileOutputStream fos = new FileOutputStream("abc.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(e1);
			oos.writeObject(e2);
			oos.flush();
			oos.close();
			System.out.println("Done");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
