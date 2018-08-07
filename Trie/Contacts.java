//https://www.hackerrank.com/challenges/contacts/problem

public class Contacts {
  static class TrieNode {
    String value = "";
    Map<String, TrieNode> child = new HashMap();
    boolean isWord = false;
    int size = 0;
    TrieNode(String value){
        this.value = value;
    }
  }

  static TrieNode addToTrie(TrieNode root, String word){
    TrieNode current = root;
    for(String w : word.split("")){
        if(!current.child.containsKey(w)) current.child.put(w, new TrieNode(w));
        current.size++;
        current = current.child.get(w);
    }
    current.isWord = true;
    return root; 
  }

  static int getPartialCount(TrieNode root, String partial) {
    TrieNode current = root;
    for(String w : partial.split("")){
        if(!current.child.containsKey(w)) return 0;
        current = current.child.get(w);
    }
    if(current.isWord)  return current.size+1;
    return current.size;
  }

  /*
  * Complete the contacts function below.
  */
  static List<Integer> contacts(String[][] queries) {
    TrieNode t = new TrieNode("");
    List<Integer> result = new ArrayList<>();
    for(String[] q : queries) {
        String oper = q[0];
        String val = q[1];
        if(oper.equals("add")){
            addToTrie(t,val); 
        } 
        else if(oper.equals("find")) {
            int count = getPartialCount(t,val);
            op.add(count);
        }   
    }
  }

  public static void main(String[] args) {
    int[][] queries = new int[][] {
      {"add", "s"},
      {"add","ss"},
      {"add", "sss"},
      {"add", "ssss"},
      {"add","sssss"},
      {"find","s"},
      {"find","ss"},
      {"find","sss"},
      {"find","ssss"},
      {"find","sssss"},
      {"find","ssssss"}
    };
    System.out.println(contacts(queries));
  }
}