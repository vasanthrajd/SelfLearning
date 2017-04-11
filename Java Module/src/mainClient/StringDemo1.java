package mainClient;

import java.util.StringTokenizer;

public class StringDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		System.out.println("~~~~~~~~~~~~~~~~~~~STRING's Alone~~~~~~~~~~~~~~");
			
		String a="vasanth";
		String b=new String("vasanthraj");
		String a2="vasa";
		char[] c={'v','a','s','a','n','t','h'};
		
		CharSequence a1="ab"; 
		StringBuffer b1=new StringBuffer("raj");
		Object o1="vasanth";
		/* 
		 * We can't give the character as a separate format. so we need to make it in char [];
		 * Not like this String c={'v','a','s','a','n','t','h'}; 
		 */
		/*
		System.out.println("1="+a.charAt(4));
		
		System.out.println("2="+a.codePointAt(4));
		System.out.println("3="+a.codePointBefore(4));
		System.out.println("4="+a.codePointCount(2, 5));
		System.out.println("5="+a.compareTo("vasnth"));
		System.out.println("6="+a.compareToIgnoreCase("VASANTH"));
		System.out.println("7="+a.concat("Java"));
		System.out.println("8="+a.contains(a1));
		System.out.println("9="+a.contentEquals(a1));
		System.out.println("10="+a.contentEquals(b1));
		System.out.println("11="+a.endsWith("j"));
		System.out.println("12="+a.equals(o1));
		System.out.println("13="+a.equalsIgnoreCase("VASANTH"));
		System.out.println("14="+a.hashCode());
		System.out.println("15="+a.indexOf(2));
		System.out.println("16="+a.indexOf('a'));
		System.out.println("17="+a.indexOf(1, 4));
		System.out.println("18="+a.indexOf('a', 'h'));
		System.out.println("19="+a.intern());
		System.out.println("20="+a.isEmpty());
		System.out.println("21="+a.lastIndexOf(5));
		System.out.println("22="+a.lastIndexOf('a'));
		System.out.println("23="+a.lastIndexOf(1, 4));
		System.out.println("24="+a.lastIndexOf('a', 'h'));
		System.out.println("25="+a.length());
		System.out.println("26="+a.matches(b));
		System.out.println("27="+a.offsetByCodePoints(1, 4));
		//a=
		System.out.println("28="+a.replace('a','b'));
		
		System.out.println(a);
		System.out.println("29="+a.replaceAll(a, b));
		
		System.out.println("30="+a.substring(2));
		System.out.println("31="+a.substring(2, 5));
		System.out.println("32="+a.split("vasa"));		// Doubt in this function
		/* 
		 * The above function will return the array of string as a result,
		 * The above line returns the result but with location of the result
		 */
		/*
		System.out.println("33="+a.split("vasa", 1));		
		System.out.println("34="+a.subSequence(4, 6));
		
		System.out.println("35="+a.toCharArray());
		System.out.println("36="+b.toLowerCase());
		System.out.println("37="+a.trim());
		
		System.out.println(b.replace('a', 'b'));
		*/
		/* 
		 *   Reason why String is IMMUTABLE
		 *   1.String has been widely used as parameter for many Java classes 
		 *   e.g. for opening network connection, you can pass hostname and port number as string ,
		 *   you can pass database URL as string for opening database connection, 
		 *   you can open any file in Java by passing name of file as argument to File I/O classes.
		 *   
		 *   2.In case, if String is not immutable, this would lead serious security threat , 
		 *   I mean some one can access to any file for which he has authorization, 
		 *   and then can change the file name either deliberately or accidentally and gain access
		 *   of those file. Because of immutability, you don't need to worry about those kind 
		 *   of threats. This reason also gel with, Why String is final in Java, 
		 *   by making java.lang.String final, Java designer ensured that no one overrides 
		 *   any behavior of String class.
		 *   
		 *   3.Since String is immutable it can /safely shared between many threads ,
		 *   which is very important for multithreaded programming and to avoid any 
		 *   synchronization issues in Java, Immutability also makes String instance 
		 *   thread-safe in Java, means you don't need to synchronize String operation externally.
		 *   Another important point to note about String is memory leak caused by SubString, 
		 *   which is not a thread related issues but something to be aware of.
		 *   
		 *   4. The absolutely most important reason that String is immutable is that 
		 *   it is used by the class loading mechanism, and thus have profound and 
		 *   fundamental security aspects. Had String been mutable, a request to load 
		 *   "java.io.Writer" could have been changed to load "mil.vogoon.DiskErasingWriter"
		 *   
		 *  <<<<<<<<<  Test for the String to be immutale >>>>>>>>>
		 *  
		 *  Above is the example in which the String's are being replaced
		 *  First b.replace('a','b') will produce the Temporary Results,  So that you can feel the 
		 *  difference in while printing the character.
		 *  
		 *  Secondly in the case if you do  b=b.replace('a', 'b'); in this case, 
		 *  you are totally modifying the value's for the Object B itself;
		 * 
		 */
			
		//b=b.replace('a', 'b');
/*		System.out.println(b);
		
		*/
		/*
		StringBuffer b1=new StringBuffer("raj");
		String a="vasanth";
		char[] c={'v','a','s','a','n','t','h'};
		CharSequence a1="ab";
		Object o1="vasanth";
		
		System.out.println("Concatenation by + operator="+a+"raj");
		System.out.println("~~~~~~~~String Buffer~~~~~~~~~");

		System.out.println("Replace value= "+b1.replace(2, 7, "velu"));
		System.out.println("Original Value ="+ b1);
		
		System.out.println("Append Function "+ b1.append(a));	
		System.out.println("Append Function 1"+ b1.capacity());
		System.out.println("Append Function 2"+b1.append(c));
		System.out.println("Append Function 3"+b1.append(a1));
		System.out.println("Append Function 4"+b1.append(o1));
		System.out.println("Append Function 5"+b1.append(b1));
		System.out.println("Append Function 6"+b1.append(b1));
		System.out.println("Append Function 7"+b1.append(a1, 0,2));
		System.out.println("Append Function 8"+b1.appendCodePoint(5));
		
		
		System.out.println(b1.reverse());
		//System.out.println(b1.trimToSize());
		
		StringTokenizer s= new StringTokenizer("Hai , how , are you? what you are doing");
		while(s.hasMoreTokens()){
			System.out.println(s.nextToken("?"));
		}
//		while(s.hasMoreElements()){
		while(s.hasMoreElements()){
			//System.out.println(s.nextToken(","));
			System.out.println(s.nextToken(","));
		}
		
		
		Integer i=new Integer(100);
		System.out.println("1 ="+ i.byteValue());
		System.out.println("2="+i.compareTo(1000));
		
		System.out.println("2="+i.doubleValue());
		System.out.println("2="+i.floatValue());
		System.out.println("2="+i.hashCode());
		System.out.println("2="+i.longValue());
		String i1=i.toString();
		System.out.println("2="+i1.charAt(1));
		
		*/
		/*
		Character c1=new Character('a');
		
		char[] c2= {'a','b','c','d'};
		*/
	   
		
	//	StringBuffer s1=new StringBuffer("Velusamy");
	//	s1="vasanth";
	//	System.out.println(s1.replace(1, 6, "a"));
	//	System.out.println(s1);
		
		final StringBuffer s1=new StringBuffer("v");
		System.out.println(s1.replace(1,5,"b"));
		System.out.println(s1);
		
		System.out.println(s1.capacity());
		System.out.println(s1.append("vasan"));
		System.out.println(s1.capacity());
		s1.ensureCapacity(22);
		System.out.println(s1.capacity());
		s1.setLength(6);
		System.out.println(s1);
		System.out.println(s1.capacity());
		
		char[] a1=new char[10];
		char[] b1={'v','s','n','t','h'};
		char[] c1=new char[1];
		int [] i1={65,67,69,16};
		int [] i2=new int[4];
		
		System.out.println("Char to String"+ new String(b1));
		
		char [] j={65,67,69,16};
		
		System.out.println(c1.length);
		s1.getChars(0, 5, a1, 1);
		System.out.println(a1);
		
		System.out.println(c1);
		System.out.println(c1.length);
		s1.getChars(0, c1.length, c1, (c1.length-1));
		System.out.println(c1);
		
		String s3="Hello";
		System.out.println(s3+"world");
		System.out.println(s3);
		System.out.println(s3.concat("world"));
		System.out.println(s3);
		String s4=new String(i1, 0, 3);
		System.out.println(s4);
		
		
		Integer i3=24;
		String age=i3.toString();
		System.out.println(age);
		age=age.valueOf(i3);
		System.out.println(age);
		
		Integer [] i4=new Integer[10];
		String s5=new String();
		String string=String.valueOf(b1, 1, 4);
		System.out.println(string);
		System.out.println(string.codePointBefore(2));
		
		StringBuilder str=new StringBuilder("vasanth");
		
				
		
		String word=new String("Java is a Programming Languaage");
		//char temp[]=word.toCharArray();
		String words[]=word.split(" ");
		int count=0;
		int len=words.length;
			
		for(int i=0;i<words.length;i++){
			for(int v=0;v<i;v++){
				
			}
			
		}
		/*for(int i=0;i<temp.length;i++){
			if(temp[i]=='A' || temp[i]=='a'){
				count++;
			}
		}
		System.out.println("Number of the Character in the Word="+word+"is"+count);
		*/
		
		
		
		
		
	

	}

}

