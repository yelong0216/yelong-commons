/**
 * 
 */
package org.yelong;

import java.util.Date;

/**
 * @author YL
 *
 */
public class Student {

	private String id;

	private String name;

	private Integer age;

	private Date createTime;

	private String aAb;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getaAb() {
		return aAb;
	}

	public void setaAb(String aAb) {
		this.aAb = aAb;
	}
	
}
