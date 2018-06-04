
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;

public class Main {

	private static final long MOD = (long) (10e9 + 7);
	private static HashMap<Long, Long> time_list;

	public static void main(String[] args) {
		startProgramm();
	}

	private static int getInput() {
		int input = 0;
		try {

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			input = Integer.parseInt(in.readLine());

		} catch(IOException ex) {
			System.out.println("Invalid value! Must be integer!");
		}
		return input;
	}

	private static final long fibo(long n) {
		long a = 0;
		long b = 1;
		for(int i = 0; i < n; i++) {
			long z = (a + b) % MOD;
			a = b;
			b = z;
		}
		return a;
	}

	private static final double Area(double r) {
		return Math.PI * Math.pow(r, 2);
	}

	private static final double Area(int r) {
		double radius = (double) r;
		return Math.PI * Math.pow(radius, 2);
	}

	private static void startOne() {

		int value;

		System.out.println("Enter your F(n): ");
		value = getInput();

		while(value != 0){

			long start = System.currentTimeMillis();
			System.out.println("Result: " + fibo(value));
			long end = System.currentTimeMillis();
			System.out.println(end - start + " ms required time");

			System.out.println("Back to main menu: 0");
			System.out.println("Enter any value: ");
			value = getInput();
		}	

	}

	private static void startWithLoop() {

		int start, end;
		long start_time, end_time;
		time_list = new HashMap<>();

		System.out.println("Enter start of range for function: ");
		start = getInput();
		System.out.println("Enter end of range for function: ");
		end = getInput();

		for(int i = start; i <= end; i++) {
			start_time = System.currentTimeMillis();
			System.out.println(i + ": " + fibo(i));
			end_time = System.currentTimeMillis();
			System.out.println(end_time - start_time + " ms");
			time_list.put(fibo(i), end_time - start_time);
		}

		System.out.println("Finished...");
		System.out.println("Calculating greatest time diffrence...");
		System.out.println("Maximum time: " + Collections.max(time_list.values()) + " ms with value Fibonacci " + 
			getMapKeyWithHighestValue(time_list));
		System.out.println("Minimum time: " + Collections.min(time_list.values()) + " ms with value Fibonacci " + 
			getMapKeyWithLowestValue(time_list));

	}

	private static final long GCD(int a, int b) {
		if(a == 0) return b;
		if(b == 0) return a;
		if(a >= b) return GCD(a % b, b);
		if(b >= a) return GCD(a, b % a);
		return a + b;
	}

	private static long getMapKeyWithHighestValue(HashMap<Long, Long> map) {

		long greatestKey = 0;

		long maxValueInMap = (Collections.max(map.values()));

		for(Map.Entry<Long, Long> entry: map.entrySet()) {
			if(entry.getValue() == maxValueInMap) greatestKey = entry.getKey();
		}

		return greatestKey;

	}


	private static long getMapKeyWithLowestValue(HashMap<Long, Long> map) {

		long lowerKey = 0;

		long minValueInMap = (Collections.min(map.values()));

		for(Map.Entry<Long, Long> entry: map.entrySet()) {
			if(entry.getValue() == minValueInMap) lowerKey = entry.getKey();
		}

		return lowerKey;

	}

	private static void getInfoBanner() {
		print("0 - Exit");
		print("1 - Calculate Area of Circle");
		print("2 - Calculate Finbonacci number");
		print("3 - Calculate GCD");
		print("4 - Credits");
		print("Your choice: ");
	}

	private static void getCredits() {
		print("\t\tDMITRYI GORDEEV .INC 2018");
		print("\t\tTHIS PROGRAM WAS WRITTEN BY ME IN 27.05.2018");
		print("\t\tI HAD SOME UP IN MY EXPERIENCE OF DEVELOPMENT");
	}

	private static void print(String s) { System.out.println(s); }

	private static void startProgramm() {
		while(true) {
			getInfoBanner();
			int choice = getInput();
			if(choice == 0) System.exit(0);
			if(choice == 1) {
				System.out.println("Enter your radius: ");
				int value = getInput();
				System.out.print("Result: ");
				System.out.println(Area(value));
			}
			if(choice == 2) {
				System.out.println("Loop option to get time of operation? [1 / 0]: ");
				int toChoiceOption = getInput();
				if(toChoiceOption == 0) { startOne(); }
				if(toChoiceOption == 1) { startWithLoop(); }
			}
			if(choice == 3) {
				System.out.println("Enter your numbers of GCD: ");
				int a = getInput();
				int b = getInput();
				System.out.print("Result: ");
				System.out.println(GCD(a, b));
			}
			if(choice == 4) getCredits();
		}
	}

}