package org.sample.servlet.service;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class MongoApp {

 public void conn(String userID, String password) {

 try {

 Mongo mongo = new Mongo("localhost", 27017);
 DB db = mongo.getDB("quotesdb");
 DBCollection collection = db.getCollection("quotesCollection");
 BasicDBObject document = new BasicDBObject();

 document.put("id", userID);
 document.put("quote", "Long range planning does not deal with future decisions, but with the future of present decisions.");
 document.put("pass", password);

 collection.insert(document);
 BasicDBObject searchQuery = new BasicDBObject();
 DBCursor cursor = collection.find();
 while (cursor.hasNext()) {
 System.out.println(cursor.next());
 }
 System.out.println("Done");
 } catch (UnknownHostException e) {
 e.printStackTrace();
 } catch (MongoException e) {
 e.printStackTrace();
 }

 }

}