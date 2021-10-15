public class Main {

	public static void main(String[] args) {
		
		System.out.println("\n Fichier");
		File file1 = new File("text/text.txt");
		System.out.println(file1.write());
		
		System.out.println("Fichier � l'envers");
		Reverse file2 = new Reverse("text/text.txt");
		System.out.println(file2.write());
		
		System.out.println("Fichier Palindromique");
		Palindrome file3 = new Palindrome("text/text.txt");
		System.out.println(file3.write());
		
		System.out.println("Comparer deux fichiers");
		
		File file4 = new File("text/text.txt");
		File file5 = new File("text/text.txt");
		File file6 = new File("text/text2.txt");
		
		Compare test = new Compare();
		test.compare(file4, file5);
		
		System.out.println("Comparer deux fichiers");
		
		Compare test2 = new Compare();
		test2.compare(file4, file6);
		
	}

}