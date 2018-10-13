package cn.qst.comman.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64 {
	// 图片转化成base64字符串
	public static String GetImageStr(String imageName) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		String imgFile = imageName;// 待处理的图片
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}

	/**
	 * base64字符串 转化为byte数组，并返回
	 * @param imgStr
	 * @return
	 */
	public static byte[] GenerateImage(String imgStr) { // 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			return b;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 将url加密，存入数据库之前
	 * @param url
	 * @return
	 */
	public static String urlToString(String url) {
		BASE64Encoder encoder = new BASE64Encoder();
		String urlBase = null;
		try {
			urlBase = encoder.encode(url.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return urlBase;
	}
	/**
	 * 前台传回url之后，对url进行解密，查找文件
	 * @param string
	 * @return
	 */
	public static String stringToUrl(String string) {
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] b;
		String fileUrl = null;
		try {
			b = decoder.decodeBuffer(string);
			fileUrl = new String(b, "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileUrl;
	}
}
