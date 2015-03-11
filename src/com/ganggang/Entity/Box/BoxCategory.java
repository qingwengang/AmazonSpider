package com.ganggang.Entity.Box;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.ganggang.Entity.Base.BaseEntity;

@Entity
public class BoxCategory extends BaseEntity{
	private int Id;
	private String Name;
	private String BoxCategoryId;
	private String Type;
	private int Flag;
	public BoxCategory() {
	}
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getBoxCategoryId() {
		return BoxCategoryId;
	}
	public void setBoxCategoryId(String boxCategoryId) {
		BoxCategoryId = boxCategoryId;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getFlag() {
		return Flag;
	}
	public void setFlag(int flag) {
		Flag = flag;
	}

}
