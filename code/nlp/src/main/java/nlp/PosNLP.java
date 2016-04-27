package nlp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.FileSystemException;
import java.util.Scanner;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.ObjectStream;

public class PosNLP {
	
	@SuppressWarnings("resource")
	public static void posTaggingImpl() 
	{	
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter File name: ");
		String fileName = scn.next();
		String filePath = "C:\\Users\\Ruchi\\Desktop\\nlp-project\\"+fileName;
		String posTagVal = null;
		try {          
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
			while((posTagVal = bufferedReader.readLine()) != null) 
			{
				System.out.println("File contents as:");
				System.out.println(posTagVal);
				POSModel posmodel = new POSModelLoader().load(new File("models\\en-pos-maxent.bin"));
				PerformanceMonitor performance = new PerformanceMonitor(System.err, "sent");
				POSTaggerME tagger = new POSTaggerME(posmodel);
				//String test = "Disney Fairies is a Disney franchise created in 2005. The franchise is built around the character of Tinker Bell from Disney's 1953 animated film Peter Pan, subsequently adopted as a mascot for the company. In addition to the fictional fairy character created by J. M. Barrie, the franchise introduces many new characters, and expands substantially upon the limited information the author gave about the fairies and their home of Neverland. The characters are referred to within stories as Neverland fairies. The franchise includes children's books and other merchandise, a web site, and the computer-animated Tinker Bell film series, featuring the character and several of the Disney fairies as supporting and recurring characters.";
				ObjectStream<String> lineStream = new PlainTextByLineStream(new StringReader(posTagVal));
				performance.start();
				String line;
				while ((line = lineStream.read()) != null) 
				{
					String whitespaceTokenizerLine[] = WhitespaceTokenizer.INSTANCE.tokenize(line);
					String[] tags = tagger.tag(whitespaceTokenizerLine);
					POSSample sample = new POSSample(whitespaceTokenizerLine, tags);
					System.out.println(sample.toString());
					performance.incrementCounter();
				}
			performance.stopAndPrintFinalResult();
			}
			bufferedReader.close();
        }
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
