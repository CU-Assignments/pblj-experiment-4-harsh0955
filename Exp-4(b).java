import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

class Card {
    String rank;
    String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    public boolean matchesSuit(String suit) {
        return this.suit.equalsIgnoreCase(suit);
    }
}

public class CardCollector {

    static Collection<Card> cards = new ArrayList<>();

    public static void addCard(String rank, String suit) {
        Card card = new Card(rank, suit);
        cards.add(card);
        System.out.println("Card added: " + card);
    }

    public static void findCardsBySuit(String suit) {
        boolean found = false;
        for (Card card : cards) {
            if (card.matchesSuit(suit)) {
                System.out.println(card);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cards found with the suit: " + suit);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nCard Collection System");
            System.out.println("1. Add Card");
            System.out.println("2. Find Cards by Suit");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter Card Rank (e.g., Ace, 2, 3, Jack, etc.): ");
                    String rank = scanner.nextLine();
                    System.out.print("Enter Card Suit (e.g., Hearts, Diamonds, Clubs, Spades): ");
                    String suit = scanner.nextLine();
                    addCard(rank, suit);
                    break;

                case 2:
                    System.out.print("Enter the suit you want to find (e.g., Hearts, Spades, Diamonds, Clubs): ");
                    String searchSuit = scanner.nextLine();
                    findCardsBySuit(searchSuit);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
