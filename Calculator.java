public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      @SuppressWarnings("unchecked")
      MyDeque<Double> numbers = new MyDeque();
      boolean isOp = false;
      String num = "";
      char[] ops = new char[] {'+','-','*','/','%'};
      for (int i = 0 ; i < s.length() ; i++){
        //System.out.println(numbers);
        isOp = false;
        for (char op: ops){
          if (s.charAt(i) == op){
            isOp = true;
            Double second = numbers.getLast();
            numbers.removeLast();
            Double first = numbers.getLast();
            numbers.removeLast();
            numbers.addLast(do3(first,second,op));
            //System.out.println("first: " + first +"\n" + "second: " + second + "\n" + numbers);
          }
        }
        if (s.charAt(i) == ' ' && num.length() > 0){
          numbers.addLast(Double.parseDouble(num));
          num = "";
        }
        else if(!isOp && s.charAt(i) != ' '){
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
