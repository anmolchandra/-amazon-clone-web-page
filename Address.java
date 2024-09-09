import java.io.*;

class Address {
	public static void main(String args[]) {
		try {
			String id;
			int ch;
			Address a = new Address();
			do {
				System.out.println(
						"******************************************\t WELCOME TO ADDRESS BOOK \t*****************************************");
				System.out.println();
				System.out.println("*\t\t\t\t\t\t 1.Add New Record\t\t\tcurrent count:  \t\t\t *");
				System.out.println("*\t\t\t\t\t\t 2.Edit a Record \t\t\t\t\t\t\t *");
				System.out.println("*\t\t\t\t\t\t 3.View Record\t\t\t\t\t\t\t\t *");
				System.out.println("*\t\t\t\t\t\t 4.Search Record \t\t\t\t\t\t\t *");
				System.out.println("*\t\t\t\t\t\t 5.Count Record \t\t\t\t\t\t\t *");
				System.out.println("*\t\t\t\t\t\t 6.Delete Record\t\t\t\t\t\t\t *");
				System.out.println("*\t\t\t\t\t\t 7.Export All Records To MS Word File \t\t\t\t\t *");
				System.out.println("*\t\t\t\t\t\t 8.Quit \t\t\t\t\t\t\t\t *");
				System.out.println();
				System.out.println(
						"**************************************************************************************************************************");
				System.out.println();
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("\n\nEnter Your Choice: ");
				ch = Integer.parseInt(br.readLine());
				if (ch == 1) {
					System.out.println("You Choose Add New Record Option");
					a.Add_New_Record();
				}

				else if (ch == 2) {
					System.out.println("You Choose Edit a Record Option");
					a.edit_record();
				}

				else if (ch == 3) {
					System.out.println("You Choose View Record Option");
					System.out.print(
							"Choose the type of record view: \n\ta)View All Record\n\tb)View Tabular Record \nChoice: ");

					char ch1 = (char) br.read();

					if (ch1 == 'a') {
						System.out.println("You Choose View All Record Option");
						a.view_record();
					} else if (ch1 == 'b') {
						System.out.println("You Choose View Tabular Record Option");
						a.view_tab_record();
					} else {
						System.out.println("You Entered a Wrong choice.....Please enter a valid choice");
						break;
					}
				} else if (ch == 4) {
					System.out.println("You Choose Search Record Option");
					System.out.println(
							"Choose the way you want to perform the search: \n\t\ta)By Candidate Id\n\t\tb)By First Name\n\t\tc)By Last Name\n\t\td)By City\n\t\te)By Date Of Birth");
					System.out.print("\tChoice: ");
					char ch2 = (char) br.read();

					if (ch2 == 'a') {
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						System.out.print("Enter the ContactID of the person whose record you want to search: ");
						id = br1.readLine();
						a.search_record_by_(id, 0);
					} else if (ch2 == 'b') {
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						System.out.print("Enter the First Name of the person whose record you want to search: ");
						id = br1.readLine();
						a.search_record_by_(id, 1);
					} else if (ch2 == 'c') {
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						System.out.print("Enter the Last Name of the person whose record you want to search: ");
						id = br1.readLine();
						a.search_record_by_(id, 2);
					} else if (ch2 == 'd') {
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						System.out.print("Enter the City of the person whose record you want to search: ");
						id = br1.readLine();
						a.search_record_by_(id, 4);

					} else if (ch2 == 'e') {
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						System.out.print("Enter the Date Of Birth of the person whose record you want to search: ");
						id = br1.readLine();
						a.search_record_by_(id, 8);

					} else {
						System.out.println("You Entered a Wrong choice.....Please enter a valid choice");
						break;
					}
				} else if (ch == 5) {
					System.out.println("You Choose Count Record Option");
					System.out.println("Total No.of Records =" + a.count_records());
				} else if (ch == 6) {
					System.out.println("You Choose Delete Record Option");
					a.delete_record();
				} else if (ch == 7) {
					System.out.println("You Choose Export All Records To MS-Word File Option");
					a.Export_File_To_MSWord();
				} else if (ch == 8) {
					System.out.println("Thank You for using Address Book");
					System.exit(0);
				}
			} while (ch != 8);

		} catch (Exception e) {
			System.out.println("Error-----------------" + e.toString());
		}
	}

	public void Add_New_Record() {
		try {
			FileWriter fout = new FileWriter("address.txt", true);
			BufferedWriter bout = new BufferedWriter(fout);
			PrintWriter pout = new PrintWriter(bout);

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("Enter the Contact id: ");
			String cid = br.readLine();

			System.out.print("Enter the First Name: ");
			String fname = br.readLine();

			System.out.print("Enter the Last Name: ");
			String lname = br.readLine();

			System.out.print("Enter the Address: ");
			String add = br.readLine();

			System.out.print("Enter the City: ");
			String city = br.readLine();

			System.out.print("Enter the Mobile No.: ");
			String mob_no = br.readLine();

			System.out.print("Enter the Email Id: ");
			String email_id = br.readLine();

			System.out.print("Enter the D.O.B(dd/mm/yyyy): ");
			String dob = br.readLine();

			pout.println(cid);
			pout.println(fname);
			pout.println(lname);
			pout.println(add);
			pout.println(city);
			pout.println(mob_no);
			pout.println(email_id);
			pout.println(dob);

			System.out.println("One Record Added To Database Successfully............");

			pout.close();
			fout.close();
		} catch (Exception e) {
			System.out.println("Error-----------------" + e.toString());
		}
	}

	// Function to Count the total no.of records in the Address Book
	public int count_records() {
		int c = 0;
		int count = 0;
		try {
			FileReader fin = new FileReader("address.txt");
			BufferedReader bin = new BufferedReader(fin);

			while (true) {
				String s = bin.readLine();
				if (s == null)
					break;
				c++;
			}
			count = c / 8;
			fin.close();
		} catch (Exception e) {
			System.out.println("Error--------" + e.toString());
		} finally {
			return count;
		}
	}

	public void search_record_by_(String id, int t) {
		boolean f = false;
		int c = 0;
		try {
			FileReader fin = new FileReader("address.txt");
			BufferedReader bin = new BufferedReader(fin);
			while (true) {
				String s = bin.readLine();
				c++;
				if (s == null)
					break;
				if (id.equalsIgnoreCase(s)) {
					f = true;
					Address a = new Address();
					a.search_rec(c, t);
				}
			}
			if (f == false) {
				System.out.println("Record with contact id " + id + " is not found in the database");
			}
			fin.close();
		}

		catch (Exception e) {
			System.out.println("Error--------" + e.toString());
		}
	}

	public void search_rec(int c, int t) {
		String s1;
		try {
			FileReader fin = new FileReader("address.txt");
			BufferedReader bin1 = new BufferedReader(fin);

			System.out.println("****************************************");

			while (true) {
				s1 = bin1.readLine();
				if (s1 == null)
					break;
				for (int j = 1; j < c - t; j++) {
					s1 = bin1.readLine();
				}
				for (int i = 1; i <= 8; i++) {
					if (i == 1) {
						System.out.println("Contact Id:\t\t " + s1);
					}
					if (i == 2) {
						System.out.println("First Name:\t\t " + bin1.readLine());
					}
					if (i == 3) {
						System.out.println("Last Name:\t\t " + bin1.readLine());
					}
					if (i == 4) {
						System.out.println("Address:\t\t " + bin1.readLine());
					}
					if (i == 5) {
						System.out.println("City:\t\t\t " + bin1.readLine());
					}
					if (i == 6) {
						System.out.println("Mobile No.:\t\t " + bin1.readLine());
					}
					if (i == 7) {
						System.out.println("Email Id:\t\t " + bin1.readLine());
					}
					if (i == 8) {
						System.out.println("Date Of Birth:\t\t " + bin1.readLine());

					}
				}
				break;
			}
			fin.close();
		} catch (Exception e) {
			System.out.println("Error--------" + e.toString());
		}
	}

	// Function to display all the records
	public void view_record() {
		int c = 0;
		try {
			FileReader fin = new FileReader("address.txt");
			BufferedReader bin = new BufferedReader(fin);

			System.out.println("All Records are:-");
			while (true) {
				String s = bin.readLine();
				if (s == null)
					break;
				c++;

				System.out.println("\t" + s);
				if (c % 8 == 0) {
					System.out.println("\t***************************************************");
				}
			}
			fin.close();
		} catch (Exception e) {
			System.out.println("Error--------" + e.toString());
		}
	}

	// display all the rscords in tabular form
	public void view_tab_record() {
		int c = 1;
		try {
			FileReader fin = new FileReader("address.txt");
			BufferedReader bin = new BufferedReader(fin);

			System.out.println("All Records are:-");
			System.out.println(
					"\nContact_Id FName           LName           Address                        City            MobileNo.  Email_Id                                 DOB");
			while (true) {
				if (c > 8)
					c = 1;
				String s = bin.readLine();
				if (s == null)
					break;
				if (c == 1) {
					if (s.length() <= 10) {
						System.out.print("\n" + s);
						for (int i = 1; i <= 10 - s.length(); i++)
							System.out.print(" ");
					} else {
						System.out.print("|");
						for (int i = 0; i < 10; i++) {
							char ch = s.charAt(i);
							System.out.print(ch);
						}
					}
				}
				if (c == 2) {
					if (s.length() <= 15) {
						System.out.print("|" + s);
						for (int i = 1; i <= 15 - s.length(); i++)
							System.out.print(" ");
					} else {
						System.out.print("|");
						for (int i = 0; i < 15; i++) {
							char ch = s.charAt(i);
							System.out.print(ch);
						}
					}
				}
				if (c == 3) {
					if (s.length() <= 15) {
						System.out.print("|" + s);
						for (int i = 1; i <= 15 - s.length(); i++)
							System.out.print(" ");
					} else {
						System.out.print("|");
						for (int i = 0; i < 15; i++) {
							char ch = s.charAt(i);
							System.out.print(ch);
						}
					}
				}
				if (c == 4) {
					if (s.length() <= 30) {
						System.out.print("|" + s);
						for (int i = 1; i <= 30 - s.length(); i++)
							System.out.print(" ");
					} else {
						System.out.print("|");
						for (int i = 0; i < 30; i++) {
							char ch = s.charAt(i);
							System.out.print(ch);
						}
					}
				}
				if (c == 5) {
					if (s.length() <= 15) {
						System.out.print("|" + s);
						for (int i = 1; i <= 15 - s.length(); i++)
							System.out.print(" ");
					} else {
						System.out.print("|");
						for (int i = 0; i < 15; i++) {
							char ch = s.charAt(i);
							System.out.print(ch);
						}
					}
				}
				if (c == 6) {
					if (s.length() <= 10) {
						System.out.print("|" + s);
						for (int i = 1; i <= 10 - s.length(); i++)
							System.out.print(" ");
					} else {
						System.out.print("|");
						for (int i = 0; i < 10; i++) {
							char ch = s.charAt(i);
							System.out.print(ch);
						}
					}
				}
				if (c == 7) {
					if (s.length() <= 40) {
						System.out.print("|" + s);
						for (int i = 1; i <= 40 - s.length(); i++)
							System.out.print(" ");
					} else {
						System.out.print("|");
						for (int i = 0; i < 40; i++) {
							char ch = s.charAt(i);
							System.out.print(ch);
						}
					}
				}
				if (c == 8) {
					if (s.length() <= 10) {
						System.out.print("|" + s);
						for (int i = 1; i <= 10 - s.length(); i++)
							System.out.print(" ");
					} else {
						System.out.print("|");
						for (int i = 0; i < 10; i++) {
							char ch = s.charAt(i);
							System.out.print(ch);
						}
					}
				}
				c++;
			}
			fin.close();
		} catch (Exception e) {
			System.out.println("Error--------" + e.toString());
		}
	}

	public void Export_File_To_MSWord() {
		int c = 1;
		try {
			FileReader fin = new FileReader("address.txt");
			BufferedReader bin = new BufferedReader(fin);

			FileWriter fout = new FileWriter("file1.doc");
			BufferedWriter bout = new BufferedWriter(fout);
			PrintWriter pout = new PrintWriter(bout);

			pout.println("All Records are:-");
			pout.println(
					"\nContact_Id FName           LName           Address                        City            MobileNo.  Email_Id                                 DOB");
			System.out.println(
					"\nContact_Id FName           LName           Address                        City            MobileNo.  Email_Id                                 DOB");
			while (true) {
				if (c > 8)
					c = 1;
				String s = bin.readLine();
				if (s == null)
					break;
				if (c == 1) {
					if (s.length() <= 10) {
						System.out.print("\n" + s);
						pout.print("\n" + s);
						for (int i = 1; i <= 10 - s.length(); i++) {
							System.out.print(" ");
							pout.print(" ");
						}
					} else {
						System.out.print("|");
						for (int i = 0; i < 10; i++) {
							char ch = s.charAt(i);
							System.out.print(ch);
							pout.print(ch);
						}
					}
				}
				if (c == 2) {
					if (s.length() <= 15) {
						System.out.print("|" + s);
						pout.print("|" + s);
						for (int i = 1; i <= 15 - s.length(); i++) {
							System.out.print(" ");
							pout.print(" ");
						}
					} else {
						System.out.print("|");
						for (int i = 0; i < 15; i++) {
							char ch = s.charAt(i);
							System.out.print(ch);
							pout.print(ch);
						}
					}
				}
				if (c == 3) {
					if (s.length() <= 15) {
						System.out.print("|" + s);
						pout.print("|" + s);
						for (int i = 1; i <= 15 - s.length(); i++) {
							System.out.print(" ");
							pout.print(" ");
						}
					} else {
						System.out.print("|");
						for (int i = 0; i < 15; i++) {
							char ch = s.charAt(i);
							System.out.print(ch);
							pout.print(ch);
						}
					}
				}
				if (c == 4) {
					if (s.length() <= 30) {
						System.out.print("|" + s);
						pout.print("|" + s);
						for (int i = 1; i <= 30 - s.length(); i++) {
							System.out.print(" ");
							pout.print(" ");
						}
					} else {
						System.out.print("|");
						for (int i = 0; i < 30; i++) {
							char ch = s.charAt(i);
							System.out.print(ch);
							pout.print(ch);
						}
					}
				}
				if (c == 5) {
					if (s.length() <= 15) {
						System.out.print("|" + s);
						pout.print("|" + s);
						for (int i = 1; i <= 15 - s.length(); i++) {
							System.out.print(" ");
							pout.print(" ");
						}
					} else {
						System.out.print("|");
						for (int i = 0; i < 15; i++) {
							char ch = s.charAt(i);
							System.out.print(ch);
							pout.print(ch);
						}
					}
				}
				if (c == 6) {
					if (s.length() <= 10) {
						System.out.print("|" + s);
						pout.print("|" + s);
						for (int i = 1; i <= 10 - s.length(); i++) {
							System.out.print(" ");
							pout.print(" ");
						}
					} else {
						System.out.print("|");
						for (int i = 0; i < 10; i++) {
							char ch = s.charAt(i);
							System.out.print(ch);
							pout.print(ch);
						}
					}
				}
				if (c == 7) {
					if (s.length() <= 40) {
						System.out.print("|" + s);
						pout.print("|" + s);
						for (int i = 1; i <= 40 - s.length(); i++) {
							System.out.print(" ");
							pout.print(" ");
						}
					} else {
						System.out.print("|");
						for (int i = 0; i < 40; i++) {
							char ch = s.charAt(i);
							System.out.print(ch);
							pout.print(ch);
						}
					}
				}
				if (c == 8) {
					if (s.length() <= 10) {
						System.out.print("|" + s);
						pout.print("|" + s);
						for (int i = 1; i <= 10 - s.length(); i++) {
							System.out.print(" ");
							pout.print(" ");
						}
					} else {
						System.out.print("|");
						for (int i = 0; i < 10; i++) {
							char ch = s.charAt(i);
							System.out.print(ch);
							pout.print(ch);
						}
					}
				}
				c++;
			}
			fin.close();
			pout.close();
			fout.close();
		} catch (Exception e) {
			System.out.println("Error--------" + e.toString());
		}
	}

	public void delete_record() {
		try {
			int flag = 0;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter the contact id of the person whose record you want to delete: ");
			String id = br.readLine();

			FileReader fin = new FileReader("address.txt");
			BufferedReader bin = new BufferedReader(fin);

			FileWriter fout = new FileWriter("xyz.txt", true);
			BufferedWriter bout = new BufferedWriter(fout);
			PrintWriter pout = new PrintWriter(bout);

			while (true) {
				String s = bin.readLine();
				if (s == null)
					break;

				if (s.equals(id)) {
					bin.readLine();
					bin.readLine();
					bin.readLine();
					bin.readLine();
					bin.readLine();
					bin.readLine();
					bin.readLine();
					flag = 1;
				} else {
					pout.println(s);
					pout.println(bin.readLine());
					pout.println(bin.readLine());
					pout.println(bin.readLine());
					pout.println(bin.readLine());
					pout.println(bin.readLine());
					pout.println(bin.readLine());
					pout.println(bin.readLine());
				}
			}
			fin.close();
			pout.close();
			fout.close();

			if (flag == 0) {
				System.out.println("Enterd Contact Id is Invalid.. Please Enter a correct Candidate id...");
				File f = new File("address.txt");
				boolean b = f.delete();
				if (b == true) {
				}
				File oldfile = new File("xyz.txt");
				File newfile = new File("address.txt");
				if (oldfile.renameTo(newfile)) {
				}
			} else {
				File f = new File("address.txt");
				boolean b = f.delete();
				if (b == true) {
					System.out.println("Record Deleted Successfuly");
				}
				File oldfile = new File("xyz.txt");
				File newfile = new File("address.txt");
				if (oldfile.renameTo(newfile)) {
				}
			}
		} catch (Exception e) {
			System.out.println("Error--------" + e.toString());
		}
	}

	public void edit_record() {
		try {
			int flag = 0;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter the contact id of the person whose record you want to edit: ");
			String id = br.readLine();

			FileReader fin = new FileReader("address.txt");
			BufferedReader bin = new BufferedReader(fin);

			FileWriter fout = new FileWriter("temp.txt");
			BufferedWriter bout = new BufferedWriter(fout);
			PrintWriter pout = new PrintWriter(bout);

			while (true) {
				String s = bin.readLine();
				if (s == null)
					break;
				if (s.equals(id)) {
					System.out.println("The Record of Person With contact id: " + id + "is-");
					Address a = new Address();
					a.search_record_by_(id, 0);
					System.out.print("Enter New First Name: ");
					String fname = br.readLine();

					System.out.print("Enter New Last Name: ");
					String lname = br.readLine();

					System.out.print("Enter New Address: ");
					String add = br.readLine();

					System.out.print("Enter New City: ");
					String city = br.readLine();

					System.out.print("Enter New Mobile No.: ");
					String mob_no = br.readLine();

					System.out.print("Enter New Email Id: ");
					String email_id = br.readLine();

					System.out.print("Enter New D.O.B(dd/mm/yyyy): ");
					String dob = br.readLine();

					pout.println(s);
					pout.println(fname);
					pout.println(lname);
					pout.println(add);
					pout.println(city);
					pout.println(mob_no);
					pout.println(email_id);
					pout.println(dob);
					flag = 1;
					for (int i = 1; i <= 7; i++) {
						s = bin.readLine();
					}
				} else {
					pout.println(s);
					pout.println(bin.readLine());
					pout.println(bin.readLine());
					pout.println(bin.readLine());
					pout.println(bin.readLine());
					pout.println(bin.readLine());
					pout.println(bin.readLine());
					pout.println(bin.readLine());
				}
			}
			pout.close();
			fout.close();
			fin.close();

			if (flag == 1) {

				File f = new File("address.txt");
				boolean b = f.delete();

				File oldfile = new File("temp.txt");
				File newfile = new File("address.txt");

				if (oldfile.renameTo(newfile)) {
					System.out.println("Record Edited Successfully------------");
				}
			} else {
				File f = new File("address.txt");
				boolean b = f.delete();

				File oldfile = new File("temp.txt");
				File newfile = new File("address.txt");

				if (oldfile.renameTo(newfile)) {
					System.out.println("Record not found");
				}
			}
		} catch (Exception e) {
			System.out.println("Error--------" + e.toString());
		}
	}

}