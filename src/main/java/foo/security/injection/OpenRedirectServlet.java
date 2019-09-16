package foo.security.injection;

import java.io.IOException;
import java.util.Random;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/OpenRedirectServlet")
public class OpenRedirectServlet extends HttpServlet {

  private static final long serialVersionUID = 2613361068242552174L;

  //Uncomment to fix the Vuln
  //private final List<String> urlWhiteList =  Arrays.asList("https://sonarsource.com/");
  
  //Uncomment to fix the Bug
  //private Random rand = SecureRandom.getInstanceStrong();  // SecureRandom is preferred to Random

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String location = req.getParameter("url");

    // Match the incoming URL against a whitelist
    //if (!urlWhiteList.contains(location))
      //throw new IOException();
    
    resp.sendRedirect(location + "&trackingNumber=" + doSomethingRandom());
  }

  public int doSomethingRandom() {
    Random rand = new Random();  // Noncompliant; new instance created with each invocation
    int rValue = rand.nextInt();

    //Uncomment to fix the Bug
    //int rValue = this.rand.nextInt();
    return rValue;
  }
}