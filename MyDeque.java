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
    for (int i = start ; i != end ; i++){
      if (i == data.length){
          i = 0;
      }
      ans += data[i] + " ";
    }
    return ans.substring(0,ans.length()-1) + "}";
  }
  public void addFirst(E element){
    start--;
    if (start == -1 || start == end){
      biggerCopy(data);
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
    if (end == start){
      biggerCopy(data);
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
    E b4 = data[end];
    data[end] = null;
    end--;
    size--;
    if (end == -1)
      end = data.length-1;
    while (data[end] == null)
      end--;
    return b4;
  }
  public E getFirst(){
    return data[start];
  }
  public E getLast(){
    return data[end];
  }

  private void biggerCopy(E[] ary){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[ary.length*2];
    data = d;
    start += ary.length-1;
    end = start;
    size = 0;
    for (E item: ary){
      if (item == null)
        size--;
      addLast(item);
    }
  }

  private void loop(){
    if (start > 0){
      end = 0;
    }
    else{
      biggerCopy(data);
    }
  }


}
