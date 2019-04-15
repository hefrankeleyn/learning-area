package com.hef.algorithms.fundamentals.bags_queues_stacks.exercise1_3.exe35;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * @Date 2019-04-15
 * @Author lifei
 */
public class RandomQueue<Item> {

    private Item item;
    private Item[] a;
    private int N;

    public RandomQueue() {
        a = (Item[]) new Object[2];
        N = 0;
    }

    public int size(){
        return N;
    }

    /**
     * is the queue empty?
     * @return
     */
    public boolean isEmpty(){
        return N == 0;
    }

    /**
     * add an item
     * @param item
     */
    public void enqueue(Item item) {
        if (N == a.length) resize(N * 2);
        a[N] = item;
        N++;
    }

    /**
     * remove and return a random item
     * (sample without replacement)
     * Use an array representation (with resizing). To remove an item,
     * swap one at a random position (indexed 0 through N-1) with the one at the last position (index N-1).
     * Then delete and return the last object, as in ResizingArrayStack.
     * @return
     */
    public Item dequeue(){
        Random random = new Random();
        int index = random.nextInt(N);
        Item temp = a[N-1];
        a[N-1] = a[index];
        a[index] = temp;
        Item r = a[N-1];
        a[N-1] = null;
        N--;
        if(N == a.length / 4) resize(a.length/2);
        return r;
    }

    /**
     * return a random item, but do not remove
     * (sample with replacement)
     * @return
     */
    public Item sample(){
        Random random = new Random();
        int index = random.nextInt(N);
        Item item = a[index];
        return item;
    }

    /**
     * resize array length
     * @param len
     */
    private void resize(int len){
        assert len > N;
        Item[] items = (Item[]) new Object[len];
        for (int i = 0; i < N; i++) {
            items[i] = a[i];
        }
        a = items;
    }

    public static void main(String[] args) {
        Card card = null;
        RandomQueue<Card> q = new RandomQueue<>();
        for (int i = 1; i <= 15; i++) {
            if(i == 14){
                card = new Card();
                card.setNum(i);
                card.setColor(i);
                q.enqueue(card);
                continue;
            }
            if(i == 15){
                card = new Card();
                card.setNum(i);
                card.setColor(i);
                q.enqueue(card);
                continue;
            }
            for (int j = 1; j <= 4; j++) {
                card = new Card();
                card.setNum(i);
                card.setColor(j);
                q.enqueue(card);
            }
        }
        Card[] handOne = new Card[13];
        Card[] handTwo = new Card[13];
        Card[] handThree = new Card[13];
        Card[] handFour = new Card[13];
        Card.randCards(q,handOne);
        Card.randCards(q,handTwo);
        Card.randCards(q,handThree);
        Card.randCards(q,handFour);
        System.out.println(Arrays.toString(handOne));
        System.out.println(Arrays.toString(handTwo));
        System.out.println(Arrays.toString(handThree));
        System.out.println(Arrays.toString(handFour));

    }

}

class Card{
    public static final String RED_RECTANGLE = "red_rectangle";
    public static final int RED_RECTANGLE_NUM = 1;
    public static final String RED_HEART = "red_heart";
    public static final int RED_HEART_NUM = 2;
    public static final String BLACK_RECTANGLE = "black_rectangle";
    public static final int BLACK_RECTANGLE_NUM = 3;
    public static final String BLACK_HEART = "black_heart";
    public static final int BLACK_HEART_NUM = 4;
    public static final int KING = 15;
    public static final String KING_COLOR = "kong_color";
    public static final int WANG = 14;
    public static final String WANG_COLOR = "wang_color";
    private String color;
    private int num;
    public Card(){

    }

    public String getColor() {
        return color;
    }

    public void setColor(int color_num) {
        if(color_num == RED_RECTANGLE_NUM){
            this.color = RED_RECTANGLE;
        }else if(color_num == RED_HEART_NUM){
            this.color = RED_HEART;
        }else if(color_num == BLACK_RECTANGLE_NUM){
            this.color = BLACK_RECTANGLE;
        }else if(color_num == BLACK_HEART_NUM){
            this.color = BLACK_HEART;
        }else if(color_num == WANG){
            this.color = WANG_COLOR;
        }else if(color_num == KING){
            this.color = KING_COLOR;
        }else {
            throw new NoSuchElementException("color_num must between 1 (inclusive) and 4 (inclusive)");
        }
    }

    public String getNum() {
        if(num == 1){
            return "A";
        }else if (num == 15){
            return "KING";
        }else if (num == 14){
            return "WANG";
        }else if (num == 11){
            return "J";
        }else if (num == 12){
            return "Q";
        }else if (num == 13){
            return "K";
        }else {
            return num + "";
        }
    }

    public void setNum(int num) {
        this.num = num;
    }


    public static void randCards(RandomQueue<Card> q, Card[] cards){
        for (int i = 0; i < cards.length; i++) {
            Card c = q.dequeue();
            cards[i] = c;
        }
    }

    @Override
    public String toString() {
        return "Card{" +
                "color='" + color + '\'' +
                ", num=" + num +
                '}';
    }
}
