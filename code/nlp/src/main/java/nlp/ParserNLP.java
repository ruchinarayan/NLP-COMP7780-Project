package nlp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystemException;
import java.util.Scanner;
import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;
import opennlp.tools.util.InvalidFormatException;

public class ParserNLP {
	
	public static void parseImpl() throws InvalidFormatException, IOException {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter File name: ");
		String fileName = scn.next();
		String filePath = "C:\\Users\\Ruchi\\Desktop\\nlp-project\\"+fileName;
		String parsingData = null;
		 try {
	            FileReader fileReader = new FileReader(filePath);
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
				while((parsingData = bufferedReader.readLine()) != null) 
				{
					System.out.println("File contents as:");
					System.out.println(parsingData);	
	            }   
				InputStream inpS = new FileInputStream("models\\en-parser-chunking.bin");	    	 
	    		ParserModel model = new ParserModel(inpS);
	    		Parser parser = ParserFactory.create(model);
	    		String val = "Disney Fairies is a Disney franchise created in 2005. The franchise is built around the character of Tinker Bell from Disney's 1953 animated film Peter Pan, subsequently adopted as a mascot for the company. In addition to the fictional fairy character created by J. M. Barrie, the franchise introduces many new characters, and expands substantially upon the limited information the author gave about the fairies and their home of Neverland. The characters are referred to within stories as Neverland fairies. The franchise includes children's books and other merchandise, a web site, and the computer-animated Tinker Bell film series, featuring the character and several of the Disney fairies as supporting and recurring characters.";
	    		Parse topParses[] = ParserTool.parseLine(val, parser, 1);
	    		System.out.println("Parsed data: ");
	    		for (Parse p : topParses)
	    		{
	    			p.show();
	    		}
	    		inpS.close();
	    		bufferedReader.close();  
	    		scn.close();
	        }
		 	catch(Exception ex)
		 	{
		 		ex.printStackTrace();
		 	}
		 
		/* 
		 * (TOP (S (NP (NNP Disney) 
		 * (NNP Fairies))
		 * (VP (VBZ is) (NP (NP (NP (DT a)
		 * (NNP Disney) (NN franchise))
		 * (VP (VBN created) (PP (IN in) 
		 * (NP (DT 2005.))))) (SBAR (S (NP (DT The) 
		 * (NN franchise)) (VP (VBZ is) (VP (VBN built)
		 * (PP (IN around) (NP (NP (DT the) (NN character)) 
		 * (PP (IN of) (NP (NP (NNP Tinker) (NNP Bell)) (PP
		 * (IN from) (NP (NNP Disney's) (CD 1953) (VBN animated)
		 * (NN film) (NNP Peter) (NNP Pan,))))))) (ADVP (RB subsequently))
		 * (VP (VBD adopted) (PP (IN as) (NP (NP (NP (DT a) (NN mascot)) 
		 * (PP (IN for) (NP (DT the) (NN company.)))) (SBAR (S (PP (IN In) 
		 * (NP (NP (NN addition)) (PP (TO to) (NP (NP (DT the) (JJ fictional) 
		 * (JJ fairy) (NN character)) (VP (VBN created) (PP (IN by) (NP (NNP J.)
		 * (NNP M.) (NNP Barrie,)))))))) (NP (DT the) (NN franchise))
		 * (VP (VP (VBZ introduces) (NP (JJ many) (JJ new) (NN characters,)))
		 * (CC and) (VP (VBZ expands) (ADVP (RB substantially)) (PP (IN upon)
		 * (NP (NP (DT the) (JJ limited) (NN information)) (SBAR (S (NP (DT the) 
		 * (NN author)) (VP (VBD gave) (PP (IN about) (NP (NP (DT the) 
		 * (NNS fairies)) (CC and) (NP (NP (PRP$ their) (NN home)) 
		 * (PP (IN of) (NP (NP (NNP Neverland.)) (SBAR (S (NP (DT The) 
		 * (NNS characters)) (VP (VBP are) (VP (VBN referred) (PP (TO to)) 
		 * (PP (IN within) (NP (NP (NNS stories)) (PP (IN as) (NP (NNP Neverland)))))
		 * (S (VP (VBD fairies.) (SBAR (S (NP (DT The) (NN franchise)) 
		 * (VP (VBZ includes) (NP (NP (NP (NNS children's) (NNS books))
		 * (CC and) (NP (NP (JJ other) (NNS merchandise,)) (NP (DT a)
		 * (NN web) (NN site,)))) (CC and) (NP (DT the) (JJ computer-animated) 
		 * (NNP Tinker) (NNP Bell) (NN film) (NN series,)) (VP (VBG featuring) 
		 * (NP (NP (NP (DT the) (NN character)) (CC and) (NP (NP (JJ several))
		 * (PP (IN of) (NP (DT the) (NNP Disney) (NNS fairies))))) (PP (IN as) 
		 * (S (VP (VBG supporting) (CC and) (VP (VBG recurring)))))))))))))))))))))))))))))))))))))))) 
		 * (. characters.)))
		 * 
		 */
	}
}
