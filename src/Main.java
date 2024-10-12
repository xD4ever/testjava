// Base class Document
abstract class Doc{
    private String title;
    private String author;
    public Doc(String title, String author){
        this.title = title;
        this.author = author;
    }
    public Doc(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
}

class Livre extends Doc {
    private String editeur;
    private String anneeEdition;
    public Livre(String title, String author, String editeur, String anneeEdition){
        super(title, author);
        this.editeur = editeur;
        this.anneeEdition = anneeEdition;
    }
    public String getEditeur(){
        return editeur;
    }
    public String getAnneeEdition(){
        return anneeEdition;
    }
}

class revues extends Doc{
    private String editeur;
    private String domaine;
    public revues(String title, String author, String editeur, String domaine){
        super(title, author);
        this.editeur = editeur;
        this.domaine = domaine;
    }
    public String getEditeur(){
        return editeur;
    }
    public String getAnneeEdition(){
        return domaine;
    }
}

class Dvd extends Doc{
    private String dureeParMinute;
    private String domaine;
    public Dvd(String title, String dureeParMinute, String domaine){
        super(title);
        this.dureeParMinute = dureeParMinute;
        this.domaine = domaine;
    }
    public String getDureeParMinute(){
        return dureeParMinute;
    }
    public String getAnneeEdition(){
        return domaine;
    }
}

class Biblio{
    private Doc[] tabDocuments;
    private int nbDocuments;
    private final int tailleMax = 20;

    public Biblio(){
        tabDocuments = new Doc[tailleMax];
        nbDocuments = 0;
    }

    public void ajoutDocuments(Doc doc){
        if(nbDocuments < tailleMax){
            tabDocuments[nbDocuments] = doc;
            nbDocuments++;
        }
    }

    public void afficher(){
        for(int i = 0; i < nbDocuments; i++){
            System.out.println(tabDocuments[i]);
        }
    }
    public void afficherAuteur(String auteur){
        for(int i = 0; i < nbDocuments; i++){
            if (tabDocuments[i] instanceof Livre && (tabDocuments[i]).getAuthor().equalsIgnoreCase(auteur)){
                System.out.println(tabDocuments[i]);
            }
        }
    }

}


public class Main {
    public static void main(String[] args) {
        Biblio biblio = new Biblio();
        biblio.ajoutDocuments(new Livre("J.K. Rowling", "Harry Potter", "Bloomsbury", "1997"));
        biblio.ajoutDocuments(new revues("12", "National Geographic", "Science", "2021"));
        biblio.ajoutDocuments(new Dvd("Inception", "148", "Sci-Fi"));
        biblio.afficher();
        System.out.println("\nSearching for books by J.K. Rowling:");
        biblio.afficherAuteur("J.K. Rowling");
    }
}



/*System.out.println("Displaying all documents:");
        library.displayDocuments();

        // Search for books by J.K. Rowling
        System.out.println("\nSearching for books by J.K. Rowling:");
        library.searchByAuthor("J.K. Rowling");*/