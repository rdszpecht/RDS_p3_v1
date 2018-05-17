import java.util.*;

class main{

    public static void main(String[] args) {
        System.out.println("Wellcome to the Movie Data Base Analysis system!");
        boolean end = false;
        Scanner scanner = new Scanner(System.in);
        String buffer;
        DataBaseTool dbt = new DataBaseTool();

        while(!end){
            System.out.println("Select your Option (\"Help\" for option list):");
            buffer = scanner.nextLine();
            buffer = buffer.toLowerCase();
            String temp;

            switch (buffer){
                case "help":
                    showOptions();
                    break;

                case "1":
                    System.out.println("Select path: ");
                    String path = scanner.nextLine();
                    List<Movie> movies;
                    if (path.equals("")){
                        path = "./db/movies_db.csv";
                    }

                    long start = System.currentTimeMillis();
                    dbt.csvToList(path);
                    long elapsedTimeMillis = System.currentTimeMillis()-start;
                    System.out.println(elapsedTimeMillis);
                    movies = dbt.getMovies();
                    dbt.printAllMovies(movies);
                    break;

                case "2":
                    long min, max;
                    System.out.println("Give a min and a max value in this format: N,N");
                    temp = scanner.nextLine();
                    min = Long.parseLong(temp.split(",")[0]);
                    max = Long.parseLong(temp.split(",")[1]);
                    dbt.printAllBudgetBtw(min, max);
                    break;

                case "3":
                    Set<String> genres = new HashSet<>();
                    genres.add("Science Fiction");
                    genres.add("Crime");
                    dbt.printAllByGender(genres);
                    break;

                case "4":
                    System.out.println("Insert the KeyWord:");
                    temp = scanner.nextLine();
                    dbt.printMaxRecKeyword(temp);
                    break;

                case "5":
                    System.out.println("Select language: ");
                    String language = scanner.nextLine();
                    System.out.println("Select minimum level of popularity: ");
                    temp = scanner.nextLine();
                    dbt.getPopularInLanguage(language, Integer.parseInt(temp));
                    break;
/*
                case "6":
                    System.out.println("Type the year: ");
                    temp = scanner.nextLine();
                    dbt.getTotalIncomeOfYear(Integer.parseInt(temp));
                    break;

                case "7":
                    System.out.println("Give a min and a max value in this format: N.N,N.N");
                    temp = scanner.nextLine();
                    double dmin = Double.parseDouble(temp.split(",")[0]);
                    double dmax = Double.parseDouble(temp.split(",")[1]);
                    dbt.getTotalVotesBtw(dmin, dmax);
                    break;

                case "8":
                    Map<String,String> map = dbt.getMapProducersTitles();
                    System.out.println("Map ocurrences of Columbia Pictures: ");
                    System.out.println(map.get("Columbia Pictures"));
                    break;
                    */

                case "end":
                    end = true;
                    break;
                default:
                    showErrMsg(buffer);
                    break;
            }
        }
    }

    private static void showOptions(){
        System.out.println("Valid Options are the following: ");
        System.out.println(" -> exit: If you want to finish the program's execution");
        System.out.println(" -> 1: Read a csv file, save it in a List, and print all the movies on the screen.");
        System.out.println(" -> 2: Given a min and a max value, show all the movies in between this budget");
        System.out.println(" -> 3: Given a set of genres, show all the movies with such a gener (modify set in code)");
        System.out.println(" -> 4: Asks for a keyword, then show the movie with bigger revenue");
        System.out.println(" -> 5: Given a language and a minimum of popularity, selects movies with these parameters");
        System.out.println(" -> 6: Given a Year, it shows the total revenue of that year");
        System.out.println(" -> 7: Given a min and a max valoration, returns the movies in between those");
        System.out.println(" -> 8: It returns a Map with a Key = Production company, and Value = Movie title");
    }

    private static void showErrMsg(String comand){
        System.out.println(comand + " is an invalid comand.");
    }
}