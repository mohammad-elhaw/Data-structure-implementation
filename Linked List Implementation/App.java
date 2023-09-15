public class App {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();

//        list.insert(10);
//        list.insert(-2);
//        list.insert(3);
//        list.insert(100);

        list.insert("mohammad");
        list.insert("Ahmed");
        list.insert("Hesham");
        list.insert("Esmaeal");


        list.traverseList();
        System.out.println(list.size());

        //list.remove(3);
        list.traverseList();
        System.out.println(list.size());
    }
}
