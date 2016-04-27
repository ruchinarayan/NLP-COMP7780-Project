package nlp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.util.InvalidFormatException;

public class SentenceDetectionNLP 
{
	public void sentenceDetectImpl() throws InvalidFormatException,IOException 
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter File name: ");
		String fileName = scn.next();
		//Location of file
		String filePath = "C:\\Users\\Ruchi\\Desktop\\nlp-project\\"+fileName;
		String sentLines = null;
		 try {
	            FileReader fileReader = new FileReader(filePath);
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
        
				while((sentLines = bufferedReader.readLine()) != null) 
				{
					System.out.println("File contents as:");
					System.out.println(sentLines+"\n"); 
	     
					InputStream inpS = new FileInputStream("models\\en-sent.bin");
					SentenceModel sentmodel = new SentenceModel(inpS);
					SentenceDetectorME sdetectorObj = new SentenceDetectorME(sentmodel);
					String sentLinesVal[] = sdetectorObj.sentDetect(sentLines);
					System.out.println("Contents after Sentence Detection as:\n");
					for(int i=0;i<sentLinesVal.length;i++)
					{
						System.out.println(i+": " + sentLinesVal[i]);
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
