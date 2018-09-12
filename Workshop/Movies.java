/**
 * printMovies
 */
public class Movies {
    public static String fav = "Dark knight,Dark knight rises,Harry Potter,Her,Warcraft";
    public static void main(String[] args) {
        // String[] movies = {"Dark knight","Dark knight rises","Harry Potter","Her","Warcraft"};
        // int[] ranks = {1,2,3,4,5};
        // for(int i = 0; i < 5; i++){
        //     printMovies(ranks[i], movies[i]);
        // }
        // printMovies(3, "Guardians of the Galaxy");
        // printMovies("The Avengers,Iron Man,Thor");
        // printMovies(fav);
    }
  
    public static void printMovies(int rank, String movie) {
        System.out.println(rank + ". " + movie);
    }

    public static void printMovies(String movies) {
        int i = 1;
        for (String movie : movies.split(",")) {
            System.out.println(i + ". " + movie);
            i++;
        }
    }
    public static boolean isAFavourite(String name) {
        if (fav.contains(name)) {
            return true;
        }
        return false;
    }
}