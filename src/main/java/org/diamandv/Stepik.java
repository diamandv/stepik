package org.diamandv;

import java.math.BigInteger;
import java.util.function.DoubleUnaryOperator;

public class Stepik {
    public static void main(String[] args) {
//        System.out.println(isPalindrome("m..a....m!"));
        int[] a1 = new int[]{0, 1, 1, 2, 3, 5, 8, 9};
        int[] a2 = new int[]{1, 1, 2, 4, 9};
//        System.out.println(Arrays.toString(mergeArrays(a1, a2)));
        Stepik start = new Stepik();
        start.starter();
    }

    public void starter() {
        String[] roles = {"Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич"};
        String[] textLines = {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.", "Аммос Федорович: Как ревизор?", "Артемий Филиппович: Как ревизор?", "Городничий: Ревизор из Петербурга, инкогнито. и еще с секретным предписаньем.", "Аммос Федорович: Вот те на!", "Артемий Филиппович: Вот не было заботы, так подай!", "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        System.out.println(printTextPerRole(roles, textLines));
    }

    private String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder text = new StringBuilder();
        StringBuilder line;
        for (String role : roles) {
            text.append(role).append(":").append("\n");
            for (int j = 0; j < textLines.length; j++) {
                if (textLines[j].startsWith(role + ":")) {
                    line = new StringBuilder(textLines[j]).replace(0, role.length() + 1, (j + 1) + ")").append("\n");
                    text.append(line);
                }
            }
            text.append("\n");
        }
        return text.toString();
    }

    public static boolean isPalindrome(String text) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (Character.isLetterOrDigit(character)) {
                s.append(Character.toLowerCase(character));
            }
        }
        return s.toString().contentEquals(String.valueOf(s.reverse()));
    }

    public static BigInteger factorial(int value) {
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 2; i <= value; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] a3 = new int[a1.length + a2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] <= a2[j]) {
                a3[k] = a1[i];
                i++;
            } else {
                a3[k] = a2[j];
                j++;
            }
            k++;
        }
        while (i < a1.length) {
            a3[k] = a1[i];
            i++;
            k++;
        }
        while (j < a2.length) {
            a3[k] = a2[j];
            j++;
            k++;
        }
        return a3;
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double n = 1000000;
        double s = (b - a) / n;
        double result = 0;
        for(int i = 0; i < n; i++) {
            result +=  f.applyAsDouble(a + s * i);
        }
        return result *= s;
    }

}