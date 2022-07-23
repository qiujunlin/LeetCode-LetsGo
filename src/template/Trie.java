package template;



/**
 * @Classname Trie
 * @Description:
 * @Date 2021/4/14 11:01
 * @Created by qiujunlin
 */
public class Trie {

    private Trie[] children;
    private boolean isend;
    /** Initialize your data structure here. */
    public Trie() {
      children = new Trie[26];
      isend =false;
    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie trie = this;
        for(int i=0;i<word.length();i++){
              char  c =word.charAt(i);
              if(trie.children[c-'a']==null){
                  trie.children[c-'a']=new Trie();
              }
              trie = trie.children[c-'a'];
          }
        trie.isend=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
          Trie trie = searchPrefix(word);
          return  trie!=null&& trie.isend;
    }
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
 return  searchPrefix(prefix)!=null;
    }
    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

}
