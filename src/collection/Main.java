package collection;

import collection.list.AList;
import collection.set.DemoSet;
import oop.access.A;

import java.util.*;

import static java.util.Arrays.*;

public class Main {
    static class Node{
        String name;
        String type;
        private List<Node> parents;
        private List<Node> nodes;
        private void setParents(Node[] parents){
            for(Node p : parents)
                setParent(p);
        }
        private void setParent(Node parent){
            parent.nodes.add(this);
            this.parents.add(parent);
        }
        private Node(){
            nodes = new ArrayList<>();
            parents = new ArrayList<>();
        }
        public Node(String name, String type, Node[] parents){
            this();
            setParents(parents);
            this.name = name;
            this.type = type;
        }
        public Node(String name, String type){
            this();
            this.name = name;
            this.type = type;
        }
    }
    private  static void MapNodes(){
        Node iterable = new Node("Iterable","I");
        Node collection = new Node("Collection", "I", new Node[]{iterable});
        Node list = new Node("List", "I", new Node[]{collection});
        Node queue = new Node("Queue", "I", new Node[]{collection});
        Node dequeue = new Node("Dequeue", "I", new Node[]{collection});
        Node set = new Node("Set", "I", new Node[]{collection});
        Node arrayList = new Node("ArrayList", "C", new Node[]{list});
        Node vector = new Node("Vector", "C", new Node[]{list});
        Node linkList = new Node("LinkList", "C", new Node[]{list, queue, dequeue});
        Node priorityQueue = new Node("PriorityQueue", "C", new Node[]{queue});
        Node arrayDeque = new Node("arrayDeque", "C", new Node[]{queue});
        Node hasSet = new Node("hasSet", "C", new Node[]{set});
        Node linkedHashSet = new Node("linkedHashSet", "C", new Node[]{set});
        Node sortSet = new Node("sortSet", "I", new Node[]{set});
        Node treeSet = new Node("treeSet", "C", new Node[]{sortSet});

    }
    public static void main(String[] args){
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {1, 2, 6, 7, 8, 9};
        List<Integer> la, lb, tmp;
        la = new ArrayList<>(stream(a).boxed().toList());
        lb = new ArrayList<>(stream(b).boxed().toList());
        tmp =  new ArrayList<>(la);
        la.removeAll(lb);
        lb.removeAll(tmp);
        tmp.clear();

        TreeSet<Integer> hs = new TreeSet<>();
        hs.addAll(la);
        hs.addAll(lb);

        for (Integer i : hs){
              System.out.println(i);
        }
    }
}
