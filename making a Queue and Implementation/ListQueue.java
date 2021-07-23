public class ListQueue implements Queue{
  int size;
  Node front;
  Node rear;
  
  
  public ListQueue(){
    size = 0;
    front = null;
    rear = null;
  }
  public int size(){
    return size;
  }
  
// Returns true if the queue is empty
  public boolean isEmpty(){
    if(null==front) return true;
    return false;
  } 
  
// Adds the new item on the back of the queue, throwing the
// QueueOverflowException if the queue is at maximum capacity. It
// does not throw an exception for an "unbounded" queue, which 
// dynamically adjusts capacity as needed.
  public void enqueue(Object o) throws QueueOverflowException{
    size++;
    
    rear=new Node(o,rear);
    front=null;
    for(Node i=rear;i!=null;i=i.next){
      front=new Node(i.val,front);
    }
    
  } 
  
// Removes the item in the front of the queue, throwing the 
// QueueUnderflowException if the queue is empty.
  public Object dequeue() throws QueueUnderflowException{
    if(0==size) throw new QueueUnderflowException();
    size--;
    Object e=front.val;
    front=front.next;
    
    return e;
  }
  
// Peeks at the item in the front of the queue, throwing
// QueueUnderflowException if the queue is empty.
  public Object peek() throws QueueUnderflowException{
    return front;
  }
  
// Returns a textual representation of items in the queue, in the
// format "[ x y z ]", where x and z are items in the front and
// back of the queue respectively.
  public String toString(){
    if(size==0)return "Empty Queue";
    String a="[ ";
    for(Node i=rear;i!=null;i=i.next){
      a+=i.val+" ";   
    }
    return a+"]";
  }
  
// Returns an array with items in the queue, with the item in the
// front of the queue in the first slot, and back in the last slot.
  public Object[] toArray(){
    Object[]a=new Object[size];
    int count=0;
    
    for(Node i=front;i!=null;i=i.next){
      a[count++%a.length]=i.val; 
    }
    return a;
  }
  
// Searches for the given item in the queue, returning the
// offset from the front of the queue if item is found, or -1
// otherwise.
  public int search(Object o){
    int a=0;
    for(Node i=front;i!=null;i=i.next){
    
      if(i.val.equals(o)) return a;
        a++;
    }
    a=-1;
    return a;
  }
}
