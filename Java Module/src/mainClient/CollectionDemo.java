package mainClient;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NavigableMap;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

import mainService.CollectionService;
import mainService.CollectionService1;
import mainService.JobProfile;
import mainService.salaryComparator;

public class CollectionDemo {

	public static <E> void main(String[] args) {
		// TODO Auto-generated method stub
		/*ArrayList<E> ar1=new ArrayList<>();
		ArrayList<E> ar2=new ArrayList<>(10);
		ArrayList<E> ar3=(ArrayList<E>) new ArrayList<>(ar1);
		Vector<Integer> v1=new Vector<>();
		List<E> lst=(List<E>) Collections.synchronizedList(ar1);
		
		
		List<Integer> l1= new ArrayList<Integer>();
		LinkedList<E> ll1=new LinkedList<>();
		int i=0;
		for(i=0;i<10;i++){
			l1.add(i);
		}
	/*	Enumeration<E> e=(Enumeration<E>) v1.elements();
		while(e.hasMoreElements())
		{
		System.out.println(e.nextElement());
		}*/
		
		
	/*	Iterator<E> itr= ar1.iterator();
	 * while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		}
		HashSet<E> h1=new HashSet<>();
		Iterator<E> itr1=h1.iterator();*/
		
		
		/*
		 * Data Structure in List
		 * 
		 * 1. Array List with Example of Specific Object, here we have the example of adding
		 * 	  Integer Value. ( Like wise we can specify anytime of specific object )
		 *  
		 *  	List<Integer> l1=new ArrayList<>();
		 *  
		 * 2. If we want to add heterogenous element then we need to go for the concept of generics
		 * 
		 */
		/* ArrayList l1=new ArrayList();
		
		int i=0;
		for(;i<10;i++){
			if(i%2==0){
				l1.add("a");
			}else{
				l1.add(i);
			}
		}
		
		Iterator it1=l1.iterator(); */
		/*
		 * When using Iterator to travese the any Collections it is better to opt for while 
		 * loop instead of for, reason is for loop will look for the increment portion everytime
		 * before condition checking
		 * 
		 * for(;it1.hasNext();){
				System.out.println("Odd Values="+it1.next());
		}
		*
		* We can use for each, for printing the values from collections
		*
		for (Object integer : l1) {
			System.out.println(integer);
		}*/
	/*	while(it1.hasNext()){
		System.out.println(it1.next());
		}*/
		/*
		 * Inter Operations between ArrayList, Vector and LinkedList
		 * 
		 */
		/*  l2=(LinkedList) l1.clone(); 
		 * 
		 * It is cloning of l1 (ArrayList) into Linked List which
		 * will throw runtime exception, Java.land.ClassCastException.
		 * 
		 * List l2=new LinkedList(l1);
		 * It will copy the contents from l1 to l2 by content wise, and it will be in the same
		 * order as how it added in the list l1.
		 * 
		 */
		
	//	System.out.println("Copying from one data structure to another one");
		
	/*	LinkedList l2=new LinkedList();
		String s="java";
		
		Collections.sort(l1);
		System.out.println(l1);
		Iterator it2=l2.iterator();
		while(it2.hasNext()){
			System.out.println(it2.next());
		}
		*/
	/*	
	 * Basic usage of Hash Set
	 * 
	 * HashSet h1=new HashSet();
		int j=0;
		for(;j<10;j++){
			if(j%2==0){
				h1.add(j);
			}else{
				h1.add(10);
			}
			
		}
		h1.add(null);
		Iterator it3=h1.iterator();
		while(it3.hasNext()){
			System.out.println(it3.next());
		}*/
	/*	JobProfile j1=new JobProfile("jose", "Software Engineer", 4, "Drivers", 80000);
		JobProfile j2=new JobProfile("jose", "Tech Lead", 3, "Product Designer", 90000);
		JobProfile j3=new JobProfile("johan","Designer", 6, "Front end developer",100000);
		JobProfile j4=new JobProfile("will","Product Analyst",5, "Data Analyst",75000);
		*/
		//List<JobProfile> lst=new ArrayList<JobProfile>();
		/*lst.add(j1);
		lst.add(j2);
		lst.add(j3);
		lst.add(j4);*/
		/*lst.add(new JobProfile("jose", "Tech Lead", 3, "Product Designer", 90000));
		lst.add(new JobProfile("jose", "Tech Lead", 4, "Product Designer", 90000));
		lst.add(new JobProfile("johan","Designer", 6, "Front end developer",100000));
		lst.add(new JobProfile("will","Product Analyst",5, "Data Analyst",75000));*/
			
		//l1.addAll((Collection<? extends JobProfile>) new JobProfile("jose", "Software Engineer", 4, "Drivers", 80000));
		
	/*	Iterator<JobProfile> it1=lst.iterator();
		while(it1.hasNext())
				System.out.println(it1.next());
		*/
		/*
		 * Conversion from Normal ArrayList to Hash Set runs fine, but if we convert from A.L to 
		 * Tree Set it will report error
		 * 
		 * Set<JobProfile> set1=new HashSet<JobProfile>(lst);
		Iterator<JobProfile> it2=set1.iterator();*/
		
		/*
		 * Conversion is not happening, it results in ClassCastException		 
		 * To overcome this, we need to define the compareTo method or compare method based on 
		 * business requirements,  
		 */
		
		/*Set<E> set1=new HashSet<E>((Collection <? extends E>)lst);
		// The below method will call compare method defined in the Class JobProfile
		
		Set<E> set2=new TreeSet<>(set1);
		Iterator<E> it2=set2.iterator();
	*/
		
		/*Set<E> set4=new HashSet<E>((Collection<? extends E>) lst1);
		Set<E> set5=new TreeSet<>(set4);*/
	    
		/*while(it2.hasNext()){
			System.out.println(it2.next());
		}*/
		
		/*
		 * While creating the set we can assign the contents of the set by making using of
		 * Constructor method to assign the components
		 */
		
		
		/*Set<JobProfile> set2=new LinkedHashSet<JobProfile>(lst);
		set2.addAll(lst);*/
		/*Set<JobProfile> set2=new TreeSet<JobProfile>();
		set2.addAll(set1);
							
		Iterator<JobProfile> it3=set2.iterator();
		while(it3.hasNext()){
			System.out.println(it3.next());
		}*/
		
		/*Set<JobProfile> set1=new TreeSet<JobProfile>(new salaryComparator());
		set1.addAll(lst);
		Iterator<JobProfile> it2=set1.iterator();
		while(it2.hasNext()){
			System.out.println(it2.next());
		}*/
		/*List<CollectionService1> lst1=new LinkedList<>();
		lst1.add(new CollectionService1(1010,"Jose", "Associate", 2, "Testing", 400000));
		lst1.add(new CollectionService1(1011,"Luther", "Senior Associate", 4, "Automation testing", 600000));
		lst1.add(new CollectionService1(1012,"Raymond", "Tech Lead", 4, "Product Developer", 1200000));
		lst1.add(new CollectionService1(1013,"Kenziv", "Senior Analyst", 12, "Architect", 2000000));
		*/
		/*Iterator<E> it4=(Iterator<E>) lst1.iterator();
	    while (it4.hasNext()) {
			System.out.println(it4.next());
					
		}*/
	   /* Iterator<E> it4= (Iterator<E>) lst1.iterator();
	    while (it4.hasNext()) {
			System.out.println(it4.next());
					
		} */
		/*
		 * Here first I convert A.L to Normal HashSet, then Passing that Set as a parameter to TreeSet,
		 * where it will call compareTo method which it was override in CollectionService1, results in 
		 * conversion with sorting order.
		*/
		/*Set<E> set4=new HashSet<E>((Collection<? extends E>) lst1);
		Set<E> set5=new TreeSet<>(set4);
	    Iterator<E> it4= (Iterator<E>) set5.iterator();
	    while (it4.hasNext()) {
			System.out.println(it4.next());
					
		}*/
		/*
		 * Trying to implement the hertogenous contens for the set
		 * 
		 */
		List<E> list1=new ArrayList<E>();
		list1.add((E) new JobProfile("jose", "Tech Lead", 4, "Product Designer", 90000));
		list1.add((E) new CollectionService1(1010,"Jose", "Associate", 2, "Testing", 400000));
		
		
		// **** we can sort the ArrayList by implementing the comparable interface for comparing 
		// the details with single paramter then we have to go for comparable with compareTo method
		// and if we need to sort with multiple parameters then we need to implement with comparator 
		// by overwritting the compare method.
		
		/*
		 * This will list out hetrogenous contents without any issue.
		 * 
		 * Iterator<E> itr=list1.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}*/
		
		
		Set<E> set=new HashSet<>(list1); // Conversion from A.L to Hash Set which has hetrogenous contents
		Set<E> set1=new TreeSet<>(); 
		set1.addAll(set); // This line will assign hetrogenous contents to Tree set which will report Class cast exception	
		Iterator<E> itr=set1.iterator(); 
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		
		}	
}
