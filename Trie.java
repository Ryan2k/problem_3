import java.util.LinkedList;
import java.util.ArrayList;
public class Trie
{
    TrieNode root;
    int count;
    public Trie()
    {
        root = new TrieNode((char)0);
    }
    public void initTrie(String[] dictionary)
    {
        TrieNode curr = root;
        for(int i = 0; i < dictionary.length; i++)
        {
            dictionary[i] = dictionary[i].toLowerCase();
            curr = root;
            for(int j = 0; j < dictionary[i].length(); j++)
            {
                if(!curr.getChildVals().contains(dictionary[i].charAt(j)))
                {
                    curr.children.add(new TrieNode(dictionary[i].charAt(j)));
                }
                curr = curr.getChild(dictionary[i].charAt(j));
            }
        }
    }
    public TrieNode search(String q)
    {
        TrieNode curr = root;
        for(int i = 0; i < q.length(); i++)
        {
            if(curr.getChild(q.charAt(i)) == null)
            {
                return null;//Query not in dictionary
            }
            curr = curr.getChild(q.charAt(i));
        }
        return curr;
    }
    public ArrayList<String> autoComplete(String q)
    {
        TrieNode midPoint = search(q);
        if(midPoint == null)
        {
            return null;
        }
        ArrayList<String> result = midPoint.getEndings();
        for(int i = 0; i < result.size(); i++)
        {
            result.set(i, q + result.get(i));//adds prefix
        }
        return result;
    }
    public void print()
    {
        root.print();
    }
}
/*
 * for(int i = 0; i < dictionary.length; i++)
        {
            if(!root.children.contains(dictionary[i].charAt(0)))
            {
                root.children.add(new TrieNode(dictionary[i].charAt(0)));
            }
        }
 */