import java.io.*;

public class legolist{
	private legoset head;
	class legoset{
		protected int setnum;
		protected String theme;
		protected String setname;
		protected int pcs;
		protected int minifigs;
		protected int age;
		protected double price;
		protected legoset link;

		legoset(int s, String t, String sn, int p, int mf, int a, double $){
			setnum = s;
			theme= t;
			setname = sn;
			pcs = p;
			minifigs = mf;
			age = a;
			price = $;
			link = null;
		}
	}
	public void create(int lines) throws IOException{
		//		FileReader fr = new FileReader("E:\\Grade 12\\(3)Chen\\.LEGO PROJECT\\combined database.txt");
		FileReader fr = new FileReader(".\combined-database.txt");
		BufferedReader br = new BufferedReader(fr);
		int s;
		String t;
		String sn;
		int p;
		int mf;
		int a;
		double $;
		for(int c=1;c<=(lines/7);c++){
			s = Integer.parseInt(br.readLine());
			t= br.readLine();
			sn = br.readLine();
			p = Integer.parseInt(br.readLine());
			mf = Integer.parseInt(br.readLine());
			a = Integer.parseInt(br.readLine());
			$ = Double.parseDouble(br.readLine());
			legoset current = head;   // current points to the current Node
			legoset previous = null;    // previous points to the previous Node
			while (current!= null){
				previous = current;    // moves along the list
				current = current.link;
			}
			legoset newNode = new legoset(s,t,sn,p,mf,a,$);
			// creates a new Node with item as info and points to �current�
			if (current == head){
				head = newNode;
			}// if new Node was inserted into an empty list
			else{
				previous.link = newNode;
			}
		}
		br.close();
	}
	public String[] getthemes(int lines){
		String[] themes = new String[(lines/7)];
		legoset temp = head;
		for(int c=0; c<themes.length;c++){
			themes[c]=temp.theme;
			temp=temp.link;
		}
		String t="";
		int compare =0;
		boolean swap;
		do{
			swap = false;
			for(int c=0;c<themes.length-1;c++){
				compare = themes[c].compareTo(themes[c+1]);
				if (compare < 0)
				{
					//dont swap
				}
				else
				{
					if (compare > 0){
						t=themes[c];
						themes[c]=themes[c+1];
						themes[c+1]=t;
						swap = true;
					}else
					{
						//dont swap
					}
				}
			}
		}while(swap == true);
		int numu=0;		//number of unique themes
		for(int c=1;c<themes.length;c++){
			//System.out.println(themes[c-1]);		tag line
			if(themes[c].equals(themes[c-1])){
				//dont add to count
			}
			else{
				numu++;
			}
		}
		numu++;
		//System.out.println(numu);           tag line
		String[] unique = new String[numu];
		int x=0;
		for(int c=1;c<themes.length;c++){
			if(themes[c].equals(themes[c-1])){
				//dont add to array of unique
			}
			else{
				unique[x]=themes[c-1];
				x++;
			}
		}
		unique[unique.length-1]=themes[themes.length-1];
		return unique;
	}
	public void sortbysetnumlowtohigh(){
		boolean swap=false;
		int s;
		String t;
		String sn;
		int p;
		int mf;
		int a;
		double $;
		do{
			swap = false;
			for(legoset temp = head;temp.link!=null;temp=temp.link){
				if((temp.setnum>temp.link.setnum)){
					s = temp.setnum;
					t = temp.theme;
					sn = temp.setname;
					p = temp.pcs;
					mf = temp.minifigs;
					a = temp.age;
					$ = temp.price;

					temp.setnum=temp.link.setnum;
					temp.theme=temp.link.theme;
					temp.setname=temp.link.setname;
					temp.pcs=temp.link.pcs;
					temp.minifigs=temp.link.minifigs;
					temp.age=temp.link.age;
					temp.price=temp.link.price;

					temp.link.setnum = s;
					temp.link.theme = t;
					temp.link.setname = sn;
					temp.link.pcs = p;
					temp.link.minifigs = mf;
					temp.link.age = a;
					temp.link.price = $;

					swap = true;
				}
			}
		}while(swap==true);
	}
	public void sortbysetnumhightolow(){
		boolean swap=false;
		int s;
		String t;
		String sn;
		int p;
		int mf;
		int a;
		double $;
		do{
			swap = false;
			for(legoset temp = head;temp.link!=null;temp=temp.link){
				if((temp.setnum<temp.link.setnum)){
					s = temp.setnum;
					t = temp.theme;
					sn = temp.setname;
					p = temp.pcs;
					mf = temp.minifigs;
					a = temp.age;
					$ = temp.price;

					temp.setnum=temp.link.setnum;
					temp.theme=temp.link.theme;
					temp.setname=temp.link.setname;
					temp.pcs=temp.link.pcs;
					temp.minifigs=temp.link.minifigs;
					temp.age=temp.link.age;
					temp.price=temp.link.price;

					temp.link.setnum = s;
					temp.link.theme = t;
					temp.link.setname = sn;
					temp.link.pcs = p;
					temp.link.minifigs = mf;
					temp.link.age = a;
					temp.link.price = $;

					swap = true;
				}
			}
		}while(swap==true);
	}
	public void sortbycostlowtohigh(){
		boolean swap=false;
		int s;
		String t;
		String sn;
		int p;
		int mf;
		int a;
		double $;
		do{
			swap = false;
			for(legoset temp = head;temp.link!=null;temp=temp.link){
				if((temp.price>temp.link.price)){
					s = temp.setnum;
					t = temp.theme;
					sn = temp.setname;
					p = temp.pcs;
					mf = temp.minifigs;
					a = temp.age;
					$ = temp.price;

					temp.setnum=temp.link.setnum;
					temp.theme=temp.link.theme;
					temp.setname=temp.link.setname;
					temp.pcs=temp.link.pcs;
					temp.minifigs=temp.link.minifigs;
					temp.age=temp.link.age;
					temp.price=temp.link.price;

					temp.link.setnum = s;
					temp.link.theme = t;
					temp.link.setname = sn;
					temp.link.pcs = p;
					temp.link.minifigs = mf;
					temp.link.age = a;
					temp.link.price = $;

					swap = true;
				}
			}
		}while(swap==true);
	}
	public void sortbycosthightolow(){
		boolean swap=false;
		int s;
		String t;
		String sn;
		int p;
		int mf;
		int a;
		double $;
		do{
			swap = false;
			for(legoset temp = head;temp.link!=null;temp=temp.link){
				if((temp.price<temp.link.price)){
					s = temp.setnum;
					t = temp.theme;
					sn = temp.setname;
					p = temp.pcs;
					mf = temp.minifigs;
					a = temp.age;
					$ = temp.price;

					temp.setnum=temp.link.setnum;
					temp.theme=temp.link.theme;
					temp.setname=temp.link.setname;
					temp.pcs=temp.link.pcs;
					temp.minifigs=temp.link.minifigs;
					temp.age=temp.link.age;
					temp.price=temp.link.price;

					temp.link.setnum = s;
					temp.link.theme = t;
					temp.link.setname = sn;
					temp.link.pcs = p;
					temp.link.minifigs = mf;
					temp.link.age = a;
					temp.link.price = $;

					swap = true;
				}
			}
		}while(swap==true);
	}


	public void sortbyminifigshightolow(){
		boolean swap=false;
		int s;
		String t;
		String sn;
		int p;
		int mf;
		int a;
		double $;
		do{
			swap = false;
			for(legoset temp = head;temp.link!=null;temp=temp.link){
				if(((temp.minifigs)<(temp.link.minifigs))){
					s = temp.setnum;
					t = temp.theme;
					sn = temp.setname;
					p = temp.pcs;
					mf = temp.minifigs;
					a = temp.age;
					$ = temp.price;

					temp.setnum=temp.link.setnum;
					temp.theme=temp.link.theme;
					temp.setname=temp.link.setname;
					temp.pcs=temp.link.pcs;
					temp.minifigs=temp.link.minifigs;
					temp.age=temp.link.age;
					temp.price=temp.link.price;

					temp.link.setnum = s;
					temp.link.theme = t;
					temp.link.setname = sn;
					temp.link.pcs = p;
					temp.link.minifigs = mf;
					temp.link.age = a;
					temp.link.price = $;

					swap = true;
				}
			}
		}while(swap==true);
	}
	public void sortbyminifigslowtohigh(){
		boolean swap=false;
		int s;
		String t;
		String sn;
		int p;
		int mf;
		int a;
		double $;
		do{
			swap = false;
			for(legoset temp = head;temp.link!=null;temp=temp.link){
				if(((temp.minifigs)>(temp.link.minifigs))){
					s = temp.setnum;
					t = temp.theme;
					sn = temp.setname;
					p = temp.pcs;
					mf = temp.minifigs;
					a = temp.age;
					$ = temp.price;

					temp.setnum=temp.link.setnum;
					temp.theme=temp.link.theme;
					temp.setname=temp.link.setname;
					temp.pcs=temp.link.pcs;
					temp.minifigs=temp.link.minifigs;
					temp.age=temp.link.age;
					temp.price=temp.link.price;

					temp.link.setnum = s;
					temp.link.theme = t;
					temp.link.setname = sn;
					temp.link.pcs = p;
					temp.link.minifigs = mf;
					temp.link.age = a;
					temp.link.price = $;

					swap = true;
				}
			}
		}while(swap==true);
	}
	public void sortbycostperminifiglowtohigh(){
		boolean swap=false;
		int s;
		String t;
		String sn;
		int p;
		int mf;
		int a;
		double $;
		do{
			swap = false;
			for(legoset temp = head;temp.link!=null;temp=temp.link){
				if((temp.link.minifigs==0)&&(temp.minifigs>0)){
					s = temp.setnum;
					t = temp.theme;
					sn = temp.setname;
					p = temp.pcs;
					mf = temp.minifigs;
					a = temp.age;
					$ = temp.price;

					temp.setnum=temp.link.setnum;
					temp.theme=temp.link.theme;
					temp.setname=temp.link.setname;
					temp.pcs=temp.link.pcs;
					temp.minifigs=temp.link.minifigs;
					temp.age=temp.link.age;
					temp.price=temp.link.price;

					temp.link.setnum = s;
					temp.link.theme = t;
					temp.link.setname = sn;
					temp.link.pcs = p;
					temp.link.minifigs = mf;
					temp.link.age = a;
					temp.link.price = $;

					swap = true;
				}
				else if((temp.price/temp.minifigs)>(temp.link.price/temp.minifigs)){
					s = temp.setnum;
					t = temp.theme;
					sn = temp.setname;
					p = temp.pcs;
					mf = temp.minifigs;
					a = temp.age;
					$ = temp.price;

					temp.setnum=temp.link.setnum;
					temp.theme=temp.link.theme;
					temp.setname=temp.link.setname;
					temp.pcs=temp.link.pcs;
					temp.minifigs=temp.link.minifigs;
					temp.age=temp.link.age;
					temp.price=temp.link.price;

					temp.link.setnum = s;
					temp.link.theme = t;
					temp.link.setname = sn;
					temp.link.pcs = p;
					temp.link.minifigs = mf;
					temp.link.age = a;
					temp.link.price = $;

					swap = true;
				}
			}
		}while(swap==true);
	}
	public void sortbycostperminifighightolow(){
		boolean swap=false;
		int s;
		String t;
		String sn;
		int p;
		int mf;
		int a;
		double $;
		do{
			swap = false;
			for(legoset temp = head;temp.link!=null;temp=temp.link){
				if((temp.link.minifigs>0)&&(temp.minifigs==0)){
					s = temp.setnum;
					t = temp.theme;
					sn = temp.setname;
					p = temp.pcs;
					mf = temp.minifigs;
					a = temp.age;
					$ = temp.price;

					temp.setnum=temp.link.setnum;
					temp.theme=temp.link.theme;
					temp.setname=temp.link.setname;
					temp.pcs=temp.link.pcs;
					temp.minifigs=temp.link.minifigs;
					temp.age=temp.link.age;
					temp.price=temp.link.price;

					temp.link.setnum = s;
					temp.link.theme = t;
					temp.link.setname = sn;
					temp.link.pcs = p;
					temp.link.minifigs = mf;
					temp.link.age = a;
					temp.link.price = $;

					swap = true;
				}
				if((temp.price/temp.minifigs)<(temp.link.price/temp.minifigs)){
					s = temp.setnum;
					t = temp.theme;
					sn = temp.setname;
					p = temp.pcs;
					mf = temp.minifigs;
					a = temp.age;
					$ = temp.price;

					temp.setnum=temp.link.setnum;
					temp.theme=temp.link.theme;
					temp.setname=temp.link.setname;
					temp.pcs=temp.link.pcs;
					temp.minifigs=temp.link.minifigs;
					temp.age=temp.link.age;
					temp.price=temp.link.price;

					temp.link.setnum = s;
					temp.link.theme = t;
					temp.link.setname = sn;
					temp.link.pcs = p;
					temp.link.minifigs = mf;
					temp.link.age = a;
					temp.link.price = $;

					swap = true;
				}
			}
		}while(swap==true);
	}

	public void numofbrickslowtohigh(){
		boolean swap=false;
		int s;
		String t;
		String sn;
		int p;
		int mf;
		int a;
		double $;
		do{
			swap = false;
			for(legoset temp = head;temp.link!=null;temp=temp.link){
				if((temp.pcs>temp.link.pcs)){
					s = temp.setnum;
					t = temp.theme;
					sn = temp.setname;
					p = temp.pcs;
					mf = temp.minifigs;
					a = temp.age;
					$ = temp.price;

					temp.setnum=temp.link.setnum;
					temp.theme=temp.link.theme;
					temp.setname=temp.link.setname;
					temp.pcs=temp.link.pcs;
					temp.minifigs=temp.link.minifigs;
					temp.age=temp.link.age;
					temp.price=temp.link.price;

					temp.link.setnum = s;
					temp.link.theme = t;
					temp.link.setname = sn;
					temp.link.pcs = p;
					temp.link.minifigs = mf;
					temp.link.age = a;
					temp.link.price = $;

					swap = true;
				}
			}
		}while(swap==true);
	}
	public void numofbrickshightolow(){
		boolean swap=false;
		int s;
		String t;
		String sn;
		int p;
		int mf;
		int a;
		double $;
		do{
			swap = false;
			for(legoset temp = head;temp.link!=null;temp=temp.link){
				if((temp.pcs<temp.link.pcs)){
					s = temp.setnum;
					t = temp.theme;
					sn = temp.setname;
					p = temp.pcs;
					mf = temp.minifigs;
					a = temp.age;
					$ = temp.price;

					temp.setnum=temp.link.setnum;
					temp.theme=temp.link.theme;
					temp.setname=temp.link.setname;
					temp.pcs=temp.link.pcs;
					temp.minifigs=temp.link.minifigs;
					temp.age=temp.link.age;
					temp.price=temp.link.price;

					temp.link.setnum = s;
					temp.link.theme = t;
					temp.link.setname = sn;
					temp.link.pcs = p;
					temp.link.minifigs = mf;
					temp.link.age = a;
					temp.link.price = $;

					swap = true;
				}
			}
		}while(swap==true);
	}
	public void costperbrickslowtohigh(){
		boolean swap=false;
		int s;
		String t;
		String sn;
		int p;
		int mf;
		int a;
		double $;
		do{
			swap = false;
			for(legoset temp = head;temp.link!=null;temp=temp.link){
				if((temp.price/temp.pcs)>(temp.link.price/temp.link.pcs)){
					s = temp.setnum;
					t = temp.theme;
					sn = temp.setname;
					p = temp.pcs;
					mf = temp.minifigs;
					a = temp.age;
					$ = temp.price;

					temp.setnum=temp.link.setnum;
					temp.theme=temp.link.theme;
					temp.setname=temp.link.setname;
					temp.pcs=temp.link.pcs;
					temp.minifigs=temp.link.minifigs;
					temp.age=temp.link.age;
					temp.price=temp.link.price;

					temp.link.setnum = s;
					temp.link.theme = t;
					temp.link.setname = sn;
					temp.link.pcs = p;
					temp.link.minifigs = mf;
					temp.link.age = a;
					temp.link.price = $;

					swap = true;
				}
			}
		}while(swap==true);
	}
	public void costperbrickshightolow(){
		boolean swap=false;
		int s;
		String t;
		String sn;
		int p;
		int mf;
		int a;
		double $;
		do{
			swap = false;
			for(legoset temp = head;temp.link!=null;temp=temp.link){
				if((temp.price/temp.pcs)<(temp.link.price/temp.link.pcs)){
					s = temp.setnum;
					t = temp.theme;
					sn = temp.setname;
					p = temp.pcs;
					mf = temp.minifigs;
					a = temp.age;
					$ = temp.price;

					temp.setnum=temp.link.setnum;
					temp.theme=temp.link.theme;
					temp.setname=temp.link.setname;
					temp.pcs=temp.link.pcs;
					temp.minifigs=temp.link.minifigs;
					temp.age=temp.link.age;
					temp.price=temp.link.price;

					temp.link.setnum = s;
					temp.link.theme = t;
					temp.link.setname = sn;
					temp.link.pcs = p;
					temp.link.minifigs = mf;
					temp.link.age = a;
					temp.link.price = $;

					swap = true;
				}
			}
		}while(swap==true);
	}
	public void minagelowtohigh(){
		boolean swap=false;
		int s;
		String t;
		String sn;
		int p;
		int mf;
		int a;
		double $;
		do{
			swap = false;
			for(legoset temp = head;temp.link!=null;temp=temp.link){
				if((temp.age>temp.link.age)){
					s = temp.setnum;
					t = temp.theme;
					sn = temp.setname;
					p = temp.pcs;
					mf = temp.minifigs;
					a = temp.age;
					$ = temp.price;

					temp.setnum=temp.link.setnum;
					temp.theme=temp.link.theme;
					temp.setname=temp.link.setname;
					temp.pcs=temp.link.pcs;
					temp.minifigs=temp.link.minifigs;
					temp.age=temp.link.age;
					temp.price=temp.link.price;

					temp.link.setnum = s;
					temp.link.theme = t;
					temp.link.setname = sn;
					temp.link.pcs = p;
					temp.link.minifigs = mf;
					temp.link.age = a;
					temp.link.price = $;

					swap = true;
				}
			}
		}while(swap==true);
	}

	public void discount(double x){
		double z=x;
		z=1-(z/100);
		for(legoset temp=head;temp!=null;temp=temp.link){
			temp.price=temp.price*z;
			temp.price=Math.round(temp.price*100.0)/100.0;
		}
	}

	public void minagehightolow(){
		boolean swap=false;
		int s;
		String t;
		String sn;
		int p;
		int mf;
		int a;
		double $;
		do{
			swap = false;
			for(legoset temp = head;temp.link!=null;temp=temp.link){
				if((temp.age>temp.link.age)){
					s = temp.setnum;
					t = temp.theme;
					sn = temp.setname;
					p = temp.pcs;
					mf = temp.minifigs;
					a = temp.age;
					$ = temp.price;

					temp.setnum=temp.link.setnum;
					temp.theme=temp.link.theme;
					temp.setname=temp.link.setname;
					temp.pcs=temp.link.pcs;
					temp.minifigs=temp.link.minifigs;
					temp.age=temp.link.age;
					temp.price=temp.link.price;

					temp.link.setnum = s;
					temp.link.theme = t;
					temp.link.setname = sn;
					temp.link.pcs = p;
					temp.link.minifigs = mf;
					temp.link.age = a;
					temp.link.price = $;

					swap = true;
				}
			}
		}while(swap==true);
	}
	public double costperbricktheme(String x){
		int count=0;
		double tot=0;
		for(legoset temp = head;temp.link!=null;temp=temp.link){
			if(temp.theme.equals(x)){
				tot=tot+(temp.price/temp.pcs);
				count++;
			}
		}
		return(tot/count);
	}
	public double costperminifigtheme(String x){
		int count=0;
		double tot=0;
		for(legoset temp = head;temp.link!=null;temp=temp.link){
			if(temp.minifigs==0){
				//cannot divide by zero
			}
			else if(temp.theme.equals(x)){
				tot=tot+(temp.price/temp.minifigs);
				count++;
			}
		}
		return(tot/count);
	}
	public double averageminage(String x){
		int count=0;
		double tot=0;
		for(legoset temp = head;temp.link!=null;temp=temp.link){
			if(temp.theme.equals(x)){
				tot=tot+(temp.age);
				count++;
			}
		}
		return(tot/count);
	}

	public double cheapthemebycost(String[] themes){
		int[] totsets = new int[themes.length];
		double[] totcost = new double[themes.length];
		for(legoset temp = head;temp!=null;temp=temp.link){
			for(int c=0;c<themes.length;c++){
				if (temp.theme.equals(themes[c])){
					totcost[c]=totcost[c]+temp.price;
					totsets[c]=totsets[c]+1;
				}
			}
		}
		double cheapest = 500000;
		String cheap="";
		for(int c=0;c<themes.length;c++){
			if ((totcost[c]/totsets[c])<cheapest){
				cheapest = totcost[c]/totsets[c];
				cheap = themes[c];
			}
		}

		System.out.println("Cheapest Theme By Average Cost Per Set: "+cheap);
		cheapest = Math.round(cheapest*100.0)/100.0;
		return cheapest;
	}
	public double expensivethemebycost(String[] themes){
		int[] totsets = new int[themes.length];
		double[] totcost = new double[themes.length];
		for(legoset temp = head;temp!=null;temp=temp.link){
			for(int c=0;c<themes.length;c++){
				if (temp.theme.equals(themes[c])){
					totcost[c]=totcost[c]+temp.price;
					totsets[c]=totsets[c]+1;
				}
			}
		}
		double costly = 0;
		String cost="";
		for(int c=0;c<themes.length;c++){
			if ((totcost[c]/totsets[c])>costly){
				costly = totcost[c]/totsets[c];
				cost = themes[c];
			}
		}

		System.out.println("Most Expensive Theme By Average Cost Per Set: "+cost);
		costly = Math.round(costly*100.0)/100.0;
		return costly;
	}

	public double cheapthemebybrick(String[] themes){
		int[] totbricks = new int[themes.length];
		double[] totcost = new double[themes.length];
		for(legoset temp = head;temp!=null;temp=temp.link){
			for(int c=0;c<themes.length;c++){
				if (temp.theme.equals(themes[c])){
					totcost[c]=totcost[c]+temp.price;
					totbricks[c]=totbricks[c]+temp.pcs;
				}
			}
		}
		double cheapest = 500000;
		String cheap="";
		for(int c=0;c<themes.length;c++){
			if ((totcost[c]/totbricks[c])<cheapest){
				cheapest = totcost[c]/totbricks[c];
				cheap = themes[c];
			}
		}

		System.out.println("Cheapest Theme By Average Cost Per Brick: "+cheap);
		cheapest = Math.round(cheapest*100.0)/100.0;
		return cheapest;
	}
	public double expensivethemebybrick(String[] themes){
		int[] totbricks = new int[themes.length];
		double[] totcost = new double[themes.length];
		for(legoset temp = head;temp!=null;temp=temp.link){
			for(int c=0;c<themes.length;c++){
				if (temp.theme.equals(themes[c])){
					totcost[c]=totcost[c]+temp.price;
					totbricks[c]=totbricks[c]+temp.pcs;
				}
			}
		}
		double costly = 0;
		String cost="";
		for(int c=0;c<themes.length;c++){
			if ((totcost[c]/totbricks[c])>costly){
				costly = totcost[c]/totbricks[c];
				cost = themes[c];
			}
		}

		System.out.println("Most Expensive Theme By Average Cost Per Brick: "+cost);
		costly = Math.round(costly*100.0)/100.0;
		return costly;
	}
	public double cheapthemebymf(String[] themes){
		int[] totmf = new int[themes.length];
		double[] totcost = new double[themes.length];
		for(legoset temp = head;temp!=null;temp=temp.link){
			for(int c=0;c<themes.length;c++){
				if (temp.theme.equals(themes[c])){
					totcost[c]=totcost[c]+temp.price;
					totmf[c]=totmf[c]+temp.minifigs;
				}
			}
		}
		double cheapest = 500000;
		String cheap="";
		for(int c=0;c<themes.length;c++){
			if(totmf[c]==0){
				//cannot divide by zero
			}
			else if ((totcost[c]/totmf[c])<cheapest){
				cheapest = totcost[c]/totmf[c];
				cheap = themes[c];
			}
		}

		System.out.println("Cheapest Theme By Average Cost Per Mini-Figure: "+cheap);
		cheapest = Math.round(cheapest*100.0)/100.0;
		return cheapest;
	}

	public double expensivethemebymf(String[] themes){
		int[] totmf = new int[themes.length];
		double[] totcost = new double[themes.length];
		for(legoset temp = head;temp!=null;temp=temp.link){
			for(int c=0;c<themes.length;c++){
				if (temp.theme.equals(themes[c])){
					totcost[c]=totcost[c]+temp.price;
					totmf[c]=totmf[c]+temp.minifigs;
				}
			}
		}
		double costly = 0;
		String cost="";
		for(int c=0;c<themes.length;c++){
			if(totmf[c]==0){
				//cannot divide by zero
			}
			else if ((totcost[c]/totmf[c])>costly){
				costly = totcost[c]/totmf[c];
				cost = themes[c];
			}
		}

		System.out.println("Most Expensive Theme By Average Cost Per Mini-Figure: "+cost);
		costly = Math.round(costly*100.0)/100.0;
		return costly;
	}
	public double cheapsetbycost(){
		double cheap = 1000000;
		String cheapest="";
		int num = 0;
		for(legoset temp = head;temp!=null;temp=temp.link){
			if (temp.price<cheap){
				cheap = temp.price;
				cheapest = temp.setname;
				num = temp.setnum;
			}
		}
		System.out.println("Cheapest Set By Cost: "+num+"  |  "+cheapest);
		return cheap;
	}
	public double costlysetbycost(){
		double cost = 0;
		String costly="";
		int num = 0;
		for(legoset temp = head;temp!=null;temp=temp.link){
			if (temp.price>cost){
				cost = temp.price;
				costly = temp.setname;
				num = temp.setnum;
			}
		}
		System.out.println("Most Expensive Set By Cost: "+num+"  |  "+costly);
		return cost;
	}

	public double cheapsetbybricks(){
		double cheap = 1000000;
		String cheapest="";
		int num = 0;
		for(legoset temp = head;temp!=null;temp=temp.link){
			if ((temp.price/temp.pcs)<cheap){
				cheap = temp.price/temp.pcs;
				cheapest = temp.setname;
				num = temp.setnum;
			}
		}
		System.out.println("Cheapest Set By Cost Per Brick: "+num+"  |  "+cheapest);
		return cheap;
	}
	public double costlysetbybricks(){
		double cost = 0;
		String costly="";
		int num = 0;
		for(legoset temp = head;temp!=null;temp=temp.link){
			if ((temp.price/temp.pcs)>cost){
				cost = temp.price/temp.pcs;
				costly = temp.setname;
				num = temp.setnum;
			}
		}
		System.out.println("Most Expensive Set By Cost Per Brick: "+num+"  |  "+costly);
		return cost;
	}
	public double cheapsetbymf(){
		double cheap = 1000000;
		String cheapest="";
		int num = 0;
		for(legoset temp = head;temp!=null;temp=temp.link){
			if(temp.minifigs==0){
				//cannot divide by zero
			}
			else if ((temp.price/temp.minifigs)<cheap){
				cheap = temp.price/temp.minifigs;
				cheapest = temp.setname;
				num = temp.setnum;
			}
		}
		System.out.println("Cheapest Set By Cost Per Mini-Figure: "+num+"  |  "+cheapest);
		return cheap;
	}
	public double costlysetbymf(){
		double cost = 0;
		String costly="";
		int num = 0;
		for(legoset temp = head;temp!=null;temp=temp.link){
			if(temp.minifigs==0){
				//cannot divide by zero
			}
			else if ((temp.price/temp.minifigs)>cost){
				cost = temp.price/temp.minifigs;
				costly = temp.setname;
				num = temp.setnum;
			}
		}
		System.out.println("Most Expensive Set By Cost Per Mini-Figure: "+num+"  |  "+costly);
		return cost;
	}

	public void sortalphabetatoz(){
		//fields
		int s;
		String t;
		String sn;
		int p;
		int mf;
		int ag;
		double $;
		boolean swap;
		do{
			swap = false;
			for(legoset temp = head;temp.link!=null;temp=temp.link){
				String a=temp.setname;
				String b=temp.link.setname;
				int compare = a.compareTo(b);
				if (compare < 0)
				{

				}
				else
				{
					if (compare > 0){
						s = temp.setnum;
						t = temp.theme;
						sn = temp.setname;
						p = temp.pcs;
						mf = temp.minifigs;
						ag = temp.age;
						$ = temp.price;

						temp.setnum=temp.link.setnum;
						temp.theme=temp.link.theme;
						temp.setname=temp.link.setname;
						temp.pcs=temp.link.pcs;
						temp.minifigs=temp.link.minifigs;
						temp.age=temp.link.age;
						temp.price=temp.link.price;

						temp.link.setnum = s;
						temp.link.theme = t;
						temp.link.setname = sn;
						temp.link.pcs = p;
						temp.link.minifigs = mf;
						temp.link.age = ag;
						temp.link.price = $;
						swap = true; 					//next setname comes before (swap)
					}else
					{
						//set names are equal
					}
				}
			}
			//System.out.println(swap);
		}while(swap == true);
	}
	public void sortalphabetztoa(){
		//fields
		int s;
		String t;
		String sn;
		int p;
		int mf;
		int ag;
		double $;
		boolean swap;
		do{
			swap = false;
			for(legoset temp = head;temp.link!=null;temp=temp.link){
				String a=temp.setname;
				String b=temp.link.setname;
				int compare = a.compareTo(b);
				if (compare < 0)
				{
					s = temp.setnum;
					t = temp.theme;
					sn = temp.setname;
					p = temp.pcs;
					mf = temp.minifigs;
					ag = temp.age;
					$ = temp.price;

					temp.setnum=temp.link.setnum;
					temp.theme=temp.link.theme;
					temp.setname=temp.link.setname;
					temp.pcs=temp.link.pcs;
					temp.minifigs=temp.link.minifigs;
					temp.age=temp.link.age;
					temp.price=temp.link.price;

					temp.link.setnum = s;
					temp.link.theme = t;
					temp.link.setname = sn;
					temp.link.pcs = p;
					temp.link.minifigs = mf;
					temp.link.age = ag;
					temp.link.price = $;
					swap = true;
				}
				else
				{
					if (compare > 0){

					}else
					{
						//set names are equal
					}
				}
			}
			//System.out.println(swap);
		}while(swap == true);
	}
	public int[] largestall(int i) throws IOException{
		int s=0;
		int t=0;
		int bricks=0;
		int minif=0;
		int ag=0;
		int pr=0;
		String w;
		int lines=i;
		int li=0;
		//		FileReader fr2 = new FileReader("E:\\Grade 12\\(3)Chen\\.LEGO PROJECT\\combined database.txt");

		FileReader fr2 = new FileReader(".\combined-database.txt");
		BufferedReader br2 = new BufferedReader(fr2);
		try{
			do{
				w=br2.readLine();
				if(w.length()>s){
					s=w.length();
				}
				w=br2.readLine();
				if(w.length()>t){
					t=w.length();
				}
				w = br2.readLine();
				w=br2.readLine();
				if(w.length()>bricks){
					bricks=w.length();
				}
				w=br2.readLine();
				if(w.length()>minif){
					minif=w.length();
				}
				w=br2.readLine();
				if(w.length()>ag){
					ag=w.length();
				}
				w=br2.readLine();
				if(w.length()>pr){
					pr=w.length();
				}
				li = li+7;
				//System.out.println("tag");
			}while(li!=lines);
		}catch(IOException r){}
		catch (NumberFormatException r){}
		br2.close();

		int[]ret = new int[6];
		ret[0]=s;
		ret[1]=t;
		ret[2]=bricks;
		ret[3]=minif;
		ret[4]=ag;
		ret[5]=pr;

		return ret;
	}
	public void printspecific(String t, int[] form,int x1,int xx,double xxx,int xxxx,int yy,double yyy,int yyyy){
		String out;
		out =(String.format("%-"+form[0]+"s\t|\t%-"+form[1]+"s\t|  %-"+form[2]+"s  |    %-"+form[3]+"s   |      %-"+form[4]+"s\t|    %-"+form[5]+"s\t|  ", "Set #", "Theme", "# Of Bricks", "Minifigs", "Age", "Price"));
		System.out.println(out+"Set Name\n");
		String output;
		int s=0;
		String th="";
		int bricks=0;
		int minif=0;
		int ag=0;
		double pr=0;
		for(legoset temp = head; temp !=null; temp = temp.link){
			if((temp.theme.equals(t))&&(temp.age>=x1)&&(temp.pcs>=xx)&&(temp.pcs<=yy)&&(temp.price>=(xxx-0.02))&&(temp.price<=(yyy+0.02))&&(temp.minifigs>=xxxx)&&(temp.minifigs<=yyyy)){
				s=temp.setnum;
				th=temp.theme;
				bricks=temp.pcs;
				minif=temp.minifigs;
				ag=temp.age;
				pr=temp.price;
				output = String.format("%-"+form[0]+"s\t|\t%-"+form[1]+"s\t|     %-"+form[2]+"s\t|\t%-"+form[3]+"s\t|\t%-"+form[4]+"s\t|  $ %-"+form[5]+"s\t|  ", s, th, bricks, minif, ag, pr);
				System.out.println(output+temp.setname);
			}
		}
	}

	public void printlist(int[] form,int x1,int xx,double xxx,int xxxx,int yy,double yyy,int yyyy){
		String out;
		out =(String.format("%-"+form[0]+"s\t|\t%-"+form[1]+"s\t|  %-"+form[2]+"s  |    %-"+form[3]+"s   |      %-"+form[4]+"s\t|    %-"+form[5]+"s\t|  ", "Set #", "Theme", "# Of Bricks", "Minifigs", "Age", "Price"));
		System.out.println(out+"Set Name\n");
		String output;
		int s=0;
		String th="";
		int bricks=0;
		int minif=0;
		int ag=0;
		double pr=0;
		for(legoset temp = head; temp !=null; temp = temp.link){
			if ((temp.age>=x1)&&(temp.pcs>=xx)&&(temp.pcs<=yy)&&(temp.price>=(xxx-0.02))&&(temp.price<=(yyy+0.02))&&(temp.minifigs>=xxxx)&&(temp.minifigs<=yyyy)){
				s=temp.setnum;
				th=temp.theme;
				bricks=temp.pcs;
				minif=temp.minifigs;
				ag=temp.age;
				pr=temp.price;
				output = String.format("%-"+form[0]+"s\t|\t%-"+form[1]+"s\t|     %-"+form[2]+"s\t|\t%-"+form[3]+"s\t|\t%-"+form[4]+"s\t|  $ %-"+form[5]+"s\t|  ", s, th, bricks, minif, ag, pr);
				System.out.println(output+temp.setname);
			}
		}
	}

	public void printsinglebyname(String n, int[] form){
		String out;
		out =(String.format("%-"+form[0]+"s\t|\t%-"+form[1]+"s\t|  %-"+form[2]+"s  |    %-"+form[3]+"s   |      %-"+form[4]+"s\t|    %-"+form[5]+"s\t|  ", "Set #", "Theme", "# Of Bricks", "Minifigs", "Age", "Price"));
		System.out.println(out+"Set Name\n");
		String output;
		int s=0;
		String th="";
		int bricks=0;
		int minif=0;
		int ag=0;
		double pr=0;
		for(legoset temp = head; temp !=null; temp = temp.link){
			if (temp.setname.equals(n)){
				s=temp.setnum;
				th=temp.theme;
				bricks=temp.pcs;
				minif=temp.minifigs;
				ag=temp.age;
				pr=temp.price;
				output = String.format("%-"+form[0]+"s\t|\t%-"+form[1]+"s\t|     %-"+form[2]+"s\t|\t%-"+form[3]+"s\t|\t%-"+form[4]+"s\t|  $ %-"+form[5]+"s\t|  ", s, th, bricks, minif, ag, pr);
				System.out.println(output+temp.setname);
			}
		}
	}
	public void printsinglebynum(int n, int[] form){
		String out;
		out =(String.format("%-"+form[0]+"s\t|\t%-"+form[1]+"s\t|  %-"+form[2]+"s  |    %-"+form[3]+"s   |      %-"+form[4]+"s\t|    %-"+form[5]+"s\t|  ", "Set #", "Theme", "# Of Bricks", "Minifigs", "Age", "Price"));
		System.out.println(out+"Set Name\n");
		String output;
		int s=0;
		String th="";
		int bricks=0;
		int minif=0;
		int ag=0;
		double pr=0;
		for(legoset temp = head; temp !=null; temp = temp.link){
			if (temp.setnum==n){
				s=temp.setnum;
				th=temp.theme;
				bricks=temp.pcs;
				minif=temp.minifigs;
				ag=temp.age;
				pr=temp.price;
				output = String.format("%-"+form[0]+"s\t|\t%-"+form[1]+"s\t|     %-"+form[2]+"s\t|\t%-"+form[3]+"s\t|\t%-"+form[4]+"s\t|  $ %-"+form[5]+"s\t|  ", s, th, bricks, minif, ag, pr);
				System.out.println(output+temp.setname);
			}
		}
	}

	public void comparethemes2(int[] form, String x, String y,int x1,int xx,double xxx,int xxxx,int yy,double yyy,int yyyy){
		String out;
		out =(String.format("%-"+form[0]+"s\t|\t%-"+form[1]+"s\t|  %-"+form[2]+"s  |    %-"+form[3]+"s   |      %-"+form[4]+"s\t|    %-"+form[5]+"s\t|  ", "Set #", "Theme", "# Of Bricks", "Minifigs", "Age", "Price"));
		System.out.println(out+"Set Name\n");
		String output;
		int s=0;
		String th="";
		int bricks=0;
		int minif=0;
		int ag=0;
		double pr=0;
		for(legoset temp = head; temp !=null; temp = temp.link){
			if(((temp.theme.equals(x))||(temp.theme.equals(y)))&&(temp.age>=x1)&&(temp.pcs>=xx)&&(temp.pcs<=yy)&&(temp.price>=(xxx-0.02))&&(temp.price<=(yyy+0.02))&&(temp.minifigs>=xxxx)&&(temp.minifigs<=yyyy)){
				s=temp.setnum;
				th=temp.theme;
				bricks=temp.pcs;
				minif=temp.minifigs;
				ag=temp.age;
				pr=temp.price;
				output = String.format("%-"+form[0]+"s\t|\t%-"+form[1]+"s\t|     %-"+form[2]+"s\t|\t%-"+form[3]+"s\t|\t%-"+form[4]+"s\t|  $ %-"+form[5]+"s\t|  ", s, th, bricks, minif, ag, pr);
				System.out.println(output+temp.setname);
			}
		}
	}
	public void comparethemes3(int[] form, String x, String y,String z,int x1,int xx,double xxx,int xxxx,int yy,double yyy,int yyyy){
		String out;
		out =(String.format("%-"+form[0]+"s\t|\t%-"+form[1]+"s\t|  %-"+form[2]+"s  |    %-"+form[3]+"s   |      %-"+form[4]+"s\t|    %-"+form[5]+"s\t|  ", "Set #", "Theme", "# Of Bricks", "Minifigs", "Age", "Price"));
		System.out.println(out+"Set Name\n");
		String output;
		int s=0;
		String th="";
		int bricks=0;
		int minif=0;
		int ag=0;
		double pr=0;
		for(legoset temp = head; temp !=null; temp = temp.link){
			if(((temp.theme.equals(x))||(temp.theme.equals(y))||(temp.theme.equals(z)))&&(temp.age>=x1)&&(temp.pcs>=xx)&&(temp.pcs<=yy)&&(temp.price>=(xxx-0.02))&&(temp.price<=(yyy+0.02))&&(temp.minifigs>=xxxx)&&(temp.minifigs<=yyyy)){
				s=temp.setnum;
				th=temp.theme;
				bricks=temp.pcs;
				minif=temp.minifigs;
				ag=temp.age;
				pr=temp.price;
				output = String.format("%-"+form[0]+"s\t|\t%-"+form[1]+"s\t|     %-"+form[2]+"s\t|\t%-"+form[3]+"s\t|\t%-"+form[4]+"s\t|  $ %-"+form[5]+"s\t|  ", s, th, bricks, minif, ag, pr);
				System.out.println(output+temp.setname);
			}
		}
	}

	public void addatend(int s, String t, String sn, int p, int mf, int a, double $){
		legoset current = head;   // current points to the current Node
		legoset previous = null;    // previous points to the previous Node
		while (current!= null){
			previous = current;    // moves along the list
			current = current.link;
		}
		legoset newNode = new legoset(s,t,sn,p,mf,a,$);
		// creates a new Node with item as info and points to �current�
		if (current == head){
			head = newNode;
		}// if new Node was inserted into an empty list
		else{
			previous.link = newNode;
		}
		// otherwise the �previous�  node points to the new node
	}

	public void legoOrginize(int s, String t, String sn, int p, int mf, int a, double price){
		legoset k;
		for(legoset temp = head; temp !=null; temp = temp.link){
			k = new legoset(s,t,sn,p,mf,a,price);
			k = k.link;
		}

	}
	public void printsetnum(int setnum){
		for(legoset temp = head; temp !=null; temp = temp.link){
			System.out.println(temp.setnum);
		}
	}
}
