package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GettheWeather;
import model.weatherBean;

@WebServlet("/OWservlet")
public class OWservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cityStr = request.getParameter("city");
		String countryStr = request.getParameter("country");
		String tempStr = request.getParameter("temp");
		String cityAndCountryStr = cityStr + "-" + countryStr;

		weatherBean wBean = new weatherBean(cityStr, countryStr, tempStr);
		
		try {
		GettheWeather.getWeather(wBean,request, response);
		}catch(Exception e){
			//response.sendRedirect("error.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("./view/error.jsp");
			rd.forward(request, response);
		}

		request.setAttribute("wBean", wBean);

		
		Cookie[] cookies = request.getCookies(); //gets all cookies
		
		//Looks for the cooke "cookieAccepted" 
		String acceptCookies = "";
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("cookieAccepted")) {
				acceptCookies = cookies[i].getValue();
			};
		}
		
		//If cookies are accepted "city" cookie are set and value of "city" is set to bean. else "" set to bean
		if(acceptCookies.equals("yes")) {
		String temp = "";
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("city")) {
				temp = cookies[i].getValue();
			};
		}
		
		temp = temp + ":" + cityAndCountryStr;
		wBean.setCookieString(temp);
		
		Cookie ck = new Cookie("city", temp);
		ck.setMaxAge(60*60*24*365);
		
		response.addCookie(ck);
		}else {
			wBean.setCookieString("No cookies");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("./view/showWeather.jsp");
		rd.forward(request, response);
	}

}