package Google;

public class TestStringBuilder {
    public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("abcedef");
		sb.deleteCharAt(0);  // bcedef
		System.out.println(sb.toString());
		sb.delete(0, 2);     // edef
		System.out.println(sb.toString());
		sb.append("ab");    //  edefab
		System.out.println(sb.toString());
		sb.replace(0, 2, "abd");    // abdefab
		System.out.println(sb.toString());
	}
}
