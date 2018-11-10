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
import java.util.List;
import java.util.Set;
 
import com.mongodb.DB;
import com.mongodb.MongoClient;
 
public class HDFSMongoDBConnection {
 
    public static void main(String[] args) throws UnknownHostException {
        MongoClient mongoClient = new MongoClient("localhost");
        List<String> databases = mongoClient.getDatabaseNames();
        for (String dbName : databases) {
            System.out.println("- Database: " + dbName);
            
            DB db = mongoClient.getDB(dbName);
            
            Set<String> collections = db.getCollectionNames();
            for (String colName : collections) {
                System.out.println("\t + Collection: " + colName);
            }
        }
        mongoClient.close();
         
    }
}
