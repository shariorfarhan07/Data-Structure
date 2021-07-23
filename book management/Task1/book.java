public class book{
  public String name;
  public int id;
  public String author;
  public String publisher;
  private static int count=1;
  public book(String n,String m,String s){
    name=n;
    author=m;
    publisher=s;
    id=count++;
    
  }
  public String toString(){
  return ""+name+"\t"+id+"\t"+author+"\t"+publisher;
  }
}