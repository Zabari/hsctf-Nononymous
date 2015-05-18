import java.util.*;
public class Beer2{
    public static long start = 358000000L * 7000000000L;

    public static void main(String[] args) {
	long m = 1583035059L; // square marker
	long n = 2238749651L; // summation marker
	while(true){
	    long square = m*m;
	    long sum = n*(n+1) / 2;
	    if(square == sum){
		System.out.println(m*m + "DONE");
	    }else if(square > sum){
		n++;
	    }else{
		m++;
	    }
		
	}
    }
}
