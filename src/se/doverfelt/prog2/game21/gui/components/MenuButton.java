package se.doverfelt.prog2.game21.gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

/**
 * Created by Rickard on 2015-12-28.
 */
public class MenuButton extends JButton {

    private String label;
    private boolean isMouseOver = false;
    private boolean rightAligned;

    public MenuButton(String label) {
        super("");
        this.label = label;
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setBackground(new Color(0f, 0f, 0f, 0.5f));
        this.setOpaque(true);
        this.setContentAreaFilled(true);
        this.setBorderPainted(false);
        this.setForeground(new Color(186, 186, 186));
        this.setFont(new Font("Helvetica", Font.PLAIN, 18));
        this.setRolloverEnabled(false);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                isMouseOver = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                isMouseOver = false;
                repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {

        if (isMouseOver) {
            g.setColor(getBackground());
        } else {
            g.setColor(new Color(0,0,0,0));
        }


        g.fillRect(1, 1, getWidth(), getHeight());
        g.setColor(getForeground());

        Graphics2D g2 = (Graphics2D) g;

        HashMap<RenderingHints.Key, Object> keys = new HashMap<>();
        keys.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        keys.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2.addRenderingHints(keys);

        g2.setColor(this.getForeground());
        if (rightAligned) {
            g2.drawString(label, (float) ((this.getWidth()) - (this.getFontMetrics(this.getFont()).stringWidth(label) + 10)), (float) ((this.getHeight() / 2) - (this.getFontMetrics(this.getFont()).getHeight() / 2)));
        } else {
            g2.drawString(label, 10f, (float) ((this.getHeight() / 2) - (this.getFontMetrics(this.getFont()).getHeight() / 2)));
        }
    }

    public void setRightAligned(boolean rightAligned) {
        this.rightAligned = rightAligned;
    }
}
