public class FibonacciSequence implements Runnable
{
private int x;
public  int answer;

public FibonacciSequence(int x) {
    this.x = x;
}

public void run() {
    if( x < 2 )
        answer = 1;
    else {
        try {
        	FibonacciSequence f1= new FibonacciSequence(x-1);
        	FibonacciSequence f2= new FibonacciSequence(x-2);
            Thread threadf1=new Thread(f1);
            Thread threadf2=new Thread(f2);
            threadf1.start();
            threadf2.start();
            threadf1.join();
            threadf2.join();

            answer = f1.answer + f2.answer;

        }
        catch(InterruptedException ex) { }
    }
}

public static void main(String[] args)

{
    try {

            for (int i=0;i<19;i++){
            	FibonacciSequence f= new FibonacciSequence(i);
                Thread threadf= new Thread(f);
                threadf.start();
                threadf.join();
                Thread.sleep(500);

                System.out.println("Results:"+f.answer);

            }
            
          
        }

    catch(Exception e) {
        System.out.println("usage: java Fib NUMBER");
    }
  }
}