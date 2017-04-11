package mainClient;

class WildAnimal {
	public String willYouBite(){
		return "Yes";
	}
}
 
class Lion extends WildAnimal {
	public String whoAreYou() {
		return "Lion";
	}
}

class BengalTiger extends WildAnimal {
	public String whoAreYou() {
		return "Bengal Tiger";
	}
}
 
class Zoo {
	// Return a new Class Object as a value. 
     WildAnimal getWildAnimal() {
         return new WildAnimal();
     }
 }
 
class AfricaZoo extends Zoo {
     @Override
  // Return a new Class Object as a value.
   // Lion is subClass of Wild Animal
     Lion getWildAnimal() {
         return new Lion();
     }
}

class IndiaZoo extends Zoo {
     @Override
     //Return a new Class Object as a value.
     // Lion is subClass of Wild Animal
     BengalTiger getWildAnimal() {
         return new BengalTiger();
     }
}

public class Covariant {
	public static void main(String args[]){
		AfricaZoo afZoo = new AfricaZoo();
		System.out.println(afZoo.getWildAnimal().whoAreYou());
		IndiaZoo inZoo = new IndiaZoo();
		System.out.println(inZoo.getWildAnimal().whoAreYou());
		Object obj=new Object();
		System.out.println(obj.toString());
		
	}
}


