package com.ganggang.Entity.Ebay;

import java.util.Map;
import java.util.Set;

import org.bson.BSONObject;

import com.ganggang.DO.Ebay.EbayCommentDO;
import com.mongodb.DBObject;

public class EbayComment{

	private int parentId;
	private EbayCommentDO comment;
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public EbayCommentDO getComment() {
		return comment;
	}
	public void setComment(EbayCommentDO comment) {
		this.comment = comment;
	}
	

}
