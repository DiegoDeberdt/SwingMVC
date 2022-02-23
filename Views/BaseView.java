package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BaseView extends JPanel {

    private JPanel centerPanel = null;

    public BaseView() {

        super();

        setLayout(new BorderLayout());

        var outerPanel = new JPanel(new BorderLayout());
        outerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        add(outerPanel, BorderLayout.CENTER);

        var borderPanel = new JPanel(new BorderLayout());
        borderPanel.setBorder(BorderFactory.createEtchedBorder());

        outerPanel.add(borderPanel, BorderLayout.CENTER);

        var innerPanel = new JPanel(new BorderLayout());
        innerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        innerPanel.add(getCenterPanel(), BorderLayout.CENTER);

        borderPanel.add(innerPanel, BorderLayout.CENTER);
    }

    public JPanel getCenterPanel() {

        if (this.centerPanel == null) {
            this.centerPanel = new JPanel();
            this.centerPanel.setLayout(new BorderLayout());
        }

        return this.centerPanel;
    }
}
