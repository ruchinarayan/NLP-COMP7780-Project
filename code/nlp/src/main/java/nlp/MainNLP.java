package nlp;

import java.io.IOException;
import java.util.Scanner;
import opennlp.tools.util.InvalidFormatException;

public class MainNLP {
	
	public static void main(String[] args) throws InvalidFormatException, IOException
	{
		Scanner scn = new Scanner(System.in);	
		System.out.println("Natural Language Processing");
		System.out.println("===========================");
		System.out.println("1. Sentence Detection");
		System.out.println("2. Tokenization");
		System.out.println("3. Name Finder");
		System.out.println("4. POS Tagging");
		System.out.println("5. Chunking");
		System.out.println("6. Parsing");
	
		System.out.println("Enter the option :");
		int option = scn.nextInt();
			if(option == 1)
			{
				SentenceDetectionNLP sentDet = new SentenceDetectionNLP();
				sentDet.sentenceDetectImpl();
			}
			else if(option == 2)
			{
				TokenizingNLP token = new TokenizingNLP();
				token.tokenizationImpl();
			}
			else if(option == 3)
			{
				NameFinderNLP nameFind = new NameFinderNLP();
				nameFind.findNameImpl();
			}
			else if(option == 4)
			{
				PosNLP posTag = new PosNLP();
				posTag.posTaggingImpl();
			}
			else if(option == 5)
			{
				ChunkerNLP chunkVal = new ChunkerNLP();
				chunkVal.chunkImpl();
			}
			else if(option == 6)
			{
				ParserNLP parseVal = new ParserNLP();
				parseVal.parseImpl();
			}
			else
			{
				System.out.println("Please select a proper option!");
			}	
}
}
