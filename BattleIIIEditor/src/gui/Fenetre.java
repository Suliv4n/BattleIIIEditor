package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;


public class Fenetre extends JFrame implements ActionListener
{
	private static final long serialVersionUID = -873367703458180262L;

	private static FileFilter imageFilter;
	
	//--MENU----------------
	private JMenuBar menu;
	private JMenu donnees;
	
	private JMenu arme;
	private JMenu armure;
	private JMenu skill;
	private JMenu ennemi;
	
	private JMenuItem modifierArme;
	private JMenuItem ajouterArme;
	
	private JMenuItem modifierArmure;
	private JMenuItem ajouterArmure;
	
	private JMenuItem modifierSkill;
	private JMenuItem ajouterSkill;
	
	private JMenuItem modifierEnnemi;
	private JMenuItem ajouterEnnemi;
	
	
	//--PANEL---------------
	private JPanel panArme;
	private JPanel panArmure;
	private JPanel panSkill;
	private JPanel panEnnemi;
	
	
	//--ARME----------------
	private JPanel previewArme;
	
	private JLabel labIdArme;
	private JTextField idArme;
	private JButton verifierIdArme;
	
	private JLabel labIdImgArme;
	private JFormattedTextField idImgArme;
	private JButton updateImgArme;
	
	private JLabel labNomArme;
	private JTextField nomArme;
	
	private JLabel labTypeArme;
	private JComboBox<String> typeArme;
	
	private JLabel labAtqPhyArme;
	private JFormattedTextField atqPhyArme;

	private JLabel labAtqMagArme;
	private JFormattedTextField atqMagArme;

	private JLabel labDefPhyArme;
	private JFormattedTextField defPhyArme;

	private JLabel labDefMagArme;
	private JFormattedTextField defMagArme;
	
	private JLabel labPathImgArme;
	private JTextField pathImgArme;
	
	private JLabel labRelativPathImgArme;
	private JTextField relativPathImgArme;
	
	private JButton imgPathButtonArme;
	
	private JFileChooser imageChooserArme;
	
	private JButton ajouterBoutonArme;
	private JButton modifierBoutonArme;
	private JButton supprimerBoutonArme;
	
	//-------------------------------------------
	
	//--------------------ARMURE-----------------
	
	private JPanel previewArmure;
	
	private JLabel labIdArmure;
	private JTextField idArmure;
	private JButton verifierIdArmure;
	
	
	private JLabel labNomArmure;
	private JTextField nomArmure;
	
	private JLabel labTypeArmure;
	private JComboBox<String> typeArmure;
	
	private JLabel labEmplacementArmure;
	private JComboBox<String> emplacementArmure;
	
	private JLabel labPathImageArmure;
	private JTextField pathImageArmure;
	private JButton imgPathButtonArmure;
	
	private JLabel labRelativPathImgArmure;
	private JTextField relativPathImgArmure;
	
	private JLabel labIdImgArmure;
	private JFormattedTextField idImgArmure;
	private JButton updateImageArmure;
	
	private JLabel labDefPhyArmure;
	private JFormattedTextField defPhyArmure;
	
	private JLabel labDefMagArmure;
	private JFormattedTextField defMagArmure;
	
	private JButton ajouterBoutonArmure;
	private JButton modifierBoutonArmure;
	private JButton supprimerBoutonArmure;
	
	//-------------------------------------------
	public Fenetre()
	{
		
		super("Battle III - Editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(new Dimension(600,600));
		setLocationRelativeTo(null);
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
		
		menu = new JMenuBar();
		donnees = new JMenu("Donnees");
		
		arme = new JMenu("Arme");
		armure = new JMenu("Armure");
		skill = new JMenu("Skill");
		ennemi = new JMenu("Ennemi");
		
		ajouterArme = new JMenuItem("Nouveau");
		modifierArme = new JMenuItem("Modifier");
		arme.add(ajouterArme);
		arme.add(modifierArme);
		
		ajouterArmure = new JMenuItem("Nouveau");
		modifierArmure = new JMenuItem("Modifier");
		armure.add(ajouterArmure);
		armure.add(modifierArmure);
		
		ajouterSkill = new JMenuItem("Nouveau");
		modifierSkill = new JMenuItem("Modifier");
		skill.add(ajouterSkill);
		skill.add(modifierSkill);
		
		ajouterEnnemi = new JMenuItem("Nouveau");
		modifierEnnemi = new JMenuItem("Modifier");
		ennemi.add(ajouterEnnemi);
		ennemi.add(modifierEnnemi);
		
		donnees.add(arme);
		donnees.add(armure);
		donnees.add(skill);
		donnees.add(ennemi);
		
		menu.add(donnees);
		
		buildPanelArme();
		buildPanelArmure();
        
		setJMenuBar(menu);
		add(panArme);
		add(panArmure);
		panArme.setVisible(true);
		
		pack();
	}
	
	
	
	private void buildPanelArme()
	{
		panArme = new JPanel();
        panArme.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Arme"));
        panArme.setLayout(new FlowLayout());
        
        JPanel p0 = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p10 = new JPanel();
        JPanel p11 = new JPanel();
        JPanel p12 = new JPanel();
        JPanel p13 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        
        previewArme = new JPanel();
        previewArme.setPreferredSize(new Dimension(32,32));
        previewArme.setBackground(Color.red);
        
        /*
        p1.setBackground(Color.blue);
        p2.setBackground(Color.red);
        p3.setBackground(Color.yellow);
        p4.setBackground(Color.pink);
        p5.setBackground(Color.green);
        */
        
        imageChooserArme = new JFileChooser("Sélectionner une image :");
        imageChooserArme.setFileFilter(imageFilter);
        imageChooserArme.setApproveButtonText("Sélectionner");
        
        p0.setLayout(new FlowLayout(FlowLayout.LEFT));
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        p10.setLayout(new FlowLayout(FlowLayout.LEFT));
        p11.setLayout(new FlowLayout(FlowLayout.LEFT));
        p12.setLayout(new FlowLayout(FlowLayout.LEFT));
        p13.setLayout(new FlowLayout(FlowLayout.LEFT));
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p3.setLayout(new FlowLayout(FlowLayout.LEFT));
        p4.setLayout(new FlowLayout(FlowLayout.LEFT));
        p5.setLayout(new FlowLayout(FlowLayout.LEFT));
        p6.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        GridBagLayout gbl = new GridBagLayout();
        panArme.setLayout(gbl);
        
        
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panArme.add(previewArme,gbc);
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panArme.add(p0,gbc);
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        //gbc.fill = GridBagConstraints.EAST;
        //gbc.weightx = 1;
        //gbc.weighty = 1;
        panArme.add(p1,gbc);
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 3;
        //gbc.fill = GridBagConstraints.BOTH;
        panArme.add(p10,gbc);
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 4;
        //gbc.fill = GridBagConstraints.BOTH;
        panArme.add(p11,gbc);
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 5;
        //gbc.fill = GridBagConstraints.BOTH;
        panArme.add(p12,gbc);
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 6;      
        //gbc.fill = GridBagConstraints.BOTH;
        panArme.add(p13,gbc);
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 7;      
        //gbc.fill = GridBagConstraints.BOTH;
        panArme.add(p2,gbc);
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weightx = 1;
        //gbc.fill = GridBagConstraints.BOTH;
        panArme.add(p3,gbc);
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.weightx = 1;
        //gbc.fill = GridBagConstraints.BOTH;
        panArme.add(p4,gbc);
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.weightx = 1;
        //gbc.fill = GridBagConstraints.BOTH;
        panArme.add(p5,gbc);
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.weightx = 1;
        //gbc.fill = GridBagConstraints.BOTH;
        panArme.add(p6,gbc);
        
        labIdArme = new JLabel("ID : ");
        labNomArme = new JLabel("Nom : ");
        labTypeArme = new JLabel("Type : ");
        labAtqPhyArme = new JLabel("Attaque physique : ");
        labAtqMagArme = new JLabel("Attaque magique : ");
        labDefPhyArme = new JLabel("Défense physique : ");
        labDefMagArme = new JLabel("Défense magique : ");
        labPathImgArme = new JLabel("Image : ");
        labRelativPathImgArme = new JLabel("Chemin relatif de l'image :");
        labIdImgArme = new JLabel("ID image : ");
        
        
        
        NumberFormat mask = null;
		mask = NumberFormat.getIntegerInstance();
		mask.setMaximumIntegerDigits(5);
		mask.setMinimumIntegerDigits(1);
		mask.setParseIntegerOnly(true);
		
		idArme = new JTextField(5);
		verifierIdArme = new JButton("Vérifier");
		nomArme = new JTextField(20);
		String[] types = {"Arc", "Bâton", "Bouclier", "Epée", "Hache", "Marteau"};
		typeArme = new JComboBox<String>(types);
        atqPhyArme = new JFormattedTextField(mask);        
        atqPhyArme.setColumns(5);
        atqPhyArme.setValue(0);
        atqMagArme = new JFormattedTextField(mask);
        atqMagArme.setColumns(5);
        atqMagArme.setValue(0);
        defPhyArme = new JFormattedTextField(mask);
        defPhyArme.setColumns(5);
        defPhyArme.setValue(0);
        defMagArme = new JFormattedTextField(mask);
        defMagArme.setColumns(5);
        defMagArme.setValue(0);
        pathImgArme = new JTextField(30);
        imgPathButtonArme = new JButton("...");
        imgPathButtonArme.addActionListener(this);
        relativPathImgArme = new JTextField(20);
        idImgArme = new JFormattedTextField(mask);
        idImgArme.setColumns(3);
        updateImgArme = new JButton("Mise à jour de l'aperçu");
        updateImgArme.addActionListener(this);
        
        ajouterBoutonArme = new JButton("Ajouter");
        modifierBoutonArme = new JButton("Modifier");
        supprimerBoutonArme = new JButton("Supprimer");
        
        p0.add(labIdArme);
        p0.add(idArme);
        p0.add(verifierIdArme);
        p1.add(labNomArme);
        p1.add(nomArme);
        p10.add(labTypeArme);
        p10.add(typeArme);
        p11.add(labPathImgArme);
        p11.add(pathImgArme);
        p11.add(imgPathButtonArme);
        p12.add(labRelativPathImgArme);
        p12.add(relativPathImgArme);
        p13.add(labIdImgArme);
        p13.add(idImgArme);
        p13.add(updateImgArme);
        p2.add(labAtqPhyArme);
        p2.add(atqPhyArme);
        p3.add(labAtqMagArme);
        p3.add(atqMagArme);
        p4.add(labDefPhyArme);
        p4.add(defPhyArme);
        p5.add(labDefMagArme);
        p5.add(defMagArme);
        p6.add(ajouterBoutonArme);
        p6.add(modifierBoutonArme);
        p6.add(supprimerBoutonArme);
        
        
/*
        panArme.add(p1);
        panArme.add(p2);
        panArme.add(p3);
        panArme.add(p4);
        panArme.add(p5);
*/
	}

	
	private void buildPanelArmure()
	{
		panArmure = new JPanel();
		panArmure.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Armure"));
		

        
        previewArmure = new JPanel();        
        previewArmure.setPreferredSize(new Dimension(32,32));
        previewArmure.setBackground(Color.red);
        
        JPanel p1 = new JPanel(); //id
        JPanel p2 = new JPanel(); //nom
        JPanel p20 = new JPanel(); //type
        JPanel p21 = new JPanel(); //emplacement
        JPanel p3 = new JPanel(); //path img
        JPanel p4 = new JPanel(); //relativ path
        JPanel p5 = new JPanel(); //id path + bouton update
        JPanel p6 = new JPanel(); //def phy
        JPanel p7 = new JPanel(); //def mag
        JPanel p8 = new JPanel(); //boutons
        
        NumberFormat mask = null;
		mask = NumberFormat.getIntegerInstance();
		mask.setMaximumIntegerDigits(5);
		mask.setMinimumIntegerDigits(1);
		mask.setParseIntegerOnly(true);
		
        labIdArmure = new JLabel("ID : ");
        labNomArmure = new JLabel("Nom : ");
        labTypeArmure = new JLabel("Type : ");
        labEmplacementArmure = new JLabel("Emplacement : ");
        labPathImageArmure = new JLabel("Image : ");
        labRelativPathImgArmure = new JLabel("Chemin relatif de l'image : ");
        labIdImgArmure = new JLabel("ID Image : ");
        labDefPhyArmure = new JLabel("Défense physique : ");
        labDefMagArmure = new JLabel("Défense magique : ");
        
        
        
        idArmure = new JTextField(5);
        verifierIdArmure = new JButton("Vérifier");
        nomArmure = new JTextField(20);
        String[] types = {"Cuir", "Mailles", "Tissu"};
        typeArmure = new JComboBox<String>(types);
        String[] emplacements = {"Main", "Bas", "Haut", "Tête"};
        emplacementArmure = new JComboBox<String>(emplacements);
        pathImageArmure = new JTextField(30);
        imgPathButtonArmure = new JButton("...");
        relativPathImgArmure = new JTextField(20);
        idImgArmure = new JFormattedTextField(mask);
        idImgArmure.setColumns(3);
        updateImageArmure = new JButton("Mise à jour de l'aperçu");
        defPhyArmure = new JFormattedTextField(mask);
        defPhyArmure.setColumns(5);
        defMagArmure = new JFormattedTextField(mask);
        defMagArmure.setColumns(5);
        ajouterBoutonArmure = new JButton("Ajouter");
        modifierBoutonArmure = new JButton("Modifier");
        supprimerBoutonArmure = new JButton("Supprimer");
        
        p1.add(labIdArmure);
        p1.add(idArmure);
        p1.add(verifierIdArmure);
        p2.add(labNomArmure);
        p2.add(nomArmure);
        p20.add(labTypeArmure);
        p20.add(typeArmure);
        p21.add(labEmplacementArmure);
        p21.add(emplacementArmure);
        p3.add(labPathImageArmure);
        p3.add(pathImageArmure);
        p4.add(labRelativPathImgArmure);
        p4.add(relativPathImgArmure);
        p5.add(labIdImgArmure);
        p5.add(idImgArmure);
        p5.add(updateImageArmure);
        p6.add(labDefPhyArmure);
        p6.add(defPhyArmure);
        p7.add(labDefMagArmure);
        p7.add(defMagArmure);
        p8.add(ajouterBoutonArmure);
        p8.add(modifierBoutonArmure);
        p8.add(supprimerBoutonArmure);
        
        GridBagLayout gbl = new GridBagLayout();
        panArmure.setLayout(gbl);
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panArmure.add(previewArmure,gbc);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panArmure.add(p1,gbc);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panArmure.add(p2,gbc);
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panArmure.add(p20,gbc);
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        panArmure.add(p21,gbc);
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        panArmure.add(p3,gbc);
	
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        panArmure.add(p4,gbc);
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        panArmure.add(p5,gbc);
	
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        panArmure.add(p6,gbc);
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        panArmure.add(p7,gbc);
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.WEST;
        panArmure.add(p8,gbc);
        
        //$$01
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
			if(e.getSource().equals(imgPathButtonArme))
			{
				if(imageChooserArme.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
				{
					pathImgArme.setText(imageChooserArme.getSelectedFile().getAbsolutePath());
					relativPathImgArme.setText("ressources/images/"+imageChooserArme.getSelectedFile().getName());
				}
			}
			else if(e.getSource().equals(updateImgArme))
			{
				BufferedImage img = null;
				try 
				{
				    img = ImageIO.read(new File(pathImgArme.getText()));	
				    int id = Integer.parseInt(idImgArme.getText());
				    int x = id%15;
				    System.out.println(id + " " + x);
				    int y = (int) (id/15);
				    img = img.getSubimage(x*33+1, y*33+1, 32, 32);
					previewArme.getGraphics().drawImage(img,0,0,null);
				} 
				catch (IOException exc) 
				{
					exc.printStackTrace();
				}				
			}
	}


	public static void init()
	{

			imageFilter = new FileFilter() {
				
				@Override
				public String getDescription() {
					return "Image png jpg gif.";
				}
				
				@Override
				public boolean accept(File arg0) {
					ArrayList<String> extensions = new ArrayList<String>();
					extensions.add("png");
					extensions.add("jpg");
					extensions.add("gif");
					
					if(arg0.getName().contains("."))
					{
						String[] parties = arg0.getName().split("\\.");
						String extension = parties[1];
						return extensions.contains(extension);
					}
					else
					{
						return true;
					}
				}
			};
	}
}
