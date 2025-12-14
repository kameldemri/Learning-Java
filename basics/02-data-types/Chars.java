public class Chars {
    public static void main(String[] args) {

        char c1 = 'A';
        char c2 = 65; // ASCII value for 'A'

        char heart = '\u2764';

        char next = (char) (c1 + 1); // 'B'

        // Some Unicode characters need two UTF-16 chars (surrogate pairs)
        String s = "😀";

        System.out.println(s.length()); // 2
        System.out.println(s.codePointCount(0, s.length())); // 1 (prints actual chars)
    }
}
