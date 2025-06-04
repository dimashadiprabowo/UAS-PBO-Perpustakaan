package placeholder;

import javax.swing.text.*;
public class limit extends PlainDocument {
    private int max;
    
    public limit(int max) {
        super();
        this.max = max;
    }
    
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }
        if ((getLength() + str.length()) <= max) {
            super.insertString(offset, str, attr);
        }
    }
}
