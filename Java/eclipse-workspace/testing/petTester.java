import java.util.*;
import java.io.*;
public class petTester {
	public static void main(String[] args)
	  {
	Pet test = new LoudDog("bud");
	System.out.println(test.speak() + " " + test.getName());
	  }
}
