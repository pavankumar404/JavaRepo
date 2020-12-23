package com.wipro.assignment.phonedirectory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TelephoneDirectory {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int menu = 0;
		System.out.println("Telephone Directory Management System");
		System.out.println();
		System.out.println("1. Accept(Adding Record) Data");
		System.out.println("2. Search");
		System.out.println("3. Sort Data");
		System.out.println("4. List of all persons");
		System.out.println("5. Exit");
		boolean quit = false;
		do {
			System.out.print("Please enter your choice: ");
			menu = input.nextInt();
			System.out.println();

			switch (menu) {
			case 1:
				System.out.print("Enter student ID (int): ");
				int ID = input.nextInt();
				System.out.print("Enter Name: ");
				String name = input.next();
				System.out.print("Enter Address: ");
				String address = input.next();
				System.out.println("Enter Phone No: ");
				int number = input.nextInt();
				FileWriter fileWriter = new FileWriter(new File("directory.txt"), true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				bufferedWriter.write(ID + " " + name + " " + address + " " + number);
				bufferedWriter.newLine();
				bufferedWriter.close();
				break;
			case 2:
				System.out.print("Enter name to search information: ");
				String enteredName = input.next();
				File file = new File("directory.txt");
				try {
					BufferedReader fileReader = new BufferedReader(new FileReader(
							file));
					String s;
					while ((s = fileReader.readLine()) != null) {
						String[] splitInput = s.split(" ");
						String nm = splitInput[1];
						String add = splitInput[2];
						String phoneNo = splitInput[3];
						if (enteredName.equals(nm)) {
							System.out
									.println("***********Information**************");
							System.out.println("Address : " + add);
							System.out.println("PhoneNo : " + phoneNo);
						}
					}
					fileReader.close();
				} catch (Exception e) {
				}
				break;
			case 3:
				File fileDir = new File("directory.txt");
				FileInputStream fileInputStream = new FileInputStream(fileDir);
				DataInputStream dataInputStream = new DataInputStream(fileInputStream);
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(dataInputStream));
				String strLine;
				List<String> list = new ArrayList<>();
				while ((strLine = bufferedReader.readLine()) != null) {
					list.add(strLine);
				}
				int j = 0;
				Directory data[] = new Directory[list.size()];
				try {
					Iterator<String> itr;
					for (itr = list.iterator(); itr.hasNext();) {
						String inputString = itr.next().toString();
						String[] splitSt = inputString.split(" ");
						String id = "", sortName = "", add = "", pno = "";
						for (int i = 0; i < splitSt.length; i++) {
							id = splitSt[0];
							sortName = splitSt[1];
							add = splitSt[2];
							pno = splitSt[3];

						}
						data[j] = new Directory();
						data[j].setId(Integer.parseInt(id));
						data[j].setName(sortName);
						data[j].setAddress(add);
						data[j].setPhoneNo(Integer.parseInt(pno));

						j++;
					}

					Arrays.sort(data);
					System.out.println("********Sorted by id********");
					for (int i = 0; i < 8; i++) {
						Directory show = data[i];
						int ide = show.getId();
						String nnn = show.getName();
						String add = show.getAddress();
						int phone = show.getPhoneNo();
						System.out.println(ide + " " + nnn + " " + add + " "
								+ phone);
					}
				} catch (Exception e) {
				}
				break;

			case 4:
				FileInputStream fileIPStream = new FileInputStream(new File("directory.txt"));
				DataInputStream dataIPStream = new DataInputStream(fileIPStream);
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(dataIPStream));
				String allData;
				List<String> datList = new ArrayList<String>();
				while ((allData = reader.readLine()) != null) {
					datList.add(allData);
				}
				Iterator<String> iterator;
				for (iterator = datList.iterator(); iterator.hasNext();) {
					String str = iterator.next().toString();
					String[] splitSt = str.split(" ");
					String id = "", names = "", ada = "", phNo = "";
					for (int i = 0; i < splitSt.length; i++) {
						id = splitSt[0];
						names = splitSt[1];
						ada = splitSt[2];
						phNo = splitSt[3];
					}
					System.out.println(id + " " + names + " " + ada + " " + phNo);
				}
				break;
			case 5:
				quit = true;
				break;
			default:
				System.out.println("Invalid Entry!");
			}
		} while (!quit);
	}
}