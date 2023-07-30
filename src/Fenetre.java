import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Fenetre extends JFrame {
	
	private static final long serialVersionUID = 1L;
private JMenuBar menuBar= new JMenuBar();
private JMenu fichier= new JMenu("Fichier"), aide=new JMenu("Aide");
JMenuItem mQuitter=new JMenuItem("Quitter"), mChoix=new JMenuItem("Choisir fichier/dossier"),
mDemarrer=new JMenuItem("Démarrer"),
mAide=new JMenuItem("?"),mAPropos=new JMenuItem("A propos");
JPanel panel=new JPanel();
JPanel[] panels={new JPanel(),new JPanel(),new JPanel(),new JPanel()};
JLabel labelChoix=new JLabel("Choisissez le dossier: "), labelSerie=new JLabel("Nom de la série: "),
labelModele=new JLabel("Modèle de sortie: "), labelTerminaison=new JLabel("Terminaison: ");
JTextField textChoix=new JTextField(), textSerie=new JTextField();
String[] str1={"S01E01","S1E1","saison 1 épisode 1"}, str2={"","FRENCH","VF","VO","VOSTFR"};
JComboBox<String> comboModele=new JComboBox<String>(str1), comboTerminaison=new JComboBox<String>(str2);
JButton btChoix=new JButton("..."), btDemarrer=new JButton("Démarrer");
JCheckBox check1=new JCheckBox("Remplacer les espaces par des points" +
		"                                              ");
String erreurs=""; File monFichier=new File("");


  public Fenetre()
  {
   this.setSize(600,300);
   this.setLocationRelativeTo(null);
   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
 this.initMenu();
 this.initComponents();
 this.initActionListeners();
 
   this.setVisible(true);
  }

private void initMenu()//mettre les éléments dans la barre de menu();
 { menuBar.add(fichier); menuBar.add(aide);
   fichier.add(mChoix); fichier.add(mDemarrer); fichier.add(mQuitter);
   aide.add(mAide); aide.add(mAPropos);
   fichier.setMnemonic('F'); aide.setMnemonic('I');
   mChoix.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.ALT_DOWN_MASK));
   mDemarrer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,KeyEvent.ALT_DOWN_MASK));
   mQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,KeyEvent.CTRL_DOWN_MASK));
   mAide.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,KeyEvent.ALT_DOWN_MASK));
   mAPropos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.ALT_DOWN_MASK));
   
   this.setJMenuBar(menuBar);
  
 }

private void initComponents() //mettre les composants dans la fenetre
 {	this.setContentPane(panel);
   panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
   for(JPanel pan:panels)
    {panel.add(pan);pan.setLayout(new FlowLayout());
    }
   
   panels[0].add(labelChoix);panels[0].add(textChoix);panels[0].add(btChoix);
   panels[1].add(labelSerie);panels[1].add(textSerie);panels[1].add(labelModele);panels[1].add(comboModele);
   panels[2].add(check1);panels[2].add(labelTerminaison);panels[2].add(comboTerminaison);
   panels[3].add(btDemarrer);
   textChoix.setPreferredSize(new Dimension(363,27)); textChoix.setEditable(false);
   textSerie.setPreferredSize(new Dimension(200,27));
 }

private void initActionListeners() //Ajout des ActionsListener
 { 
  mQuitter.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}});
  
  mAide.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
	JOptionPane.showMessageDialog(null, "Cet outil sert à renommer les épisodes d'une série " +
  "selon un format précis\n\n1- Choisissez le dossier contenant les épisodes de la série\n" +
  "2- Précisez le nom de la série, le modèle de sortie et la terminaison\n" +
  "3- Spécifiez si on doit remplacer les espaces par des points\n" +
  "4- Cliquez sur le bouton Démarrer, et le tour est joué!","Aide",JOptionPane.INFORMATION_MESSAGE);
			}});
  
  mAPropos.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
	JOptionPane.showMessageDialog(null, "Renommeur de séries\nRéalisé le 14 Novembre 2017\n\n" +
			"Copyright Aurel","A propos...",JOptionPane.INFORMATION_MESSAGE);
				}});
  
  ActionListener btChoixListener=new choixListener();
  btChoix.addActionListener(btChoixListener);
  mChoix.addActionListener(btChoixListener);
  ActionListener btDemarrerListener=new demarrerListener();
  btDemarrer.addActionListener(btDemarrerListener);
  mDemarrer.addActionListener(btDemarrerListener);
	
 }

public class choixListener implements ActionListener
  {
	public void actionPerformed(ActionEvent arg0) {
    JFileChooser chooser=new JFileChooser(new File("C:/Users/DJOUMESSI/Videos"));
    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    FileNameExtensionFilter filtre=new FileNameExtensionFilter("Fichiers vidéo","avi",
    "flv","mkv","mov","mp4","m4b","ts");
    chooser.setFileFilter(filtre);
    int returnVal = chooser.showOpenDialog(null);
    if(returnVal==JFileChooser.APPROVE_OPTION)
      { monFichier=chooser.getSelectedFile(); textChoix.setText(monFichier.getAbsolutePath());
    	
      }
    else{}
    
	}
	
  }

public class demarrerListener implements ActionListener
  {
	public void actionPerformed(ActionEvent arg0) {
 if(monFichier.exists())
  { if(textSerie.getText().equals("")){JOptionPane.showMessageDialog(null,"Vous devez renseigner le nom de la série!","Attention",JOptionPane.WARNING_MESSAGE);}
    else
    {   erreurs="";
    	renameSerie(monFichier);
    JOptionPane.showMessageDialog(null, "Terminé!");
    try {
    if(erreurs.length()>0)
      {	
    	FileWriter fw=new FileWriter((!monFichier.isDirectory()? monFichier.getParentFile() : monFichier)
				+File.separator+"Rapport_rnm.txt");
		fw.write(erreurs);
		fw.close();
      }
	} catch (IOException e) {
		e.printStackTrace();
	}
     textChoix.setText(""); monFichier=new File(""); erreurs="";
    }
  
  }
 else{JOptionPane.showMessageDialog(null,"Vous devez choisir un dossier ou un fichier!","Attention",JOptionPane.WARNING_MESSAGE);}
		
	}
	
  }


public int getSaison(String chemin,String modele)
{int pos=-1; String utile=chemin.toLowerCase(),utileFinal=""; int b1=-1, b2=-1;
 int saison=-1; 

 //modele=modele.toLowerCase()+" ";
 pos=utile.indexOf(modele);
 if(pos!=-1)
 {utile=utile.substring(pos); System.out.println(utile);
  try {utileFinal=utile.substring(modele.length(),modele.length()+2); System.out.println(utileFinal+"#"+utileFinal.length());}
  catch (Exception e1) {e1.printStackTrace();}
 try
  {b1=Integer.valueOf(String.valueOf(utileFinal.charAt(0))); b2=Integer.valueOf(String.valueOf(utileFinal.charAt(1)));
  }
 catch(Exception e){/*e.printStackTrace();*/}
 System.out.println(b1+"   "+b2);
 if(b1!=-1){saison= (b2==-1) ? b1:Integer.valueOf(utileFinal);}
 else { return getSaison(utile.substring(modele.length()),modele);}
 }
 else {}
return saison;
}

public int getSaison(String chemin)
{ String[] modeles={"saison ", "s", "saison","saison.", "season ", "season",
		 "season."};
	for(String str:modeles){int i=getSaison(chemin,str); if(i>0) return i;}
	this.erreurs+="ECHEC D'OBTENTION DE LA SAISON POUR: "+chemin+"\n";
	return -1;
}

public int getEpisode(String chemin)
{ String[] modeles={"épisode ", "episode ", "e", "épisode.", "episode.", "épisode", "episode", "episod ", "episod", "episod."};
	for(String str:modeles){int i=getSaison(chemin,str); if(i>0) return i;}
	this.erreurs+="ECHEC D'OBTENTION DE L'EPISODE POUR: "+chemin+"\n";
	return -1;
}

/* Voici les différents modes */
/*1: S01E01; 2: S1E1; 3: Saison1 épisode 1; 4: 1.01*/
public String getNomFinal(String chemin,int mode,String serie,boolean replaceSpaceByPoint,String terminaison)
{int saison=getSaison(chemin), episode=getEpisode(chemin); String nomFinal="";
if(saison>0&&episode>0)
 {
  String saison2=saison<10?"0"+saison:""+saison;
  String episode2=episode<10?"0"+episode:""+episode;
if(mode==1){nomFinal=serie+" S"+saison2+"E"+episode2;}
else if(mode==2){nomFinal=serie+" S"+saison+"E"+episode;}
else if(mode==3){nomFinal=serie+" saison "+saison+" épisode "+episode;}

 if(!terminaison.equals("")) nomFinal+=(" "+terminaison);
if(replaceSpaceByPoint) nomFinal=nomFinal.replace(" ",".");
return nomFinal;
 }

this.erreurs+="ECHEC D'OBTENTION DU NOM FINAL POUR: "+chemin+"\n";
return chemin;
}

public String getExtension(File fichier)
{String nomFichier=fichier.getName();
int i=nomFichier.lastIndexOf(".");
//si le fichier a une extension
if(i!=-1) return nomFichier.substring(i);

return "";
}

public void renameSerie(File f) //f peut être un fichier ou un dossier
{
 if(f.exists())
 {
  if(!f.isDirectory())
   { String nomFinal=getNomFinal(f.getName(),comboModele.getSelectedIndex()+1,
  textSerie.getText(),check1.isSelected(),comboTerminaison.getSelectedItem().toString());
   
     String extension=getExtension(f);
	   if(f.getName().equals(nomFinal))
		   System.out.println("Fichier ignoré :"+f.getName());
	   else if(f.getName().equals(nomFinal+extension)) 
		   System.out.println("Ce fichier correspond déjà : "+f.getName());
	   else f.renameTo(new File(f.getParentFile()+File.separator+
		    nomFinal+ extension)   );
	}
  
  else{for(File fichier:f.listFiles()) renameSerie(fichier);}
 }
 else System.out.println("Le fichier/dossier n'existe pas");
	
}



}
