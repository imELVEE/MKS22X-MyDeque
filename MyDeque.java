public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    start = 0;
    end = 0;
    size = 0;
  }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    start = 0;
    end = 0;
    size = 0;
  }
  public int size(){
    return size;
  }
  public String toString(){
    String ans = "{";
    for (int i = start ; i != end+1 ; i++){
      if (i == data.length){
          i = 0;
      }
      if (data[i] != null)
        ans += data[i] + " ";
    }
    //ans += data[end] + " ";
    return ans.substring(0,ans.length()-1) + "}";
  }
  public void addFirst(E element){
    if (size == 0){
      addLast(element);
    }
    else{
      start--;
      if (start == -1){
        start = data.length-1;
      }
      if (start == end){
        biggerCopy(data,"start");
      }
      data[start] = element;
      size++;
    }
  }
  public void addLast(E element){
    if (size == 0){
      data[end] = element;
      size++;
      end++;
    }
    else{
      end++;
      if (end == data.length){
        loop();
      }
      else if (end == start){
        biggerCopy(data,"start");
      }
      data[end] = element;
      size++;
    }
  }
  public E removeFirst(){
    E b4 = data[start];
    data[start] = null;
    size--;
    if (start == end){
      return b4;
    }
    start++;
    if (start == data.length)
      start = 0;
    while (data[start] == null){
      start++;
      if (start == end)
        return b4;
    }
    return b4;
  }
  public E removeLast(){
    E b4 = data[end];
    data[end] = null;
    size--;
    if (end == start){
      return b4;
    }
    end--;
    if (end == -1)
      end = start+size-1;
    return b4;
  }
  public E getFirst(){
    return data[start];
  }
  public E getLast(){
    return data[end];
  }

  private void biggerCopy(E[] ary, String mode){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[ary.length*2];
    data = d;
    if (mode.equals("start")){
      start += ary.length;
    }

    for (int i = start ; i != end ; i++){
      if (i == data.length){
          i = 0;
          mode = "end";
      }
      if (mode.equals("start")){
        if (i-ary.length > -1){
          data[i] = ary[i-ary.length];
        }
      }
      else{
        data[i] = ary[i];
      }
    }

    System.out.println("ENDING-1: " + ary[end-1]);
    System.out.println("ARY LENGTH: " + ary.length);
    System.out.println("Start index: " + start);
    System.out.println("End index: " + end);
  }

  private void loop(){
    if (start > 0){
      end = 0;
    }
    else{
      biggerCopy(data,"end");
    }
  }


}
