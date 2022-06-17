package servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Payment;
import dao.DaoPayment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/savePayment")
public class PaymentServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader jsonReader = request.getReader();
        if (Objects.equals(jsonReader,null)) {
            return;
        }
        Gson gson = new Gson();
        Payment payment = gson.fromJson(gson.newJsonReader(jsonReader), new TypeToken<Payment>(){}.getType());
        PrintWriter writer = response.getWriter();

        response.setStatus(200);
        response.setContentType("application/json;charset=UTF-8");

        JsonObject jsonObject = new JsonObject();
        DaoPayment daoPayment = new DaoPayment();
        boolean isPresent = Objects.equals(daoPayment.find(payment.getId()), null);
        if (isPresent) {
            jsonObject.addProperty("status", 0);
            daoPayment.save(payment);
        } else {
            jsonObject.addProperty("status", 1);
        }
        writer.print(jsonObject);
        writer.flush();
    }
}