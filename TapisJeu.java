package coursesDeChevaux;

public class TapisJeu {
	
	Posable [] rouge = new Posable[80];
	Posable [] bleu = new Posable[80];
	Posable [] jaune = new Posable[80];
	Cheval rougeChe = new Cheval("rouge");
	Cheval bleuChe = new Cheval("bleu");
	Cheval jauneChe = new Cheval("jaune");
	
	boolean gagnant;
	
	public TapisJeu(){
		rouge[0] = rougeChe;
		bleu[0] =bleuChe;
		jaune[0]=jauneChe;
		
		for(int i=1;i<rouge.length-1;i++){
			rouge[i]=new Vide();
			jaune[i]=new Vide();
			bleu[i]=new Vide();
		}
		rouge[79]= new Final();
		jaune[79]= new Final();
		bleu[79]= new Final();
	}
	
	public void tourDeJeu() throws Exception{
		int r =lancerDe()+trouverRouge();
		int b= lancerDe()+trouverBleu();
		int j =lancerDe() +trouverJaune();
		
		if(r>79 || b>79 || j>79){
			gagnant(r,b,j);
			return;
		}
		
		rouge[trouverRouge()]= new Vide();
		jaune[trouverJaune()] = new Vide();
		bleu[trouverBleu()] =  new Vide();
		
		rouge[r] = rougeChe;
		bleu[b]=bleuChe;
		jaune[j]=jauneChe;
		
		affiche();
	}
	
	public void affiche(){
		for(int i=0; i<rouge.length;i++){
			System.out.print(rouge[i].toString());
		}
		System.out.println("");
		for(int i=0; i<jaune.length;i++){
			System.out.print(jaune[i].toString());
		}
		System.out.println("");
		for(int i=0; i<rouge.length;i++){
			System.out.print(bleu[i].toString());
		}
		System.out.println("");
	}
	
	public boolean gagnant(int r,int b,int j){
		if(r>79){
			System.out.println("Rouge est le gagnant");
		}
		if(b>79){
			System.out.println("Bleu est le gagnant");
		}
		if(j>79){
			System.out.println("Jaune est le gagnant");
		}
		return this.gagnant = true;
	}
	public int trouverRouge() throws Exception{
		for(int i=0;i<rouge.length; i++){
			if(rouge[i]==rougeChe){
				return i;
			}
		}
		 throw new Exception();
	}
	public int trouverBleu() throws Exception{
		for(int i=0;i<bleu.length; i++){
			if(bleu[i]==bleuChe){
				return i;
			}
		}
		 throw new Exception();
	}
	public int trouverJaune() throws Exception{
		for(int i=0;i<jaune.length; i++){
			if(jaune[i]==jauneChe){
				return i;
			}
		}
		 throw new Exception();
	}
	public boolean getGagnant(){
		return gagnant;
	}
	static int lancerDe(){
		return (int)( Math.random()*6 +1) ;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TapisJeu nouveau = new TapisJeu();
		System.out.print("Bienvenue au jeu de course, tapez entree pour demarer");
		try{
			int cpt=1;
			while(nouveau.getGagnant()==false){
				Terminal.lireString();
				System.out.println("tour numero "+cpt);
				nouveau.tourDeJeu();
				cpt++;
			}
		}catch(Exception e){
			
		}

	}

}

class Cheval implements Posable{
	String couleur;
	
	public Cheval(String c){
		this.couleur = c;
	}
	
	public String toString(){
		
		return ""+couleur.charAt(0);
	}
	
}

class Vide implements Posable{
	public String toString(){
		
		return " ";
	}
}


class Final implements Posable{
	public String toString(){
		
		return "!";
	}
}
