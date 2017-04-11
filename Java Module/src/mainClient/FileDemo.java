package mainClient;
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class FileDemo {

	public static void main(String[] args) throws IOException{
		
		/*FileInputStream fin=new FileInputStream("C:\\Users\\ee206105\\workspace\\Java Module\\bin\\filereaderin.txt");
		FileInputStream fin1=new FileInputStream("filereaderin");
		*/
		BufferedReader br=new BufferedReader(new FileReader("filereaderin"));
		PrintWriter pr= new PrintWriter("filereaderout");
		/*FileOutputStream fout=new FileOutputStream("C:\\Users\\ee206105\\workspace\\Java Module\\bin\\filereaderout.txt");
		FileOutputStream fout1=new FileOutputStream("filereaderout");*/
		try{
			int c; // Can be used only for the reading the characters, bytes
			String l; 	// Can be used for reading the characters as a single line.
			
			/*while((c=fin1.read())!=-1){
				fout1.write(c);
			}*/
	/*		while((l=br.readLine())!=null){
				pr.println(l);
			}*/
			Scanner s=new Scanner(new BufferedReader(new FileReader("filereaderin")));
			while(s.hasNext()){
				System.out.println(s.nextLine());
			}
			Scanner s1=new Scanner(System.in);
			String ss=s1.next();
			System.out.println(ss);
			/*System.out.println();
			System.out.println(pr.getClass());
			System.out.println(pr.append(" File Operation ", 0, 12));*/
			Console c1=System.console();
			if(c1==null){
				System.err.println("No Console");
				System.exit(1);
			}
			String user=c1.readLine();
			System.out.println(user);
			//char [] pass=c1.readPassword("Enter Your Password");
			
			
			
			
			/*if(fout1.getChannel().isOpen())
					fout1.close();*/
			
			//System.out.println();
		}
		finally{
			
			if(br!=null){
				br.close();
			}
			if(pr!=null){
				pr.close();
			}
		}
}
}