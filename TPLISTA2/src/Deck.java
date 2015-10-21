import java.util.ArrayList;
import java.util.Random;

public class Deck {
        private int countCard=0;
        public ArrayList<Card> cards;
        Deck()
        {
        cards = new ArrayList<Card>();
         int suit, rank;
         for(suit=1; suit<=4; suit++){
                 for(rank=1; rank<=13; rank++){
                         cards.add(new Card(suit, rank));                        
                 }
         }         
        }
        public Card takeCard()
        {
        		Card card=cards.get(0);
        		cards.remove(0);
                return card;
        }
        public void returnCard(String card) throws PokerException
        {
                try
                {
                int suit=0, rank=Integer.parseInt(card.substring(1));
                if(card.charAt(0)=='C') suit=1;
                else if(card.charAt(0)=='D') suit=2;
                else if(card.charAt(0)=='H') suit=3;
                else if(card.charAt(0)=='S') suit=4;
                cards.add(new Card(suit, rank));
                }
                catch(NumberFormatException ex)
                {
                        throw new PokerException("Blad konwersji symbolicznej reprezentacji kart na liczbowa");
                }
        }
        void shuffle()
        {
                for(int i=0; i<2*cards.size(); i++)
                {
                        Random r = new Random();
                        int cardId = r.nextInt(cards.size());
                        Card card = cards.get(cardId);
                        cards.remove(cardId);
                        cards.add(r.nextInt(cards.size()), card);
                }
        }
}