//import java.util.*;

public class DoublyList{
    public Node head;
    
    
    /* First Constructor:
     * Creates a linked list using the values from the given array. head will refer
     * to the Node that contains the element from a[0]
     */ 
    public DoublyList(Object [] a){
        head = new Node(null, null, null);
        Node tail = head;
        
        for(int i = 0; i<a.length; i++){
            Node mn = new Node(a[i], null, null);
            tail.next = mn;
            mn.prev=tail;
            tail=tail.next;
        }
        tail.next=head; // Making it circular
        head.prev=tail;
    }
    
    /* Second Constructor:
     * Sets the value of head. head will refer
     * to the given LinkedList
     */
    public DoublyList(Node h){
        head = h;
    }
    
    /* Counts the number of Nodes in the list */
    public int countNode(){
        int count=0;
        for(Node t=head;t.next!=head;t=t.next){
        count++;
        }
        
        return count; // please remove this line!
    }
    
    /* prints the elements in the list */
    public void forwardprint(){
        for(Node t=head.next;;t=t.next){
        System.out.print(t.element);
        if(t.next!=head){
        System.out.print(",");
       
        }else{
        System.out.println(".");
        break;
        }
    }
    }
    
    public void backwardprint(){
      Node t;
      for( t=head;;t=t.next){
        if(t.next!=head){break;}
      }
      for( t=t.prev;;t=t.prev){
        System.out.print(t.element);
        if(t.prev!=head){
        System.out.print(",");
        }else{
        System.out.println(".");
        break;
        
        }
      }
      
      
    }
    
    
    // returns the reference of the Node at the given index. For invalid index return null.
    public Node nodeAt(int idx){
        int count=0;
        Node n=null;
         for(Node t=head.next;;t=t.next){
           if(count==idx){
           n=t;
           break;
           }
           if(t.next==head){
           break;
           }
           count++;
        }
        
        return n; // please remove this line!
    }
    
    
    
    /* returns the index of the Node containing the given element.
     if the element does not exist in the List, return -1.
     */
    public int indexOf(Object elem){
        int count=0;
        Object n=null;
         for(Node t=head.next;;t=t.next){
           if(elem.equals(t.element)){
           n=t.element;
           return count;
           }
           if(t.next==head){
           break;
           }
           count++;
        }
          
        return -1; // please remove this line!
    }
    
    
    
    /* inserts Node containing the given element at the given index
     * Check validity of index.
     */
    public void insert(Object elem, int idx){
      int count=0;
        Node n=null;
         for(Node t=head;;t=t.next){
           if(count==idx){
           n=t;
           break;
           }
           if(t.next==head){
           break;
           }
           count++;
        }
    // System.out.println(n.element);
      Node nn=new Node(elem,n.next,n);
      n.next=nn;
      n.next.next.prev=nn;
        
    }
    
    
    
    
    /* removes Node at the given index. returns element of the removed node.
     * Check validity of index. return null if index is invalid.
     */
    public Object remove(int index){
        int count=-1;
        Object a=null;
        Node n=null;
         for(Node t=head;;t=t.next){
           if(count==index){
           n=t;
           break;
           }
           if(t.next==head){
           break;
           }
           count++;
        }
         if(n!=null)a=n.element;
      //  System.out.println(n.element);
        
       // Node p=n.prev;
       // Node ne=n.next;
        n.prev.next=n.next;
        n.next.prev=n.prev;  
         return a; // please remove this line!
    }
    
    
    
}