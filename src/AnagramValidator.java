import java.util.Scanner;
public class AnagramValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two strings:");
        char[] s1 = sc.next().toCharArray();
        char[] s2 = sc.next().toCharArray();

        if (s1.length != s2.length) {
            System.out.println("NO");
            return;
        }

        // Bubble Sort for characters
        sortCharAlphabetically(s1);
        sortCharAlphabetically(s2);

        boolean isAnagram = true;
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                isAnagram = false;
                break;
            }
        }
        System.out.println(isAnagram ? "YES" : "NO");
    }

    public static void sortCharAlphabetically(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}