import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
public class TrieNode
{
    char val;
    LinkedList<TrieNode> children;
    public TrieNode(char c)
    {
        this.val = c;
        this.children = new LinkedList<>();
    }
    public Set<Character> getChildVals()
    {
        Set result = new TreeSet<>();
        for(int i = 0; i < this.children.size(); i++)
        {
            result.add(this.children.get(i).val);
        }
        return result;
    }
    public TrieNode getChild(char c)
    {
        for(int i = 0; i < this.children.size(); i++)
        {
            if(this.children.get(i).val == c)
            {
                return this.children.get(i);
            }
        }
        return null;
    }
    public ArrayList<String> getEndings()
    {
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < this.children.size(); i++)
        {
            this.children.get(i).getEndings(result, "");
        }
        return result;
    }
    private void getEndings(ArrayList<String> result, String progress)
    {
        if(this.children.size() == 0)
        {
            result.add(progress + this.val);
            return;
        }
        
        for(int i = 0; i < this.children.size(); i++)
        {
            this.children.get(i).getEndings(result, progress + this.val);
        }
    }
    public void print()
    {
        for(int i = 0; i < this.children.size(); i++)
        {
            System.out.println(this.val + "-" + this.children.get(i).getChildVals().toString() + " ");
            this.children.get(i).print();
        }
        
    }
}
