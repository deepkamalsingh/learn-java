class A {
    int x; 
    public A(int _x) {
        this.x = _x;
    }
} 

public class Main {


    public static void main(String[] args) {
        A obj = new A(10);
        System.out.println(obj.x);
        A obj2 = new A(20);
        System.out.println(obj2.x);
        obj2.x = 30;
        System.out.println(obj2.x);

    }
  }