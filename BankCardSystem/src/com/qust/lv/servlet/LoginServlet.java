package com.qust.lv.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qust.lv.mysqlcon.MysqlStore;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Loginservlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MysqlStore mysqlStore;  
	private boolean result=false;
	String time;
	String ph;
	Float acount;
	int card;
	String infor;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
        super.init();
        this.mysqlStore = new MysqlStore();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
		String name=request.getParameter("logname");
		String password=request.getParameter("logpassword");
		String remember = request.getParameter("savesid");
		//int time = Integer.parseInt(request.getParameter("time"));
		String sql = "select * from user_information where user_name=? and user_password=?;";
        String[] params = {name, password};
        boolean state =mysqlStore.login(sql, params);
		if(state==true) {
			int al=mysqlStore.execUpdate("update user_information set login_time=now() where user_name=? and user_password=?;",new Object[]{name,password});
			
			if (remember!=null) {
				Cookie c1 = new Cookie("username", name);
				Cookie c2 = new Cookie("password", password);
				c1.setMaxAge(1000);
				c2.setMaxAge(1000);//这里设置保存这条Cookie的时间
				response.addCookie(c1);//添加Cookie
				response.addCookie(c2);
			} 
	        List<Map<String, Object>> res = mysqlStore.execQuery("select * from user_information where user_name=?;",new Object[]{name}); 
	        System.out.println(res);
	        	        
	        for (Map<String, Object> m1 : res)  
	        {  	            
	        	ph=(String)m1.get("user_phone");
	       	}  
	        for (Map<String, Object> m1 : res)  
	        {  	            
	        	card=(int)m1.get("card");
	       	}  
	        for (Map<String, Object> m1 : res)  
	        {  	            
	        	acount=(Float)m1.get("count");
	       	}  
	        for (Map<String, Object> m1 : res)  
	        {  	            
	        	infor=(String)m1.get("information");
	       	} 
	        request.setAttribute("ph","您的手机号为："+ph);
	        request.setAttribute("card","您目前有 "+card+"张银行卡");
	        request.setAttribute("acount","您的账户余额为:"+acount);
	        request.setAttribute("infor","您的预留信息为:"+infor);
 
	       // request.setAttribute("time","上次登陆时间：:"+time);
	        request.setAttribute("msg","欢迎用户:"+name);
			request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		}
		else {
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}


}
