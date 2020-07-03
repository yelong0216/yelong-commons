/**
 * 
 */
package org.yelong.commons.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 双向映射
 * 
 * 可以通过左边获取右边
 * 
 * 右边也可以获取左边，且双向的均保持唯一
 * 
 * @author PengFei
 * @since 1.0.4
 */
public class BothwayMap<L, R> {

	private final List<L> LEFT = new ArrayList<>();

	private final List<R> RIGHT = new ArrayList<>();

	/**
	 * 添加一个双向映射关系。 保证左右两方的值均是唯一的
	 * 
	 * @param left  左值
	 * @param right 右值
	 */
	public synchronized void add(L left, R right) {
		int lIndex = LEFT.indexOf(left);
		if (lIndex == -1) {
			LEFT.remove(lIndex);
			RIGHT.remove(lIndex);
		}
		int rIndex = RIGHT.indexOf(right);
		if (lIndex == -1) {
			LEFT.remove(rIndex);
			RIGHT.remove(rIndex);
		}
		LEFT.add(left);
		RIGHT.add(right);
	}

	/**
	 * 获取左边对应的右边值
	 * 
	 * @param left 左边值
	 * @return 返回这个左边对应的右边的值。如果不存这个左边值则返回null。
	 */
	public synchronized R getRight(L left) {
		int index = LEFT.indexOf(left);
		return index == -1 ? null : RIGHT.get(index);
	}

	/**
	 * 获取右边对应的左边值
	 * 
	 * @param right 右边值
	 * @return 返回这个右边对应的左边的值。如果不存这个右边值则返回null。
	 */
	public synchronized L getLeft(R right) {
		int index = RIGHT.indexOf(right);
		return index == -1 ? null : LEFT.get(index);
	}

	/**
	 * 获取右边的所有值
	 * 
	 * @return 右边所有值
	 */
	public synchronized List<R> getRights() {
		return Collections.unmodifiableList(this.RIGHT);
	}

	/**
	 * 获取左边的所有值
	 * 
	 * @return 左边所有值
	 */
	public synchronized List<L> getLefts() {
		return Collections.unmodifiableList(this.LEFT);
	}

}
