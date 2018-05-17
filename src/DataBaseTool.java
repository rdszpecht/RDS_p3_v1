import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class DataBaseTool {

    private JSONParser parser;
    private List<Movie> movies;

    public DataBaseTool(){
        parser = new JSONParser();
        movies = new ArrayList<Movie>();
    }

    public List<Movie> getMovies(){
        return this.movies;
    }

    private String normalize(String s){
        s = s.replace("\"\"","\"");
        s = s.replace("\"[","[");
        s = s.replace("]\"","]");
        return s;
    }

    public void csvToList(String csvPath){
        try (BufferedReader bf = new BufferedReader(new FileReader(csvPath))) {
            movies = bf.lines()
                    .skip(1)
                    .map(line -> line.split(";"))
                    .map(tokens ->  {
                        try {
                            long budget = Long.parseLong(tokens[0]);

                            Object genres = parser.parse(normalize(tokens[1]));
                            JSONArray jsGenres = (JSONArray) genres;

                            Object keywords = parser.parse(normalize(tokens[2]));
                            JSONArray jsKeywords = (JSONArray) keywords;

                            String original_language = tokens[3];
                            String original_title = tokens[4];
                            long popularity = Long.parseLong(tokens[5].replace(".",""));

                            Object production_companies = parser.parse(normalize(tokens[6]));
                            JSONArray jsProduction_companies = (JSONArray) production_companies;

                            String release_date = tokens[7];
                            long revenue = Long.parseLong(tokens[8]);
                            String status = tokens[9];
                            double vote_average = Double.parseDouble(tokens[10]);
                            int vote_count = Integer.parseInt(tokens[11]);

                            return new Movie(budget,jsGenres,jsKeywords,original_language,original_title,popularity,jsProduction_companies,release_date,revenue,status,vote_average,vote_count);
                        } catch (Exception e) {
                            e.printStackTrace();
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printAllMovies(List<Movie> movies){
        movies.forEach(System.out::println);
    }

    public void printAllBudgetBtw (long min, long max){
        movies
                .parallelStream()
                .filter(m -> m.getBudget() >= min)
                .filter(m -> m.getBudget() <= max)
                .forEach(m -> {
                    System.out.print(m);
                    System.out.println(" ; Budget: " + m.getBudget());
                });
    }

    public void printAllByGender(Set<String> genres){
        movies
                .parallelStream()
                .filter(m -> {
                    boolean contains = false;
                    for(String g: genres){
                        contains = contains || m.getGenres().toString().contains(g);
                    }
                    return contains;
                })
                .forEach(m -> {
                    System.out.print(m);
                    System.out.println(" |||| Genres: " + m.getGenres());
                });
    }

    public void printMaxRecKeyword(String keyword){
        Movie maxCash = movies
                .parallelStream()
                .filter(m -> m.getKeywords().toString().contains(keyword))
                .max((m1,m2) -> comparator(m1,m2)).get();
        System.out.println("Maximum revenue -> " + maxCash.getRevenue() + " by the " + maxCash);
    }

    private int comparator(Movie m1, Movie m2){
        if (m1.getRevenue() == m2.getRevenue()) {
            return 0;
        } else if(m1.getRevenue() > m2.getRevenue()){
            return 1;
        } else{
            return -1;
        }
    }

    public List<Movie> getPopularInLanguage(String language, int popularity){
        movies
                .parallelStream()
                .filter(m -> m.get)
    }
/*
    public double getTotalIncomeOfYear (int year){
        // Diapo 26 y demás
        double toRet = 0.0;
        if((year > 1900) || (year < 2020)){

        }
        return toRet;
    }

    public int getTotalVotesBtw (double min, double max){

    }

    public Map<String,String> getMapProducersTitles (){
        // Map reduce ?
        // Diapo 25 del tema de streams
    }
*/
}
