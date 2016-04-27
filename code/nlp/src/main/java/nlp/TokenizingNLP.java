package nlp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;

public class TokenizingNLP {
	public static void tokenizationImpl() throws InvalidFormatException, IOException 
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter File name: ");
		String fileName = scn.next();
		String filePath = "C:\\Users\\Ruchi\\Desktop\\nlp-project\\"+fileName;
		String tokenVal = null;	
		 try {
	            FileReader fileReader = new FileReader(filePath);
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
				while((tokenVal = bufferedReader.readLine()) != null) {
					System.out.println("File contents as:");
					System.out.println(tokenVal);
	            InputStream inpS = new FileInputStream("models\\en-token.bin");
	    		TokenizerModel tokenModel = new TokenizerModel(inpS);
	    	    Tokenizer tokenizeObj = new TokenizerME(tokenModel);
	    	    // String testing = "Disney Fairies is a Disney franchise created in 2005. The franchise is built around the character of Tinker Bell from Disney's 1953 animated film Peter Pan, subsequently adopted as a mascot for the company. In addition to the fictional fairy character created by J. M. Barrie, the franchise introduces many new characters, and expands substantially upon the limited information the author gave about the fairies and their home of Neverland. The characters are referred to within stories as Neverland fairies. The franchise includes children's books and other merchandise, a web site, and the computer-animated Tinker Bell film series, featuring the character and several of the Disney fairies as supporting and recurring characters.";
	    		String tokensArr[] = tokenizeObj.tokenize(tokenVal);
	    	 
	    		System.out.println("Content after Tokenization: ");
	    		for (String val : tokensArr)
	    		{
	    			System.out.println(val);
	    		}
	    		inpS.close();
				}
				bufferedReader.close();  
	        }
		 	catch(Exception ex)
		 	{
		 		ex.printStackTrace();
		 	}
		 scn.close();
	}
}
