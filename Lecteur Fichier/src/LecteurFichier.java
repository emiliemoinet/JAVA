import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

abstract class LecteurFichier implements InterfaceLecteur {
	protected ArrayList<String> text;
	private File file;
	
	public LecteurFichier(){
		this.text = new ArrayList<String>();
		this.file = null;
	}
	
	public boolean open(String name){
		file = new File(name);
		if(file.isFile()){
			return true;
		}
		return false;
		
	}
	
	public void read() {
		try {
			InputStream ips=new FileInputStream(file); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader bfr =new BufferedReader(ipsr);
			String line;
			while ((line= bfr.readLine())!=null){
				text.add(line+"\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}