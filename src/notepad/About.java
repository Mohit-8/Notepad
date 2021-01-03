package notepad;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame{
	JButton b1;
	About(){
		setBounds(600,200,700,600);
		//setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("windows.png"));
		Image i2 = i1.getImage().getScaledInstance(400, 80, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel jl = new JLabel(i3);
		jl.setBounds(150, 40, 400, 80);
		add(jl);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("notepad.png"));
		Image i5 = i4.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel jl2 = new JLabel(i6);
		jl2.setBounds(50, 180, 70, 70);
		add(jl2);
		
		JLabel jl3 = new JLabel("<html>Notepad is a simple text editor for Microsoft Windows and a basic text-editing program which enables computer users to create documents.<br> It was first released as a mouse-based MS-DOS program in 1983, and has been included in all versions of Microsoft Windows since Windows 1.0 in 1985.</html>");
		jl3.setBounds(150, 130, 500, 300);
		jl3.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
		add(jl3);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new About().setVisible(true);
	}

}
