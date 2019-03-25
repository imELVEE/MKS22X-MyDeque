public class driver{
  public static void main(String[] args){
    @SuppressWarnings("unchecked")
    MyDeque<Integer> DATA = new MyDeque();
    for (int i = 0 ; i < 18 ; i++){
      DATA.addLast((Integer)i);
    }
    System.out.println("size: " + DATA.size() + "\n" + DATA);
    System.out.println("remove: " + DATA.removeFirst());
    System.out.println("size: " + DATA.size() + "\n" + DATA);
    System.out.println("remove: " + DATA.removeFirst());
    System.out.println("remove: " + DATA.removeFirst());
    System.out.println("size: " + DATA.size() + "\n" + DATA);
    System.out.println("remove: " + DATA.removeLast());
    System.out.println("size: " + DATA.size() + "\n" + DATA);
    System.out.println("remove: " + DATA.removeLast());
    System.out.println("remove: " + DATA.removeLast());
    DATA.addFirst((Integer)(-3));
    System.out.println("size: " + DATA.size() + "\n" + DATA);

  }
}
