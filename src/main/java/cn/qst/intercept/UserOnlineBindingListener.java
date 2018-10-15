package cn.qst.intercept;

import java.io.File;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * session 监听器 
 * 对 session 进行监听，当用户注销，或者session失效之后，
 * 自动调用缩略图删除功能
 * @author 疯自
 *
 */
public class UserOnlineBindingListener implements HttpSessionBindingListener {

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		HttpSession session = event.getSession();
		//缩略图删除，再用户注销登陆之后，session失效之后
		String uploadPath = "/static/thum_img";
		String imgFile = session.getServletContext().getRealPath(uploadPath);
		File file = new File(imgFile);
		File[] files = file.listFiles();
		for (File file2 : files) {
			if ((file2.getName()).contains("thum_")) {
				StringBuffer imgUrl = new StringBuffer(imgFile);
				imgUrl.append("\\");
				imgUrl.append(file2.getName());
				File img = new File(imgUrl.toString());
				img.delete();
			} 
		}
		System.out.println("文件删除成功");
	}

}
