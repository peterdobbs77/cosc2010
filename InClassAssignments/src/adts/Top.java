/**
 * 
 */
package adts;

/**
 * @author Peter
 *
 */
public class Top {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedStringLog log = new LinkedStringLog("test");
		log.insert("test1");
		log.insertLast("test2");
		log.insertLast("test3");
		System.out.println(log.toString());
		try {
			log.removeFirst();
			log.remove("test3");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(log.toString());
	}

}
