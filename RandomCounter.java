// Code by CWColeman - 180409 
import java.util.*;

class RandomCounter {

	public static int[] count(int counter[]){
		// counter is set for 70 decimal places
		int i;

		counter[0]=counter[0]+1;
		//if(counter[0]> 9){counter[0]=0; counter[1]=counter[1]+1;}
		//if(counter[1]> 9){counter[1]=0; counter[2]=counter[2]+1;}
		for (i = 0; i < 70;i++ ){
			if(counter[i]> 9){counter[i]=0; counter[i+1]=counter[i+1]+1;}
		}

		return counter;
	}
	public static void printArrayRev(int rInts[]){
		int match = 0;
		for (int i = rInts.length-1; i > -1; i--){
			if ((i+1)%3==0)System.out.print(" ");
				System.out.print(rInts[i]);
			//	if ((rInts.length) % 20 == 0)
				//	System.out.println();

		}
	}
	public static void printArray(int rInts[]){
		int match = 0;
		for (int i = rInts.length-1; i > -1; i--){
				System.out.print(rInts[i]+" ");
				if ((i+1) % 20 == 0)
					System.out.println();

		}
	}
	public static int getMatches (int rInts[]){
		int match = 0;
		for (int i = 0; i < rInts.length; i++){
				//System.out.print(rInts[i]+" ");
				//if ((i+1) % 10 == 0)
					//System.out.println();
					if (rInts[i] ==i)match++;
		}
		//System.out.println("\n MATCHES : "+match+"\n");
		return match;
	}

	public static int[] swapInts(int baseInts[],int n, int last){
		int i;
		for(i = n; i < last-1; i++){
			baseInts[i] = baseInts[i+1];
			// this code moves the next to previous element in the array
			// starting with the location of n
		}
			baseInts[last-1] = -1;
		return baseInts;
	}

	public static int[] shuffle(int baseInts[],int randomInts[], int max){
		int i = 0;
		int last;
		int n;
		int temp;
		while (i < max){
			last = max-i;
			n = (int)(Math.random() *last);
			randomInts[i] = baseInts[n];
			baseInts[n] = -1;
			baseInts = swapInts(baseInts,n,last);
			i++;
		}//edn while
		return randomInts;
	}

	public static void main (String args[])throws InterruptedException{
		int i; // loop variable i
		int max = 52; // maximum number of cards
		int maxmatches = 0;
		int shortcount = 0;
		// define arrays
		int baseInts[] = new int[max];
		int randomInts[] = new int[max];
		int counter[] = new int[70];
		for (i = 0; i < 70; i++) counter[i] = 0;
		printArrayRev(counter);
		int matches = 0;
		int countit = 0;
		for(;;){
			countit++;
			counter = count(counter);
			for (i = 0; i < max; i++) {
					baseInts[i] = i;
					randomInts[i] = -1;
			}
			//System.out.println("BASE MAIN* * * * * * * * * * * * *");
			//matches = printArray(baseInts);
			//System.out.println("\n* * * * * * * * * * * * *");
			randomInts = shuffle(baseInts,randomInts,max);
			//System.out.println("\nRANDOM INTS* * * * * * * * * * * * *");
			matches = getMatches(randomInts);
			if (matches > maxmatches){maxmatches = matches;
				System.out.println("\n* MATCHES : "+matches+" * MAX MATCHES * "+maxmatches+" WITH ");
				printArrayRev(counter);System.out.println();
				//Thread.sleep(250);
			}
shortcount++;
			if(shortcount % 1000000000 == 0 ){
					System.out.println("\n* MATCHES : "+matches+" * MAX MATCHES * "+maxmatches+" WITH ");
			printArrayRev(counter);System.out.println();
			shortcount = 0;
			}
		}
	}//end main
}//end class
