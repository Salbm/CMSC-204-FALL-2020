package sourcefiles;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Morse Code Converter class
 * @author steph
 *
 */
public class MorseCodeConverter {

	private static MorseCodeTree MorseTree=new MorseCodeTree();	
	
	/**
	 * Returns content of the tree in string form with space in between
	 * @return TreeContent
	 */
	public static java.lang.String printTree(){
		
		String TreeContent ="";
		ArrayList<String>StringList =new ArrayList<String>();
		
		StringList = MorseTree.toArrayList();
		
		for(int k=0;k< StringList.size();k++) {
			
			TreeContent += StringList.get(k);
		}
		return TreeContent;
	}
	
	/**
	 * Converts from morse to english
	 * 
	 * @param code
	 * @return x (english conversion product)
	 */
	public static java.lang.String convertToEnglish(java.lang.String code){
		
		String[] words;
		String[] letters;
		
		String x ="";
		
		words = code.split("/");
		
		for(int k=0;k< words.length;k++) {
			
			words[k] = words[k].trim();
			letters = words[k].split(" ");
			
			for(int i=0;i<letters.length;i++) 
			{
				x += MorseTree.fetch(letters[i]);
			}
			
			x+=" ";
		
	}
		x = x.trim();
		
		return x;
}
	
	public static java.lang.String convertToEnglish(java.io.File codeFile)
            throws java.io.FileNotFoundException{
		
		Scanner sc = new Scanner(codeFile);
		
		String x = "";
		
		while(sc.hasNext()) {
			
			x += convertToEnglish(sc.nextLine());
		}
		
		return x;
	}
	
}
