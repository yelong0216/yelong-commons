/**
 * 
 */
package org.yelong.commons.lang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * 
 * @author PengFei
 * @deprecated 冲突的命名。{@link org.apache.commons.lang3.StringUtils}
 * @see StringUtilsE
 */
@Deprecated
public class StringUtils {

	/**
	 * 下划线转驼峰
	 * peng_fei ==> pengFei
	 * 
	 * @param str
	 * @return 下划线转换为驼峰后的字符串
	 * @see StringUtilsE#underscoreToCamelCase(String)
	 */
	public static String underscoreToCamelCase(String str) {
		//利用正则删除下划线，把下划线后一位改成大写
		Pattern pattern = Pattern.compile("_(\\w)");
		Matcher matcher = pattern.matcher(str);
		StringBuffer sb = new StringBuffer(str);
		if(matcher.find()) {
			sb = new StringBuffer();
			//将当前匹配子串替换为指定字符串，并且将替换后的子串以及其之前到上次匹配子串之后的字符串段添加到一个StringBuffer对象里。
			//正则之前的字符和被替换的字符
			matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
			//把之后的也添加到StringBuffer对象里
			matcher.appendTail(sb);			
		}else {
			return sb.toString();
		}	
		return underscoreToCamelCase(sb.toString());
	}

	/**
	 * 驼峰转下划线
	 * pengFei ==> peng_fei
	 * 
	 * @param str 
	 * @return 驼峰转换为下划线后的字符串
	 * @see StringUtilsE#camelCaseToUnderscore(String)
	 */
	public static String camelCaseToUnderscore(String str) {
		Pattern pattern = Pattern.compile("[A-Z]");
		Matcher matcher = pattern.matcher(str);
		StringBuffer sb = new StringBuffer(str);
		if(matcher.find()) {
			sb = new StringBuffer();
			//将当前匹配子串替换为指定字符串，并且将替换后的子串以及其之前到上次匹配子串之后的字符串段添加到一个StringBuffer对象里。
			//正则之前的字符和被替换的字符
			matcher.appendReplacement(sb,"_"+matcher.group(0).toLowerCase());
			//把之后的也添加到StringBuffer对象里
			matcher.appendTail(sb);			
		}else {
			return sb.toString();
		}	
		return camelCaseToUnderscore(sb.toString());
	}

}
