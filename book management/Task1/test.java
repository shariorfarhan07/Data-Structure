import java.util.Scanner;
public class test{
  public static void main(String arg[]){
    Scanner sc =new Scanner(System.in);
    bookRecords n=new bookRecords();
    while (true){
      System.out.println("Enter 1 to Add a Record\nEnter 2 to Print the Records\nEnter 3 to Delete a Record\nEnter 4 to Edit a Record"); 
      int a=sc.nextInt();
      try{
        switch(a){
          case 1:
            n.AddRecord();
            break;
          case 2:
            n.printRecord();
            break;
          case 3:
            System.out.println("Enter Id number to delete record");
            n.deleteRecord(sc.nextInt());
            break;
          case 4:
            System.out.println("Enter Id number to Edit record");
            n.editRecord(sc.nextInt());
            break;
        }
        
      }catch(Exception e ){
        System.out.println("enter valid value");
      }
      System.out.println("Do you want to continue");
      sc.nextLine();
      String sss=sc.nextLine();
      if(!(sss.toLowerCase()).equals("y"))break;
    }
  }
}