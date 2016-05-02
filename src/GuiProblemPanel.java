import java.awt.*;

import javax.swing.*;

public class GuiProblemPanel extends JPanel {

    private ProblemInput problemInput;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int size = getWidth() - 6;

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, size + 6, size + 6);

        if (problemInput != null) {
            g.setColor(Color.BLACK);

            for (Point point : problemInput.getPoints()) {
                if (point != null) {
                    g.fillOval((int) (point.getX() * size), (int) (point.getY() * size), 6, 6);
                }
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension parentSize = getParent().getSize();
        int width = parentSize.width - 10;
        int height = parentSize.height - 10;

        if (width > height) {
            return new Dimension(height, height);
        } else {
            return new Dimension(width, width);
        }
    }

    public void setProblemInput(ProblemInput problemInput) {
        this.problemInput = problemInput;
        this.repaint();
    }
}
