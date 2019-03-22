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
    for (E item : data){
      ans += item + " ";
    }
    return ans.substring(0,ans.length()-1) + "}";
  }
  public void addFirst(E element){
    start--;
    data[start] = element;
    size++;
  }
  public void addLast(E element){
    data[end] = element;
    end++;
    if (end == data.length){
      loop();
    }
    size++;
  }
  public E removeFirst(){
    E b4 = data[start];
    data[start] = null;
    start++;
    size--;
    return b4;
  }
  public E removeLast(){
    E b4 = data[end];
    data[end] = null;
    end--;
    size--;
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
