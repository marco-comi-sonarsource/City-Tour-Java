package foo;

/**
 * Foo class
 */
public class Foo {
    
    // Public field = not good for encapsulation
    public int aNumber;

    public static int div(int a, int b) throws Exception {
    	if (b == 0) {
    		throw new UnsupportedOperationException("Can't divide by zero!");
    	}
        return a / b;  
    }

}
