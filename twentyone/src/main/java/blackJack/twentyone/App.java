package blackJack.twentyone;

public class App 
{
    public static void main( String[] args )
    {
    	BlackJack blackjack = new BlackJack(); 
 
    	 
 		System.out.println(blackjack.play(21, 20)); 
  		System.out.println(blackjack.play(10, 22)); 
  		System.out.println(blackjack.play(22, 22)); 
  		System.out.println(blackjack.play(0, 22)); 

    }
}
