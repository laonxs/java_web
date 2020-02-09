package cn.ade.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.misc.BASE64Encoder;

/**
 * 需求：文件下载
 * 
 * @author ade
 * @version 1.0，2017-10-12 19:30:26 
 */
public class DownLoadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		downloadFile01(req, resp);
		downloadFile02(req, resp);
	}

	/**
	 * 文件下载之中文问题解决
	 * 
	 * @param req
	 * @param resp
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	private void downloadFile02(HttpServletRequest req, HttpServletResponse resp)
			throws UnsupportedEncodingException, IOException {
		// 获取文件名
		// 浏览器通过使用iso-8859-1字符集对传递的参数进行编码后再传递，所有服务器通过设置字符集来接受参数
		// tomcat服务器的默认解码字符集是is-8859-1
		String filename = new String(req.getParameter("filename").getBytes("iso-8859-1"), "utf-8");
		
		// 获取文件的MIME类型
		String mimeType = this.getServletContext().getMimeType(filename);	// MIME:描述消息内容类型的因特网标准
		
		// 设置响应正文类型
		resp.setHeader("Content-Type", mimeType);
		
		// 获取输入流
		InputStream is = this.getServletContext().getResourceAsStream("/download/"+filename);
		
		// 通知浏览器以正确的格式解析中文正文
		String agent = req.getHeader("User-Agent");
		if(agent.contains("Firefox")){
			filename = base64EncodeFileName(filename);
		}else{
			filename = URLEncoder.encode(filename,"UTF-8");
		}
		resp.setHeader("Content-Disposition", "attachment;filename="+filename);
		
		// 获取输出流
		OutputStream os = resp.getOutputStream();
		
		// 下载文件
		int len;
		byte[] ch = new byte[1024];
		while((len = is.read(ch)) != -1) {
			os.write(ch, 0, len);
			os.flush();
		}
		
		// 释放资源
		os.close();
		is.close();
	}

	/**
	 * 文件下载
	 * 
	 * @param resp
	 * @param filename
	 * @throws IOException
	 */
	private void downloadFile01(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String filename = req.getParameter("filename");
		
		// 获取文件的MIME类型
		String mimeType = this.getServletContext().getMimeType(filename);	// MIME:描述消息内容类型的因特网标准
		
		// 设置响应正文类型
		resp.setHeader("Content-Type", mimeType);
		
		// 通知浏览器以正确方式来解析正文
		resp.setHeader("Content-Disposition", "attachment;filename="+filename);	
		
		// 下载文件
		InputStream is = this.getServletContext().getResourceAsStream("/download/"+filename);
		OutputStream os = resp.getOutputStream();
		int len;
		byte[] ch = new byte[1024];
		while((len = is.read(ch)) != -1) {
			os.write(ch, 0, len);
			os.flush();
		}
		
		// 释放资源
		os.close();
		is.close();
	}
	
	/**
	 * 将中文名进行指定格式的编码
	 * 
	 * @param fileName
	 * @return
	 */
	public static String base64EncodeFileName(String fileName) {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		try {
			return "=?UTF-8?B?" + new String(base64Encoder.encode(fileName.getBytes("UTF-8"))) + "?=";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
       
}
