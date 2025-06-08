package placeholder;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.SwingConstants.LEFT;
import javax.swing.border.*;
import javax.swing.text.*;

public class cari_anggota extends JTextField {
    private String placeholder = "  Cari Data...";
    private Image icon = null;
    
    public cari_anggota() {
        initListener();
        setOpaque(false);
        setForeground(Color.BLACK);
        setCaretColor(Color.black);
        setHorizontalAlignment(LEFT);
    }
    
    public cari_anggota(String text) {
        initListener();
    }
    
    public cari_anggota(int columns) {
        initListener();
    }
    
    public cari_anggota(String text, int columns) {
        super(text, columns);
        initListener();
    }
    
    public cari_anggota(Document doc, String text, int columns) {
        super(doc, text, columns);
        initListener();
    }

    private void initListener() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                repaint();
            }
        });
    }
    
    public String getPlaceholder() {
        return placeholder;
    }
    
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setColor(getBackground());
        g2.fillRect(0,0,getWidth(),getHeight());
        super.paintComponent(g2);
        g2.dispose();
        super.paintComponent(g);
        if (getText().trim().equals("")) {
            Font font = getFont().deriveFont(Font.PLAIN).deriveFont(Font.PLAIN);
            Graphics2D g2d = (Graphics2D)g;
            FontMetrics fontMetrics = g2d.getFontMetrics(font);
            
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            g2d.setColor(Color.GRAY);
            g2d.setFont(font);
            java.awt.geom.Rectangle2D rect = fontMetrics.getStringBounds(placeholder, g2d);
            int textHeight = (int)rect.getHeight();
            g2d.drawString(placeholder, 1, textHeight+4);
        }
    }
}
