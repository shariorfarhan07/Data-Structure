public class CircularArray{
  
  private int start;
  private int size;
  private Object [] cir;
  
  /*
   * if Object [] lin = {10, 20, 30, 40, null}
   * then, CircularArray(lin, 2, 4) will generate
   * Object [] cir = {40, null, 10, 20, 30}
   */
  public CircularArray(Object [] lin, int st, int sz){
    size=sz;
    start=st;
    cir=new Object[lin.length];
    for(int i =0;i<lin.length;i++){
      cir[st++%cir.length]=lin[i];
      //st++;
    }
  }
  
  //Prints from index --> 0 to cir.length-1
  public void printFullLinear(){
    for(int i =0;i<cir.length;i++){
      System.out.print(cir[i]);
      if(i<cir.length-1)
      { System.out.print(',');}
      else
      { System.out.print('.');}
    }
    System.out.println();
  }
  
  // Starts Printing from index start. Prints a total of size elements
  public void printForward(){
    int st=start;
    for(int i =0;i<size;i++){
      System.out.print(cir[st++%cir.length]);
      if(i<size-1)
      { System.out.print(',');}
      else
      { System.out.print(".\n");}
    }
  }
  
  
  
  public void printBackward(){
    int end=(start+size-1)%cir.length;
    for(int i =0;i<size;i++){
      System.out.print(cir[end--]);
      if(i<size-1)
      { System.out.print(',');}
      else
      { System.out.print('.');}
      if(end<=0)
        end=cir.length-1;
      
    }
  }
  
  // With no null cells
  public void linearize(){
    Object a[]=new Object[cir.length];
    int st=start;
    start=0;
    for(int i=0; i <size;i++){
      a[i]=cir[st++%cir.length];
    }
    cir=a;
  }
  
  // Do not change the Start index
  public void resizeStartUnchanged(int newcapacity){
    Object a[]=new Object[newcapacity];
    int st=start;
    for(int i=0;size>i;i++){
      a[st%a.length]=cir[(st++)%cir.length];
    }
    cir=a;
  }
  
  // Start index becomes zero
  public void resizeByLinearize(int newcapacity){
    linearize();
    resizeStartUnchanged(newcapacity);
  }
  
  /* pos --> position relative to start. Valid range of pos--> 0 to size.
   * Increase array length by 3 if size==cir.length
   * use resizeStartUnchanged() for resizing.
   */
  public void insertByRightShift(Object elem, int pos){
    if(size==cir.length)
      resizeStartUnchanged(3+cir.length);
    int index=(start+pos)%cir.length;
    Object a []=new Object[size-pos];
    for(int i=0;i<a.length;i++){
      a[i]=cir[index++];
    }
    index=(start+pos)%cir.length;
    cir[index++]=elem;
    for(int i=0;i<a.length;i++){
      cir[index++]=a[i];
    }
    size++;
  }
  
  public void insertByLeftShift(Object elem, int pos){
    if(size==cir.length)
      resizeStartUnchanged(3+cir.length);
    
    int index=(start+pos-1)%cir.length;
    Object a []=new Object[pos];
    int st=start;
    for(int i =0;i<a.length;i++){
      a[i]=cir[st++%cir.length];
    }
    
    //System.out.println(java.util.Arrays.toString(cir));
    // System.out.println(java.util.Arrays.toString(a));
    cir[index]=elem;
    start--;
    
    if(start<0){
      start=cir.length-1;
    }
    st=start;
    
    
    for(int i =0;i<a.length;i++){
      cir[st++%cir.length]=a[i];
    }
    
    //  System.out.println(java.util.Arrays.toString(cir));
    // System.out.println(java.util.Arrays.toString(a));
    
    //  System.out.println(size);
    // System.out.println(start);
    
  }
  
  public void removeByLeftShift(int pos){
    Object a[]=new Object[size-pos-1];
    int end =(start+size-1)%cir.length;
    int index=(start+pos+1)%cir.length;
    
    for(int i =0;i<a.length;i++){
      a[i]=cir[index++%cir.length];
    }
   // System.out.println(java.util.Arrays.toString(cir));
   // System.out.println(java.util.Arrays.toString(a));
   // System.out.println(size);
   // System.out.println(start);
    
    cir[end]=null;
    size--;
    index=(start+pos)%cir.length;
    for(int i =0;i<a.length;i++){
      cir[index++%cir.length]=a[i];
    }
    
  //  System.out.println(java.util.Arrays.toString(cir));
  //  System.out.println(java.util.Arrays.toString(a));
   // System.out.println(size);
   // System.out.println(start);
    
  }
  
  /* parameter--> pos. pos --> position relative to start.
   * Valid range of pos--> 0 to size-1
   */
  public void removeByRightShift(int pos){
    int index=(start+pos-1)%cir.length;
    int st=start;
    Object a[]=new Object[pos];
    
    for(int i =0;i<a.length;i++){
      a[i]=cir[st++%cir.length];
    }
    
    // System.out.println(java.util.Arrays.toString(cir));
    //  System.out.println(java.util.Arrays.toString(a));
    
    cir[start]=null;
    st=++start;
    size--;
    for(int i =0;i<a.length;i++){
      cir[st++%cir.length]=a[i];
    }
    // System.out.println(start);
    // System.out.println(java.util.Arrays.toString(cir));
    //  System.out.println(java.util.Arrays.toString(a));
    
  }
  
  
  //This method will check whether the array is palindrome or not
  public void palindromeCheck(){
    int st=start;
    int c=0;
    int end=(start+size-1)%cir.length;
    for(int i =0;i<cir.length/2;i++){
      if(cir[(st)%cir.length]==cir[(end)]){
        c++;
      }
      st=st+i;
      end=end-i;
      if(end<0)end=cir.length-1;
    }
    if(c==cir.length/2){
      System.out.println("This array is a palindrome");
    }else{
      System.out.println("This array is not palindrome");
    }
  }
  
  
  //This method will sort the values by keeping the start unchanged
  public void sort(){
    int st=start;
    int si=size;
    linearize();
    int min=0;
    for(int i=0;i<size;i++){
      for(int ii=i+1;ii<size;ii++){
        if((int)cir[i]>(int)cir[ii]){
        min=ii;
        }
      }
      Object temp=cir[min];
      cir[min]=cir[i];
      cir[i]=temp;      
    }
    Object a[]=new Object[cir.length];
  
    st=start;
  for(int i=0;i<size;i++){
      a[st++%a.length]=cir[i];
     }
   cir=a;
  }
  
  //This method will check the given array across the base array and if they are equivalent interms of values return true, or else return false
  public boolean equivalent(CircularArray k){
    int st=start;
    int st1=k.start;
    if(size!=k.size) return false;
    for(int i=0;i<size;i++){
      if(cir[st++%cir.length]!=k.cir[st1++%k.cir.length]) return false;    
    }
    
    return true; 
  }
}