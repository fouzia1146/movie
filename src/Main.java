import java.util.*;
public class Main {
    public static void main(String[] args){
        Movies movies = new Movies();
        int movieArraySize = movies.movies.length;
        int random = (int) (Math.random()* movieArraySize);
        String movie = movies.movies[random];
        int movieSize = movie.length();
        char[] outputMovie = new char[movieSize];
        for(int i=0;i<movieSize;i++){
            if(movie.charAt(i)!=' '){
                outputMovie[i] = '_';
            }
            else{
                outputMovie[i]=' ';
            }
        }
        System.out.println(outputMovie);
        int chance =10;
        Scanner s = new Scanner(System.in);
        String wrong ="";
        while(chance>0){
            System.out.print("you are guessing: ");
            char input = s.next().charAt(0);
            boolean matched =false;
            for(int i=0;i<movieSize;i++){
                if(movie.charAt(i) == input){
                    outputMovie[i] = input;
                    matched = true;
                }
            }
            if(!matched){
                boolean contain = false;
                for(int i=0;i<wrong.length();i++){
                    if(wrong.charAt(i)==input){
                        contain=true;
                    }
                }
                if(!contain){
                    wrong+=(" " + input);
                    chance--;
                }
            }
            System.out.println(outputMovie);
            System.out.println("You have guessed (" + (10-chance) + ") wrong letters: " + wrong );
            boolean win = true;
            for(int i=0;i<movieSize;i++){
                if(outputMovie[i] == '_'){
                    win =false;
                }
            }
            if(win){
                System.out.println("You Win");
                return;
            }
        }
        System.out.println("You loose");
    }
}

