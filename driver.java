public class driver{
  public static void main(String[] args){
    @SuppressWarnings("unchecked")
    MyDeque<Integer> DATA = new MyDeque();
    for (int i = 0 ; i < 8 ; i++){
      DATA.addLast((Integer)i);
    }
    System.out.println(DATA.size() + "\n" + DATA);
  }
}
