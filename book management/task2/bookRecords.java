import java.io.*;
import java.util.*;
import java.math.*;

public class bookRecords{
  book[]a;
  private int size=0;
  Scanner sc=new Scanner(System.in);
  Scanner file;
  public bookRecords(){
   read  r=new read();
   try{
  book[]a=r.readBook();
   }catch(Exception e){
   System.out.println("cant read");
   }
  if(a!=null)this.a=a;
  else a=new book[5];
  }

  public void AddRecord(){
    System.out.println("Enter Book Name:");
    String aa=sc.nextLine();
    System.out.println("Enter Book Author:");
    String b=sc.nextLine();
    System.out.println("Enter Book Publisher:");
    String c=sc.nextLine();
    if(size==a.length){
      book bb[]=new book[a.length+5];
      for(int i=0;i<a.length;i++){
        bb[i]=a[i];
        a=bb;
      }
    }
    a[size++]=new book(aa,b,c);
    System.out.println("success fully added");
    
  }
  public void printRecord(){
    book tep[]=a;
    for(int i =0;i<size;i++){
      
      for(int ii =i+1;ii<size;ii++){
        int aaa=((a[i].name).compareTo(a[ii].name));
        if(aaa>0){
          book temp=a[i];//thank you garbage collector for making my life easy
          a[i]=a[ii];
          a[ii]=temp;
        }else if(aaa==0){
          if(a[i].id>a[ii].id){
            book temp=a[i];//thank you garbage collector for making my life easy
            a[i]=a[ii];
            a[ii]=temp;
          }
        }
      }
    }
    System.out.println("Name    Id    Author    Publisher");
    for(int i =0;i<size;i++){
      
      System.out.println(a[i].name+"\t"+a[i].id+"\t"+a[i].author+"\t"+a[i].publisher);
    }
    a=tep;
  }
  
  public void deleteRecord(int b){
    if(b>=size||b<0){
      System.out.println("ID "+b+" does not exist!");
    }else{
      for(int i=b;i<size;i++){
        a[i]=a[i+1];
      }
      a[size-1]=null;
      size--;
      System.out.println("ID "+b+" was deleted successfully");
    }
  }
  public void editRecord(int b){
    
    
    System.out.println("press following number to edit \n1 Name\n2 author\n3 publisher ");
    System.out.println(a[b]);
   int num=0;
    int i=1;
    do{ try{
     num=sc.nextInt();
     i=0;
    }catch(Exception e){
    
    }}while(i!=0);
    sc.nextLine();
    String s=sc.nextLine();
    if(b>=0&&b<size){
      if(num==1){a[b].name=s; }
      else if(num==2){a[b].author=s;}
      else if(num==3){a[b].publisher=s;}
    }  
  }
  public String save(){
    String aa=""; 
    for(int i =0;i<size;i++){
      
      aa+=a[i].name+"\t"+a[i].id+"\t"+a[i].author+"\t"+a[i].publisher+"\n";
    }
    return aa;
  }
  
}