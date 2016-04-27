package nlp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

public class NameFinderNLP {
	
	public static void findNameImpl() throws IOException {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter File name: ");
		String fileName = scn.next();
		String filePath = "C:\\Users\\Ruchi\\Desktop\\nlp-project\\"+fileName;
		String lineVal = null;
		try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
			while((lineVal = bufferedReader.readLine()) != null) 
			{
				System.out.println("File contents as:");
				System.out.println(lineVal+"\n"); 
				InputStream is = new FileInputStream("models\\en-ner-person.bin");
				TokenNameFinderModel model = new TokenNameFinderModel(is);
				is.close();
				NameFinderME nameFinderObj = new NameFinderME(model);
				String []sentence = lineVal.split(" ");
				Span nameSpansVal[] = nameFinderObj.find(sentence);
				System.out.println("Index of the names present in a file as: ");
				for(Span s: nameSpansVal)
				{
					System.out.println(s.toString());
				}
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
