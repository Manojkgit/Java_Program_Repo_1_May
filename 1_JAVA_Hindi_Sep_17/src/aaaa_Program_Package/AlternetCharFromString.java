package aaaa_Program_Package;

public class AlternetCharFromString {

	public static void main(String[] args) {
	   
		int n[]={2,4,21,5,3,23,62,345,1};
		int temp=0;
		for(int i=0;i<n.length;i++){
			for(int j=i+1;j<n.length;j++){
		       if(n[i]>n[j]){
		    	   temp=n[i];
		    	   n[i]=n[j];
		    	   n[j]=temp;
		       }
		       }
			System.out.println(n[i]);
			
		}
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		int n11=0,n22=1,n33;
		System.out.print(n11+" "+n22);
		for(int i=0;i<10;i++){
			n33=n11+n22;
			System.out.print(" "+n33);
			n11=n22;
			n22=n33;
		}
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    String s="manoj kushwaha";
    char[] c=s.toCharArray();
    for(int i=0;i<c.length;i+=2){
    	System.out.print(c[i]+ " ");
    }
		
		/*	String s="manoj kushwaha";
		char[] c=s.toCharArray();
		//Count the Character in String ----
		System.out.println(c.length);
		
		// Alternate Charater from String ---
		for(int i=0;i<c.length;i+=2){
			System.out.println(c[i]);
		}
		
		//Reverse the Character in String ---
		StringBuffer sb=new StringBuffer(s);
		System.out.println(sb.reverse());
		
		 
		int l=s.length()-1;
		for(int i=l;i>=0;i--){
			System.out.print(c[i]);
		}
		
		System.out.println("((((((((((((((((((((((((((((((((((((((");
		int n=12345; int rev=0;
		while(n!=0){
			rev=rev*10+n%10;
			n=n/10;
		}
		System.out.println(rev);
		String num=String.valueOf(rev);
		StringBuffer sb_number=new StringBuffer(num);
		System.out.println(sb_number.reverse());
	*/	givenNumberIsPrime(17);
		//fabo(10);
		printAllPrimeNumber(17);
		
		System.out.println("***************************");
		printPrime(17);
	}
	
	public static void fabo(int n){
		int n1=0,n2=1,n3;
		System.out.print(n1+" "+n2);
		for(int i=0;i<n;i++){
			n3=n1+n2;
			System.out.print(" "+n3);
			n1=n2;n2=n3;
		}
	}
	
	public static void givenNumberIsPrime(int n){
		boolean isP=true;
		for(int i=2;i<n/2;i++){
			if(n%i==0){
				isP=false;
				break;
			}
		}if(isP){
			System.out.println("Number is Prime");
		}else{
			System.out.println("Number is  NOt Prime");
		}
	}
	
	public static void printPrime(int n){
	for(int i=2;i<=n;i++){
		   boolean is=true;
		   for(int j=2;j<i;j++){
		   if(i%j==0){
				 is=false;
			     break;
  	          }
	   }
		   if(is){
			   System.out.println(i+"  --  "+"Prime");
		   }
	}
}
	
	public static void printAllPrimeNumber(int n){
	  for(int i=2;i<n;i++){
		  boolean isP=true;
		  for(int j=2;j<i;j++){
			  if(i%j==0){
				  isP=false;
				  break;
			  }
		  }if(isP){
			  System.out.println(i);
		  }
	  }
	}
}
