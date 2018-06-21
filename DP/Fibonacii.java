import java.util.*;
class Fibonacii {

  private int fibDp(int num, Map<Integer,Integer> fibMap){;
    if(num <= 0) return 0;
    if(num == 1) return 1;
    if(fibMap.containsKey(num)) return fibMap.get(num);
    Integer fib =  fibDp(num-1, fibMap)+fibDp(num-2, fibMap);
    fibMap.put(num, fib);
    return fib;
  }
  
  public static void main(String[] args) {
    Fibonacii m = new Fibonacii();
    int fib = m.fibDp(500,new HashMap());
    System.out.println("fib = " + fib);
  }
}