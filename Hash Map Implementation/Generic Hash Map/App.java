public class App {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();

        hashTable.put("aboMazen", 1000);
        hashTable.put("Mohammad", 2000);
        hashTable.put("ahmed", 3000);
        hashTable.put("mustafa", 4000);
        hashTable.put("aboAli", 5000);
        hashTable.put("esmaeal", 6000);
        hashTable.put("youssef", 7000);
        hashTable.put("zaki", 8000);
        hashTable.put("zakaria", 9000);
        hashTable.put("kareem", 10000);
        hashTable.put("abc", 11000);

        System.out.println(hashTable.get("aboMazen"));
        System.out.println(hashTable.get("Mohammad"));
        System.out.println(hashTable.get("ahmed"));
        System.out.println(hashTable.get("mustafa"));
        System.out.println(hashTable.get("aboAli"));
        System.out.println(hashTable.get("esmaeal"));
        System.out.println(hashTable.get("youssef"));
        System.out.println(hashTable.get("zaki"));
        System.out.println(hashTable.get("zakaria"));
        System.out.println(hashTable.get("kareem"));
        System.out.println(hashTable.get("abc"));


        hashTable.remove("aboMazen");
        hashTable.remove("Mohammad");
        hashTable.remove("ahmed");
        hashTable.remove("mustafa");
        hashTable.remove("aboAli");
        hashTable.remove("esmaeal");
        hashTable.remove("youssef");
        hashTable.remove("zaki");
        hashTable.remove("zakaria");

        System.out.println(hashTable.size());

    }
}
