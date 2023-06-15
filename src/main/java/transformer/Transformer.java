package transformer;
import java.util.HashMap;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;

/**
 * Transforms a text by replacing a set of tokens by predefined values.
 * Example :
 * I am {name} => I am Robert
 * A token is a word between brackets : {age}
 * @author Melanie
 *
 */
public class Transformer {
	public HashMap<String, String> tokens = new HashMap<String, String>();
	
	private static Logger logger = LoggerFactory.getLogger(Transformer.class);
	
	public Transformer() {
	}

	/**
	 * Adds a couple key-value to the HashMap of tokens
	 * If the couple already exists in the HashMap, replace the value
	 * @param token The token without brackets
	 * @param value The value which will replace the associated token
	 * @return void
	 */
	public void addToken(String token, String value) {
		String goodToken = "{" + token + "}";
		if( tokens.containsKey(goodToken) ) {
			logger.info("{} : Donnée modifiée", token);
		} else {
			logger.info("{} : Donnée initialisée", token);
		}
		tokens.put(goodToken, value);
	}
	
	/**
	 * Removes the couple key-value associated to the token in the HashMap tokens
	 * If the couple doesn't exist, print a message in the console
	 * @param token	The token without brackets
	 * @return void
	 */
	public void removeToken(String token) {
		String goodToken = "{" + token + "}";
		if( tokens.containsKey(goodToken) ) {
			tokens.remove(goodToken);
			logger.info("{} : Donnée supprimée", token);
		} else {
			logger.warn("{} : Cette donnée n'existe pas", token);
		}
	}
	
	/**
	 * Replaces all the tokens in the text if they exist in the HashMap tokens else print a message in the console and the token remains in the text
	 * @param text The text where you need to replace tokens
	 * @param tokens The list of available tokens 
	 * @return String
	 */
	public String transform(String text, HashMap<String, String> tokens) {
		Pattern pattern = Pattern.compile("(\\{.+?\\})");
		Matcher matcher = pattern.matcher(text);
		StringBuffer buffer = new StringBuffer();
		
		while( matcher.find() ) {
			String match = matcher.group(1);
			String replacement = tokens.get(match);
			if( replacement != null ) {
				matcher.appendReplacement(buffer, replacement);
			} else {
				logger.warn("Attention! La donnée {} est manquante et ne peut pas être remplacée.", match);
			}
		}
		//Si on entre pas dans la boucle, vient ajouter la fin du texte
		matcher.appendTail(buffer);
		return buffer.toString();
	}
}




