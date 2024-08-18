package collection.set;

import w3resource.indexInterface.p4.IAccount;

class BinaryTree <T extends Comparable>{
    BinaryTree LeftSub;
    T Node;
    BinaryTree RightSub;

    void Insert(BinaryTree<T> searchTree, T node){
        if(searchTree == null)
            searchTree.Node = node;
        else if(node.compareTo(searchTree.Node) < 0)
                Insert(LeftSub, node);
            else
                Insert(RightSub, node);
    }
    ///https://en.wikipedia.org/wiki/Tree_sort#Efficiency

}
public class DemoSet implements IAccount {


    public static void lesson(){
//        HashSet<Person> hs = new HashSet<>();
//        LinkedHashSet<Person> lhs = new LinkedHashSet<>();
//        Person p = new Person("A", "B", 100);
//        hs.add(p);
//        p = new Person("A1", "B2", 100);
//        hs.add(p);
//
//        Iterator<Person> h = hs.iterator();
//        while (h.hasNext()){
//            System.out.println(h.next());
//        }
//        h = lhs.iterator();
//        while (h.hasNext()){
//            System.out.println(h.next());
//        }
//        TreeSet<Integer> treeSet = new TreeSet<>();
//        treeSet.add(13);
//        treeSet.add(33);
//        treeSet.add(43);
//        treeSet.add(23);
//        treeSet.add(19);
//        Iterator<Integer> hi = treeSet.iterator();
//        while (hi.hasNext()){
//            System.out.println(hi.next());
//        }

    }
    public static void ref_eq(){
        DemoSet demoSet = new DemoSet();
        IAccount account = demoSet;
        DemoSet  demoSet1 = new DemoSet();
        System.out.println(account ==  demoSet);
        System.out.println(demoSet1 == demoSet);
    }

    @Override
    public void withdraw(double amount) {

    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public double interest() {
        return 0;
    }

    @Override
    public void viewBalance() {

    }


}
