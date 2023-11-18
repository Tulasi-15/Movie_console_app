import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

class Main{
    static Scanner sc = new Scanner(System.in);
    public static void ShowMovies(){
        try {
            File myObj = new File("Movies.text");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void AddMovie(){
        String name,year,director,lang,rating;
        name = sc.nextLine();
        year = sc.nextLine();
        director = sc.nextLine();
        lang = sc.nextLine();
        rating = sc.nextLine();
        String data = String.format("%-20s|%20s |%8s |%6s |%5s\n",name,director,lang,year,rating);
        try{
            FileWriter myWriter = new FileWriter("Movies.text",true);
            myWriter.write(data);
            myWriter.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
         
    }
    public static void DeleteMovie(){
        try {
            System.out.println("Enter the Movie name you want to Delete:::");
            String name = sc.nextLine();
            File movie = new File("Movies.text");
            String path = movie.getAbsolutePath();
            File MovieFile = new File(path);
            File temp = new File("temp.text");
            FileWriter myWriter = new FileWriter(temp,true);
            Scanner readScanner = new Scanner(movie);
            while (readScanner.hasNextLine()){
                String data = readScanner.nextLine();
                String[] dataSet = data.split("[|]");
                if((dataSet[0].trim()).equals(name.trim()))continue;
                myWriter.write(data+"\n");
            }
            myWriter.close();
            readScanner.close();
            MovieFile.delete();
            temp.renameTo(MovieFile);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static String[] Search(String name){
        String[] a = new String[5];
        try{
            File movie = new File("Movies.text");
            Scanner readScanner = new Scanner(movie);
            while (readScanner.hasNextLine()){
                String data = readScanner.nextLine();
                String[] dataSet = data.split("[|]");
                if((dataSet[0].trim()).equals(name.trim())){
                    for(int i=0;i<5;i++){
                        a[i] = dataSet[i].trim();
                    }
                }
            }
            readScanner.close();

        }
        catch(Exception e){
            System.out.println(e);
        }
        return a;
    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        boolean fl = true;
        while (fl) {
            System.out.println("enter your choice:\n1.Show Movies\n2.Add Movie\n3.Delete Movie\n4.search");
            int num = scan.nextInt();
            switch (num) {
                case 1:
                    ShowMovies();
                    break;
                case 2:
                    AddMovie();
                    break;
                case 3:
                    DeleteMovie();
                    break;
                case 4:
                    String dat = sc.nextLine();
                    String SearchMovie[] = Search(dat);
                    if(SearchMovie[0]==null){
                        System.out.println("Not Found");
                    }else{ 
                        System.out.printf(
                            "%-10s: "+SearchMovie[0]
                        +"\n%-10s: "+SearchMovie[1]
                        +"\n%-10s: "+SearchMovie[2]
                        +"\n%-10s: "+SearchMovie[3]
                        +"\n%-10s: "+SearchMovie[4]+"\n","Name","Director","Language","Year","Rating"
                        );
                    }
                    break;
                default:
                    fl = false;
                    break;
            }
            /*
                Filter Movies
                update
            */
            
        }
        scan.close();


        
    }
}