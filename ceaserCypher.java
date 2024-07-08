import java.util.Scanner;

public class ceaserCypher{
    public static int findIndex(char[] chars, char charToFind){
        for(int i = 0; i<chars.length; i++){
            if (chars[i] == charToFind) return i;
        }
        return 0;
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Encryption or Decryption? 1 for Encryption, 2 for Decryption");
        int firstString = scan.nextInt();
        if (firstString == 2){
            System.out.println("Type your ciphertext: ");
            String ciphertext = scan.next();
            System.out.println("Type your key:");
            int key = scan.nextInt();
            char[] charArray = ciphertext.toCharArray();
            char[] AlphabetArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
            int length = charArray.length;
            char[] finalArray = new char[charArray.length];        
            for (int i = 0; i<length; i++){
                int index = findIndex(AlphabetArray, charArray[i]) - key;
                if (index>35 || index<0){
                    if (index>35){
                        index = index-35;
                    }
                    else index = index+35;
                }
                finalArray[i] = AlphabetArray[index];

            }
            System.out.println(finalArray);
        } else if (firstString == 1){
            System.out.println("Type your plaintext: ");
            String plaintext = scan.next();
            System.out.println("Type your key:");
            int key = scan.nextInt();
            char[] charArray = plaintext.toCharArray();
            char[] AlphabetArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
            int length = charArray.length;
            char[] finalArray = new char[charArray.length];        
            for (int i = 0; i<length; i++){
                int index = findIndex(AlphabetArray, charArray[i]) + key;
                if (index>35 || index<0){
                    if (index>35){
                        index = index-35;
                    }
                    else index = index+35;
                }
                finalArray[i] = AlphabetArray[index];

            }
            System.out.println(finalArray);
        } else System.exit(0);
    }
    
}
