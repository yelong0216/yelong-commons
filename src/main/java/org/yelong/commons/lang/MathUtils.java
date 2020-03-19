/**
 * 
 */
package org.yelong.commons.lang;

import java.text.DecimalFormat;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author PengFei
 */
public class MathUtils {

	static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");

	/**
	 * 除法运算，保留两位小数
	 * @param a 除数
	 * @param b 被除数
	 * @return 运算后结果
	 */
	public static String txfloat(int a,int b) {
		DecimalFormat df = new DecimalFormat ("0.00");
		return df.format((float)a/b);
	}

	/**
	 * 除法运算，保留两位小数
	 * @param a 除数
	 * @param b 被除数
	 * @return 运算后结果
	 */
	public static String txfloat(long a,long b) {
		DecimalFormat df = new DecimalFormat ("0.00");
		return df.format((float)a/b);
	}

	/**
	 * 计算str的表达式
	 * @param str 数学计算表达式
	 * @return 计算后的值
	 */
	public static Number eval(String str) throws ScriptException{
		return (Number)jse.eval(str);
	}

}
