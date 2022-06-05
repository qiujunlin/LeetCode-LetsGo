package Contest.week;
class TextEditor {
    StringBuilder s ;
    int i =0;

    public TextEditor() {
   s =new StringBuilder();
    }

    public void addText(String text) {
       s.insert(i+1,text);
       i = i+text.length();
    }

    public int deleteText(int k) {
        int l =  Math.max(0,i-k);
        s.delete(l,i);
        int len  =  i-l;
        i = i-len;
        System.out.println(s);
        return  len;

    }

    public String cursorLeft(int k) {
        int l  = Math.max(0,i-k);
        if(l==0) return  "";
        i =l;
        int l2 = Math.max(0,i-10);
         return  s.substring(l2,i);
    }

    public String cursorRight(int k) {
        int r =Math.min(s.length(),i+k);
        if(r==s.length())  return  "";
        i =r;
        int r2 =Math.min(s.length(),i+10);
        return  s.substring(i,r2);


    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */