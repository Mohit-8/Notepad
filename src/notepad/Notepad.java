package notepad;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.io.*;

public class Notepad extends JFrame implements ActionListener{
	JTextArea area;
	JScrollPane pane;
	String str;

	Notepad(){
		setBounds(0,0,1950,1050);
		
		JMenuBar menubar = new JMenuBar();
		
		
		//Menu
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		
		//adding menus to the menubar
		menubar.add(file);
		menubar.add(edit);
		menubar.add(help);
		
		//Menu items of file menu
		JMenuItem newf = new JMenuItem("New");
		newf.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		newf.addActionListener(this);
		
		JMenuItem open = new JMenuItem("Open");
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		open.addActionListener(this);
		
		JMenuItem save = new JMenuItem("Save");
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		save.addActionListener(this);
		
		JMenuItem print = new JMenuItem("Print");
		print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		print.addActionListener(this);
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0));
		exit.addActionListener(this);
		
		//adding menu items to the file menu.
		file.add(newf);
		file.add(open);
		file.add(save);
		file.add(print);
		file.add(exit);
		
		//Menu items of edit menu
		
		JMenuItem cut = new JMenuItem("Cut");
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		cut.addActionListener(this);
		
		JMenuItem copy = new JMenuItem("Copy");
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		copy.addActionListener(this);
		
		JMenuItem paste = new JMenuItem("Paste");
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
		paste.addActionListener(this);
		
		JMenuItem selectAll = new JMenuItem("Select All");
		selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		selectAll.addActionListener(this);
		
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(selectAll);
		
		//Menu items of help menu
		JMenuItem about = new JMenuItem("About");
		help.add(about);
		about.addActionListener(this);
		
		setJMenuBar(menubar);
		
		area = new JTextArea();
		area.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
		area.setLineWrap(true); // to get the text in the new line
		area.setWrapStyleWord(true);
		
		pane = new JScrollPane(area);
		pane.setBorder(BorderFactory.createEmptyBorder());
		add(pane,BorderLayout.CENTER);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("New"))
		{
			area.setText("");
		}
		else if(e.getActionCommand().equals("Open")) {
			JFileChooser jf = new JFileChooser();
			jf.setAcceptAllFileFilterUsed(false); //to only show files with .txt extension.
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Only .txt files","txt");
			jf.addChoosableFileFilter(filter);
			
			int action = jf.showOpenDialog(this);
			if(action!=JFileChooser.APPROVE_OPTION)
			{
				return;
			}
			
			File file = jf.getSelectedFile();
			try {
				BufferedReader readf = new BufferedReader(new FileReader(file));
				area.read(readf,null);
				
			}catch(Exception ex) {
				
			}
		}
		else if(e.getActionCommand().equals("Save")) {
			JFileChooser saved = new JFileChooser(); //to open the directory where to save the file.
			saved.setApproveButtonText("Save"); //will only work is save is selectd in the dialog box.
			int action = saved.showOpenDialog(this);
			if(action!=JFileChooser.APPROVE_OPTION)
			{
				return;
			}
			File f = new File(saved.getSelectedFile()+".txt");
			BufferedWriter outf = null;
			try {
				outf = new BufferedWriter(new FileWriter(f));
				area.write(outf);
				
			}catch(Exception ex) {
				
			}
		}
		else if(e.getActionCommand().equals("Print")) {
			try {
				area.print();
			} catch (PrinterException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equals("Exit")) {
			System.exit(0);
		}
		else if(e.getActionCommand().equals("Cut")) {
			str=area.getSelectedText();
			area.replaceRange("", area.getSelectionStart(),area.getSelectionEnd());
		}
		else if(e.getActionCommand().equals("Paste")) {
			area.insert(str, area.getCaretPosition());
		}
		else if(e.getActionCommand().equals("Copy")) {
			str=area.getSelectedText();
		}
		else if(e.getActionCommand().equals("Select All")) {
			area.selectAll();
		}
		else if(e.getActionCommand().equals("About")) {
			new About().setVisible(true);
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Notepad().setVisible(true);

	}
	

}
