public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      @SuppressWarnings("unchecked")
      MyDeque<Double> numbers = new MyDeque();
      String num = "";
      char[] ops = new char[] {'+','-','*','/','%'};
      for (int i = 0 ; i < s.length() ; i++){
        for (char op: ops){
          if (s.charAt(i) == op){
            Double first = numbers.getLast();
            numbers.removeLast();
            System.out.println(numbers+"\n");
            Double second = numbers.getLast();
            numbers.removeLast();
            System.out.println(numbers+"\n");
            numbers.addLast(do3(first,second,op));
            System.out.println(numbers+"\n");
          }
        }
        if (s.charAt(i) == ' ' && num.length() > 0){
          numbers.addLast(Double.parseDouble(num));
          System.out.println(numbers+"\n");
          num = "";
        }
        else{
          num += s.charAt(i);
        }
      }
      return numbers.getLast();
    }

    private static Double do3(Double num1, Double num2, char operator){
      if (operator == '+'){
        return num1 + num2;
      }
      if (operator == '-'){
        return num1 - num2;
      }
      if (operator == '/'){
        return num1 / num2;
      }
      if (operator == '*'){
        return num1 * num2;
      }
      return num1 % num2;
    }
}
