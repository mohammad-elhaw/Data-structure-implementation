
@SuppressWarnings("unchecked")
public class HashTable<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int numOfItems;
    private int capacity;

    public HashTable() {
        this.keys = (Key[]) new Object[Constants.TABLE_SIZE];
        this.values = (Value[]) new Object[Constants.TABLE_SIZE];
        this.numOfItems = 0;
        this.capacity = Constants.TABLE_SIZE;
    }


    public HashTable(int newCapacity) {
        this.keys = (Key[]) new Object[newCapacity];
        this.values = (Value[]) new Object[newCapacity];
        this.numOfItems = 0;
        this.capacity = newCapacity;
    }

    public int size(){
        return numOfItems;
    }

    public boolean isEmpty(){
        return numOfItems == 0;
    }

    public void put(Key key, Value value){
        if(key == null || value == null) return;

        if(numOfItems >= capacity * 0.75){
            System.out.println("doubling the size of the hash table");
            resize(2 * capacity);
        }

        int hashingKey = hash(key);
        while(keys[hashingKey] != null){
            // update
            if(keys[hashingKey].equals(key)){
                values[hashingKey] = value;
                return;
            }

            hashingKey = (hashingKey + 1) % capacity;
        }
        keys[hashingKey] = key;
        values[hashingKey] = value;
        numOfItems++;
    }


    public Value get(Key key){
        if(key == null) return null;
        int hashingKey = hash(key);
        while(keys[hashingKey] != null){
            if(keys[hashingKey].equals(key)){
                return values[hashingKey];
            }
            hashingKey = (hashingKey + 1) % capacity;
        }
        return null;
    }

    public void remove(Key key){
        if(key == null) return;

        int hashingKey = hash(key);

        while(!keys[hashingKey].equals(key)){
            if(keys[hashingKey] == null) return;
            hashingKey = (hashingKey + 1) % capacity;
        }
        keys[hashingKey] = null;
        values[hashingKey] = null;
        numOfItems--;

        hashingKey = (hashingKey + 1) % capacity;
        while(keys[hashingKey] != null){
            Key tempKey = keys[hashingKey];
            Value tempValue = values[hashingKey];
            numOfItems--;
            keys[hashingKey] = null;
            values[hashingKey] = null;
            put(tempKey, tempValue);

            hashingKey = (hashingKey + 1) % capacity;
        }

        if(numOfItems <= capacity / 3){
            System.out.println("Resizing the table: half the size");
            resize(capacity / 2);
        }
    }

    private void resize(int newCapacity) {
        HashTable<Key, Value> newTable = new HashTable<>(newCapacity);

        for(int i = 0; i < capacity; ++i){
            if(keys[i] != null)
                newTable.put(keys[i], values[i]);
        }
        keys = newTable.getKeys();
        values = newTable.getValues();
        capacity = newTable.getCapacity();
    }

    private int hash(Key key){
        return Math.abs(key.hashCode() % capacity);
    }

    public Key[] getKeys() {
        return keys;
    }

    public void setKeys(Key[] keys) {
        this.keys = keys;
    }

    public Value[] getValues() {
        return values;
    }

    public void setValues(Value[] values) {
        this.values = values;
    }

    public int getNumOfItems() {
        return numOfItems;
    }

    public void setNumOfItems(int numOfItems) {
        this.numOfItems = numOfItems;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
