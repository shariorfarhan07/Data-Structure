public class ArrayQueue implements Queue{
  int size;
  int front;
  int rear;
  Object [] data;
  
  public ArrayQueue(){
    size=0;
    front = -1;
    rear = -1;
    data = new Object[5];
  }
  public int size(){
    return size;
  }
  
// Returns true if the queue is empty
  public boolean isEmpty(){
    if(size==0)return true ;
    return false;
  }
  
// Adds the new item on the back of the queue, throwing the
// QueueOverflowException if the queue is at maximum capacity. It
// does not throw an exception for an "unbounded" queue, which 
// dynamically adjusts capacity as needed.
  public void enqueue(Object o) throws QueueOverflowException{
    if(rear==-1){
      rear=0;
      front=0;
    }
    if(size==5) throw new QueueOverflowException();
    size++;
    data[rear]=o;
    rear=(rear+1)%data.length;
  } 
  
// Removes the item in the front of the queue, throwing the 
// QueueUnderflowException if the queue is empty.
  public Object dequeue() throws QueueUnderflowException{
    if(0==size)throw new QueueUnderflowException();
    Object a=data[front];
    data[front]=null;
    front=(front+1)%data.length;
    size--;
    return a;
  }
  
// Peeks at the item in the front of the queue, throwing
// QueueUnderflowException if the queue is empty.
  public Object peek() throws QueueUnderflowException{
    return data[front];
  }
  
// Returns a textual representation of items in the queue, in the
// format "[ x y z ]", where x and z are items in the front and
// back of the queue respectively.
  public String toString(){
    if(size==0)return "Empty Queue";
    String a="[ ";
    int n=size;
    for(int i=0;i<size;i++){
      a+=data[n++%data.length]+" ";
    }
    return a+"]";
  }
  
// Returns an array with items in the queue, with the item in the
// front of the queue in the first slot, and back in the last slot.
  public Object[] toArray(){
    Object []a=new Object[size];
    int n=size;
    for(int i=0;i<size;i++){
      a[i]=data[n++%data.length];
    }
    return a;
  }
  
  
// Searches for the given item in the queue, returning the
// offset from the front of the queue if item is found, or -1
// otherwise.
  public int search(Object o){
    int a=0;
    int n=size;
    
    for(int i=0;i<size;i++){
      if(o.equals(data[n++%data.length])){
        return a;
      }
      a++;
    }
    a=-1;
    return a;
  }
}

