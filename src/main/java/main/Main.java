package main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import transformer.Transformer;

public class Main {

	private static Logger logger = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		Transformer georgesTransformer = new Transformer();
		georgesTransformer.addToken("name", "Georges");
		georgesTransformer.addToken("address", "78, rue Will Smith");
		georgesTransformer.addToken("phone", "03 21 56 78 41");
		georgesTransformer.addToken("company", "Amazon");
		georgesTransformer.addToken("company", "Google");
		
		georgesTransformer.removeToken("{phone}");
		
		logger.info(georgesTransformer.transform("Bonjour je suis {name}, j'habite au {address}, j'ai {age} ans, je suis encore {name}", georgesTransformer.tokens));
	}
}
