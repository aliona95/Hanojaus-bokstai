import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HanojausBokstai {
	
	private static HashMap <Character, ArrayList<Integer>> abc = new HashMap <Character, ArrayList<Integer>>();  
	static ArrayList<Integer> a = new ArrayList<Integer>();
	static ArrayList<Integer> b = new ArrayList<Integer>();
	static ArrayList<Integer> c = new ArrayList<Integer>();
	
	private static int lineCounter = 0;
	
	public static void hb(char x, char y, char z, int n) {
		if (n > 0) {
			hb(x, z, y, n - 1); // 1. Perkelti n-1 diską ant tarpinio. (B)  (nuo A ant B)
			int temp = abc.get(x).get(lastElement(x));
			abc.get(x).remove(lastElement(x));
			abc.get(z).add(temp);
			System.out.printf(String.format("%4s",++lineCounter) + ". Diską " + n + " nuo " + x + " perkelti ant " + z + ". "); // 2. Perkelti n nuo A ant C
			print();
			hb(y, x, z, n - 1); // 3. Perkelti is viso n-1 diską ant tikslo. (nuo B ant C)
		}
	}

	public static int lastElement(char key){
		return abc.get(key).size() - 1;
	}
	
	public static void print() {
		String a = abc.get('A').toString();
		String b = abc.get('B').toString();
		String c = abc.get('C').toString();
		
		System.out.print("A=(" + a.substring(1, a.length() - 1) + "), ");
		System.out.print("B=(" + b.substring(1, b.length() - 1) + "), ");
		System.out.println("C=(" + c.substring(1, c.length() - 1) + ").");
	}
	public static void main(String[] args) {
		/*
		if (Integer.valueOf(args[0]) <= 10) {
			for (int i = Integer.valueOf(args[0]); i > 0; i--) {
				a.add(i);
			} 
			abc.put('A', a);
			abc.put('B', b);
			abc.put('C', c);
			System.out.println("Įvestas n = " + args[0] + ".");
			System.out.print("Pradinė būsena ");
			print();
			hb('A', 'B', 'C', Integer.valueOf(args[0]));
		}else {
			System.out.println("Ivesti skaiciu 1 - 10");
		}
		*/
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Įveskite n ");
		int n = scanner.nextInt();
		if (n <= 10 && n > 0) {
			for (int i = n; i > 0; i--) {
				a.add(i);
			} 
			abc.put('A', a);
			abc.put('B', b);
			abc.put('C', c);
			System.out.println("Įvestas n = " + n + ".");
			System.out.print("Pradinė būsena ");
			print();
			hb('A', 'B', 'C', n);
		}else {
			System.out.println("Klaida. Ivesti skaiciu 1 - 10");
		}	
		
		
	}
}
