package Javaproject;

public class String1 {
    
    public static void main(String[] args) {
        String str = "Hello, World!";
        
        // Length of the string
        int length = str.length();
        System.out.println("Length: " + length);
        
        // Convert to uppercase
        String upperStr = str.toUpperCase();
        System.out.println("Uppercase: " + upperStr);
        
        // Convert to lowercase
        String lowerStr = str.toLowerCase();
        System.out.println("Lowercase: " + lowerStr);
        
        // Substring
        String subStr = str.substring(7, 12);
        System.out.println("Substring: " + subStr);
        
        // Replace characters
        String replacedStr = str.replace("World", "Java");
        System.out.println("Replaced String: " + replacedStr);
        
        // Trim whitespace
        String strWithSpaces = "   Hello, World!   ";
        String trimmedStr = strWithSpaces.trim();
        System.out.println("Trimmed String: '" + trimmedStr + "'");
        
        // Check if string contains a substring
        boolean contains = str.contains("World");
        System.out.println("Contains 'World': " + contains);
    }
}
