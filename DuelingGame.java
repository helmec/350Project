package escaperoom;

import java.util.Random;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

// Change the name of this class after it has been completed
public class DuelingGame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Random rand = new Random();
	boolean win, lose;
	//String instructions = "rules rules rules";
	
	JFrame frame;
	JPanel panel;
	JMenuBar menu;
	JMenu file;
	JMenuItem quit;
	JButton go;
	JTextField input;
	JTextField result;
	JTextArea rules;
	
	int lives = 5;
	int aiLives = 5;
	int player;
	int ai;
	int guess;
	String buf;
	
	public String duel(){
		ai = rand.nextInt(3);
		player = this.getGuess();
		buf = "";
		
		if (ai == 0){
			if (player == 1){
				aiLives -= 1;
				buf = "You hit them!";
			}
			if (player == 2){
				lives -= 1;
				buf = "You've been hit!";
			}
			else{
				buf = "You countered their attack!";
			}
		}
		if (ai == 1){
			if (player == 2){
				aiLives -= 1;
				buf = "You hit them!";
			}
			if (player == 0){
				lives -= 1;
				buf = "You've been hit!";
			}
			else{
				buf = "You countered their attack!";
			}
		}
		if (ai == 2){
			if (player == 0){
				aiLives -= 1;
				buf = "You hit them!";
			}
			if (player == 1){
				lives -= 1;
				buf = "You've been hit!";
			}
			else{
				buf = "You countered their attack!";
			}
		}
		
		if (lives < 1){
			lose = true;
		}
		if (aiLives <1){
			win = true;
		}
		return buf;
		
		
	}
	
	
	public int getGuess(){
		return this.guess;
	}
	public void setGuess(int g){
		this.guess = g;
	}

	
	public static void main(String[] args){
		DuelingGame d = new DuelingGame();
		//d.buildGUI();
	}
	
}