package mainClient;

import java.awt.image.BufferedImageFilter;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import mainService.AbsService;
import mainService.AbsService1;

public class AbsDemo {

	
	public static <E> void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		AbsService1 as1=new AbsService1(10,20);
		as1.Run();
		AbsService as2=new AbsService1(100, 200);
		System.out.println(as2.start);
		as2.Run();
		//BufferedOutputStream bos=new BufferedOutputStream(new FileReader("filereaderout"));
		//BufferedWriter bw=new BufferedWriter(new FileWriter("filereaderout"));
		FileOutputStream fos=new FileOutputStream("filereaderout");
		//ObjectOutputStream oos=new Obje
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(as1);
		oos.close();
		FileInputStream fis=new FileInputStream("filereaderout");
				
	}

}
