import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

class Main{
    static int SNO;
    public static void initilize(){
        try {
            File myObj = new File("Movies.text");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] dataSet = data.split("/");
                SNO = Integer.parseInt(dataSet[0]);
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public static void ShowMovies(){
        try {
            File myObj = new File("Movies.text");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] dataSet = data.split("/");
                for(String i:dataSet)
                System.out.print(i+"\t");
                System.out.println();
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void AddMovie(){
        initilize();
        Scanner sc = new Scanner(System.in);
        String name,year,director,lang,rating;
        name = sc.nextLine();
        year = sc.nextLine();
        director = sc.nextLine();
        lang = sc.nextLine();
        rating = sc.nextLine();
        String data = SNO+++"/"+name+"/"+director+"/"+lang+"/"+year+"/"+rating+"\n";
        // sc.close();
        try{
            FileWriter myWriter = new FileWriter("Movies.text",true);
            myWriter.write(data);
            myWriter.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
         
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("enter your choice:\n1.Show Movies\n2.Add Movie\n");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    ShowMovies();
                    break;
                case 2:
                    AddMovie();
                    break;
                default:
                    break;
            }
            
            
        }


        
    }
}