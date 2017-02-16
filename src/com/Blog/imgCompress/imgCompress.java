package com.Blog.imgCompress;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class imgCompress {
	private Image img;
	private int width;
	private int height;

	/*	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		System.out.println("��ʼ��" + new Date().toLocaleString());
		imgCompress imgCom = new imgCompress("C:\\temp\\pic123.jpg");
		imgCom.resizeFix(400, 400);
		System.out.println("������" + new Date().toLocaleString());
	}*/
	/**
	 * ���캯��
	 */
	/**
	 * ���տ�Ȼ��Ǹ߶Ƚ���ѹ��
	 * @param w int �����
	 * @param h int ���߶�
	 * @throws IOException 
	 */
	public void setImg(MultipartFile image) throws IOException {      
	        CommonsMultipartFile cf= (CommonsMultipartFile)image; 
	        DiskFileItem fi = (DiskFileItem)cf.getFileItem(); 
	        File file = fi.getStoreLocation();
		    this.img = ImageIO.read(file);
		    setWidth(img);
		    setHeight(img);
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(Image img) {
		this.width = img.getWidth(null);
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(Image img) {
		this.height = img.getHeight(null);
	}
	public void resizeFix(int w, int h,String path,String fileName) throws IOException {
		if (width / height >= w / h) {
			resizeByWidth(w,path,fileName);
		} else {
			resizeByHeight(h,path,fileName);
		}
	}
	/**
	 * �Կ��Ϊ��׼���ȱ�������ͼƬ
	 * @param w int �¿��
	 */
	public void resizeByWidth(int w,String path,String fileName) throws IOException {
		int h = (int) (height * w / width);
		resize(w, h,path,fileName);
	}
	/**
	 * �Ը߶�Ϊ��׼���ȱ�������ͼƬ
	 * @param h int �¸߶�
	 */
	public void resizeByHeight(int h,String path,String fileName) throws IOException {
		int w = (int) (width * h / height);
		resize(w, h,path,fileName);
	}
	/**
	 * ǿ��ѹ��/�Ŵ�ͼƬ���̶��Ĵ�С
	 * @param w int �¿��
	 * @param h int �¸߶�
	 */
	public void resize(int w, int h,String path,String fileName) throws IOException {
		// SCALE_SMOOTH �������㷨 ��������ͼƬ��ƽ���ȵ� ���ȼ����ٶȸ� ���ɵ�ͼƬ�����ȽϺ� ���ٶ���
		BufferedImage image = new BufferedImage(w, h,BufferedImage.TYPE_INT_RGB ); 
		image.getGraphics().drawImage(img, 0, 0, w, h, null); // ������С���ͼ
		File destFile = new File(path+"/"+fileName);
		FileOutputStream out = new FileOutputStream(destFile); // ������ļ���
		// ��������ʵ��bmp��png��gifתjpg
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(image); // JPEG����
		out.close();
	}
}
