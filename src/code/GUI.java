package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class GUI{

    public JPanel startGUI() {
        JPanel ret = new JPanel();
        ret.setLayout(new BoxLayout(ret, BoxLayout.Y_AXIS));

        ArrayList<String> subreddits = RedditWrapper.allSubredditNames();
        for (final String name : subreddits) {
            JButton b = new JButton(name);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                        try {
                            desktop.browse(new URI("https://www.reddit.com/" + name));
                        } catch (URISyntaxException | IOException error) {
                            error.printStackTrace();
                        }
                    }
                }
            });
            ret.add(b);
        }
        return ret;
    }

}
