import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Interface extends JFrame implements ActionListener {
	private Panneau pan = new Panneau();
	private Panneau1 pan1 =new Panneau1();
	private Bouton bouton = new Bouton("JOUER");
	private Bouton bouton2 = new Bouton("-");
	private JPanel container = new JPanel();
	private JPanel jeu = new JPanel();
	private JLabel label = new JLabel("Risk'Isep : Sublime Wafare IIII");
	//private int compteur=0;
	private JComboBox combo = new JComboBox();
	private JLabel label1 = new JLabel("Nombres de joueurs ? ");
	private JCheckBox check1 =new JCheckBox("Avec IA ? ");
	
	
	public Interface(){
		super();
		build();
	}
	private void build(){
		
		setTitle("Risk'Isep : Sublime Warfare III");
		setSize(1290, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(buildContentPane());
		
	

	}
	
	
	
	private JPanel buildContentPane() {
		container.setLayout(new BorderLayout());
		container.add(pan1, BorderLayout.CENTER);
		
		bouton.addActionListener(this);
		bouton2.addActionListener(this);
        
		JPanel south  = new JPanel();
		south.add(bouton);
		check1.addActionListener(new StateListener());

		// south.add(bouton2);
		container.add(south, BorderLayout.SOUTH);
		String[]tab= {"2 joueurs","3 joueurs","4 joueurs","5 joueurs","6 joueurs"};
		combo = new JComboBox(tab);
		combo.addItemListener(new ItemState());
		combo.addActionListener(new ItemAction());
		combo.setPreferredSize(new Dimension(100, 20));
		combo.setForeground(Color.blue);
		south.add(label1);
		south.add(combo);
		south.add(check1);
		container.add(south, BorderLayout.SOUTH);
/*
		//Définition d'une police d'écriture
		Font police = new Font("Tahoma", Font.BOLD, 16);
		//On l'applique au JLabel
		label.setFont(police);
		//Changement de la couleur du texte
		label.setForeground(Color.blue);
		//On modifie l'alignement du texte grâce aux attributs statiques
		//de la classe JLabel
		label.setHorizontalAlignment(JLabel.CENTER);

		container.add(label, BorderLayout.CENTER);
		*/
		
		
		setVisible(true);

		go();
		return container;
		
	}
	
	private JPanel buildContentPane1() {
		jeu.setLayout(new BorderLayout());
		jeu.add(pan, BorderLayout.CENTER);
	return jeu;	
	}
	class StateListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("source :"+((JCheckBox)e.getSource()).getText()+"etat:"+((JCheckBox)e.getSource()).isSelected());

		}
	}
	class ItemAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("ActionListener : action sur " + combo.getSelectedItem());
		}               
	}
	class ItemState implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			System.out.println("événement déclenché sur : " + e.getItem());
		}               
	}
	private void go() {
	}

	public void actionPerformed(ActionEvent arg0) {   
		if(arg0.getSource()==bouton)
		container.setVisible(false);
		setTitle("Risk'Isep :Sublime Warfare III");
		setSize(1600, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setContentPane(buildContentPane1());
		
	/*  if(arg0.getSource()==bouton)
		  this.compteur++;
		  label.setText("vous avez cliqué "+this.compteur+" !");
	 if(arg0.getSource()==bouton2)
		 this.compteur--;
	 label.setText("vous avez cliqué "+this.compteur+" !");
		*/ 
	} 






	class Panneau extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			try {


				Image img = ImageIO.read(new File("Carte.png"));
				g.drawImage(img, 0, 0,1280 ,600,this);
				// int x1 =500;
				// int y1=500;

				//g.fillOval(x1,y1,25,25);
			}catch(IOException e) {
				e.printStackTrace();
			}

		}		 
	}
	class Panneau1 extends JPanel{
		
		public void paintComponent(Graphics g) {

			
			try {


				Image img = ImageIO.read(new File("Risk_Accueil.png"));
				g.drawImage(img, 0, 0,1280 ,600,this);

			}catch(IOException e) {
				e.printStackTrace();
			}

		}		 

	}

	
	



	class Bouton extends JButton implements MouseListener{

		private String name;
		private Image img;


		public Bouton(String str){
			super(str);
			this.name = str;
			try {
				img = ImageIO.read(new File("105974.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.addMouseListener(this);
		}

		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D)g;
			GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20, Color.cyan, true);
			g2d.setPaint(gp);
			g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			g2d.setColor(Color.black);
			g2d.drawString(this.name, this.getWidth() / 2 - (this.getWidth() / 2 /4), (this.getHeight() / 2) + 5);
		}
		//Méthode appelée lors du clic de souris
		public void mouseClicked(MouseEvent event) {
			
		}

		//Méthode appelée lors du survol de la souris
		public void mouseEntered(MouseEvent event) {

		}

		//Méthode appelée lorsque la souris sort de la zone du bouton
		public void mouseExited(MouseEvent event) { }

		//Méthode appelée lorsque l'on presse le bouton gauche de la souris
		public void mousePressed(MouseEvent event) { }

		//Méthode appelée lorsque l'on relâche le clic de souris
		/*  public void mouseReleased(MouseEvent event) { 
			  if((event.getY() > 0 && event.getY() < this.getHeight()) && (event.getX() > 0 && event.getX() < this.getWidth())){
			  try {
			      img = ImageIO.read(new File("105974.png"));
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
			  }
			  else{
				    try {
				      img = ImageIO.read(new File("Carte.png"));
				    } catch (IOException e) {
				      e.printStackTrace();
				    }
			  }

		  }   
		*/  

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Image getImg() {
			return img;
		}

		public void setImg(Image img) {
			this.img = img;
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
