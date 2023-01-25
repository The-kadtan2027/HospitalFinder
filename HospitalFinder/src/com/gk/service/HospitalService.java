package com.gk.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 	to create sequence in sql
 	
 	CREATE SEQUENCE customers_seq
	 START WITH     1000
	 INCREMENT BY   1
	 NOCACHE
	 NOCYCLE;
 	
 */

public class HospitalService {
	static Connection con = DbService.openConn();
	private static PreparedStatement ps;
	//add hospital details into database
	public static void addHospital(
			String hospitalName,String conPerson,String conNumber,String address){
		
		try {
			ps = con.prepareStatement("INSERT INTO hospitalfinder VALUES('H-' || hospital_seq.NEXTVAL,?,?,?,?)");
			
			ps.setString(1, hospitalName);
			ps.setString(2, conPerson);
			ps.setString(3, conNumber);
			ps.setString(4, address);
			if(ps.executeUpdate()>0) {
				System.out.println("Record successfully inserted..");
			}else {
				System.out.println("Failed to add..");
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
		
	}
	
	//showing all hospital details 
	public static ResultSet viewAllHospital() {
//		Vector<Hospital> list = new Vector<>();
		ResultSet rs = null;
		try {
			ps= con.prepareStatement("SELECT * FROM hospitalfinder");
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	
	public static ResultSet viewByCode(String code) {
		
		ResultSet rs = null;
		try {
			ps= con.prepareStatement("SELECT * FROM hospitalfinder where hcode = ?");
			ps.setString(1, code);
			rs = ps.executeQuery();
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return rs;
	}
	
	public static void modifyDetails(String code) {
		Scanner sc = new Scanner(System.in);
		try {
			
			ResultSet rs = viewByCode(code);
			if(rs.next()) {
				System.out.println("=======Select what to UPDATE=======");
				System.out.println("1.Hospital Name"
									+ "\n2.Contact Person"
									+ "\n3.Contact number"
									+ "\n4.Address"
									+ "\n5.Back to main menu");
				int op = Integer.parseInt(sc.nextLine());
				THIS: switch(op) {
				case 1:
					System.out.println("Enter Name:");
					String name = sc.nextLine();
					Statement st = con.createStatement();
					int n = st.executeUpdate("UPDATE hospitalfinder SET hname='"+name+"' where hcode='"+code+"'");
					if(n>0) {
						System.out.println("Successfully Modified...");
					}else {
						System.out.println("Update Failed....");
					}
					break;
				case 2:
					System.out.println("Enter contact Person Name:");
					String cName = sc.nextLine();
					Statement st1 = con.createStatement();
					int n1 = st1.executeUpdate("UPDATE hospitalfinder SET contact_person='"+cName+"' where hcode='"+code+"'");
					if(n1>0) {
						System.out.println("Successfully Modified...");
					}else {
						System.out.println("Update Failed....");
					}
					break;
				case 3:
					System.out.println("Enter contact Number:");
					String number = sc.nextLine();
					Statement st2 = con.createStatement();
					int n2 = st2.executeUpdate("UPDATE hospitalfinder SET contact_number='"+number+"' where hcode='"+code+"'");
					if(n2>0) {
						System.out.println("Successfully Modified...");
					}else {
						System.out.println("Update Failed....");
					}
					break;
				case 4:
					System.out.println("Enter Address:");
					String add = sc.nextLine();
					Statement st3 = con.createStatement();
					int n3 = st3.executeUpdate("UPDATE hospitalfinder SET haddress='"+add+"' where hcode='"+code+"'");
					if(n3>0) {
						System.out.println("Successfully Modified...");
					}else {
						System.out.println("Update Failed....");
					}
					
					break;
				case 5:
					break THIS;
				default:
					System.out.println("Invalid Option..");
				}
			}else {
				System.out.println("Invalid Code...");
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
	}
	
	public static void deleteHospital(String hospitalCode) {
		
		try {
			if(viewByCode(hospitalCode).next()) {
				Statement st = con.createStatement();
				int n = st.executeUpdate("DELETE FROM hospitalfinder where hcode = '"+hospitalCode+"'");
				if(n>0) {
					System.out.println("Record successfully deleted..");
				}else {
					throw new SQLException();
				}
			} 
			else {
				System.out.println("Invalid hospital code...");
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	public static void conClose() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
