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
    for (int i = start ; i != (end-1) ; i++){
      if (i == data.length){
          i = 0;
      }
      if (data[i] != null)
        ans += data[i] + " ";
    }
    ans += data[(end-1)] + " ";
    return ans.substring(0,ans.length()-1) + "}";
  }
  public void addFirst(E element){
    start--;
    if (start == -1 || start == (end+1)){
      biggerCopy(data,"start");
    }
    data[start] = element;
    size++;
  }
  public void addLast(E element){
    data[end] = element;
    end++;
    size++;
    if (end == data.length){
      loop();
    }
    else if (end == start){
      biggerCopy(data,"end");
    }
  }
  public E removeFirst(){
    E b4 = data[start];
    data[start] = null;
    start++;
    size--;
    if (start == data.length)
      start = 0;
    while (data[start] == null){
      start++;
    }
    return b4;
  }
  public E removeLast(){
    if ((end-1) != start){
      E b4 = data[(end-1)];
      data[(end-1)] = null;
      end--;
      size--;
      if ((end-1) == -1)
        end = data.length-1;
      while (data[(end-1)] == null)
        end--;
      return b4;
    }
    E b4 = data[(end-1)];
    data[(end-1)]=null;
    return b4;
  }
  public E getFirst(){
    return data[start];
  }
  public E getLast(){
    return data[(end-1)];
  }

  private void biggerCopy(E[] ary, String mode){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[ary.length*2];
    data = d;
    if (mode.equals("start")){
      start += ary.length;
    }
    for (int i = start ; i != (end-1) ; i++){
      if (i == data.length){
          i = 0;
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
  }

  private void loop(){
    if (start > 0){
      end = 0;
    }
    else{
      biggerCopy(data,"(end-1)");
    }
  }


}
