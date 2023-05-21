package dao;

import com.mongodb.client.FindIterable;
import entity.Payment;
import org.bson.Document;

public interface PaymentDao extends Dao<Payment, String> {
    Object find(String id);
    boolean save(Payment payment);
    boolean update(Payment payment);
    boolean delete(Payment payment);
    FindIterable<Document> findAll();
}