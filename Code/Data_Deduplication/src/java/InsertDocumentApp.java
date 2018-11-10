/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sentech
 */
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

/**
 * Java MongoDB : Insert a Document
 * 
 */
public class InsertDocumentApp {
  public static void insertmongo() {

    try {

	Mongo mongo = new Mongo("localhost", 27017);
	DB db = mongo.getDB("SecDedoop");
	
	DBCollection collection = db.getCollection("dummyColl");

	// 1. BasicDBObject example
	
	BasicDBObject document = new BasicDBObject();
	document.put("database", "SecDedoop");
	document.put("table", "hosting");

	BasicDBObject documentDetail = new BasicDBObject();
	documentDetail.put("records", 99);
	documentDetail.put("index", "vps_index1");
	documentDetail.put("active", "true");
	document.put("detail", documentDetail);

	collection.insert(document);

	DBCursor cursorDoc = collection.find();
	while (cursorDoc.hasNext()) {
		System.out.println(cursorDoc.next());
	}

	collection.remove(new BasicDBObject());

	// 2. BasicDBObjectBuilder example
	
	BasicDBObjectBuilder documentBuilder = BasicDBObjectBuilder.start()
		.add("database", "SecDedoop")
                .add("table", "hosting");

	BasicDBObjectBuilder documentBuilderDetail = BasicDBObjectBuilder.start()
                .add("records", "99")
                .add("index", "vps_index1")
		.add("active", "true");

	documentBuilder.add("detail", documentBuilderDetail.get());

	collection.insert(documentBuilder.get());

	DBCursor cursorDocBuilder = collection.find();
	while (cursorDocBuilder.hasNext()) {
		System.out.println(cursorDocBuilder.next());
	}

	collection.remove(new BasicDBObject());

	// 3. Map example
	System.out.println("Map example...");
	Map<String, Object> documentMap = new HashMap<String, Object>();
	documentMap.put("database", "SecDedoop");
	documentMap.put("table", "hosting");

	Map<String, Object> documentMapDetail = new HashMap<String, Object>();
	documentMapDetail.put("records", "99");
	documentMapDetail.put("index", "vps_index1");
	documentMapDetail.put("active", "true");

	documentMap.put("detail", documentMapDetail);

	collection.insert(new BasicDBObject(documentMap));

	DBCursor cursorDocMap = collection.find();
	while (cursorDocMap.hasNext()) {
		System.out.println(cursorDocMap.next());
	}

	collection.remove(new BasicDBObject());

	// 4. JSON parse example
	System.out.println("JSON parse example...");
			
	String json = "{'database' : 'SecDedoop','table' : 'hosting'," +
	  "'detail' : {'records' : 99, 'index' : 'vps_index1', 'active' : 'true'}}}";

	DBObject dbObject = (DBObject)JSON.parse(json);
			
	collection.insert(dbObject);

	DBCursor cursorDocJSON = collection.find();
	while (cursorDocJSON.hasNext()) {
		System.out.println(cursorDocJSON.next());
	}

	collection.remove(new BasicDBObject());
			
    } catch (UnknownHostException e) {
	e.printStackTrace();
    } catch (MongoException e) {
	e.printStackTrace();
    }

  }
}
