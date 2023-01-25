package com.gk.tester;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.gk.service.HospitalService;


public class Tester {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		while(true) {
			System.out.println("================Choice==============");
			System.out.println("1.Add Hospital Details"
							+ "\n2.view All Hospitals"
							+ "\n3.view Hospital by H-code"
							+ "\n4.Modify Hospital Details"
							+ "\n5.Delete Hospital details"
							+ "\n6.Exit...");
			int op = Integer.parseInt(s.nextLine());
			switch(op) {
			case 1:
				
				System.out.println("Enter Hospital Name:");
				String name = s.nextLine();
				System.out.println("Enter Contact Peroson Name:");
				String cPName = s.nextLine();
				System.out.println("Enter Contact Number:");
				String cNumber = s.nextLine();
				System.out.println("Enter Hospital Address:");
				String add = s.nextLine();
				HospitalService.addHospital( name, cPName, cNumber, add);
				break;
			case 2:
				ResultSet rs = HospitalService.viewAllHospital();
				try {
					while(rs.next()) {
						System.out.println(rs.getString(1)+"\t"
											+rs.getString(2)+"\t"+
											rs.getString(3)+"\t"+
											rs.getString(4)+"\t"+
											rs.getString(5));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Enter Hospital Code:");
				String code = s.nextLine();
				ResultSet rs1 = HospitalService.viewByCode(code);
				try {
					if(rs1.next()) {
						System.out.println(rs1.getString(1)+"\t"
								+rs1.getString(2)+"\t"+
								rs1.getString(3)+"\t"+
								rs1.getString(4)+"\t"+
								rs1.getString(5));
					}
					else {
						throw new SQLException();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("Enter Hospital code:");
				String hCode = s.nextLine();
				HospitalService.modifyDetails(hCode);
				
				break;
			case 5:
				System.out.println("Enter Hospital code:");
				String hCode1 = s.nextLine();
				HospitalService.deleteHospital(hCode1);
				break;
			case 6:
				System.out.println("come back soon...");
				HospitalService.conClose();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice...");
			}
		}

	}

}
