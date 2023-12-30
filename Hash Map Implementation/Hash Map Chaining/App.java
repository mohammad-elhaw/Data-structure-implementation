
public class App {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        hashTable.put(1, 100);
        hashTable.put(2, 200);
        hashTable.put(3, 300);
        hashTable.put(4, 400);
        hashTable.put(5, 500);
        hashTable.put(6, 600);
        hashTable.put(7, 700);
        hashTable.put(8, 800);
        hashTable.put(9, 900);
        hashTable.put(10, 1000);
        hashTable.put(11, 1100);
        hashTable.put(12, 1200);
        System.out.println(hashTable.get(1));
    }
}
