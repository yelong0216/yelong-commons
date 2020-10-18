/**
 * 
 */
package test.org.yelong.commons.lang;

import org.junit.jupiter.api.Test;
import org.yelong.commons.lang.ByteUtilsE;

/**
 *
 */
public class ByteUtilsETest {

	@Test
	public void toBase64() {
		System.out.println(ByteUtilsE.toBase64("yelong".getBytes()));
	}

}
