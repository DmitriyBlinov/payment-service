package servlets;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.mockito.Mockito.*;

class PaymentServletTest {
    PaymentServlet servlet;

    @BeforeEach
    void setUp() {
        this.servlet = new PaymentServlet();
    }

    @Test
    void doPostTest() throws IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        servlet.doPost(request, response);
    }
}