package cn.ade.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 需求：文件上传的Servlet
 * 
 * @author ade
 * @version 1.0，2017-10-21 08:18:09
 */
@WebServlet(urlPatterns="/FileUpLoadServlet",loadOnStartup=2,initParams={@WebInitParam(name="username",value="root")})
@MultipartConfig
public class FileUpLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Servlet3.0的文件上传
		// 接收文件
		Part part = request.getPart("upload");
		
		// 获取文件大小
		long size = part.getSize();
		System.out.println(size);		// 244068个字节
		
		// 获取表单中的name属性值
		String fileName = part.getName();
		System.out.println(fileName);	// upload
		
		// 获取文件的名称
		String header = part.getHeader("Content-Disposition");
		System.out.println(header);		// image/jpeg
		int index = header.lastIndexOf("filename=\"");
		String filename = header.substring(index+10, header.length()-1);
		System.out.println(filename);		// 张三.jpg
		
		// 获取文件的输入流
		InputStream is = part.getInputStream();
		
		// 获取文件存储的绝对路径
		String realPath = this.getServletContext().getRealPath("/upload");
		System.out.println(realPath);
			
		// 获取输出流
		OutputStream os = new FileOutputStream(realPath+"/"+filename);
		
		// 文件写入
		int len;
		byte[] b = new byte[1024];
		while((len = is.read(b)) != -1) {
			os.write(b, 0, len);
			os.flush();
		}
		
		// 释放资源
		os.close();
		is.close();
		
		// 响应
		response.getWriter().println("上传成功");
	}

}
