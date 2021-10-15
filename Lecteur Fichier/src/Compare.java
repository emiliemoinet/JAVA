public class Compare {
	
	public void compare(File file1, File file2) {
		
		String text1 = file1.write();
		String text2 = file2.write();
		
		int nb = text1.compareTo(text2);
		
		if(nb==0) {
			System.out.println("Les fichiers sont identiques");
		}else {
			System.out.println("Les fichiers sont diff�rents");
		}
	}
	
}