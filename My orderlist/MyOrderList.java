public class  MyOrderList{
  Node curser;
  
  public MyOrderList(){}
  
  public void insert(Node newElement){
    
    if(curser==null){
      curser= newElement;
      newElement.next= curser;
      
    }else if(curser==curser.next){
      curser.next= newElement;
      newElement.next=curser;
    }else{
       gotoBeginning();
      boolean a=true;
      Node tail=curser;
      for(;;tail=tail.next){
        if(tail.next.elem==newElement.elem){
          System.out.println("Same key exist\ncan't insert!!!");
          a=false;
          break;
        }
        if(tail.next==curser||newElement.elem<tail.next.elem){
          // System.out.println("debugger");
          break;}
      }
      if(a){
        Node t=tail.next;
        tail.next=newElement;
        newElement.next=t;
      }
    }
  }
  
  public void showList(){
    Node t=curser;
    if(curser==null){
    System.out.println("Empty list!");
    }
    else{
    for(;;t=t.next){
      System.out.println(t.elem);
      if(t.next==curser)break;
    }
  }
  }
  public Node retrive(int searchKey){
    Node tail=curser;
    for(;;tail=tail.next){
      if(tail.elem==searchKey){
        curser=tail;
        return curser;       
      }
      if(tail.next==curser)break;
    }
    
    return null;
  }
  
  public void gotoBeginning(){
    gotoEnd();
    curser=curser.next;
  }  
  public void gotoEnd(){
    for(Node t=curser;;t=t.next){
      if(t.elem>t.next.elem){
        curser=t;
        break;
      }
    }
  }
  
  public void remove(){
    for(Node t=curser;;t=t.next){
      if(t.next==curser){
        
        t.next=curser.next;
        curser=curser.next;
        break;
      }
    }
    
  }
  public void remove(int a){
    retrive(a);
    remove();
  }
  public void clear(){
    curser=null;
  }
  public  boolean isEmpty(){
  if(curser==null)return true;
  return false;
  }
  public Node getCurser(){
  return curser;
  }
  public Node goToNext(){
    if(curser!=null){
    curser=curser.next;
    }
    return curser;
  }
  public Node goToPrior(){
    for(Node t=curser;;t=t.next){
      if(t.next==curser){
        curser=t;
        break;}
      }
    return curser;
  }
}