import java.util.Scanner;
public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str) {
        int length = str.length();
        int start = 0;
        int end = 0;

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ('(')) {
                start++;
            }
            if (str.charAt(i) == (')')) {
                end++;
            }
        }

        return start == end;
    }

    // 2. reverseInteger
    public static String reverseInteger(int num) {
        String result = "";

        while (num > 0) {
            int digit = num % 10;
            result += digit;
            num /= 10;
        }

        return result;
    }

    // 3. encryptThis
    public static String encryptThis(String str) {
        String result = "";
        Scanner scanner = new Scanner(str);
        boolean isLastWord = false;

        while (scanner.hasNext()) {
            String word=scanner.next();
            int length=word.length();

            if (length > 2) {
                char first = word.charAt(0);
                char second = word.charAt(1);
                String middle=word.substring(2,length-1);
                char last = word.charAt(length-1);

                result += String.valueOf((int)first) + last + middle + second;
            }
            else {
                    char first = word.charAt(0);
                    result += (int)first+word.substring(1);
                }

            if(scanner.hasNext()){
                result+=" ";
            }
            else{
                isLastWord=true;
            }
        }

        if(!isLastWord){
            result+=" ";
        }

        return result;
    }

    // 4. decipherThis
    public static String decipherThis(String str) {
        String result="";
        Scanner scanner=new Scanner(str);
        boolean isLastWord=false;

        while(scanner.hasNext()){
            String word=scanner.next();
            int length=word.length();
            int first=0;
            int i=0;

            while(i<length && Character.isDigit(word.charAt(i))){
                first=first*10+(word.charAt(i)-'0');
                i++;
            }

            char decodedFirst=(char)first;
            String second="";
            String middle="";

            if(length-i>1) {
                second=word.substring(length-1,length);
                middle = word.substring(i+1, length-1);
            }

            char last=word.charAt(i);

            result += decodedFirst+second+middle+last;

            if(scanner.hasNext()){
                result+=" ";
            }
            else{
                isLastWord=true;
            }
        }

        if(!isLastWord){
            result+=" ";
        }

        return result;
    }
}

