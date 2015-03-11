package com.ganggang.DO.Ebay;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.xml.ws.ServiceMode;

public class EbayCommentDO implements Serializable{
	private List<String> Comments;
	private List<String> UsedComments;
	public List<String> getComments() {
		if(Comments==null) Comments=new LinkedList<String>();
		return Comments;
	}
	public void setComments(List<String> comments) {
		Comments = comments;
	}
	public List<String> getUsedComments() {
		if(UsedComments==null) UsedComments=new LinkedList<String>();
		return UsedComments;
	}
	public void setUsedComments(List<String> usedComments) {
		UsedComments = usedComments;
	}
	@Override
	public String toString() {
		return Comments.toString()+UsedComments.toString();
	}
	
}
