package encryptdecrypt;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {

        String mode = "enc";
        String in = null;
        String out = null;
        int key = 0;
        String data = "";
        String alg = "shift";

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    mode = args[++i];
                    break;
                case "-key":
                    key = Integer.parseInt(args[++i]);
                    break;
                case "-data":
                    data = args[++i];
                    break;
                case "-in":
                    in = args[++i];
                    break;
                case "-alg":
                    alg = args[++i];
                    break;
                case "-out":
                    out = args[++i];
                    break;
            }
        }

        if ("dec".equals(mode))
            key = -key;

        if (data.equals("") && in != null) {
            data = Files.readString(Path.of(in));
        }
        PrintStream printStream = out == null ? System.out : new PrintStream(out);
        if ("shift".equals(alg)) {

            int a = 'a';
            int z = 'z';
            int A = 'A';
            int Z = 'Z';
            if ("enc".equals(mode)) {
                for (char item : data.toCharArray()) {
                    if (item >= a && item <= z) {
                        char shiftItem = (char) (((item - a + key) % 26) + a);
                        printStream.print(shiftItem);
                    } else if (item >= A && item <= Z) {
                        char shiftItem = (char) (((item - A + key) % 26) + A);
                        printStream.print(shiftItem);
                    } else {
                        printStream.print(item);
                    }
                }
            } else {
                for (char item : data.toCharArray()) {
                    char shiftItem;
                    if (item >= a && item <= z) {

                        char offset = (char) ((char) item - a + key);

                        if (item - a + key >= 0) {
                            shiftItem = (char) ((offset % 26) + a);
                        } else {
                            shiftItem = (char) ((z + (Math.abs(offset) +1)));
                        }

                        printStream.print(shiftItem);
                    } else if (item >= A && item <= Z) {
                        char Offset = (char) (item - A + key);
                        if (item - A + key > 0) {
                            shiftItem = (char) ((Offset % 26) + A);
                        } else {
                            shiftItem = (char) ((z + (Math.abs(Offset) + 1)));
                        }
                    } else {
                        printStream.print((char) (item));
                    }
                }

            }
        }
        else {
            for (char item : data.toCharArray()) {

                char shiftItem = (char) ((item + key) );
                printStream.print(shiftItem);

            }
        }



    }

    public static void getDecryption(String data, int key) {
        for (char item : data.toCharArray()) {
            char shiftItem = (char) (item - key);
            System.out.print(shiftItem);
        }
    }

    public static void getEncryption(String data, int key) {
        // char item;
        int a = 'a';
        int z = 'z';
        int A = 'A';
        int Z = 'Z';
        for (char item : data.toCharArray()){
            if (item >= a && item <= z) {
                char shiftItem = (char) (((item - a + key) % 26) + a);
                System.out.print(shiftItem);
            }
            else if (item >= A && item <= Z){
                char shiftItem = (char) (((item - A + key) % 26) + A);
                System.out.print(shiftItem);
            }
            else {
                System.out.print(item);
            }
        }

    }
}