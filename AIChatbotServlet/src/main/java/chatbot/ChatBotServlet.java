package chatbot;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/chat")
public class ChatServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String msg = request.getParameter("message");
        String reply;

        msg = msg.toLowerCase();

        if (msg.contains("hello") || msg.contains("hi"))
            reply = "Hello 👋 How can I help you?";
        else if (msg.contains("java"))
            reply = "Java is an object-oriented programming language.";
        else if (msg.contains("ai"))
            reply = "AI allows machines to think intelligently.";
        else if (msg.contains("bye"))
            reply = "Goodbye 😊 Have a nice day!";
        else
            reply = "Sorry, I didn't understand that.";

        response.setContentType("text/plain");
        response.getWriter().write(reply);
    }
}
