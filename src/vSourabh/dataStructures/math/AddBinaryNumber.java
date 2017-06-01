package vSourabh.dataStructures.math;

/**
 * @author Sourabh
 * 
 * LeetCode
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, 
 * a = "11" b = "1"
 * Return "100".
 */
public class AddBinaryNumber {

	public String addBinary(String a, String b) {
		
		StringBuilder sb = new StringBuilder();
        int carry = 0, i = a.length() - 1, j = b.length() - 1;
        
        while(i >= 0 || j >= 0) {
        	int sum = carry;
        	if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        
        if (carry != 0) 
        	sb.append(carry);
        
        return sb.reverse().toString();
    }
	public static void main(String[] args) {
		AddBinaryNumber obj = new AddBinaryNumber();
		String result = obj.addBinary("11", "111");
		System.out.println("The addition of Binary 11 and 111 is " + result);
	}

}