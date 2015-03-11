package com.ganggang.Util;

import java.net.UnknownHostException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.ganggang.DO.Ebay.EbayCommentDO;
import com.ganggang.Entity.Ebay.EbayComment;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;

public class MongoUtil {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		// QueryTest();
		// InsertTeset();
		Init();
//		 for(int i=0;i<5;i++){
//		 EbayCommentDO com=new EbayCommentDO();
//		 com.getComments().add("fldjslfj");
//		 EbayComment comment=new EbayComment();
//		 comment.setComment(com);
//		 comment.setParentId(12);
//		 SaveEbayComments(comment);}
	}

	public static void Init() throws UnknownHostException {
		Mongo mongo = new Mongo();
		DB db = mongo.getDB("Ebay");
		if (!db.collectionExists("comments")) {
			DBObject options = new BasicDBObject();
			options.put("size", 20);
			options.put("capped", 20);
			options.put("max", 20);
			System.out.println(db.createCollection("comments", options));
		}
	}

	public static void SaveEbayComments(EbayComment comment) {
		try {
			Mongo mongo = new Mongo();
			DB db = mongo.getDB("Ebay");
			if (!db.collectionExists("comments")) {
				DBObject options = new BasicDBObject();
				options.put("size", 20);
				options.put("capped", 20);
				options.put("max", 20);
				System.out.println(db.createCollection("comments", options));
			}
			DBCollection colComment = db.getCollection("comments");
			BasicDBObject doc = new BasicDBObject("parentId",
					comment.getParentId()).append("comment", comment
					.getComment().getComments());
			System.out.println(doc);
			WriteResult res = colComment.insert(doc);
			System.out.println(res);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public static void InsertTeset() throws UnknownHostException {
		Mongo mongo = new Mongo();
		DB db = mongo.getDB("cnblogs");
		boolean auth = db.authenticate("ganggang", "ganggang".toCharArray());

		for (String name : db.getCollectionNames()) {
			System.out.println("collectionName: " + name);
		}
		if (!db.collectionExists("comments")) {
			DBObject options = new BasicDBObject();
			options.put("size", 20);
			options.put("capped", 20);
			options.put("max", 20);
			System.out.println(db.createCollection("comments", options));
		}
		DBCollection colComment = db.getCollection("comments");
		List<String> comms = new LinkedList<String>();
		comms.add("fldsjflsjfl");
		comms.add("fldsjfjsldfjls");
		BasicDBObject doc = new BasicDBObject("title", "MongoDB")
				.append("description", "database").append("likes", 100)
				.append("url", "http://www.w3cschool.cc/mongodb/")
				.append("by", "w3cschool.cc").append("comms", comms);
		colComment.insert(doc);
	}

	public static void QueryTest() throws UnknownHostException {
		Mongo mongo = new Mongo();
		DB db = mongo.getDB("cnblogs");
		DBCollection colComment = db.getCollection("comments");
		BasicDBObject query = new BasicDBObject("title", "MongoDB");
		DBCursor cursor = colComment.find(query);
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}

}
