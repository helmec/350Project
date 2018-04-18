package escaperoom;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DuelingGUI implements ActionListener{
	
	
	JFrame frame;
	JPanel panel;
	JMenuBar menu;
	JMenu file;
	JMenuItem quit;
	JButton go;
	JTextField input;
	JTextField result;
	JTextArea rules;
	JTextArea status;
	
	DuelingGame d;
	
	
	
	public static void main(String[] args){
		//DuelingGame d = new DuelingGame();
		DuelingGUI gui = new DuelingGUI();
	}
	
	public DuelingGUI(){
		// Building all of our components
		d = new DuelingGame();
		
		menu = new JMenuBar();
		file = new JMenu("File");
		quit = new JMenuItem("quit");
		
		quit.addActionListener(this);
		file.add(quit);
		menu.add(file);
		
		go = new JButton("Attack!");
		go.addActionListener(this);
		
		input = new JTextField("How will you counter?");
		input.setColumns(20);
		result = new JTextField("");
		result.setColumns(20);
		status = new JTextArea("Player Lives: " + d.lives + "\nOpponent Lives: " + d.aiLives);
		rules = new JTextArea("Welcome to the Dueling Game! You will have to\ncounter your opponent's strikes and avoid getting hit\nif you want to get out alive!\nEnter '0', '1', or '2' to choose a counter.");
		
		frame = new JFrame("Dueling Game");
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 1;
		c.gridy = 1;
		panel.add(rules, c);
		
		c.gridy = 2;
		panel.add(input, c);
		
		c.gridy = 3;
		panel.add(go, c);
		
		c.gridy = 4;
		panel.add(result, c);
		
		c.gridy = 5;
		panel.add(status, c);
		
		frame.add(panel);
		
		frame.setJMenuBar(menu);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		Object w = e.getSource();
		if (w == quit){
			System.exit(1);
		}
		if (w == go){
			d.setGuess(Integer.parseInt(input.getText()));
			updateUI(d.duel());
		}
	}
	
	public void updateUI(String b){
		status.setText("Player Lives: " + d.lives + "\nOpponent Lives: " + d.aiLives);
		result.setText(b);
		if (d.win){
			result.setText("You won!");
		}
		if (d.lose){
			result.setText("You lost!");
		}
	}
}
