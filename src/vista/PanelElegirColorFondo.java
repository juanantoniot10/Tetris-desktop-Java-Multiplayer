package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.Color;

public class PanelElegirColorFondo extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton button_10;
	private JButton button_11;
	public PanelElegirColorFondo() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		button_10 = new JButton("");
		button_10.setName("1");
		button_10.setMinimumSize(new Dimension(43, 23));
		button_10.setMaximumSize(new Dimension(2220, 400));
		button_10.setMargin(new Insets(20, 20, 20, 20));
		button_10.setHorizontalTextPosition(SwingConstants.LEADING);
		button_10.setFont(new Font("Pristina", Font.BOLD, 25));
		button_10.setBackground(new Color(128, 0, 0));
		panel.add(button_10);
		
		button_11 = new JButton("");
		button_11.setName("1");
		button_11.setMinimumSize(new Dimension(43, 23));
		button_11.setMaximumSize(new Dimension(2220, 400));
		button_11.setMargin(new Insets(20, 20, 20, 20));
		button_11.setHorizontalTextPosition(SwingConstants.LEADING);
		button_11.setFont(new Font("Pristina", Font.BOLD, 25));
		button_11.setBackground(new Color(0, 0, 128));
		panel.add(button_11);
		
		JButton button_12 = new JButton("");
		button_12.setName("1");
		button_12.setMinimumSize(new Dimension(43, 23));
		button_12.setMaximumSize(new Dimension(2220, 400));
		button_12.setMargin(new Insets(20, 20, 20, 20));
		button_12.setHorizontalTextPosition(SwingConstants.LEADING);
		button_12.setFont(new Font("Pristina", Font.BOLD, 25));
		button_12.setBackground(new Color(0, 128, 0));
		panel.add(button_12);
		
		JButton button_13 = new JButton("");
		button_13.setName("1");
		button_13.setMinimumSize(new Dimension(43, 23));
		button_13.setMaximumSize(new Dimension(2220, 400));
		button_13.setMargin(new Insets(20, 20, 20, 20));
		button_13.setHorizontalTextPosition(SwingConstants.LEADING);
		button_13.setFont(new Font("Pristina", Font.BOLD, 25));
		button_13.setBackground(new Color(0, 0, 255));
		panel.add(button_13);
		
		JButton button_14 = new JButton("");
		button_14.setName("1");
		button_14.setMinimumSize(new Dimension(43, 23));
		button_14.setMaximumSize(new Dimension(2220, 400));
		button_14.setMargin(new Insets(20, 20, 20, 20));
		button_14.setHorizontalTextPosition(SwingConstants.LEADING);
		button_14.setFont(new Font("Pristina", Font.BOLD, 25));
		button_14.setBackground(new Color(85, 107, 47));
		panel.add(button_14);
		
		JButton button_15 = new JButton("");
		button_15.setName("1");
		button_15.setMinimumSize(new Dimension(43, 23));
		button_15.setMaximumSize(new Dimension(2220, 400));
		button_15.setMargin(new Insets(20, 20, 20, 20));
		button_15.setHorizontalTextPosition(SwingConstants.LEADING);
		button_15.setFont(new Font("Pristina", Font.BOLD, 25));
		button_15.setBackground(new Color(0, 51, 0));
		panel.add(button_15);
		
		JButton button_16 = new JButton("");
		button_16.setName("1");
		button_16.setMinimumSize(new Dimension(43, 23));
		button_16.setMaximumSize(new Dimension(2220, 400));
		button_16.setMargin(new Insets(20, 20, 20, 20));
		button_16.setHorizontalTextPosition(SwingConstants.LEADING);
		button_16.setFont(new Font("Pristina", Font.BOLD, 25));
		button_16.setBackground(new Color(153, 51, 102));
		panel.add(button_16);
		
		JButton button_17 = new JButton("");
		button_17.setName("1");
		button_17.setMinimumSize(new Dimension(43, 23));
		button_17.setMaximumSize(new Dimension(2220, 400));
		button_17.setMargin(new Insets(20, 20, 20, 20));
		button_17.setHorizontalTextPosition(SwingConstants.LEADING);
		button_17.setFont(new Font("Pristina", Font.BOLD, 25));
		button_17.setBackground(new Color(51, 0, 51));
		panel.add(button_17);
		
		JButton button_18 = new JButton("");
		button_18.setName("1");
		button_18.setMinimumSize(new Dimension(43, 23));
		button_18.setMaximumSize(new Dimension(2220, 400));
		button_18.setMargin(new Insets(20, 20, 20, 20));
		button_18.setHorizontalTextPosition(SwingConstants.LEADING);
		button_18.setFont(new Font("Pristina", Font.BOLD, 25));
		button_18.setBackground(new Color(72, 61, 139));
		panel.add(button_18);
		
		JButton button_19 = new JButton("");
		button_19.setName("1");
		button_19.setMinimumSize(new Dimension(43, 23));
		button_19.setMaximumSize(new Dimension(2220, 400));
		button_19.setMargin(new Insets(20, 20, 20, 20));
		button_19.setHorizontalTextPosition(SwingConstants.LEADING);
		button_19.setFont(new Font("Pristina", Font.BOLD, 25));
		button_19.setBackground(new Color(139, 69, 19));
		panel.add(button_19);
		
		JButton button_20 = new JButton("");
		button_20.setName("1");
		button_20.setMinimumSize(new Dimension(43, 23));
		button_20.setMaximumSize(new Dimension(2220, 400));
		button_20.setMargin(new Insets(20, 20, 20, 20));
		button_20.setHorizontalTextPosition(SwingConstants.LEADING);
		button_20.setFont(new Font("Pristina", Font.BOLD, 25));
		button_20.setBackground(new Color(153, 0, 0));
		panel.add(button_20);
		
		JButton button_21 = new JButton("");
		button_21.setName("1");
		button_21.setMinimumSize(new Dimension(43, 23));
		button_21.setMaximumSize(new Dimension(2220, 400));
		button_21.setMargin(new Insets(20, 20, 20, 20));
		button_21.setHorizontalTextPosition(SwingConstants.LEADING);
		button_21.setFont(new Font("Pristina", Font.BOLD, 25));
		button_21.setBackground(new Color(0, 51, 0));
		panel.add(button_21);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JButton button = new JButton("");
		button.setName("1");
		button.setMinimumSize(new Dimension(43, 23));
		button.setMaximumSize(new Dimension(2220, 400));
		button.setMargin(new Insets(20, 20, 20, 20));
		button.setHorizontalTextPosition(SwingConstants.LEADING);
		button.setFont(new Font("Pristina", Font.BOLD, 25));
		button.setBackground(new Color(128, 0, 128));
		panel_1.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setName("1");
		button_1.setMinimumSize(new Dimension(43, 23));
		button_1.setMaximumSize(new Dimension(2220, 400));
		button_1.setMargin(new Insets(20, 20, 20, 20));
		button_1.setHorizontalTextPosition(SwingConstants.LEADING);
		button_1.setFont(new Font("Pristina", Font.BOLD, 25));
		button_1.setBackground(new Color(204, 0, 0));
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setName("1");
		button_2.setMinimumSize(new Dimension(43, 23));
		button_2.setMaximumSize(new Dimension(2220, 400));
		button_2.setMargin(new Insets(20, 20, 20, 20));
		button_2.setHorizontalTextPosition(SwingConstants.LEADING);
		button_2.setFont(new Font("Pristina", Font.BOLD, 25));
		button_2.setBackground(new Color(0, 128, 128));
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setName("1");
		button_3.setMinimumSize(new Dimension(43, 23));
		button_3.setMaximumSize(new Dimension(2220, 400));
		button_3.setMargin(new Insets(20, 20, 20, 20));
		button_3.setHorizontalTextPosition(SwingConstants.LEADING);
		button_3.setFont(new Font("Pristina", Font.BOLD, 25));
		button_3.setBackground(new Color(153, 51, 204));
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setName("1");
		button_4.setMinimumSize(new Dimension(43, 23));
		button_4.setMaximumSize(new Dimension(2220, 400));
		button_4.setMargin(new Insets(20, 20, 20, 20));
		button_4.setHorizontalTextPosition(SwingConstants.LEADING);
		button_4.setFont(new Font("Pristina", Font.BOLD, 25));
		button_4.setBackground(new Color(255, 0, 0));
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setName("1");
		button_5.setMinimumSize(new Dimension(43, 23));
		button_5.setMaximumSize(new Dimension(2220, 400));
		button_5.setMargin(new Insets(20, 20, 20, 20));
		button_5.setHorizontalTextPosition(SwingConstants.LEADING);
		button_5.setFont(new Font("Pristina", Font.BOLD, 25));
		button_5.setBackground(new Color(102, 153, 0));
		panel_1.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setName("1");
		button_6.setMinimumSize(new Dimension(43, 23));
		button_6.setMaximumSize(new Dimension(2220, 400));
		button_6.setMargin(new Insets(20, 20, 20, 20));
		button_6.setHorizontalTextPosition(SwingConstants.LEADING);
		button_6.setFont(new Font("Pristina", Font.BOLD, 25));
		button_6.setBackground(new Color(0, 0, 102));
		panel_1.add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.setName("1");
		button_7.setMinimumSize(new Dimension(43, 23));
		button_7.setMaximumSize(new Dimension(2220, 400));
		button_7.setMargin(new Insets(20, 20, 20, 20));
		button_7.setHorizontalTextPosition(SwingConstants.LEADING);
		button_7.setFont(new Font("Pristina", Font.BOLD, 25));
		button_7.setBackground(new Color(47, 79, 79));
		panel_1.add(button_7);
		
		JButton button_8 = new JButton("");
		button_8.setName("1");
		button_8.setMinimumSize(new Dimension(43, 23));
		button_8.setMaximumSize(new Dimension(2220, 400));
		button_8.setMargin(new Insets(20, 20, 20, 20));
		button_8.setHorizontalTextPosition(SwingConstants.LEADING);
		button_8.setFont(new Font("Pristina", Font.BOLD, 25));
		button_8.setBackground(new Color(184, 134, 11));
		panel_1.add(button_8);
		
		JButton button_9 = new JButton("");
		button_9.setName("1");
		button_9.setMinimumSize(new Dimension(43, 23));
		button_9.setMaximumSize(new Dimension(2220, 400));
		button_9.setMargin(new Insets(20, 20, 20, 20));
		button_9.setHorizontalTextPosition(SwingConstants.LEADING);
		button_9.setFont(new Font("Pristina", Font.BOLD, 25));
		button_9.setBackground(new Color(204, 102, 51));
		panel_1.add(button_9);
		
		JButton button_22 = new JButton("");
		button_22.setName("1");
		button_22.setMinimumSize(new Dimension(43, 23));
		button_22.setMaximumSize(new Dimension(2220, 400));
		button_22.setMargin(new Insets(20, 20, 20, 20));
		button_22.setHorizontalTextPosition(SwingConstants.LEADING);
		button_22.setFont(new Font("Pristina", Font.BOLD, 25));
		button_22.setBackground(new Color(204, 0, 0));
		panel_1.add(button_22);
		
		JButton button_23 = new JButton("");
		button_23.setName("1");
		button_23.setMinimumSize(new Dimension(43, 23));
		button_23.setMaximumSize(new Dimension(2220, 400));
		button_23.setMargin(new Insets(20, 20, 20, 20));
		button_23.setHorizontalTextPosition(SwingConstants.LEADING);
		button_23.setFont(new Font("Pristina", Font.BOLD, 25));
		button_23.setBackground(new Color(0, 0, 0));
		panel_1.add(button_23);
	}
	
}
