package dao.impl;

import com.mongodb.MongoCommandException;
import com.mongodb.client.ClientSession;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import dao.PaymentDao;
import entity.Payment;
import org.bson.Document;
import utils.DataSourceFactory;

import static com.mongodb.client.model.Filters.eq;

public class PaymentDaoImpl implements PaymentDao {
    /**
     * @param id the payment id
     * @return object if the payment with the given id is in the database. Otherwise returns null
     */
    @Override
    public Object find(String id) {
        DataSourceFactory dataSourceFactory = new DataSourceFactory();
        return dataSourceFactory.getCollection().find(eq("id", id)).first();
    }

    /**
     * @param payment
     * @return true if transaction was completed successfully. Returns false if transaction was aborted
     */
    @Override
    public boolean save(Payment payment) {
        DataSourceFactory dataSourceFactory = new DataSourceFactory();
        ClientSession session = dataSourceFactory.getClient().startSession();
        try {
            session.startTransaction();
            String id = payment.getId();
            int userId = payment.getUserId();
            int sum = payment.getSum();
            Document document = new Document("id", id).append("userId", userId).append("sum", sum);
            dataSourceFactory.getCollection().insertOne(document);
            session.commitTransaction();
        } catch (MongoCommandException e) {
            session.abortTransaction();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean update(Payment payment) {
        return false;
    }

    @Override
    public boolean delete(Payment payment) {
        return false;
    }

    @Override
    public FindIterable<Document> findAll() {
        DataSourceFactory dataSourceFactory = new DataSourceFactory();
        MongoCollection<Document> collection = dataSourceFactory.getCollection();
        FindIterable<Document> iterable = collection.find();
        for (Document document : iterable) {
            System.out.println(document);
        }
        return iterable;
    }
}