package eg.edu.alexu.csd.datastructure.linkedList.cs15_cs36;

import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please choose an action");
		System.out.println("-----------------------");
		System.out.println("1- Set a polynomial variable\r\n" + 
				"2- Print the value of a polynomial variable\r\n" + 
				"3- Add two polynomials\r\n" + 
				"4- Subtract two polynomials\n"+
				"5- Multiply two polynomials\r\n" + 
						"6- Evaluate a polynomial at some point\r\n" + 
						"7- Clear a polynomial variable");
		System.out.println("====================================================================");
		Scanner scan=new Scanner(System.in);
		int num_of_operation=scan.nextInt();
		while(true)
		{
			int found=0;
			if((0<num_of_operation)&&(num_of_operation<8))
			{
				found=1;
			}
			else 
			{
				System.out.println("please Enter number from 1 to 7 to Chose the Operation");
				num_of_operation=scan.nextInt();
				while((0>num_of_operation)||(num_of_operation>8))
				{
					System.out.println("please Enter number from 1 to 7 to Chose the Operation");
					num_of_operation=scan.nextInt();
				}
			}
			if(found==1)
			{
				IPolynomialSolver unit_exam=new OperationOnPolynomial();	
				if(num_of_operation==1)
				{
					System.out.println("Insert the variable name: A, B or C");
					char poly=scan.next().charAt(0);
					scan.nextLine();
					if((64<(int)poly)&&((int)poly<68))
					{
						System.out.println("Insert the polynomial terms in the form:\r\n" + 
								"(coeff1, exponent1), (coeff2, exponent2), ..");
						
						String x=scan.nextLine();
						int counter=0;
						for (int i=0;i<x.length();i++) {
							if (x.charAt(i)=='(') {
								counter++;
							}
						}
						int rows=counter;
						int [][]terms =new int [rows][2];
						String []term =x.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
						for (int i=0;i<rows;i++)
						{
							for (int j=0;j<2;j++)
							{
								for (int k=0;k<term.length;k++)
								{
									if ((!term [k].equals(", "))&&(!term [k].equals("(")) &&(!term [k].equals(")"))&&(!term [k].equals("), ("))) {
										terms[i][j]=Integer.parseInt(term[k]);
										term[k]=", ";
										break;
									}
								}
								
							}
						}
		                unit_exam.setPolynomial(poly, terms);
		                System.out.println("Polynomial "+ poly+" is set");
					}
					
				}
				

				else if(num_of_operation==2)
				{
					System.out.println("Insert the variable name: A, B, C or R");
					char poly=scan.next().charAt(0);
					if(((64<(int)poly)&&((int)poly<68))||((int)poly==82))
					{
						while(unit_exam.print(poly)=="Variable not set")
						{
							System.out.println(unit_exam.print(poly));
							System.out.println("Insert first operand variable name: A, B or C");
						    poly=scan.next().charAt(0);
						}
						System.out.println("Value in"+" "+poly+":"+unit_exam.print(poly));
					}
				}
				else if(num_of_operation==3)
				{
					System.out.println("Insert first operand variable name: A, B or C");
					char poly1=scan.next().charAt(0);
					while(unit_exam.print(poly1).equals("Variable not set"))
					{
						System.out.println(unit_exam.print(poly1));
						System.out.println("Insert first operand variable name: A, B or C");
					    poly1=scan.next().charAt(0);
					}
					System.out.println("Insert second operand variable name: A, B or C");
					char poly2=scan.next().charAt(0);
					while(unit_exam.print(poly2).equals("Variable not set"))
					{
						System.out.println(unit_exam.print(poly2));
						System.out.println("Insert first operand variable name: A, B or C");
					    poly2=scan.next().charAt(0);
					}
					int [][]temp=unit_exam.add(poly1, poly2);
					unit_exam.setPolynomial('R', temp);
					System.out.print("Result set in R: ");
					System.out.print("("+temp[0][0]+", "+temp[0][1]+")");
					for(int i=1;i<temp.length;i++)
					{
						System.out.print(", "+"("+temp[i][0]+", "+temp[i][1]+")");
					}
					System.out.println();
				}else if(num_of_operation==4)
				{
					System.out.println("Insert first operand variable name: A, B or C");
					char poly1=scan.next().charAt(0);
					while(unit_exam.print(poly1).equals("Variable not set"))
					{
						System.out.println(unit_exam.print(poly1));
						System.out.println("Insert first operand variable name: A, B or C");
					    poly1=scan.next().charAt(0);
					}
					System.out.println("Insert second operand variable name: A, B or C");
					char poly2=scan.next().charAt(0);
					while(unit_exam.print(poly2).equals("Variable not set"))
					{
						System.out.println(unit_exam.print(poly2));
						System.out.println("Insert second operand variable name: A, B or C");
					    poly2=scan.next().charAt(0);
					}
					
					int [][]temp=unit_exam.subtract(poly1, poly2);
					unit_exam.setPolynomial('R', temp);
					System.out.print("Result set in R: ");
					System.out.print("("+temp[0][0]+", "+temp[0][1]+")");
					for(int i=1;i<temp.length;i++)
					{
						System.out.print(", "+"("+temp[i][0]+", "+temp[i][1]+")");
					}
					System.out.println();
				}else if(num_of_operation==5)
				{
					System.out.println("Insert first operand variable name: A, B or C");
					char poly1=scan.next().charAt(0);
					
					while(unit_exam.print(poly1).equals("Variable not set"))
					{
						System.out.println(unit_exam.print(poly1));
						System.out.println("Insert first operand variable name: A, B or C");
					    poly1=scan.next().charAt(0);
					}
					System.out.println("Insert second operand variable name: A, B or C");
					char poly2=scan.next().charAt(0);
					
					while(unit_exam.print(poly2).equals("Variable not set"))
					{
						System.out.println(unit_exam.print(poly2));
						System.out.println("Insert first operand variable name: A, B or C");
					    poly2=scan.next().charAt(0);
					}
					int [][]temp=unit_exam.multiply(poly1, poly2);
					unit_exam.setPolynomial('R', temp);
					System.out.print("Result set in R: ");
					System.out.print("("+temp[0][0]+", "+temp[0][1]+")");
					for(int i=1;i<temp.length;i++)
					{
						System.out.print(", "+"("+temp[i][0]+", "+temp[i][1]+")");
					}
					System.out.println();
				}
				else if(num_of_operation==6)
				{
					System.out.println("Insert the variable name: A, B, C or R");
					char poly=scan.next().charAt(0);
					while(unit_exam.print(poly).equals("Variable not set"))
					{
						System.out.println(unit_exam.print(poly));
						System.out.println("Insert first operand variable name: A, B or C");
					    poly=scan.next().charAt(0);
					}
					System.out.println("Insert the  float value");
					float value=scan.nextFloat();
					float x=unit_exam.evaluatePolynomial(poly, value);
					System.out.println("Result set in "+poly+"="+x);
				}
				else if(num_of_operation==6)
				{
					System.out.println("Insert the variable name: A, B, C or R");
					char poly=scan.next().charAt(0);
					while(unit_exam.print(poly).equals("Variable not set"))
					{
						System.out.println(unit_exam.print(poly));
						System.out.println("Insert first operand variable name: A, B or C");
					    poly=scan.next().charAt(0);
					}
					System.out.println("Insert the  float value");
					float value=scan.nextFloat();
					float x=unit_exam.evaluatePolynomial(poly, value);
					System.out.println("Result set in "+poly+"="+x);
				}
				else if(num_of_operation==7)
				{
					System.out.println("Insert the variable name: A, B, C or R");
					char poly=scan.next().charAt(0);
					unit_exam.clearPolynomial(poly);
				}
				System.out.println("====================================================================");
				System.out.println("Please choose an action\r\n" + 
						"1- Set a polynomial variable, ... etc\r\n" + 
						"====================================================================");
				num_of_operation=scan.nextInt();
			}
			
		}
		
			
			
		
	}

}
