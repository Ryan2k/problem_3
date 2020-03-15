import java.util.Scanner;
import java.util.ArrayList;
public class Main
{
    public static void main(String[] args)
    {
        Trie t = new Trie();
        String[] dictionary = {"hello", "high", "seattle", "seatac",
                               "see", "hollow", "how"};
        t.initTrie(dictionary);
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            System.out.println("Query: ");
            String str = scan.next();
            scan.nextLine();
            ArrayList<String> result = t.autoComplete(str);
            System.out.println("Are You Looking For: ");
            if(result == null)
            {
                System.out.println("No Results Found");
            }
            else
            {
                for(int i = 0; i < result.size(); i++)
                {
                    System.out.println(result.get(i));
                }
            }
            System.out.println("\n\nWould You Like To Search Anything Else? (Y/N)");
            if(scan.nextLine().toLowerCase().charAt(0) == 'n')
            {
                break;
            }
        }
       
    }
    /*public static void dummyVersion()
    {
        String[] dictionary = {"hello", "high", "seattle", "seatac",
                               "see", "hollow", "how"};
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            System.out.println("Query: ");
            String str = scan.next();
            scan.nextLine();
            ArrayList<String> result = autoComplete(str, dictionary);
            System.out.println("Are You Looking For: ");
            for(int i = 0; i < result.size(); i++)
            {
                System.out.println(result.get(i));
            }
            System.out.println("\n\nWould You Like To Search Anything Else? (Y/N)");
            if(scan.nextLine().toLowerCase().charAt(0) == 'n')
            {
                break;
            }
        }
    }*/
    public static ArrayList<String> autoComplete(String str, String[] dict)
    {
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < dict.length; i++)
        {
            if(dict[i].startsWith(str))
            {
                result.add(dict[i]);
            }
        }
        return result;
    }
}
