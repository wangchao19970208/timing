package de.onvif;


import org.teamway.dao.MyBatisUtils;

public class Main {


	public void  main() {

//		OnvifDevice cam;
//		try {
//		//	cam = new OnvifDevice(cameraAddress, user, password);
//
//		}
//		catch (ConnectException | SOAPException e1) {
//			System.err.println("No connection to camera, please try again.");
//			return;
//		}
//
//
//
//			try {
//
//
//					Date date = cam.getDevices().getDate();
//					System.out.println(date);
//			}
//			catch (IOException e) {
//				e.printStackTrace();
//			}
		}

	public static void main(String[] args) {
		MyBatisUtils test=new MyBatisUtils();
		  test.init();
		  test.testQueryUser();
	}
	}
