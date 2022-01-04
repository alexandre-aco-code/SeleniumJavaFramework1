package demo;

import org.testng.annotations.Test;

@Test(groups= {"AllClassTest"})
public class TestNGGroupsDemo {
	

	@Test(groups= {"sanity"})
	public void test1() {
		System.out.println("im inside TEST1");
		
	}

	@Test(groups= {"sanity","smoke"})
	public void test2() {

		System.out.println("im inside TEST2");
	}

	@Test(groups= {"smoke"})
	public void test3() {

		System.out.println("im inside TEST3");
	}
	
	@Test(groups= {"other"})
	public void test4() {

		System.out.println("im inside TEST4");
	}
}
