import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
public class AutoCompleteTest
{
    @Test
    public void test()
    {
        Trie t = new Trie();
        String[] dictionary = {"hello", "high", "seattle", "seatac",
                               "see", "hollow", "how"};
        t.initTrie(dictionary);
        ArrayList<String> result1 = new ArrayList<>();
        result1.add("seattle");
        result1.add("seatac");
        result1.add("see");
        assertEquals(t.autoComplete("se").toString(), result1.toString());
        
        ArrayList<String> result2 = new ArrayList<>();
        result2.add("seattle");
        result2.add("seatac");
        assertEquals(t.autoComplete("sea").toString(), result2.toString());
        
        ArrayList<String> result3 = new ArrayList<>();
        result3.add("hollow");
        result3.add("how");
        assertEquals(t.autoComplete("ho").toString(), result3.toString());
        
        ArrayList<String> result4 = new ArrayList<>();
        assertEquals(t.autoComplete("xyz"), null);
        
    }
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
