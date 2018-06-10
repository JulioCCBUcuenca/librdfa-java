public class main {
   public static void main(String argv[]) {
     System.loadLibrary("rdfaJava"); // Attempts to load example.dll (on Windows) or libexample.so (on Linux)
     System.out.println(rdfa.RDF_TYPE_NAMESPACE_PREFIX);


     System.out.println("Adding and calling a normal C++ callback");
System.out.println("----------------------------------------");

Caller              caller = new Caller();
Callback            callback = new Callback();

caller.setCallback(callback);
caller.call();
caller.delCallback();


callback = new JavaCallback();

System.out.println();
System.out.println("Adding and calling a Java callback");
System.out.println("------------------------------------");

caller.setCallback(callback);
caller.call();
caller.delCallback();

// Test that a double delete does not occur as the object has already been deleted from the C++ layer.
// Note that the garbage collector can also call the delete() method via the finalizer (callback.finalize())
// at any point after here.
callback.delete();

System.out.println();
System.out.println("java exit");

   }
 }

 class JavaCallback extends Callback
 {
   public JavaCallback()
   {
     super();
   }

   public void run1(String ctx)
   {
     System.out.println(ctx);
     System.out.println("JavaCallback.run()");
   }
 }
