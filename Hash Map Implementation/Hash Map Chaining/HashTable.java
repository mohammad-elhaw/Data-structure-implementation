public class HashTable {

    private HashItem[] hashTable;

    public HashTable(){
        hashTable = new HashItem[Constants.TABLE_SIZE];
    }

    public void put(int key, int value){
        int hashingKey = hash(key);

        if(hashTable[hashingKey] == null){
            System.out.println("there is no collision happen");
            hashTable[hashingKey] = new HashItem(key, value);
        }
        else{
            System.out.println("Collision when inserting a key: " + key);
            HashItem hashItem = hashTable[hashingKey];
            while(hashItem.getNextHashItem() != null){
                hashItem = hashItem.getNextHashItem();
                System.out.println("Considering the next item in the linked list " + hashItem.getValue());
            }
            System.out.println("finally we have found the place to insert..");
            hashItem.setNextHashItem(new HashItem(key, value));
        }
    }

    public int get(int key){
        int hashingKey = hash(key);
        HashItem hashItem = hashTable[hashingKey];
        while(hashItem != null && hashItem.getKey() != key){
            hashItem = hashItem.getNextHashItem();
        }
        if(hashItem == null)
            return -1;

        return hashItem.getValue();
    }


    private int hash(int key){
        return key % Constants.TABLE_SIZE;
    }

}
