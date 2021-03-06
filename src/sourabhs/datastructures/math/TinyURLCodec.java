package sourabhs.datastructures.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sourabh
 * 
 * TinyURL is a URL shortening service where you enter 
 * a URL such as https://leetcode.com/problems/design-tinyurl
 * and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * 
 * Design the encode and decode methods for the TinyURL service. 
 * There is no restriction on how your encode/decode algorithm 
 * should work. You just need to ensure that a URL can be encoded
 * to a tiny URL and the tiny URL can be decoded to the original URL.
 *
 */
public class TinyURLCodec {

	Map<String, String> index = new HashMap<>();
	Map<String, String> revIndex = new HashMap<>();
	static String BASE_HOST = "http://tinyurl.com/";

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		if (revIndex.containsKey(longUrl)) 
			return BASE_HOST + revIndex.get(longUrl);
		String charSet = "abcdefghijklmnopqrstuvwxyz"
				+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789";
		String key = null;
		do {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 6; i++) {
				int r = (int) (Math.random() * charSet.length());
				sb.append(charSet.charAt(r));
			}
			key = sb.toString();
		} while (index.containsKey(key));
		index.put(key, longUrl);
		revIndex.put(longUrl, key);
		return BASE_HOST + key;
	}

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return index.get(shortUrl.replace(BASE_HOST, ""));
    }
    
	public static void main(String[] args) {
		TinyURLCodec obj = new TinyURLCodec();
		String shortURL = obj.encode("https://leetcode.com/problems/design-tinyurl");
		String longURL = obj.decode(shortURL);

		System.out.println("The long Url is " + longURL);
		System.out.println("The short Url is " + shortURL);
		
		shortURL = obj.encode("https://discuss.leetcode.com/topic/81637/two-solutions-and-thoughts/7");
		longURL = obj.decode(shortURL);

		System.out.println("The long Url is " + longURL);
		System.out.println("The short Url is " + shortURL);
	}

}
