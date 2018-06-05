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


				Image img = ImageIO.read(new File("Risk'isep_country_id.png"));
				g.drawImage(img, 0, 0,1280 ,600,this);
					//NA
				int x20=65;
				int y20=80;
				int x25=170;
				int y25=81;
				int x21=150;
				int y21=120;
				int x26=197;
				int y26=125;
				int x27=285;
				int y27=123;
				int x28=145;
				int y28=190;
				int x23=230;
				int y23=195;
				int x22=152;
				int y22=270;	
				int x24=360;
				int y24=50;
				g.fillOval(x20,y20,20,20);
				g.fillOval(x25,y25,20,20);
				g.fillOval(x21,y21,20,20);
				g.fillOval(x26,y26,20,20);
				g.fillOval(x27,y27,20,20);
				g.fillOval(x28,y28,20,20);
				g.fillOval(x23,y23,20,20);
				g.fillOval(x21,y21,20,20);
				g.fillOval(x22,y22,20,20);
				g.fillOval(x24,y24,20,20);
				//SA
				int x30=320;
				int y30=390;
				int x29=255;
				int y29=487;
				int x31=225;
				int y31=405;
				int x32=223;
				int y32=322;
				g.fillOval(x30,y30,20,20);
				g.fillOval(x29,y29,20,20);
				g.fillOval(x31,y31,20,20);
				g.fillOval(x32,y32,20,20);
				//Europe
				int x2=464;
				int y2=105;
				int x5=530;
				int y5=240;
				int x1=413;
				int y1=173;
				int x6=595;
				int y6=165;
				int x7=455;
				int y7=235;
				int x3=520;
				int y3=185;
				int x4=525;
				int y4=100;
				g.fillOval(x2,y2,17,17);
				g.fillOval(x5,y5,20,20);
				g.fillOval(x1,y1,20,20);
				g.fillOval(x6,y6,20,20);
				g.fillOval(x7,y7,20,20);
				g.fillOval(x4,y4,20,20);
				g.fillOval(x3,y3,20,20);
				//Afrique
				
				int x37=468;
				int y37=350;
				int x35=563;
				int y35=340;
				int x34=620;
				int y34=400;
				int x33=570;
				int y33=440;
				int x38=580;
				int y38=515;
				int x36=680;
				int y36=525;
				g.fillOval(x37,y37,20,20);
				g.fillOval(x35,y35,20,20);
				g.fillOval(x34,y34,20,20);
				g.fillOval(x33,y33,20,20);
				g.fillOval(x38,y38,20,20);
				g.fillOval(x36,y36,17,17);
				//Asie
				int x12=998;
				int y12=200;
				int x15=900;
				int y15=190;
				int x11=870;
				int y11=135;
				int x16=875;
				int y16=330;
				int x17=800;
				int y17=100;
				int x18=730;
				int y18=120;
				int x13=950;
				int y13=60;
				int x14=650;
				int y14=300;	
				int x10=780;
				int y10=310;
				int x8=710;
				int y8=200;
				int x9=840;
				int y9=250;
				int x19=885;
				int y19=50;
				g.fillOval(x12,y12,20,20);
				g.fillOval(x15,y15,20,20);
				g.fillOval(x11,y11,20,20);
				g.fillOval(x16,y16,20,20);
				g.fillOval(x17,y17,20,20);
				g.fillOval(x18,y18,20,20);
				g.fillOval(x13,y13,20,20);
				g.fillOval(x14,y14,20,20);
				g.fillOval(x10,y10,20,20);
				g.fillOval(x8,y8,20,20);
				g.fillOval(x9,y9,20,20);
				g.fillOval(x19,y19,20,20);
			    //Oceanie 
				int x40=890;
				int y40=430;
				int x41=980;
				int y41=410;
				int x42=940;
				int y42=520;
				int x39=1020;
				int y39=500;
				g.fillOval(x40,y40,20,20);
				g.fillOval(x41,y41,20,20);
				g.fillOval(x42,y42,20,20);
				g.fillOval(x39,y39,20,20);
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
