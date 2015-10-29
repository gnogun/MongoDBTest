package com.latis.test;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Test {
	public static void main(String[] args) {
//		Mongo mongo = new Mongo("192.168.0.70", 25000);
		
		MongoClient client = new MongoClient("192.168.0.70", 27017);
		
		MongoDatabase db = client.getDatabase("test");
		
		MongoCollection<Document> collection = db.getCollection("test");
		
//		Document document = new Document();
//		document.put("name", "gnogun2");
//		document.put("qweqw", "asdas");
//		collection.insertOne(document);
		
//		Document searchQuery = new Document();
//		searchQuery.put("name", "gnogun");		
//		Document newDocument = new Document();
//		Document newQuery = new Document();
//		newQuery.put("111111111", 11110);
//		newDocument.put("$set", newQuery);		
//		collection.updateOne(searchQuery, newDocument);
		
		FindIterable<Document> findIterable = collection.find();
		Iterator<Document> iterator = findIterable.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		client.close();
	}
}
