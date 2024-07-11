import java.util.Scanner;

public class transposition{
    public static int roundUp(double i){
        if (Math.floor(i)>i){
            return (int) (Math.floor(i)+1);
        }
        return (int) i;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Encryption or Decryption? 1 for Encryption, 2 for Decryption");
        int firstString = scan.nextInt();
        if (firstString == 1){
            System.out.println("Plaintext: ");
            String plaintext = scan.next();
            System.out.println("Key: ");
            int key = scan.nextInt();
            char[] charArray = plaintext.toCharArray();
            //System.out.println(charArray);
            double numOfCol = (int) Math.ceil((float) charArray.length/ key);
            
            char[][] firstMatrix = new char[(int) numOfCol][key];
            int index = 0;
            //rows
            for (int i=0; i<numOfCol; i++){
                //columns
                for (int j = 0; j<key; j++){
                    if (index>=charArray.length){
                        firstMatrix[i][j] = 'x';
                    } 
                    else {
                        firstMatrix[i][j] = charArray[index];
                    }
                    
                    index++;
                }
                System.out.println(firstMatrix[i]);

            }
            char[][] finalMatrix = new char[key][(int) numOfCol];
            char[] finalArray = new char[((int) numOfCol)*key];
            index = 0;
            for (int i=0; i<key; i++){
                //columns
                for (int j = 0; j<numOfCol; j++){
                    finalMatrix[i][j] = firstMatrix[j][i];
                    finalArray[index] = firstMatrix[j][i];
                    index++;
                }
                System.out.println(finalMatrix[i]);
            }
            System.out.println(finalArray);
        }
        else if (firstString == 2){
            System.out.println("Ciphertext: ");
            String ciphertext = scan.next();
            System.out.println("Key: ");
            int key = scan.nextInt();
            char[] charArray = ciphertext.toCharArray();
            //System.out.println(charArray);
            double numOfCol = (int) Math.ceil((float) charArray.length/ key);
            
            char[][] firstMatrix = new char[key][(int) numOfCol];
            int index = 0;
            //rows
            for (int i=0; i<key; i++){
                //columns
                for (int j = 0; j<numOfCol; j++){
                    if (index>=charArray.length){
                        firstMatrix[i][j] = 'x';
                    } 
                    else {
                        firstMatrix[i][j] = charArray[index];
                    }
                    
                    index++;
                }
                System.out.println(firstMatrix[i]);

            }
            char[][] finalMatrix = new char[(int) numOfCol][key];
            char[] finalArray = new char[((int) numOfCol)*key];
            index = 0;
            for (int i=0; i<numOfCol; i++){
                //columns
                for (int j = 0; j<key; j++){
                    finalMatrix[i][j] = firstMatrix[j][i];
                    finalArray[index] = firstMatrix[j][i];
                    index++;
                }
                System.out.println(finalMatrix[i]);
            }
            System.out.println(finalArray);
        }
        
        
    }
}