
public class File extends LecteurFichier {
	private String name;
	public File(String name) {
		super();
		this.name = name;
	}

	public String write(){
		boolean test = super.open(name);
		String contain = "";
		if(test){
			super.read();
			for(int a = 0; a<text.size();a++){
				contain += text.get(a);
			}
			return contain;
			
		}else {
			return "fichier incorrect";
		}
		
	}

}

