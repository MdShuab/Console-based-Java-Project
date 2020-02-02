package com.shuaib.studentRegistration;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StDAO sdao=new StDAO();
		sdao.getDetail();
	}

}
