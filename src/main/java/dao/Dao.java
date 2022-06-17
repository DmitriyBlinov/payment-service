package dao;

import com.mongodb.client.FindIterable;
import org.bson.Document;

public interface Dao<T, ID> {
    Object find(ID id);
    FindIterable<Document> findAll();
    boolean save (T o);
    boolean update (T o);
    boolean delete (T o);
}