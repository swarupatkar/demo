class A
{
	
	
	static{
		System.out.println("Static Block start");
				System.out.println("Static Block end");
	}

	int x=m1();
	int m1(){
				System.out.println("NS method start");
						System.out.println("NS method end");
						return 10;



	}

	{
				System.out.println("Non-Static Block start");
						System.out.println("Non-Static Block end");
	}
	A()
	{
			System.out.println("constructor start");	
					System.out.println("constructor end");
	}
	public static void main(String[] args) 
	{
		System.out.println("main start ");
A e=  new A ();
				System.out.println("main end");
	}
}
