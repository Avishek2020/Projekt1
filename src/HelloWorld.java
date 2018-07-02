import java.util.concurrent.RecursiveTask;

 class HellowWorld extends RecursiveTask<Integer> {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int n;
	HellowWorld(int n) { 
		
		this.n = n; }
	   protected Integer compute() {
	     if (n <= 1)
	        return n;
	     HellowWorld f1 = new HellowWorld(n - 1);
	     f1.fork();
	     HellowWorld f2 = new HellowWorld(n - 2);
	     return f2.compute() + f1.join();
	  
	   }
	   public static void main(String args[])
	 	{
		   HellowWorld f = new HellowWorld(8);
		   System.out.println("Results:"+f);
	 	}
	   
	 }