import java.util.Scanner;
import java.io.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		// Author: Nihar Rao, Dixant Patel, Satjeevan Riar, Prabhjit Dhatt
		// Purpose Of Program: LEGO PROJECT DATABASE VIEWER
		// Date Last Modified: Today
		Scanner in = new Scanner(System.in);


		FileReader fr = new FileReader(".\combined-database.txt");
		BufferedReader br = new BufferedReader(fr);
		int x;
		int y;
		int z;
		int c;
		int x1=0;
		int xx=0;
		int yy=100000;
		double xxx=0;
		double yyy=100000;
		int xxxx=0;
		int yyyy=100000;
		int[] form;
		double[] ogs;
		double average=0;
		String a;
		String chosen11="";
		String chosen22="";
		String chosen33="";
		boolean check = true;
		boolean check2 = true;
		boolean check3 = true;
		int Option;
		int InnerOption;
		int InnerInnerOption;
		legolist l = new legolist();
		String k;
		int i=0;
		while((k = br.readLine())!=null){
			i++;
		}
		l.create(i);
		//l.sortbysetnumlowtohigh();
		//l.printlist();
		String[] themes = l.getthemes(i);
		form = l.largestall(i);

		while(check==true){

			System.out.println("Choose Option:");
			System.out.println("Option 1: Search By Theme Name");
			System.out.println("Option 2: Browse Themes");
			System.out.println("Option 3: Browse All");
			System.out.println("Option 4: Apply Restrictions To Search");
			System.out.println("Option 5: Discounts");
			System.out.println("Option 6: Output All Sets");
			System.out.println("Option 7: Exit LEGO MASTER 69");

			Option = in.nextInt();

			switch(Option){


			case 1://Search By Theme Name

				System.out.println("Enter Theme Name:");
				a = in.next();
				boolean match=false;
				for(int cc=0; cc<themes.length;cc++){
					if (a.equals(themes[cc])){
						match = true;
					}
				}
				if (match==false){
					System.out.println("Theme not found\n");
					i=0;
					Option = 7;
				}

				else{
					i = 1;
				}
				while(i==1){
					//Search Theme Name Method
					System.out.println("Sort Sets:");
					System.out.println("Option 1: Alphabetically");
					System.out.println("Option 2: By Set Number");
					System.out.println("Option 3: By Costs And Quantities");
					InnerOption = in.nextInt();
					switch(InnerOption){

					case 1://Sort Alphabetically
						c = 1;
						while(c==1){
							System.out.println("Choose:");
							System.out.println("1: A-->Z");
							System.out.println("2: Z-->A");
							x = in.nextInt();
							if(x==1){
								l.sortalphabetatoz();		//sort a to z method
								l.printspecific(a,form,x1,xx,xxx,xxxx,yy,yyy,yyyy);			//print for chosen theme
							}
							else if(x==2){
								l.sortalphabetztoa();		//sort z to a method
								l.printspecific(a,form,x1,xx,xxx,xxxx,yy,yyy,yyyy);			//print for chosen theme
							}
							else{
								System.out.println("Invalid Option Entered");
							}
							System.out.println("Would You Like To Sort Alphabetically Again? (yes/no)");
							a = in.next();
							if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
								c = 1;
							}
							else{
								c = 0;
							}
						}
						break;
					case 2://Sort By Set Number
						c = 1;
						while(c==1){
							System.out.println("Choose:");
							System.out.println("1: Set #000000 to Set #999999");
							System.out.println("2: Set #999999 to Set #000000");
							x = in.nextInt();
							if(x==1){
								l.sortbysetnumlowtohigh();		//Sort Sets Ascending Order Method
								l.printspecific(a,form,x1,xx,xxx,xxxx,yy,yyy,yyyy);				//print for chosen theme
							}
							else if(x==2){
								l.sortbysetnumhightolow();		//Sort Sets Descending Order Method
								l.printspecific(a,form,x1,xx,xxx,xxxx,yy,yyy,yyyy);				//print for chosen theme
							}
							else{
								System.out.println("Invalid Option Entered");
							}
							System.out.println("Would You Like To Sort By Set Number Again? (yes/no)");
							a = in.next();
							if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
								c = 1;
							}
							else{
								c = 0;
							}
						}
						break;
					case 3://Cost
						c = 1;
						while(c==1){
							System.out.println("Choose:");
							System.out.println("1: Cost Of Sets");
							System.out.println("2: Number Of Bricks");
							System.out.println("3: Average Cost Per Brick");
							System.out.println("4: Number Of Minifigures");
							System.out.println("5: Average Cost Per Minifigure");
							System.out.println("6: Age Range");
							InnerInnerOption = in.nextInt();
							switch(InnerInnerOption){
							case 1://Cost Of Sets
								c = 1;
								while(c==1){
									System.out.println("Choose:");
									System.out.println("1: Low To High");
									System.out.println("2: High To Low");
									x = in.nextInt();
									if(x==1){
										l.sortbycostlowtohigh();		//sort low to high
										l.printspecific(a,form,x1,xx,xxx,xxxx,yy,yyy,yyyy);				//print only for desired theme
									}
									else if(x==2){
										l.sortbycosthightolow();		//sort high to low
										l.printspecific(a,form,x1,xx,xxx,xxxx,yy,yyy,yyyy);				//print only for desired theme
									}
									else{
										System.out.println("Invalid Option Entered");
									}
									System.out.println("Would You Like To Sort By Cost Of Sets Again? (yes/no)");
									a = in.next();
									if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
										c = 1;
									}
									else{
										c = 0;
									}
								}
								break;
							case 2://Number Of Bricks
								c = 1;
								while(c==1){
									System.out.println("Choose:");
									System.out.println("1: Low To High");
									System.out.println("2: High To Low");
									x = in.nextInt();
									if(x==1){
										l.numofbrickslowtohigh();		//sort low to high
										l.printspecific(a,form,x1,xx,xxx,xxxx,yy,yyy,yyyy);				//print only for desired theme
									}
									else if(x==2){
										l.numofbrickshightolow();		//sort high to low
										l.printspecific(a,form,x1,xx,xxx,xxxx,yy,yyy,yyyy);				//print only for desired theme
									}
									else{
										System.out.println("Invalid Option Entered");
									}
									System.out.println("Would You Like To Sort By # Of Bricks Again? (yes/no)");
									a = in.next();
									if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
										c = 1;
									}
									else{
										c = 0;
									}
								}
								break;
							case 3://Average Cost Per Brick
								System.out.println("The Average Cost Per Bricks Within This Theme is: ");
								average = Math.round(l.costperbricktheme(a)*100.0)/100.0;
								System.out.println(average);		//Average Cost Per Brick Within Theme Method
								c = 1;
								while(c==1){
									System.out.println("View Average Cost Of Bricks Within Sets of Theme:");
									System.out.println("1: Low To High");//Within Sets of Theme
									System.out.println("2: High To Low");//Within Sets Of Theme
									x = in.nextInt();
									if(x==1){
										l.costperbrickslowtohigh();		//Sort Low To High Method Of Avg. Price Per Brick Method
										l.printspecific(a,form,x1,xx,xxx,xxxx,yy,yyy,yyyy);				//Print Method
									}
									else if(x==2){
										l.costperbrickshightolow();		//Sort Low To High Method Of Avg. Price Per Brick Method
										l.printspecific(a,form,x1,xx,xxx,xxxx,yy,yyy,yyyy);				//Print Method
									}
									else{
										System.out.println("Invalid Option Entered");
									}
									System.out.println("Would You Like To Sort By Average Cost Per Bricks Again? (yes/no)");
									a = in.next();
									if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
										c = 1;
									}
									else{
										c = 0;
									}
								}
								break;
							case 4://Number Of Minifigures
								c = 1;
								while(c==1){
									System.out.println("Choose:");
									System.out.println("1: Low To High");
									System.out.println("2: High To Low");
									x = in.nextInt();
									if(x==1){
										l.sortbyminifigslowtohigh();		//sort low to high
										l.printspecific(a,form,x1,xx,xxx,xxxx,yy,yyy,yyyy);				//print only for desired theme
									}
									else if(x==2){
										l.sortbyminifigshightolow();		//sort low to high
										l.printspecific(a,form,x1,xx,xxx,xxxx,yy,yyy,yyyy);				//print only for desired theme
									}
									else{
										System.out.println("Invalid Option Entered");
									}
									System.out.println("Would You Like To Sort By # Of Minifigures Again? (yes/no)");
									a = in.next();
									if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
										c = 1;
									}
									else{
										c = 0;
									}
								}
								break;
							case 5://Average Cost Per Minifigure
								System.out.println("The Average Cost Per Minifigure Within This Theme is: ");
								average = Math.round(l.costperminifigtheme(a)*100.0)/100.0;
								System.out.println(average);//Average Cost Per Minifigure Within Theme Method
								c = 1;
								while(c==1){
									System.out.println("View Average Cost Of Minifigure Within Sets of Theme:");
									System.out.println("1: Low To High");//Within Sets of Theme
									System.out.println("2: High To Low");//Within Sets Of Theme
									x = in.nextInt();
									if(x==1){
										l.sortbycostperminifiglowtohigh();	//Sort Low To High Method Of Avg. Price Per Minifigure Method
										l.printspecific(a,form,x1,xx,xxx,xxxx,yy,yyy,yyyy);					//Print Method
									}
									else if(x==2){
										l.sortbycostperminifighightolow();	//Sort Low To High Method Of Avg. Price Per Minifigure Method
										l.printspecific(a,form,x1,xx,xxx,xxxx,yy,yyy,yyyy);					//Print Method
									}
									else{
										System.out.println("Invalid Option Entered");
									}
									System.out.println("Would You Like To Sort By Average Cost Per Minifigure Again? (yes/no)");
									a = in.next();
									if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
										c = 1;
									}
									else{
										c = 0;
									}
								}
								break;
							case 6://Age Range
								System.out.println("The Average Age Recommended For This Theme is: ");
								double ave =Math.round(l.averageminage(a)*100.0)/100.0;
								System.out.println(ave);	//Average Age Within Theme Method
								c = 1;
								while(c==1){
									System.out.println("View Recommended Ages Within Sets of Theme:");
									System.out.println("1: Low To High");//Within Sets of Theme
									System.out.println("2: High To Low");//Within Sets Of Theme
									x = in.nextInt();
									if(x==1){
										l.minagelowtohigh();		//Sort Low To High Method Of Min. Age Method
										l.printspecific(a, form,x1,xx,xxx,xxxx,yy,yyy,yyyy);	//Print Method
									}
									else if(x==2){
										l.minagehightolow();		//Sort High to Low Method of Min. Age Method
										l.printspecific(a, form,x1,xx,xxx,xxxx,yy,yyy,yyyy);	//Print Method
									}
									else{
										System.out.println("Invalid Option Entered");
									}
									System.out.println("Would You Like To Sort By Age Level Again? (yes/no)");
									a = in.next();
									if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
										c = 1;
									}
									else{
										c = 0;
									}
								}
								break;
							default:System.out.println("Invalid Option Entered");
							}
							System.out.println("Would You Like To Sort By Costs And Quantities Again? (yes/no)");
							a = in.next();
							if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
								c = 1;
							}
							else{
								c = 0;
							}
						}
						break;
					default:System.out.println("Invalid Option Entered");
					}
					System.out.println("Would You Like To Sort This Theme Again? (yes/no)");
					a = in.next();
					if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
						i = 1;
					}
					else{
						i = 0;
					}
				}
				break;



			case 2://Browse Themes
				System.out.println("Choose Theme:");
				for(int cc=0;cc<themes.length;cc++){
					System.out.println((cc+1)+". "+themes[cc]);
				}
				x = in.nextInt();
				String chosen = "";
				for(int cc=0;cc<x;cc++){
					chosen = themes[cc];
				}
				//Choose Theme Method
				i = 1;
				while(i==1){
					//Search Theme Name Method
					System.out.println("Sort Sets:");
					System.out.println("Option 1: Alphabetically");
					System.out.println("Option 2: By Set Number");
					System.out.println("Option 3: By Costs And Quantities");
					InnerOption = in.nextInt();
					switch(InnerOption){

					case 1://Sort Alphabetically
						c = 1;
						while(c==1){
							System.out.println("Choose:");
							System.out.println("1: A-->Z");
							System.out.println("2: Z-->A");
							x = in.nextInt();
							if(x==1){
								l.sortalphabetatoz();				//sort a to z
								l.printspecific(chosen,form,x1,xx,xxx,xxxx,yy,yyy,yyyy);		//print
							}
							else if(x==2){
								l.sortalphabetztoa();				//sort z to a
								l.printspecific(chosen,form,x1,xx,xxx,xxxx,yy,yyy,yyyy);		//print
							}
							else{
								System.out.println("Invalid Option Entered");
							}
							System.out.println("\nWould You Like To Sort Alphabetically Again? (yes/no)");
							a = in.next();
							if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
								c = 1;
							}
							else{
								c = 0;
							}
						}
						break;
					case 2://Sort By Set Number
						c = 1;
						while(c==1){
							System.out.println("Choose:");
							System.out.println("1: Set #000000 to Set #999999");
							System.out.println("2: Set #999999 to Set #000000");
							x = in.nextInt();
							if(x==1){
								l.sortbysetnumlowtohigh(); 		//Sort Sets Ascending Order Method
								l.printspecific(chosen, form,x1,xx,xxx,xxxx,yy,yyy,yyyy); 	//Print Method
							}
							else if(x==2){
								l.sortbysetnumhightolow(); 		//Sort Sets Descending Order Method
								l.printspecific(chosen, form,x1,xx,xxx,xxxx,yy,yyy,yyyy); 	//Print Method
							}
							else{
								System.out.println("Invalid Option Entered");
							}
							System.out.println("Would You Like To Sort By Set Number Again? (yes/no)");
							a = in.next();
							if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
								c = 1;
							}
							else{
								c = 0;
							}
						}
						break;
					case 3://Cost
						c = 1;
						while(c==1){
							System.out.println("Choose:");
							System.out.println("1: Cost Of Sets");
							System.out.println("2: Number Of Bricks");
							System.out.println("3: Average Cost Per Brick");
							System.out.println("4: Number Of Minifigures");
							System.out.println("5: Average Cost Per Minifigure");
							System.out.println("6: Age Range");
							InnerInnerOption = in.nextInt();
							switch(InnerInnerOption){
							case 1://Cost Of Sets
								c = 1;
								while(c==1){
									System.out.println("Choose:");
									System.out.println("1: Low To High");
									System.out.println("2: High To Low");
									x = in.nextInt();
									if(x==1){
										l.sortbycostlowtohigh(); 		//Sort Low To High Method
										l.printspecific(chosen, form,x1,xx,xxx,xxxx,yy,yyy,yyyy); 	//Print Method
									}
									else if(x==2){
										l.sortbycosthightolow(); 		//Sort High to Low Method
										l.printspecific(chosen, form,x1,xx,xxx,xxxx,yy,yyy,yyyy); 	//Print Method
									}
									else{
										System.out.println("Invalid Option Entered");
									}
									System.out.println("Would You Like To Sort By Cost Of Sets Again? (yes/no)");
									a = in.next();
									if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
										c = 1;
									}
									else{
										c = 0;
									}
								}
								break;
							case 2://Number Of Bricks
								c = 1;
								while(c==1){
									System.out.println("Choose:");
									System.out.println("1: Low To High");
									System.out.println("2: High To Low");
									x = in.nextInt();
									if(x==1){
										l.numofbrickslowtohigh(); 		//Sort Low To High Method
										l.printspecific(chosen, form,x1,xx,xxx,xxxx,yy,yyy,yyyy); 	//Print Method
									}
									else if(x==2){
										l.numofbrickshightolow(); 		//Sort High to Low Method
										l.printspecific(chosen, form,x1,xx,xxx,xxxx,yy,yyy,yyyy); 	//Print Method
									}
									else{
										System.out.println("Invalid Option Entered");
									}
									System.out.println("Would You Like To Sort By # Of Bricks Again? (yes/no)");
									a = in.next();
									if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
										c = 1;
									}
									else{
										c = 0;
									}
								}
								break;
							case 3://Average Cost Per Brick
								System.out.println("The Average Cost Per Bricks Within This Theme is: ");
								average = Math.round(l.costperbricktheme(chosen)*100.0)/100.0;
								System.out.println(average); //Average Cost Per Brick Within Theme Method
								c = 1;
								while(c==1){
									System.out.println("View Average Cost Of Bricks Within Sets of Theme:");
									System.out.println("1: Low To High");//Within Sets of Theme
									System.out.println("2: High To Low");//Within Sets Of Theme
									x = in.nextInt();
									if(x==1){
										l.costperbrickslowtohigh(); 		//Sort Low To High Method Of Avg. Price Per Brick Method
										l.printspecific(chosen, form,x1,xx,xxx,xxxx,yy,yyy,yyyy); 		//Print Method
									}
									else if(x==2){
										l.costperbrickshightolow(); 		//Sort High to Low Method of Avg. Price Per Brick Method
										l.printspecific(chosen, form,x1,xx,xxx,xxxx,yy,yyy,yyyy);  	//Print Method
									}
									else{
										System.out.println("Invalid Option Entered");
									}
									System.out.println("Would You Like To Sort By Average Cost Per Bricks Again? (yes/no)");
									a = in.next();
									if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
										c = 1;
									}
									else{
										c = 0;
									}
								}
								break;
							case 4://Number Of Minifigures
								c = 1;
								while(c==1){
									System.out.println("Choose:");
									System.out.println("1: Low To High");
									System.out.println("2: High To Low");
									x = in.nextInt();
									if(x==1){
										l.sortbyminifigslowtohigh(); 		//Sort Low To High Method
										l.printspecific(chosen ,form,x1,xx,xxx,xxxx,yy,yyy,yyyy); 		//Print Method
									}
									else if(x==2){
										l.sortbyminifigshightolow();  		//Sort High to Low Method
										l.printspecific(chosen, form,x1,xx,xxx,xxxx,yy,yyy,yyyy); 		//Print Method
									}
									else{
										System.out.println("Invalid Option Entered");
									}
									System.out.println("Would You Like To Sort By # Of Minifigures Again? (yes/no)");
									a = in.next();
									if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
										c = 1;
									}
									else{
										c = 0;
									}
								}
								break;
							case 5://Average Cost Per Minifigure
								System.out.println("The Average Cost Per Minifigure Within This Theme is: ");
								average = Math.round(l.costperminifigtheme(chosen)*100.0)/100.0;
								System.out.println(average); 		//Average Cost Per Minifigure Within Theme Method
								c = 1;
								while(c==1){
									System.out.println("View Average Cost Of Minifigure Within Sets of Theme:");
									System.out.println("1: Low To High");//Within Sets of Theme
									System.out.println("2: High To Low");//Within Sets Of Theme
									x = in.nextInt();
									if(x==1){
										l.sortbycostperminifiglowtohigh(); 		//Sort Low To High Method Of Avg. Price Per Minifigure Method
										l.printspecific(chosen, form,x1,xx,xxx,xxxx,yy,yyy,yyyy);  		//Print Method
									}
									else if(x==2){
										l.sortbycostperminifighightolow();  	//Sort High to Low Method of Avg. Price Per Minifigure Method
										l.printspecific(chosen, form,x1,xx,xxx,xxxx,yy,yyy,yyyy);  		//Print Method
									}
									else{
										System.out.println("Invalid Option Entered");
									}
									System.out.println("Would You Like To Sort By Average Cost Per Minifigure Again? (yes/no)");
									a = in.next();
									if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
										c = 1;
									}
									else{
										c = 0;
									}
								}
								break;
							case 6://Age Range
								System.out.println("The Average Age Recommended For This Theme is: ");
								double aver = Math.round(l.averageminage(chosen)*100.0)/100.0;
								System.out.println(l.averageminage(chosen));//Average Age Within Theme Method
								c = 1;
								while(c==1){
									System.out.println("View Recommended Ages Within Sets of Theme:");
									System.out.println("1: Low To High");//Within Sets of Theme
									System.out.println("2: High To Low");//Within Sets Of Theme
									x = in.nextInt();
									if(x==1){
										l.minagelowtohigh();  			//Sort Low To High Method Of Min. Age Method
										l.printspecific(chosen, form,x1,xx,xxx,xxxx,yy,yyy,yyyy); 	//Print Method
									}
									else if(x==2){
										l.minagehightolow(); 			//Sort High to Low Method of Min. Age Method
										l.printspecific(chosen, form,x1,xx,xxx,xxxx,yy,yyy,yyyy); 	//Print Method
									}
									else{
										System.out.println("Invalid Option Entered");
									}
									System.out.println("Would You Like To Sort By Age Level Again? (yes/no)");
									a = in.next();
									if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
										c = 1;
									}
									else{
										c = 0;
									}
								}
								break;
							default:System.out.println("Invalid Option Entered");
							}
							System.out.println("Would You Like To Sort By Costs And Quantities Again? (yes/no)");
							a = in.next();
							if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
								c = 1;
							}
							else{
								c = 0;
							}
						}
						break;
					default:System.out.println("Invalid Option Entered");
					}
					System.out.println("Would You Like To Sort This Theme Again? (yes/no)");
					a = in.next();
					if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
						i = 1;
					}
					else{
						i = 0;
					}
				}
				break;




			case 3://Browse All Sets
				//System.out.println(Set Of The Day Method);
				//System.out.println(Recommended For You Method);
				i = 1;
				while(i==1){
					System.out.println("Select Option");
					System.out.println("Option 1: Search");
					System.out.println("Option 2: Compare Themes");
					System.out.println("Option 3: Budget Lego");
					System.out.println("Option 4: Premium Lego");
					InnerOption = in.nextInt();

					switch(InnerOption){

					case 1:		//Search
						c = 1;
						while(c==1){
							System.out.println("Enter:");
							System.out.println("1: Enter Set Name");
							System.out.println("2: Enter Set Number");
							x = in.nextInt();
							if(x==1){
								c = 1;
								while(c==1){
									System.out.println("Enter:");
									a = in.next();
									l.printsinglebyname(a, form);		//Output/Print Set Info Method
									System.out.println("Would You Like To Search By Set Name Again? (yes/no)");
									a = in.next();
									if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
										c = 1;
									}
									else{
										c = 0;
									}
								}
							}
							else if(x==2){
								c = 1;
								while(c==1){
									System.out.println("Enter:");
									y = in.nextInt();
									l.printsinglebynum(y, form);		//Output/Print Set Info Method
									System.out.println("Would You Like To Search By Set Number Again? (yes/no)");
									a = in.next();
									if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
										c = 1;
									}
									else{
										c = 0;
									}
								}
							}
							else{
								System.out.println("Invalid Option Entered");
							}
							System.out.println("Would You Like To Search Sets Again? (yes/no)");
							a = in.next();
							if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
								c = 1;
							}
							else{
								c = 0;
							}
						}
						break;

					case 2:									//Compare
						//Compare Themes
						c = 1;
						while(c==1){
							do{
								if(c==1){
									System.out.println("Choose:");
									for(int cc=0;cc<themes.length;cc++){
										System.out.println((cc+1)+". "+themes[cc]);
									}
									x = in.nextInt();
									String chosen1 = "";
									for(int cc=0;cc<x;cc++){
										chosen1 = themes[cc];
									}
									chosen11 = chosen1;
								}
								else if(c==2){
									System.out.println("Choose:");
									for(int cc=0;cc<themes.length;cc++){
										System.out.println((cc+1)+". "+themes[cc]);
									}
									y = in.nextInt();
									String chosen2 = "";
									for(int cc=0;cc<y;cc++){
										chosen2 = themes[cc];
									}
									chosen22 = chosen2;
								}
								else if(c==3){
									System.out.println("Would You Like To Add One More To Compare? (yes/no)");
									a = in.next();
									if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
										System.out.println("Choose:");
										for(int cc=0;cc<themes.length;cc++){
											System.out.println((cc+1)+". "+themes[cc]);
										}
										z = in.nextInt();
										String chosen3 = "";
										for(int cc=0;cc<z;cc++){
											chosen3 = themes[cc];
										}
										chosen33 = chosen3;
										l.comparethemes3(form, chosen11, chosen22, chosen33, x1, xx, xxx, xxxx, yy, yyy, yyyy); 	//Compare 3 Themes Method (CompareSets(x,y,z))}
									}
									else{
										l.comparethemes2(form, chosen11, chosen22, x1, xx, xxx, xxxx, yy, yyy, yyyy); 			//Compare 2 Themes Method (CompareSets(x,y))}
									}
								}
								c++;
							}
							while(c<4);
							System.out.println("Would You Like To Compare Themes Again? (yes/no)");
							a = in.next();
							if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
								c = 1;
							}
							else{
								c = 0;
							}
						}
						break;

					case 3: //Budget Lego
						c = 1;
						while(c==1){
							double amount;
							System.out.println("Enter:");
							System.out.println("1: Cheapest Themes");
							System.out.println("2: Cheapest Sets");
							x = in.nextInt();
							if(x==1){
								amount = l.cheapthemebycost(themes);				//Cheapest Theme By Price Method
								System.out.println("$ "+amount+" per set (average)\n");
								amount = l.cheapthemebybrick(themes); 				//Cheapest Theme Per Brick Method
								System.out.println("$ "+amount+" per brick (average)\n");
								amount = l.cheapthemebymf(themes); 					//Cheapest Theme Per Minifigure Method
								System.out.println("$ "+amount+" per mini-figure (average)\n");
							}
							else if(x==2){
								amount = l.cheapsetbycost(); 						//Cheapest Set By Price Method
								System.out.println("For: $ "+amount+"\n");
								amount = l.cheapsetbybricks(); 						//Cheapest Set Per Brick Method
								System.out.println("For: $ "+amount+" per brick\n");
								amount = l.cheapsetbymf(); 							//Cheapest Set Per Minifigure Method
								System.out.println("For: $ "+amount+" per mini-figure\n");
							}
							else{
								System.out.println("Invalid Option Entered");
							}
							System.out.println("Would You Like To View Budget Lego Again? (yes/no)");
							a = in.next();
							if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
								c = 1;
							}
							else{
								c = 0;
							}
						}
						break;

					case 4: //Premium Lego
						c = 1;
						while(c==1){
							double amount1;
							System.out.println("Enter:");
							System.out.println("1: Most Expensive Themes");
							System.out.println("2: Most Expensive Sets");
							x = in.nextInt();
							if(x==1){
								amount1 = l.expensivethemebycost(themes); 			//Most Expensive Theme By Price Method
								System.out.println("$ "+amount1+" per set (average)\n");
								amount1 = l.expensivethemebybrick(themes); 			//Most Expensive Theme Per Brick Method
								System.out.println("$ "+amount1+" per brick (average)\n");
								amount1 = l.expensivethemebymf(themes);	   			//Most Expensive Theme Per Minifigure Method
								System.out.println("$ "+amount1+" per mini-figure (average)\n");
							}
							else if(x==2){
								amount1 = l.costlysetbycost(); 						//Most Expensive Set By Price Method
								System.out.println("For: $ "+amount1+"\n");
								amount1 = l.costlysetbybricks(); 					//Most Expensive Set Per Brick Method
								System.out.println("For: $ "+amount1+" per brick\n");
								amount1 = l.costlysetbymf(); 						//Most Expensive Set Per Minifigure Method
								System.out.println("For: $ "+amount1+" per mini-figure\n");
							}
							else{
								System.out.println("Invalid Option Entered");
							}
							System.out.println("Would You Like To View Premium Lego Again? (yes/no)");
							a = in.next();
							if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
								c = 1;
							}
							else{
								c = 0;
							}
						}
						break;
					default:System.out.println("Invalid Option Entered");
					}
					System.out.println("Would You Browse All Sets Again? (yes/no)");
					a = in.next();
					if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
						i = 1;
					}
					else{
						i = 0;
					}
				}
				break;



			case 4:	//Apply Restrictions To Search
				c = 1;
				while(c==1){
					System.out.println("Apply Restrictions By:");
					System.out.println("1: Age");
					System.out.println("2: #Bricks");
					System.out.println("3: Price");
					System.out.println("4: #Minifigures");
					System.out.println("5: Reset Restrictions");
					x = in.nextInt();

					if(x==1){
						c = 1;
						while(c==1){
							System.out.println("Enter Age Range:");
							System.out.println("Minimum Age:");
							x1 = in.nextInt();
							//Age Range Method (AgeRange(x,y))
							System.out.println("Would You Like To Change Age Restrictions Again? (yes/no)");
							a = in.next();
							if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
								c = 1;
							}
							else{
								c = 0;
							}
						}
					}
					else if(x==2){
						c = 1;
						while(c==1){
							System.out.println("Enter #Brick Range:");
							System.out.println("Minimum #Brick:");
							xx = in.nextInt();
							System.out.println("Maximum #Brick:");
							yy = in.nextInt();
							//#Brick Range Method (BrickRange(x,y))
							System.out.println("Would You Like To Change Brick Range Again? (yes/no)");
							a = in.next();
							if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
								c = 1;
							}
							else{
								c = 0;
							}
						}
					}
					else if(x==3){
						c = 1;
						while(c==1){
							System.out.println("Enter Price Range:");
							System.out.println("Minimum Price:");
							xxx = in.nextDouble();
							System.out.println("Maximum Price:");
							yyy = in.nextDouble();
							//Price Range Method (PriceRange(x,y))
							System.out.println("Would You Like To Change Price Range Again? (yes/no)");
							a = in.next();
							if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
								c = 1;
							}
							else{
								c = 0;
							}
						}
					}
					else if(x==4){
						c = 1;
						while(c==1){
							System.out.println("Enter #Minifigures Range:");
							System.out.println("Minimum #Minifigures:");
							xxxx = in.nextInt();
							System.out.println("Maximum #Minifigures:");
							yyyy = in.nextInt();
							//#Minifigures Range Method (MinfiguresRange(x,y))
							System.out.println("Would You Like To Change Minifigures Range Again? (yes/no)");
							a = in.next();
							if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
								c = 1;
							}
							else{
								c = 0;
							}
						}
					}
					else if(x==5){
						c = 1;
						while(c==1){
							System.out.println("Reset Restrictions For:");
							System.out.println("1: Age");
							System.out.println("2: #Bricks");
							System.out.println("3: Price");
							System.out.println("4: #Minifigures");
							System.out.println("5: Reset All Restrictions");
							x = in.nextInt();
							if(x==1){			//reset age restrictions
								x1=0;
							}
							else if(x==2){		//reset Bricks restriction
								xx=0;
								yy=100000;
							}
							else if(x==3){		//reset price restrictions
								xxx=0;
								yyy=100000;
							}
							else if(x==4){		//reset minifigures restrictions
								xxxx=0;
								yyyy=100000;
							}
							else if(x==5){		//reset all restrictions
								x1=0;
								xx=0;
								yy=100000;
								xxx=0;
								yyy=100000;
								xxxx=0;
								yyyy=100000;
							}
							else{
								System.out.println("Invalid Option Entered");
							}
							System.out.println("Would You Like To Reset Restrictions Again? (yes/no)");
							a = in.next();
							if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
								c = 1;
							}
							else{
								c = 0;
							}
						}
					}
					else{
						System.out.println("Invalid Option Entered");
					}
					System.out.println("Would You Like To Apply Search Restrictions Again? (yes/no)");
					a = in.next();
					if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
						c = 1;
					}
					else{
						c = 0;
					}
				}
				break;

			case 5: 	//Apply Discounts
				//Applies General Discount To All Prices Method
				System.out.println("1: Apply Discounts");
				System.out.println("2: Reset Discounts");
				x = in.nextInt();
				double percent=0;
				if(x==1){
					System.out.println("\nEnter Discount Percentage %:");
					percent=in.nextDouble();
					if(percent>100||percent<0){
						System.out.println("Invalid Discount Amount");
						percent = 0;
					}
					l.discount(percent); 		//Discount Method: discount(percent)
					System.out.println("\nYou May Now Browse With Applied Discounts!\n");
				}
				else if(x==2){
					System.out.println("\nResetting Discounts..");
					l.create(i);	//reset
					System.out.println("\nDiscounts Reset!\n");
				}
				else{
					System.out.println("\nInvalid Option\n");
				}
				break;

			case 6:
				i=1;
				while(i==1){
					//Search Theme Name Method
					System.out.println("Sort Sets:");
					System.out.println("Option 1: Alphabetically");
					System.out.println("Option 2: By Set Number");
					System.out.println("Option 3: By Costs And Quantities");
					InnerOption = in.nextInt();
					switch(InnerOption){
					case 1://Sort Alphabetically
						c = 1;
						while(c==1){
							System.out.println("Choose:");
							System.out.println("1: A-->Z");
							System.out.println("2: Z-->A");
							x = in.nextInt();
							if(x==1){
								l.sortalphabetatoz();		//sort a to z method
								l.printlist(form,x1,xx,xxx,xxxx,yy,yyy,yyyy);			//print for chosen theme
							}
							else if(x==2){
								l.sortalphabetztoa();		//sort z to a method
								l.printlist(form,x1,xx,xxx,xxxx,yy,yyy,yyyy);			//print for chosen theme
							}
							else{
								System.out.println("Invalid Option Entered");
							}
							System.out.println("Would You Like To Sort Alphabetically Again? (yes/no)");
							a = in.next();
							if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
								c = 1;
							}
							else{
								c = 0;
							}
						}
						break;
					case 2://Sort By Set Number
						c = 1;
						while(c==1){
							System.out.println("Choose:");
							System.out.println("1: Set #000000 to Set #999999");
							System.out.println("2: Set #999999 to Set #000000");
							x = in.nextInt();
							if(x==1){
								l.sortbysetnumlowtohigh();		//Sort Sets Ascending Order Method
								l.printlist(form,x1,xx,xxx,xxxx,yy,yyy,yyyy);				//print for chosen theme
							}
							else if(x==2){
								l.sortbysetnumhightolow();		//Sort Sets Descending Order Method
								l.printlist(form,x1,xx,xxx,xxxx,yy,yyy,yyyy);				//print for chosen theme
							}
							else{
								System.out.println("Invalid Option Entered");
							}
							System.out.println("Would You Like To Sort By Set Number Again? (yes/no)");
							a = in.next();
							if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
								c = 1;
							}
							else{
								c = 0;
							}
						}
						break;
					case 3://Cost
						c = 1;
						while(c==1){
							System.out.println("Choose:");
							System.out.println("1: Cost Of Sets");
							System.out.println("2: Number Of Bricks");
							System.out.println("3: Average Cost Per Brick");
							System.out.println("4: Number Of Minifigures");
							System.out.println("5: Average Cost Per Minifigure");
							System.out.println("6: Age Range");
							InnerInnerOption = in.nextInt();
							switch(InnerInnerOption){
							case 1://Cost Of Sets
								c = 1;
								while(c==1){
									System.out.println("Choose:");
									System.out.println("1: Low To High");
									System.out.println("2: High To Low");
									x = in.nextInt();
									if(x==1){
										l.sortbycostlowtohigh();		//sort low to high
										l.printlist(form,x1,xx,xxx,xxxx,yy,yyy,yyyy);				//print only for desired theme
									}
									else if(x==2){
										l.sortbycosthightolow();		//sort high to low
										l.printlist(form,x1,xx,xxx,xxxx,yy,yyy,yyyy);				//print only for desired theme
									}
									else{
										System.out.println("Invalid Option Entered");
									}
									System.out.println("Would You Like To Sort By Cost Of Sets Again? (yes/no)");
									a = in.next();
									if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
										c = 1;
									}
									else{
										c = 0;
									}
								}
								break;
							case 2://Number Of Bricks
								c = 1;
								while(c==1){
									System.out.println("Choose:");
									System.out.println("1: Low To High");
									System.out.println("2: High To Low");
									x = in.nextInt();
									if(x==1){
										l.numofbrickslowtohigh();		//sort low to high
										l.printlist(form,x1,xx,xxx,xxxx,yy,yyy,yyyy);				//print only for desired theme
									}
									else if(x==2){
										l.numofbrickshightolow();		//sort high to low
										l.printlist(form,x1,xx,xxx,xxxx,yy,yyy,yyyy);				//print only for desired theme
									}
									else{
										System.out.println("Invalid Option Entered");
									}
									System.out.println("Would You Like To Sort By # Of Bricks Again? (yes/no)");
									a = in.next();
									if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
										c = 1;
									}
									else{
										c = 0;
									}
								}
								break;
							case 3://Average Cost Per Brick
								c = 1;
								while(c==1){
									System.out.println("Choose:");
									System.out.println("1: Low To High");//Within Sets of Theme
									System.out.println("2: High To Low");//Within Sets Of Theme
									x = in.nextInt();
									if(x==1){
										l.costperbrickslowtohigh();		//Sort Low To High Method Of Avg. Price Per Brick Method
										l.printlist(form,x1,xx,xxx,xxxx,yy,yyy,yyyy);				//Print Method
									}
									else if(x==2){
										l.costperbrickshightolow();		//Sort Low To High Method Of Avg. Price Per Brick Method
										l.printlist(form,x1,xx,xxx,xxxx,yy,yyy,yyyy);				//Print Method
									}
									else{
										System.out.println("Invalid Option Entered");
									}
									System.out.println("Would You Like To Sort By Average Cost Per Bricks Again? (yes/no)");
									a = in.next();
									if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
										c = 1;
									}
									else{
										c = 0;
									}
								}
								break;
							case 4://Number Of Minifigures
								c = 1;
								while(c==1){
									System.out.println("Choose:");
									System.out.println("1: Low To High");
									System.out.println("2: High To Low");
									x = in.nextInt();
									if(x==1){
										l.sortbyminifigslowtohigh();		//sort low to high
										l.printlist(form,x1,xx,xxx,xxxx,yy,yyy,yyyy);				//print only for desired theme
									}
									else if(x==2){
										l.sortbyminifigshightolow();		//sort low to high
										l.printlist(form,x1,xx,xxx,xxxx,yy,yyy,yyyy);				//print only for desired theme
									}
									else{
										System.out.println("Invalid Option Entered");
									}
									System.out.println("Would You Like To Sort By # Of Minifigures Again? (yes/no)");
									a = in.next();
									if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
										c = 1;
									}
									else{
										c = 0;
									}
								}
								break;
							case 5://Average Cost Per Minifigure
								c = 1;
								while(c==1){
									System.out.println("CHoose:");
									System.out.println("1: Low To High");//Within Sets of Theme
									System.out.println("2: High To Low");//Within Sets Of Theme
									x = in.nextInt();
									if(x==1){
										l.sortbycostperminifiglowtohigh();	//Sort Low To High Method Of Avg. Price Per Minifigure Method
										l.printlist(form,x1,xx,xxx,xxxx,yy,yyy,yyyy);					//Print Method
									}
									else if(x==2){
										l.sortbycostperminifighightolow();	//Sort Low To High Method Of Avg. Price Per Minifigure Method
										l.printlist(form,x1,xx,xxx,xxxx,yy,yyy,yyyy);					//Print Method
									}
									else{
										System.out.println("Invalid Option Entered");
									}
									System.out.println("Would You Like To Sort By Average Cost Per Minifigure Again? (yes/no)");
									a = in.next();
									if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
										c = 1;
									}
									else{
										c = 0;
									}
								}
								break;
							case 6://Age Range
								c = 1;
								while(c==1){
									System.out.println("View Recommended Ages Within Sets of Theme:");
									System.out.println("1: Low To High");//Within Sets of Theme
									System.out.println("2: High To Low");//Within Sets Of Theme
									x = in.nextInt();
									if(x==1){
										l.minagelowtohigh(); 									//Sort Low To High Method Of Min. Age Method
										l.printlist(form, x1, xx, xxx, xxxx, yy, yyy, yyyy); 	//Print Method
									}
									else if(x==2){
										l.minagehightolow(); 									//Sort High to Low Method of Min. Age Method
										l.printlist(form, x1, xx, xxx, xxxx, yy, yyy, yyyy); 	//Print Method
									}
									else{
										System.out.println("Invalid Option Entered");
									}
									System.out.println("Would You Like To Sort By Age Level Again? (yes/no)");
									a = in.next();
									if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
										c = 1;
									}
									else{
										c = 0;
									}
								}
								break;
							default:System.out.println("Invalid Option Entered");
							}
							System.out.println("Would You Like To Sort By Costs And Quantities Again? (yes/no)");
							a = in.next();
							if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
								c = 1;
							}
							else{
								c = 0;
							}
						}
						break;
					default:System.out.println("Invalid Option Entered");
					}
					System.out.println("Would You Like To Sort All Sets Again? (yes/no)");
					a = in.next();
					if(a.equals("yes")||a.equals("Yes")||a.equals("y")||a.equals("Y")){
						i = 1;
					}
					else{
						i = 0;
					}
				}
				//l.printlist(form);
				break;
			case 7: 	//Exit Program
				check = false;

				break;
			default:System.out.println("Invalid Option Entered");
			}
		}
	}
}
