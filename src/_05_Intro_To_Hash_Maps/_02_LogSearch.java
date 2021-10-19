package _05_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton("Add Entry");
	JButton button0 = new JButton("Serch By ID");
	JButton button1 = new JButton("View List");
	JButton button2 = new JButton("Remove Entry");

	public void start() {
		frame.setVisible(true);
		frame.add(panel);
		panel.add(button);
		panel.add(button0);
		panel.add(button1);
		panel.add(button2);
		button.addActionListener(this);
		button0.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);

	}

	public static void main(String[] args) {
		new _02_LogSearch().start();
	}
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonClicked = (JButton) e.getSource();
		if (buttonClicked == button) {
			System.out.println("Add Entry");
			String id = JOptionPane.showInputDialog("Enter an ID");
			String name = JOptionPane.showInputDialog("Enter a name");
			int ID = Integer.parseInt(id);
			hashmap.put(ID, name);
		} else if (buttonClicked == button0) {
			System.out.println("Search By ID");
			String IDSearch = JOptionPane.showInputDialog("Enter ID");
			int idSearch = Integer.parseInt(IDSearch);
			if (hashmap.containsKey(idSearch)) {
				JOptionPane.showMessageDialog(null, hashmap.get(idSearch));
			} else {
				JOptionPane.showMessageDialog(null, "this ID does not exist");
			}

		} else if (buttonClicked == button1) {
			String IDs = "";
			String IDset;
			for (int ID : hashmap.keySet()) {
				IDset = ("ID: " + ID + " Name: " + hashmap.get(ID));
				IDs = IDs + "\n" + IDset;
			}
			JOptionPane.showMessageDialog(null, IDs);
			System.out.println("View List");

		} else if (buttonClicked == button2) {
			String removeid=JOptionPane.showInputDialog("Enter an ID you want to remove");
			int removeID=Integer.parseInt(removeid);
			if (hashmap.containsKey(removeID)) {
				hashmap.remove(removeID);
			}else {
				JOptionPane.showMessageDialog(null,"This ID doesn't exist");
			}
		}

	}

}
