package mainClient;

import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import mainService.MapService;

public class MapCollection {
public static  <E> void  main ( String[] args){

	// Basic usage and understanding about the Map
	/*
	Map<Integer, String> m1=new HashMap<>();
	m1.put(1001, "Student1");
	m1.put(1002, "Person1 ");
	System.out.println(m1);

	// This will list out the KEY Values of the Map. 
	Set<Integer> s1=m1.keySet();
	Iterator<Integer> i1=s1.iterator();
	while(i1.hasNext()){
		System.out.println(i1.next());
	}
	
	// This will return the values of the Map without the key.
	Collection<E> c=(Collection<E>) m1.values();
	System.out.println(c);
	
	// This will return the Key Value Pairs of the map. 
	Set s2=m1.entrySet();
	Iterator i2=s2.iterator();
	while(i2.hasNext()){
		System.out.println(i2.next());
	}*/
	/* Hash Map, 
	 * 1) Will not be in proper insertion order, 
	 * 2) allows heterogenous objects, 
	 * 3) duplicate keys are not allowed
	 * 4) Null Key is allowed only once. 
	 * 5) It is not synchornized
	 */
	Map<Integer, E> m1=new HashMap<>();
	m1.put(9001, (E) new MapService(91010,"Zebron", "Savings", 23594));
	m1.put(9007, (E) new MapService(91234,"Phoneix", "Current", 123594));
	m1.put(8001, (E) new MapService(80012,"Whoom", "Savings", 7979));
//	m1.put(null, (E) new MapService(8003,"Whoom", "Savings", 7979));
//	m1.put(null, null);
	
	/* Below method will return the entire Map as a set.
	Set s1=m1.entrySet();
	System.out.println(s1);*/
	
	/*
	 * Below method is by retrieving the contents of the key first and then retrieving the
	 * values of those keys separately
	 *
	
	Set s2=m1.keySet();
	System.out.println(s2);
	Iterator<E> it1=s2.iterator();
	while(it1.hasNext()){
		Object o=it1.next();
		Object o1=m1.get(o);
		System.out.println("The  Key is "+o+" Values of the Key="+o1);
	}*/
	
	/* Retrieving the values from the maps
	 * 
	 *
	 Collection<E> c=m1.values();
	 System.out.println("Collections"+c);
	 */
	/* Entry Set
	 * The below will list out the contents of Map as a Key and Value Pair
	 *
	Set s3=m1.entrySet();
	Iterator<E> it2=s3.iterator();
	while(it2.hasNext()){
		Map.Entry map=(Entry) it2.next();
		System.out.println(" The Key Value ="+map.getKey() + " The Values are "+map.getValue());
	}*/
	Set s3=m1.entrySet();
	Iterator<E> it2=s3.iterator();
	while(it2.hasNext()){
		
		Map.Entry map=(Entry) it2.next();
		System.out.println(" The Key Value ="+map.getKey() + " The Values are "+map.getValue());
		
	}
	Map<Integer, E> m2=new Hashtable<>(m1);
	Enumeration<E> e=(Enumeration<E>) m2.keySet();
	while(e.hasMoreElements()){
		System.out.println(e.nextElement());
	}
 }
}
