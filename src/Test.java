import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        System.out.println("Git test");
        String str = "51Pa*0Lp*0e";
        System.out.printf("%-25s %s%n", "Input encrypted string:", str);
        System.out.printf("%-25s %s%n", "Decrypted string:", decryptPassword(str));
        System.out.printf("%-25s %s%n", "Encrypted again:", encryptPassword(decryptPassword(str)));
    }

    public static String decryptPassword(String s) {
        ArrayList<Character> charList = new ArrayList<>();
        String noStars = s.replace("*", "");
        StringBuilder strBuilder = new StringBuilder(noStars);

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                charList.add(s.charAt(i));
            }
        }
        strBuilder.delete(0, charList.size() / 2);
        s = strBuilder.toString();
        strBuilder.setLength(0);

        int j = (charList.size() / 2 - 1);

        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && Character.isUpperCase(s.charAt(i)) && Character.isLowerCase(s.charAt(i + 1))) {
                strBuilder.append(s.charAt(i + 1)).append(s.charAt(i));
                i++;
            } else if (Character.isDigit(s.charAt(i))) {
                strBuilder.append(charList.get(j--));
            } else {
                strBuilder.append(s.charAt(i));
            }
        }

        return strBuilder.toString();
    }

    public static String encryptPassword(String s) {
        StringBuilder strBuilder = new StringBuilder();
        String strTemp;

        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && Character.isLowerCase(s.charAt(i)) && Character.isUpperCase(s.charAt(i + 1))) {
                strBuilder.append(s.charAt(i + 1)).append(s.charAt(i)).append("*");
                i++;
            } else if (Character.isDigit(s.charAt(i))) {
                strBuilder.append("0");
                strTemp = strBuilder.toString();
                strBuilder.setLength(0);
                strBuilder.append(s.charAt(i)).append(strTemp);
            } else {
                strBuilder.append(s.charAt(i));
            }
        }

        return strBuilder.toString();
    }
}
