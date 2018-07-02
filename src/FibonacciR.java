import java.util.concurrent.RecursiveTask;

class FibonacciR extends RecursiveTask<Integer> {
   final int n;
   FibonacciR(int n) { this.n = n; }
   protected Integer compute() {
     if (n <= 1)
        return n;
     FibonacciR f1 = new FibonacciR(n - 1);
     f1.fork();
     FibonacciR f2 = new FibonacciR(n - 2);
     return f2.compute() + f1.join();
   }
 }