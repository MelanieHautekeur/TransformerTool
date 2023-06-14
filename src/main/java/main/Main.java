package main;

import transformer.Transformer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transformer georgesTransformer = new Transformer();
		georgesTransformer.addToken("name", "Georges");
		georgesTransformer.addToken("address", "78, rue Will Smith");
		georgesTransformer.addToken("phone", "03 21 56 78 41");
		georgesTransformer.addToken("company", "Amazon");
		georgesTransformer.addToken("company", "Google");
		System.out.println(georgesTransformer.tokens);
		
		georgesTransformer.removeToken("{phone}");
		System.out.println(georgesTransformer.tokens);
		
		georgesTransformer.removeToken("{phone}");
		System.out.println(georgesTransformer.tokens);
		
		System.out.println(georgesTransformer.transform("Bonjour je suis {name}, je suis encore {name}, j'habite au {address}, j'ai {age} ans, j'ai un {animal}", georgesTransformer.tokens));
	}

}
