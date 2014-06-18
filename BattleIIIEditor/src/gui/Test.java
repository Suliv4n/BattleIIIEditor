package gui;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Test extends JFrame implements ActionListener
{
  JButton efface = new JButton("efface");
  JButton demarre = new JButton("demarre");
  JCheckBox relief = new JCheckBox("relief");
  JCheckBox  gras = new JCheckBox("gras");
  JTextArea texte = new JTextArea();
  JPanel dessin = new JPanel();

  public Test()
  {
  	GridBagLayout  repartiteur = new GridBagLayout();
    GridBagConstraints contraintes;
    Container interieur = getContentPane();

    interieur.setLayout(repartiteur); 

    

    // pour la zone bleue en haut à gauche
    // on cree "une fiche technique"
    contraintes = new GridBagConstraints();
    // on remplit la "fiche technique"
    contraintes.gridx = 0;
    contraintes.gridy = 0;
    contraintes.gridwidth = 2;
    contraintes.gridheight = 2;
    contraintes.fill = GridBagConstraints.BOTH;
    contraintes.weightx = 1;
    contraintes.weighty = 1;
    // on attache la "fiche technique" au sous-composant
    repartiteur.setConstraints(dessin, contraintes);
    // on ajoute le sous-composant au compoant
    interieur.add(dessin); 
    dessin.setBackground(Color.blue);
 
    //pour le bouton "efface"
    contraintes = new GridBagConstraints();
    contraintes.gridx = 2;
    contraintes.gridy = 0;
    contraintes.anchor = GridBagConstraints.SOUTH;
    contraintes.insets = new Insets(10, 10, 10, 10);
    contraintes.ipady = 20;
    repartiteur.setConstraints(efface, contraintes);
    interieur.add(efface);

    

    //pour le bouton "demarre"
    contraintes = new GridBagConstraints();
    contraintes.gridx = 2;
    contraintes.gridy = 1;
    contraintes.gridwidth = 1;
    contraintes.gridheight = 1;
    contraintes.anchor = GridBagConstraints.NORTH;
    contraintes.insets = new Insets(10, 10, 10, 10);
    repartiteur.setConstraints(demarre, contraintes);
    interieur.add(demarre);

    //pour le bouton à cocher "relief"
    contraintes = new GridBagConstraints();
    contraintes.gridx = 0;
    contraintes.gridy = 2;
    contraintes.ipady = 20;
    repartiteur.setConstraints(relief, contraintes);
    interieur.add(relief);
  
    

    //pour le bouton à cocher "gras"
    contraintes = new GridBagConstraints();
    contraintes.gridx = 0;
    contraintes.gridy = 3;
    repartiteur.setConstraints(gras, contraintes);
    interieur.add(gras); 

    //pour le texte en bas à droite
    contraintes = new GridBagConstraints();
    contraintes.gridx = 1;
    contraintes.gridy = 2;
    contraintes.gridwidth = 2;
    contraintes.gridheight = 2;
    contraintes.fill = GridBagConstraints.BOTH;
    contraintes.weightx = 1;
    contraintes.weighty = 1;
    repartiteur.setConstraints(texte, contraintes);
    interieur.add(texte);
 
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 300);
    setVisible(true);
  }

@Override
public void actionPerformed(ActionEvent e) 
{

}

}
