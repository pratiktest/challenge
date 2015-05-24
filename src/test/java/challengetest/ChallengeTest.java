package challengetest;


import org.junit.Test;

import challenge.Challenge;


/*
 * assumptions. When the words are of equal frequency the order is not guarenteed
 */
public class ChallengeTest {
	
	@Test
	public void testNormal(){
		System.out.println("TEST1");
		Challenge c =  new Challenge("abc abc abc abc bp bp bp bp bo bo bo a b c a a a", 4);
		c.startChallenge();
		System.out.println("END TEST 1");
		System.out.println("-------------------------------------------------");
		
	}
	
	@Test
	public void testNull(){
		
		System.out.println("TEST2");
		
		Challenge c1 =  new Challenge(null, 2);
		c1.startChallenge();
		
		Challenge c2 =  new Challenge(null, null);
		c2.startChallenge();
		
		Challenge c3 =  new Challenge("abc", null);
		c3.startChallenge();
		
		System.out.println("END TEST 2");
		System.out.println("-------------------------------------------------");
		
	}
	
	
	@Test
	public void testNumberGreaterThanWords(){
		
		System.out.println("TEST3");
		//8 > no of unique words assumption is program should display all words in frequency order 
		Challenge c1 =  new Challenge("abc lmn omg omg omg omg omg omg omg", 8);
		c1.startChallenge();
		
		System.out.println("END TEST 3");
		System.out.println("-------------------------------------------------");
		
		
	}
	
	@Test
	public void testAnotherNormalSet(){
		
		System.out.println("TEST4");
		Challenge c1 =  new Challenge("abc pqr pqr pqr v v v v v v v n m t", 2);
		c1.startChallenge();
		
		System.out.println("END TEST 4");
		System.out.println("-------------------------------------------------");
		
		
	}
	
	@Test
	public void testNegativeAndZero(){
		
		System.out.println("TEST5");
		Challenge c1 =  new Challenge("abc pqr pqr pqr v v v v v v v n m t", 0);
		c1.startChallenge();
		
		Challenge c2 =  new Challenge("abc pqr pqr pqr v v v v v v v n m t", -3);
		c2.startChallenge();
		
		System.out.println("END TEST 5");
		System.out.println("-------------------------------------------------");
		
		
	}
	
	@Test
	public void testEmptyAndAllSpaces(){
		
		System.out.println("TEST6");
		Challenge c1 =  new Challenge("", 4);
		c1.startChallenge();
		
		Challenge c2 =  new Challenge("                 ", 4);
		c2.startChallenge();
		
		System.out.println("END TEST 6");
		System.out.println("-------------------------------------------------");
		
		
	}
	
	@Test
	public void testSpaces(){
		
		System.out.println("TEST7");
		Challenge c1 =  new Challenge("", 4);
		c1.startChallenge();
		
		Challenge c2 =  new Challenge("s   b      a a a a a   lmn         p tmn", 9);
		c2.startChallenge();
		
		System.out.println("END TEST 7");
		System.out.println("-------------------------------------------------");
		
		
	}
	
	
	
}
