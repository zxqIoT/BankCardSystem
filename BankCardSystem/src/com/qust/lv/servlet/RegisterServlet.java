package com.qust.lv.servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.qust.lv.mysqlcon.MysqlStore;
import sun.security.util.Length;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MysqlStore mysqlStore;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
        super.init();
        this.mysqlStore = new MysqlStore();
    }
    //构建方法，使用正则表达式验证手机号码格式是否正确
    public static boolean checkPhone(String phone) {
        Pattern pattern = Pattern
                .compile("^(13[0-9]|14[5,7,9]|15[^4]|18[0-9]|17[0,1,3,5,6,7,8])\\d{8}$");
        ////2018.3.08  ^(13[0-9]|15[0-9]|153|15[6-9]|180|18[23]|18[5-9])\\d{8}$
        Matcher matcher = pattern.matcher(phone);

        if (matcher.matches()) {
            return true;
        }
        return false;
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
		String name=request.getParameter("user_name");
		String password=request.getParameter("user_password");
		String phone=request.getParameter("user_phone");
		String rpsw = request.getParameter("rpsw");
		System.out.println(name);
		System.out.println(password);	
		
		if(name==null||name.trim().isEmpty()){
			request.setAttribute("msg", "帐号不能为空");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		Boolean a=false;
		a=checkPhone(phone);
		if(a==false) {
			request.setAttribute("msg", "手机号错误");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		if(password==null||password.trim().isEmpty()){
			request.setAttribute("msg", "密码不能为空");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		if(!password.equals(rpsw)){
			request.setAttribute("msg", "两次输入的密码不同");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		String sql = "select * from user_information where user_name=?";
        String[] nam = {name};
        boolean result =mysqlStore.login(sql, nam);
		if(result==true){
			request.setAttribute("msg", "账号："+name+" 已存在");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
			}else{
				int raw=mysqlStore.execUpdate("insert into user_information(user_name,user_password,user_phone,regist_time) value(?,?,?,now())",
		               new Object[]{name,password,phone});//返回参数为所影响行数
				if(raw==1) {
		request.setAttribute("msg", "恭喜："+name+"，注册成功");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
				}else {
					request.setAttribute("msg", "抱歉注册失败");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
		}
		//response.sendRedirect("/BankCardSystem/login.jsp");
	}
	@Override
    public void destroy() {
        super.destroy();
        if(this.mysqlStore != null){
            this.mysqlStore.close();
        }
    }

}
