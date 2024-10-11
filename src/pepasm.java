import java.io.*;
import java.util.Hashtable;

public class pepasm {
    public static void main(String[] args) throws IOException {

        System.out.println(args);
        String filePath ="C:\\Users\\silha\\OneDrive\\Desktop\\CS224WorkSpace2024\\assemblycoding\\program4.pep"; // Change this to your file path -args contains path to file

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) { //throws excepetion if can't read
            String line;
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                String[] words = line.split("[ ,]+");
                if (words.length < 2) {
                    if (words[0].equals("ASLA")) {
                        System.out.print(" 0A");

                    } else if (words[0].equals("ASRA")) {
                        System.out.print(" 0C");

                    } else if (words[0].equals("STOP")) {
                        System.out.print(" 00 ");
                    } else if (words[0].equals(".END")){
                        break;
                    }
                } else if (words.length >= 2){
                    if (words[0].equals("LDBA")) {
                        if (words[2].equals("i")) {
                            System.out.print(" D0");
                            System.out.print(" ");
                            String[] seperator = words[1].split("",2);
                            System.out.print(words[1].substring(0,2)+" "+ words[1].substring(2));
                        } else {
                            System.out.print(" D1");
                            System.out.print(" " + words[1]);
                        }

                    } else if (words[0].equals("STBA")) {
                        if (words[0].equals("d")) {
                            System.out.print(" F1");
                            String[] separator = words[1].split("",2);
                            System.out.print(" " + words[1].substring(0,2)+" "+words[1].substring(2));
                        } else {
                            System.out.print(" F0");
                            String[] separator = words[1].split("",2);
                            System.out.print(" " + words[1].substring(0,2)+" "+words[1].substring(2));

                        }

                    } else if (words[0].equals("LDWA")) {
                        if (words[2].equals("i")) {
                            System.out.print(" C0");
                            String[] separator = words[1].split("",2);
                            System.out.print(" " + words[1].substring(0,2)+" "+words[1].substring(2));
                        } else {
                            System.out.print(" C1");
                            System.out.print(" " + words[1]);
                        }

                    } else if (words[0].equals("STWA")) {
                        if (words[2].equals("d")) {
                            System.out.print(" E1");
                            String[] separator = words[1].split("",2);
                            System.out.print(" " + words[1].substring(0,2)+" "+words[1].substring(2));
                        } else {
                            System.out.println(" E0");
                            System.out.print(" " + words[1]);
                        }

                    } else if (words[0].equals("ADDA")) {
                        if (words[2].equals("i")) {
                            System.out.print(" 60 ");
                        } else {
                            System.out.print(" 61 ");
                        }

                    } else if (words[0].equals("CPBA")) {
                        if (words[2].equals("i")) {
                            System.out.print("B0");
                        } else {
                            System.out.print("B1");
                        }

                    } else if (words[0].equals("BRNE")) {
                        System.out.print("1A");
                    } //Where does the 00 03 come from

                   // else {
                    //  int seperator = words[1].indexOf(",");
                    // System.out.print(words[1].substring(2, seperator));
                    //System.out.print(words[1]);
                    } //How to compensate for 0x0044, 0x044, 0x44, how to do 00 44 //ERROR when running program 4
                }
            }
        } //catch (IOException e) {
          //  e.printStackTrace();
        }


