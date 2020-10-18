/**
 * 
 */
package test.org.yelong.commons.lang;

import javax.script.ScriptException;

import org.junit.jupiter.api.Test;
import org.yelong.commons.lang.MathUtilsE;

/**
 *
 */
public class MathUtilsETest {

	@Test
	public void txfloat() {
		System.out.println(MathUtilsE.txfloat(10, 3));
	}

	@Test
	public void eval() throws ScriptException {
		System.out.println(MathUtilsE.eval("10*10/2.5"));
	}

}
