import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private final List<Card> cards;
    private static final String[] PALOS = {"Tréboles", "Corazones", "Picas", "Diamantes"};
    private static final String[] COLORES = {"Negro", "Rojo"};
    private static final String[] VALORES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        for (String palo : PALOS) {
            String color = (palo.equals("Tréboles") || palo.equals("Picas")) ? COLORES[0] : COLORES[1];
            for (String valor : VALORES) {
                cards.add(new Card(palo, color, valor));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        if (cards.isEmpty()) {
            System.out.println("El deck está vacío.");
            return;
        }
        Card card = cards.remove(0);
        System.out.println(card);
        System.out.println("Quedan " + cards.size() + " cartas en el deck.");
    }

    public void pick() {
        if (cards.isEmpty()) {
            System.out.println("El deck está vacío.");
            return;
        }
        int randomIndex = new Random().nextInt(cards.size());
        Card card = cards.remove(randomIndex);
        System.out.println(card);
        System.out.println("Quedan " + cards.size() + " cartas en el deck.");
    }

    public void hand() {
        if (cards.size() < 5) {
            System.out.println("No hay suficientes cartas en el deck.");
            return;
        }
        for (int i = 0; i < 5; i++) {
            Card card = cards.remove(0);
            System.out.println(card);
        }
        System.out.println("Quedan " + cards.size() + " cartas en el deck.");
    }
}


