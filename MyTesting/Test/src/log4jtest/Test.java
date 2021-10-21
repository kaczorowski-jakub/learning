package log4jtest;

import org.apache.log4j.Logger;

public class Test {

	private static Logger log = Logger.getLogger(Test.class);
	private static Logger log2 = Logger.getLogger("DUPA");
	public static void main(String[] args) {

		log.trace("Trace Message!");
		log.debug("Debug Message!");
		log.info("Info Message!");
		log.warn("Warn Message!");
		log.error("Error Message!");
		log.fatal("Fatal Message!");
		
		log2.info("DUPA tekst");
	}

}
