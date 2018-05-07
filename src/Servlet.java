import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        //response.getWriter().println("MAIN");
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        MongoDatabase db = mongoClient.getDatabase("restaurants");

        MongoCollection<Document> collection = db.getCollection("restaurants");

        collection.find();
/*
        Document findQuery = new Document();
        findQuery.("cityName", regQuery).append("country",country.getCarCode());
  */

        FindIterable<Document> result =collection.find(new Document("cuisine","American"));

        //DBObject doc = collection.find();

        response.getWriter().println(result.first().toString());
    }

}
