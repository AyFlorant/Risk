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
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;


public class Interface extends JFrame implements ActionListener {
	private Panneau pan = new Panneau();
	private Panneau1 pan1 =new Panneau1();
	private Bouton bouton = new Bouton("JOUER");
	private Bouton buton = new Bouton("Fin du tour");
	private JPanel container = new JPanel();
	private JPanel jeu = new JPanel();
	private JLabel label = new JLabel("Risk'Isep : Sublime Wafare IIII");
	//private int compteur=0;
	public JComboBox combo = new JComboBox();
	private JLabel label1 = new JLabel("Nombres de joueurs ? ");
	private JCheckBox check1 =new JCheckBox("Avec IA ? ");
	final JTextArea textArea = new JTextArea();
	 
	
	
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
		
		JPanel south  = new JPanel();
		south.add(bouton);
		check1.addActionListener(new StateListener());

		
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
		 class TextAreaOutputStreamTest extends JPanel {

			   public JTextArea textArea = new JTextArea(15, 30);
			   public TextAreaOutputStream taOutputStream = new TextAreaOutputStream(
			         textArea, "Console");

			   public TextAreaOutputStreamTest() {
			      setLayout(new BorderLayout());
			      add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
			            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
			      System.setOut(new PrintStream(taOutputStream));
			     
			   }
	}
			  
		 buton.addActionListener(new ActionListener() {

		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	
		          //  for(String a: textArea.getText().split("\\n"))
		            //	textArea.append(a);
						

		        }
		    });
		 
		
		jeu.setLayout(new BorderLayout());
		jeu.add(pan);
		jeu.add(buton,BorderLayout.WEST);
		JTable tableau = new JTable(new ModeleStatique());
		jeu.add(new JScrollPane(tableau),BorderLayout.EAST);
		jeu.add(new TextAreaOutputStreamTest(),BorderLayout.SOUTH);
		
		
	
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
		

	} 
	




	
	

		
	

	class Panneau extends JPanel implements MouseListener{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Panneau() {
			 this.addMouseListener(this);    
		}
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
		Ellipse2D oval1 = new Ellipse2D.Double(x1, y1, 20, 20);
		Ellipse2D oval2 = new Ellipse2D.Double(x2, y2, 17, 17);
		Ellipse2D oval3 = new Ellipse2D.Double(x3, y3, 20, 20);
		Ellipse2D oval4 = new Ellipse2D.Double(x4, y4, 20, 20);
		Ellipse2D oval5 = new Ellipse2D.Double(x5, y5, 20, 20);
		Ellipse2D oval6 = new Ellipse2D.Double(x6, y6, 20, 20);
		Ellipse2D oval7 = new Ellipse2D.Double(x7, y7, 20, 20);
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
		
		
		Ellipse2D oval8 = new Ellipse2D.Double(x8, y8, 20, 20);
		Ellipse2D oval9 = new Ellipse2D.Double(x9, y9, 20, 20);
		Ellipse2D oval10 = new Ellipse2D.Double(x10, y10, 20, 20);
		Ellipse2D oval11 = new Ellipse2D.Double(x11, y11, 20, 20);
		Ellipse2D oval12 = new Ellipse2D.Double(x12, y12, 20, 20);
		Ellipse2D oval13 = new Ellipse2D.Double(x13, y13, 20, 20);
		Ellipse2D oval14 = new Ellipse2D.Double(x14, y14, 20, 20);
		Ellipse2D oval15 = new Ellipse2D.Double(x15, y15, 20, 20);
		Ellipse2D oval16 = new Ellipse2D.Double(x16, y16, 20, 20);
		Ellipse2D oval17 = new Ellipse2D.Double(x17, y17, 20, 20);
		Ellipse2D oval18 = new Ellipse2D.Double(x18, y18, 20, 20);
		Ellipse2D oval19 = new Ellipse2D.Double(x19, y19, 20, 20);
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
		Ellipse2D oval20 = new Ellipse2D.Double(x20, y20, 20, 20);
		Ellipse2D oval21 = new Ellipse2D.Double(x21, y21, 20, 20);
		Ellipse2D oval22 = new Ellipse2D.Double(x22, y22, 20, 20);
		Ellipse2D oval23 = new Ellipse2D.Double(x23, y23, 20, 20);
		Ellipse2D oval24 = new Ellipse2D.Double(x24, y24, 20, 20);
		Ellipse2D oval25 = new Ellipse2D.Double(x25, y25, 20, 20);
		Ellipse2D oval26 = new Ellipse2D.Double(x26, y26, 20, 20);
		Ellipse2D oval27 = new Ellipse2D.Double(x27, y27, 20, 20);
		Ellipse2D oval28 = new Ellipse2D.Double(x28, y28, 20, 20);
	
	
		//SA
		int x30=320;
		int y30=390;
		int x29=255;
		int y29=487;
		int x31=225;
		int y31=405;
		int x32=223;
		int y32=322;
		Ellipse2D oval29 = new Ellipse2D.Double(x29, y29, 20, 20);
		Ellipse2D oval30 = new Ellipse2D.Double(x30, y30, 20, 20);
		Ellipse2D oval31 = new Ellipse2D.Double(x31, y31, 20, 20);
		Ellipse2D oval32 = new Ellipse2D.Double(x32, y32, 20, 20);
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
		Ellipse2D oval33 = new Ellipse2D.Double(x33, y33, 20, 20);
		Ellipse2D oval34 = new Ellipse2D.Double(x34, y34, 20, 20);
		Ellipse2D oval35 = new Ellipse2D.Double(x35, y35, 20, 20);
		Ellipse2D oval36 = new Ellipse2D.Double(x36, y36, 20, 20);
		Ellipse2D oval37 = new Ellipse2D.Double(x37, y37, 20, 20);
		Ellipse2D oval38 = new Ellipse2D.Double(x38, y38, 20, 20);
		   //Oceanie 
		int x40=890;
		int y40=430;
		int x41=980;
		int y41=410;
		int x42=940;
		int y42=520;
		int x39=1020;
		int y39=500;
		Ellipse2D oval39 = new Ellipse2D.Double(x39, y39, 20, 20);
		Ellipse2D oval40 = new Ellipse2D.Double(x40, y40, 20, 20);
		Ellipse2D oval41 = new Ellipse2D.Double(x41, y41, 20, 20);
		Ellipse2D oval42 = new Ellipse2D.Double(x42, y42, 20, 20);
	
		public void paintComponent(Graphics g) {
			
			try {
				Graphics2D g2d = (Graphics2D) g ;
				g2d.draw(oval1);
				
				Image img = ImageIO.read(new File("Risk'isep_country_id.png"));
				g2d.drawImage(img, 0, 0,1280 ,600,this);
				
				
				
				//NA
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
				g.fillOval(x30,y30,20,20);
				g.fillOval(x29,y29,20,20);
				g.fillOval(x31,y31,20,20);
				g.fillOval(x32,y32,20,20);
				//Europe
				g.fillOval(x2,y2,17,17);
				g.fillOval(x5,y5,20,20);
				g.fillOval(x1,y1,20,20);
				g.fillOval(x6,y6,20,20);
				g.fillOval(x7,y7,20,20);
				g.fillOval(x4,y4,20,20);
				g.fillOval(x3,y3,20,20);
				//Afrique
				g.fillOval(x37,y37,20,20);
				g.fillOval(x35,y35,20,20);
				g.fillOval(x34,y34,20,20);
				g.fillOval(x33,y33,20,20);
				g.fillOval(x38,y38,20,20);
				g.fillOval(x36,y36,17,17);
				//Asie
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
				g.fillOval(x40,y40,20,20);
				g.fillOval(x41,y41,20,20);
				g.fillOval(x42,y42,20,20);
				g.fillOval(x39,y39,20,20);
				
			}catch(IOException e) {
				e.printStackTrace();
			}

		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (oval1.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui1");
	        }
			if (oval2.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui2");
	        }
			
			if (oval3.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui3");
	        }
			
			if (oval4.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui4");
	        }
			
			if (oval5.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui5");
	        }
			
			if (oval6.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui6");
	        }
			
			if (oval7.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui7");
	        }
			
			if (oval8.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui8");
	        }
			
			if (oval9.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui9");
	        }
			
			if (oval10.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui10");
	        }
			
			if (oval11.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui11");
	        }
			
			if (oval12.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui12");
	        }
			
			if (oval13.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui13");
	        }
			
			if (oval14.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui14");
	        }
			
			if (oval15.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui15");
	        }
			
			if (oval16.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui16");
	        }
			
			if (oval17.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui17");
	        }
			
			if (oval18.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui18");
	        }
			
			if (oval18.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui18");
	        }
			
			if (oval19.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui19");
	        }
			
			if (oval20.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui20");
	        }
			
			if (oval21.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui21");
	        }
			
			if (oval22.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui22");
	        }
			
			if (oval23.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui23");
	        }
			
			if (oval24.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui24");
	        }
			
			if (oval25.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui25");
	        }
			
			if (oval26.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui26");
	        }
			
			if (oval27.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui27");
	        }
			
			if (oval28.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui28");
	        }
			
			if (oval29.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui29");
	        }
			
			if (oval30.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui30");
	        }
			
			if (oval31.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui31");
	        }
			
			if (oval32.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui32");
	        }
			
			if (oval33.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui33");
	        }
			
			if (oval34.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui34");
			}
			
			if (oval35.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui35");
			}
			
			if (oval36.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui36");
			}
			
			if (oval37.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui37");
			}
			
			if (oval38.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui38");
			}

			if (oval39.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui39");
			}
			
			if (oval40.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui40");
			}
			
			
			if (oval41.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui41");
			}
			
			
			if (oval42.contains(e.getX(), e.getY()) ) {
	            System.out.println("Oui42");
			}
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			if (oval1.contains(e.getX(), e.getY()) ) {
	            System.out.println("Non");
	        }
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
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
			g2d.drawString(this.name, 20 , (this.getHeight() / 2) + 5);
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
	public class ModeleStatique extends AbstractTableModel {
	    private final ArrayList<Joueur> joueur = new ArrayList<Joueur>();
	 
	    private final String[] entetes = {"Name", "ID", "Unites", "Country"};
	 
	    public ModeleStatique() {
	        super();
	 
	        
	                joueur.add(new Joueur("Joueur1",1,null,null));
	                joueur.add(new Joueur("Joueur2",2,null,null));
	       
	    }
	 
	    public int getRowCount() {
	        return joueur.size();
	    } 
	 
	    public int getColumnCount() {
	        return entetes.length;
	    }
	 
	    public String getColumnName(int columnIndex) {
	        return entetes[columnIndex];
	    }
	 
	    public Object getValueAt(int rowIndex, int columnIndex) {
	    	switch(columnIndex){
	    	case 0:
	            return joueur.get(rowIndex).getPlayer_name();
            case 1:
                return joueur.get(rowIndex).getPlayer_id();
         
            case 2:
                return joueur.get(rowIndex).getOwnedCountries();
            case 3:
                return joueur.get(rowIndex).getUnites();
                
            default:
	        return null; //Ne devrait jamais arriver
	       
	        
	    }
	  }
	 
	}
	public enum Unite{
		Soldat,
		Canon,
		Cavalier,
		RIEN;
	}
	
	class TextAreaOutputStream extends OutputStream {

		   public final JTextArea textArea;
		   public final StringBuilder sb = new StringBuilder();
		   public String title;

		   public TextAreaOutputStream(final JTextArea textArea, String title) {
		      this.textArea = textArea;
		      this.title = title;
		      sb.append(title + "> ");
		   }

		   @Override
		   public void flush() {
		   }

		   @Override
		   public void close() {
		   }

		   @Override
		   public void write(int b) throws IOException {

		      if (b == '\r')
		         return;

		      if (b == '\n') {
		         final String text = sb.toString() + "\n";
		         SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		               textArea.append(text);
		            }
		         });
		         sb.setLength(0);
		         sb.append(title + "> ");
		         return;
		      }

		      sb.append((char) b);
		   }
		   
		}
	
	}
