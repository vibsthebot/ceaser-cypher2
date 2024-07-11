import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class transpositionWord{
    public static int roundUp(double i){
        if (Math.floor(i)>i){
            return (int) (Math.floor(i)+1);
        }
        return (int) i;
    }
     public static int findIndex(char[] chars, char charToFind){
        for(int i = 0; i<chars.length; i++){
            if (chars[i] == charToFind) return i;
        }
        throw new Error("Input word needs to be lowercase");
        
    }
    
    public static List<char[]> specialSort(List<char[]> toSortList, List<Integer> orderList){
        List<Pair<Integer, char[]>> combinedList = new ArrayList<>();
        for (int i = 0; i < orderList.size(); i++) {
            combinedList.add(new Pair<>(orderList.get(i), toSortList.get(i)));
        }
        Collections.sort(combinedList, new OrderComparator());

        List<char[]> sortedList = new ArrayList<>();
        for (Pair<Integer, char[]> pair : combinedList) {
        sortedList.add(pair.getValue());
        }
        return sortedList;
    }
    public static void main(String[] args){
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] letters = Alphabet.toCharArray();
        Scanner scan = new Scanner(System.in);
        System.out.println("Encryption or Decryption? 1 for Encryption, 2 for Decryption");
        int firstString = scan.nextInt();
        if (firstString == 1){
            System.out.println("Plaintext: ");
            String plaintext = scan.next();
            System.out.println("Key: ");
            String keyString = scan.next().toUpperCase();
            int key = keyString.length();
            char[] keyArray = keyString.toCharArray();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i<key; i++){
                list.add(findIndex(letters, keyArray[i]));
            }
            char[] charArray = plaintext.toCharArray();
            System.out.println(charArray);
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
            for (int i=0; i<key; i++){
                //columns
                for (int j = 0; j<numOfCol; j++){
                    finalMatrix[i][j] = firstMatrix[j][i];
                }
            }
            List<char[]> finalMatrixAsList = Arrays.asList(finalMatrix);
            //List<char[]> finalSortedMatrix = specialSort(finalMatrixAsList, list);
            
            index = 0;
            for (int i=0; i<key; i++){
                char[] row = finalMatrixAsList.get(i);
                for (int j = 0; j<numOfCol; j++){
                    finalArray[index] = row[j];
                    index++;
                }
                System.out.println(row);
            }

            System.out.println(finalArray);
        }
        else if (firstString == 2){
            System.out.println("Ciphertext: ");
            String ciphertext = scan.next();
            System.out.println("Key: ");
            String keyString = scan.next().toUpperCase();
            int key = keyString.length();
            char[] keyArray = keyString.toCharArray();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i<key; i++){
                list.add(findIndex(letters, keyArray[i]));
            }
            char[] charArray = ciphertext.toCharArray();
            //System.out.println(charArray);
            double numOfCol = (int) Math.ceil((float) charArray.length/ key);
             
            char[][] firstMatrix = new char[key][(int) numOfCol];
            int index = 0;
            //rows
            for (int i=0; i<key; i++){
                //columns
                for (int j = 0; j<numOfCol; j++){
                    firstMatrix[i][j] = charArray[index];
                    index++;
                }
                System.out.println(firstMatrix[i]);

            }
            char[][] finalMatrix = new char[(int) numOfCol][key];
            char[] finalArray = new char[((int) numOfCol)*key];
            for (int i=0; i<numOfCol; i++){
                //columns
                for (int j = 0; j<key; j++){
                    finalMatrix[i][j] = firstMatrix[j][i];
                }
            }
            List<char[]> finalMatrixAsList = Arrays.asList(finalMatrix);
            //List<char[]> finalSortedMatrix = specialSort(finalMatrixAsList, list);
            
            index = 0;
            for (int i=0; i<numOfCol; i++){
                char[] row = finalMatrixAsList.get(i);
                for (int j = 0; j<key; j++){
                    finalArray[index] = row[j];
                    index++;
                }
                System.out.println(row);
            }

            System.out.println(finalArray);
        }
        
    }

    static class OrderComparator implements Comparator<Pair<Integer, char[]>> {
    @Override
    public int compare(Pair<Integer, char[]> o1, Pair<Integer, char[]> o2) {
      return Integer.compare(o1.getFirst(), o2.getFirst());
    }
  }

  static class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
      this.key = key;
      this.value = value;
    }

    public K getFirst() {
      return key;
    }

    public V getValue() {
      return value;
    }
  }
}

