import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Main {

	public static void main(String[] args) {

		//new Fenetre();
/*	String chemin="Teen wolf, Saison 6, Episode 2 (Version originale sous-titrée) en streaming - SkStream";
System.out.println("SAISON: "+getSaison(chemin)+" EPISODE: "+getEpisode(chemin));
System.out.println(getNomFinal(chemin,1,"Teen Wolf",true));
		System.out.println("#############################");
	chemin="How.to.Get.Away.with.Murder.S02E15.FiNAL.FRENCH.DVDRip.x264-SODAPOP";
System.out.println("SAISON: "+getSaison(chemin)+" EPISODE: "+getEpisode(chemin));
	System.out.println("#############################");
	chemin="Murder, Saison3, Episode 1 (Version française) en streaming - SkStream";
System.out.println("SAISON: "+getSaison(chemin)+" EPISODE: "+getEpisode(chemin));
  */
		
	/*	Path p=Paths.get("C:/Users/DJOUMESSI/Videos/How to get away with murder S03");
		System.out.println(Files.exists(p)+" "+Files.isDirectory(p));
		try(DirectoryStream<Path> listing = Files.newDirectoryStream(p,"*.m*")){
				for(Path nom : listing){
				System.out.println("\t"+ getExtension(nom.toFile())  );
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	/*boolean  test = p.toFile().renameTo(new File(p + "xyz"));
	System.out.println(test);*/
		
	/*File fichier=new File
	("C:/Users/DJOUMESSI/Videos/How to get away with murder S03");
	renameSerie(fichier); */
	//System.out.println(fichier.getParent()+File.separator+fichier.getName());
	try {
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (ClassNotFoundException | InstantiationException
			| IllegalAccessException | UnsupportedLookAndFeelException e) {
		e.printStackTrace();
	}
		
		new Fenetre();
		
	}
}

