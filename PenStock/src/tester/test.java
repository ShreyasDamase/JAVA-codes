package tester;

import static utility.UtilityManagement.ShowStock;
import static utility.UtilityManagement.addPen;
import static utility.UtilityManagement.readfile;
import static utility.UtilityManagement.removePenOld;
import static utility.UtilityManagement.setDiscountFoOldPen;
import static utility.UtilityManagement.updateDate;
import static utility.UtilityManagement.writefile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import stockManagement.Pen;
import utility.UtilityManagement;

public class test {

	public static void main(String[] args) {
		ArrayList<Pen> stocklist = new ArrayList<>();

		String fileName = "text.txt";
		try (Scanner sc = new Scanner(System.in)) {

			boolean flag = false;
			while (!flag) {
				System.out.println("1.Add  2. show  3.remove old pen  4.update date  5.set dicount 6.write 7.read");

				switch (sc.nextInt()) {
				case 1:
					try {
						System.out.println("id:");
						int id = sc.nextInt();
						System.out.println("Brand:");
						String Brand = sc.next();
						System.out.println("color");
						String color = sc.next();
						System.out.println("inkcolor");
						String inkColor = sc.next();
						System.out.println("material");
						String material = sc.next();
						System.out.println("pentype");
						String pentype = sc.next();
						System.out.println("price");
						double price = sc.nextDouble();
						addPen(id, Brand, color, inkColor, material, pentype, price);

					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;

				case 2:

					ShowStock();
					break;

				case 3:

					removePenOld();
					break;

				case 4:
					System.out.println("Enter id:");
					int id = sc.nextInt();
					System.out.println("Enter date:");
					String modifydate = sc.next();
					updateDate(id, modifydate);
					break;

				case 5:

					setDiscountFoOldPen();
					break;
				case 6:
					System.out.println("give file name:xyz.txt");
					fileName = sc.next();
					try {
						writefile(fileName);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 7:

					try {

						stocklist = readfile(fileName);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					for (Pen trav : stocklist) {
						System.out.println(trav);
					}
					break;
				
				case 8:
					UtilityManagement.
				      sortById();
					break;
				}
			}

		}

	}
}
