package LRU_Cache;

import java.util.HashMap;
public class LRUCache {
    class Node{
        int key,val;
        Node prev,next;
        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    Node head=new Node(-1,-1);
    Node tail=new Node(-1,-1);
    int cap;
    HashMap<Integer,Node> hm=new HashMap<>();
    public LRUCache(int capacity){
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    private void addNode(Node newNode){
        Node temp=head.next;
        newNode.next=temp;
        newNode.prev=head;
        
        head.next=newNode;
        temp.prev=newNode;
    }
    private void deleteNode(Node nn){
        Node oldPrev=nn.prev;
        Node oldNext=nn.next;

        oldPrev.next=oldNext;
        oldNext.prev=oldPrev;
    }
    public void put(int key,int value){
        if(hm.containsKey(key)){
            Node currNode=hm.get(key);
            hm.remove(key);
            deleteNode(currNode);
        }
        if(hm.size()==cap){
            hm.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        addNode(new Node(key, value));
        hm.put(key,head.next);
    }
    public int get(int key){
        if(hm.containsKey(key)){
            Node res=hm.get(key);
            int ans=res.val;
            hm.remove(key);
            deleteNode(res);
            addNode(res);
            hm.put(key,head.next);
            return ans;
        }
        return -1;
    }
    public static void main(String[] args) {
        LRUCache cache=new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));   
        cache.put(3, 3);                    
        System.out.println(cache.get(2));   
        cache.put(4, 4);                    
        System.out.println(cache.get(1));  
        System.out.println(cache.get(3));   
        System.out.println(cache.get(4));

    }
}
