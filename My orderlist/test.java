public class test{
  public static void main(String arg[]){
   MyOrderList m=new  MyOrderList();
   m.insert(new Node(1,null));
   m.insert(new Node(3,null));
   m.insert(new Node(4,null));
   m.insert(new Node(2,null));
   m.showList();
   System.out.println("return "+m.retrive(3).elem);
   m.gotoEnd();
   System.out.println("gotoEnd "+m.curser.elem);
   m.gotoBeginning();
   System.out.println("gotoStart "+m.curser.elem);
   m.remove();
  m.showList();
    System.out.println("remove 3 ");
   m.remove(3);
    System.out.println(m.isEmpty());
   m.showList();
   m.insert(new Node(10,null));
   m.insert(new Node(31,null));
   m.insert(new Node(41,null));
   m.insert(new Node(22,null));
   m.goToPrior();
   System.out.println("goToPrior "+m.curser.elem);
    m.gotoBeginning();
     m.showList();
    m. gotoEnd();
    m.showList();
    
    m.goToPrior();
     System.out.println("goToPrior "+m.curser.elem);
  }
}