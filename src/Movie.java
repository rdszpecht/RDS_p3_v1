import org.json.simple.JSONArray;
import org.json.simple.JSONArray;

public class Movie {

    private int vote_count;
    private long budget, popularity, revenue;
    private double vote_average;
    private String original_title, original_language, status, release_date;
    private JSONArray genres, keywords, production_companies;

    public Movie(){

    }

    public Movie(long budget, JSONArray genres, JSONArray keywords, String original_language, String original_title, long popularity, JSONArray production_companies, String release_date, long revenue, String status, double vote_average, int vote_count) {
        this.budget = budget;
        this.vote_count = vote_count;
        this.popularity = popularity;
        this.revenue = revenue;
        this.vote_average = vote_average;
        this.original_title = original_title;
        this.status = status;
        this.release_date = release_date;
        this.genres = genres;
        this.keywords = keywords;
        this.original_language = original_language;
        this.production_companies = production_companies;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public void setPopularity(long popularity) {
        this.popularity = popularity;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public long getBudget() {
        return budget;
    }

    public int getVote_count() {
        return vote_count;
    }

    public long getPopularity() {
        return popularity;
    }

    public long getRevenue() {
        return revenue;
    }

    public double getVote_average() {
        return vote_average;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getStatus() {
        return status;
    }

    public String getRelease_date() {
        return release_date;
    }

    public JSONArray getGenres() {
        return genres;
    }

    public JSONArray getKeywords() {
        return keywords;
    }

    public JSONArray getProduction_companies() {
        return production_companies;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setGenres(JSONArray genres) {
        this.genres = genres;
    }

    public void setKeywords(JSONArray keywords) {
        this.keywords = keywords;
    }

    public void setProduction_companies(JSONArray production_companies) {
        this.production_companies = production_companies;
    }

    @Override
    public String toString() {
        return ("Movie -> " + this.original_title);
    }
}
