package textencrypter_pro;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class TextEncrypter_Pro {

    private ArrayList<Character> list;
    private ArrayList<Character> shuffledList;
    private char letters;
    private Scanner input;
    private String getText = "";
    private char[] toArr;
    private String request = "";

    private TextEncrypter_Pro() {
        input = new Scanner(System.in);
        list = new ArrayList();
        shuffledList = new ArrayList();
        askQuestion();
    }

    public static void main(String[] args) {
        new TextEncrypter_Pro();
    }

    private void askQuestion() {

        while (true) {
            do {
                System.out.println("\n************************************************************\n"
                        + "Select (A) to see ASCII table, (N) for New Generation of Keys, (V) to View keys,(C) to Clear keys, "
                        + "(E) to Encrypt, (D) to Decrypt, (Q) to Exit.");
                request = input.nextLine().toUpperCase();
                if (request.trim().length() < 1 || "".equals(request)) {
                    System.out.print("No input.");
                }
            } while (request.trim().length() < 1 || "".equals(request));

            switch (request.charAt(0)) {
                case 'A':
                    asciiTable();
                    break;
                case 'N':
                    newKey();
                    break;
                case 'E':
                    encrypt();
                    break;
                case 'D':
                    decrypt();
                    break;
                case 'V':
                    viewKeys();
                    break;
                case 'C':
                    clearKeys();
                    break;
                case 'Q':
                    quit();
                    break;
                default:
                    System.out.println("Input out of Bounds\nMake sure right commands are selected.");
                    break;
            }
        }
    }

    private void newKey() {
        shuffledList.clear();
        list.clear();
        letters = ' ';
        for (int i = 32; i < 127; i++) {
            list.add((char) letters);
            letters++;
        }
        shuffledList = new ArrayList(list);
        Collections.shuffle(shuffledList);
        System.out.println("Your new keys have been successfully Generated.\nSelect (V) to view/see your keys.");
    }

    private void asciiTable() {
        letters = ' ';
        for (int i = letters; i < 127; i++) {
            System.out.print(letters);
            letters++;
        }
        System.out.println("\n____________________________________________________________\n");
    }

    private void clearKeys() {

        if (!list.isEmpty()) {
            list.clear();
            shuffledList.clear();
            System.out.println("Keys has been cleared");
        } else {
            System.out.println("No need to clear keys since no new keys has been Detected/Generated.");
        }
    }

    private void viewKeys() {
        if (!list.isEmpty()) {
            System.out.println("============================================================");
            System.out.println("Generated Keys:::\n");
            for (int i = 0; i < shuffledList.size(); i++) {
                System.out.print(shuffledList.get(i));
            }
            System.out.println("\n============================================================\n");
        } else {
            System.out.println("No new keys have been Generated yet\nSelect (N) to Generate new keys.");
        }
    }

    private void encrypt() {
        if (!shuffledList.isEmpty()) {
            System.out.println("Type in your words for ENCRYPTION");
            getText = input.nextLine();
            toArr = getText.toCharArray();
            System.out.print("ENCRYPTED: ");
            for (int i = 0; i < toArr.length; i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (toArr[i] == list.get(j)) {
                        toArr[i] = shuffledList.get(j);
                        break;
                    }
                }

                System.out.print(toArr[i]);
            }
        } else {
            System.out.println("No Keys has been Generated Yet.\nPlease Generate keys before Encryption.");
        }
    }

    private void decrypt() {
        if (list.size() > 0) {
            System.out.print("DECRYPTED: ");
            for (int i = 0; i < toArr.length; i++) {
                for (int j = 0; j < shuffledList.size(); j++) {
                    if (toArr[i] == shuffledList.get(j)) {
                        toArr[i] = list.get(j);
                        break;
                    }
                }

                System.out.print(toArr[i]);
            }
        } else {
            System.out.println("No words has been Ecrypted Yet.\nSelect (E) to Start your Encryption.");
        }
    }

    private void quit() {
        System.out.println("Byyeee...");
        System.exit(0);
    }
}
