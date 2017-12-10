import java.util.*;

/**
 * 
 */

/**
 * @author Peter
 *
 */
public class PrefixAverageTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[] x = new double[500000];
		Arrays.fill(x,0.0);
		long startTime = System.currentTimeMillis();
		PrefixAverage.prefixAverage1(x);
		long lap1 = System.currentTimeMillis();
		PrefixAverage.prefixAverage2(x);
		long lap2 = System.currentTimeMillis();
		System.out.println("Time for prefixAverage1: "+(lap1-startTime)+" ms");
		System.out.println("Time for prefixAverage2: "+(lap2-lap1)+" ms");
	}
}
