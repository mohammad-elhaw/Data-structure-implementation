public class HashTable {

    private HashItem[] hashTable;

    public HashTable(){
        hashTable = new HashItem[Constants.TABLE_SIZE];
    }

    public void put(int key, int value){
        int hashingKey = hashFunction(key);

        while(hashTable[hashingKey] != null){
            hashingKey = (hashingKey + 1) % Constants.TABLE_SIZE;
            System.out.println("collision -> new index is generated: " + hashingKey);
        }
        System.out.println("finally inserted with index: " + hashingKey);
        hashTable[hashingKey] = new HashItem(key, value);
    }


    public int get(int key){
        int hashingKey = hashFunction(key);

        while(hashTable[hashingKey] != null && hashTable[hashingKey].getKey() != key){
            hashingKey = (hashingKey + 1) % Constants.TABLE_SIZE;
            System.out.println("moving to the next index " + hashingKey);
        }

        if(hashTable[hashingKey] == null)
            return -1;
        else
            return hashTable[hashingKey].getValue();
    }


    public int hashFunction(int key){
        return key % Constants.TABLE_SIZE;
    }

}
