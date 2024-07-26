package edu.alpha.controller;

import java.util.Scanner;

import edu.alpha.dao.HospitalDao;

public class HospitalController {

	public static void main(String[] args) {
		// To save the Hospital Info
		// readHospitalInfo();

		// updateHospitalEmail();

		// findHospitalById();

		deleteHospital();
	}

	public static void deleteHospital() {
		Scanner read = new Scanner(System.in);

		System.out.println("Enter the Hospital Id");
		int hospoitalId = read.nextInt();

		HospitalDao hospitalDao = new HospitalDao();

		hospitalDao.deleteHospital(hospoitalId);

	}

	public static void findHospitalById() {
		Scanner read = new Scanner(System.in);

		System.out.println("Enter the Hospital Id");
		int hospoitalId = read.nextInt();

		HospitalDao hospitalDao = new HospitalDao();

		hospitalDao.findById(hospoitalId);

	}

	public static void updateHospitalEmail() {
		Scanner read = new Scanner(System.in);

		System.out.println("Enter the Hospital Id");
		int hospoitalId = read.nextInt();

		System.out.println("Enter the Hosppital Email");
		String email = read.next();

		HospitalDao hospitalDao = new HospitalDao();

		hospitalDao.updateHospital(hospoitalId, email);

	}

	public static void readHospitalInfo() {
		Scanner read = new Scanner(System.in);

		System.out.println("Enter the Hospital Id ");
		int hospitalId = read.nextInt();
		read.nextLine();

		System.out.println("Enter the Hospital Name");
		String hospitalName = read.nextLine();

		System.out.println("Enter the Hospital Email");
		String email = read.nextLine();

		System.out.println("Enter the Hospital PhoneNumber");
		long phoneNumber = read.nextLong();

//		System.out.println("Hospital Id = " + hospitalId);
//		System.out.println("Hospital Name = " + hospitalName);
//		System.out.println("Hospital Email = " + email);
//		System.out.println("Hospital PhoneNumber = " + phoneNumber);

		HospitalDao hospitalDao = new HospitalDao();
		hospitalDao.saveHospital(hospitalId, hospitalName, email, phoneNumber);

	}

}
