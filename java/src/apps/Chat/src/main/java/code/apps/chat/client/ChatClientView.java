package code.apps.chat.client;

import javax.swing.*;

import code.apps.chat.server.ChatServerView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;


@SuppressWarnings("serial")
public class ChatClientView extends JApplet {
    public static final  String HOST_NAME          = "localhost" ; //TODO Change if you want to run locally
    public static final  int    SERVER_PORT_NUMBER = ChatServerView.DEFAULT_PORT_NUMBER; //TODO Change port. Must match server port.
    private static final int    MIN_COLUMN_WIDTH   = 10;

    private JButton    connectButton;
    private JTextField chatNameField, chatText;
    private JTextArea chatRoom, chattersList;

    private String     chatName;
    private ChatClient chatClient;

    private boolean isApplet = true;

    public void init() {
        JPanel holderPanel = makeHolderPanel();
        makeChatClient();
        setControlsForConnecting();
        add(holderPanel);
    }

    public String getChatName() {
        return chatName;
    }

    public void reportList(String string) {
        chattersList.setText(string);
    }

    /**
     * Adds the message to the chatRoom. It should be prefixed
     * with the current timestamp surrounded by [] square brackets
     * and postfixed with a newline so that the message is on its own line.
     * http://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
     *
     * @param string the message to add to the chatRoom
     */
    public void report(String string) {
    	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String time = timeFormat.format(new Date());
        String output = "[" + time + "]" + " " + string + "\n";

        chatRoom.setCaretColor(Color.BLUE);
        chatRoom.setSelectedTextColor(Color.YELLOW);
        chatRoom.append(output);
        chatRoom.setCaretPosition(chatRoom.getDocument().getLength());

    }

    private void setControlsForConnecting() {
        chatNameField.setEnabled(true);
        chatRoom.setEnabled(false);
        chattersList.setEnabled(false);
        chatText.setEnabled(false);

        chatNameField.requestFocus(); // doesn't work on startup!
    }

    private void setControlsForChatting() {
        chatNameField.setEnabled(false);
        chatRoom.setEnabled(true);
        chattersList.setEnabled(true);
        chatText.setEnabled(true);

        setUpForNewChatInput();
    }

    private void setUpForNewChatInput() {
        chatText.setText("");
        chatText.requestFocus();
    }

    /**
     *
     */
    private void makeChatClient() {
        // have to deal with variations between:
        // 1/ being called as an applet on a webserver,
        // 2/ being called as an applet on a local machine,
        // 3/ being called as an application on the command line

        if (isApplet) {
            report("running as an applet: server = "
                    + HOST_NAME + ":" + SERVER_PORT_NUMBER);
        } else {
            report("running as an application: host = "
                    + HOST_NAME + ":" + SERVER_PORT_NUMBER);
        }

        chatClient = new ChatClient(this, HOST_NAME);
    }

    /**
     * This method sets up the JPanel that takes up the whole window
     * of the application. The chat application is made up of a <br>
     * 1) Chat Room <br>
     * 2) Chatters List <br>
     * 3) Message Panel <br>
     * 4) Chat Name Panel <br>
     * <p/>
     * Each of these components has a method to make them, specified lower in
     * the file. You should figure out some way to add these components to
     * the panel that you return in such a way that it resembles the provided
     * runnable sample or screenshot.
     * <p/>
     * You may find this tutorial
     * http://docs.oracle.com/javase/tutorial/uiswing/layout/using.html
     * on layout managers useful.
     *
     * @return the JPanel that will take up the whole window
     */
    private JPanel makeHolderPanel() {
        JPanel centerPanel = makeChatRoom();
        JPanel eastPanel = makeChattersList();
        JPanel upperSouthPanel = makeMessagePanel();
        JPanel lowerSouthPanel = makeChatNamePanel();
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        southPanel.add(upperSouthPanel);
        southPanel.add(lowerSouthPanel);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(eastPanel, BorderLayout.EAST);
        panel.add(southPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel makeChatRoom() {
        chatRoom = new JTextArea();
        chatRoom.setColumns(MIN_COLUMN_WIDTH);
        chatRoom.setEditable(true); // for some reason the wiki said to let this be editable, idk why one would want this???
        report("Chat Room");
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(chatRoom), BorderLayout.CENTER);
        return panel;
    }

    private JPanel makeChattersList() {
        chattersList = new JTextArea("Chatters List");
        chattersList.setColumns(MIN_COLUMN_WIDTH);
        chattersList.setEditable(false);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(chattersList), BorderLayout.CENTER);

        return panel;
    }

    private JPanel makeMessagePanel() {
        chatText = new JTextField("Chat area");
        chatText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                chatClient.sendChatMessage(chatText.getText());
                if (chatClient.isSuccessful()) {
                    setUpForNewChatInput();
                }
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(chatText, BorderLayout.CENTER);

        return panel;
    }

    private JPanel makeChatNamePanel() {
        JLabel chatNameLabel = new JLabel("ChatName:");
        chatNameField = new JTextField(MIN_COLUMN_WIDTH);

        connectButton = new JButton("Connect");
        connectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if (connectButton.getText().equals("Connect")) {
                    chatName = chatNameField.getText();
                    chatClient.connect();
                    if (chatClient.isConnected()) {
                        connectButton.setText("Disconnect");
                        setControlsForChatting();
                    }
                } else {
                    chatClient.disconnect();
                    if (!chatClient.isConnected()) {
                        connectButton.setText("Connect");
                        setControlsForConnecting();
                    }
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(chatNameLabel);
        panel.add(chatNameField);
        panel.add(connectButton);

        return panel;
    }

    public static void main(String[] arguments) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final ChatClientView chatClientView = new ChatClientView();
                chatClientView.isApplet = false;
                chatClientView.init();
                final JFrame jframe = new JFrame("C212 Chat Room");
                jframe.add(chatClientView);
                jframe.setSize(600, 600);
                jframe.addWindowListener(new WindowAdapter() {
                    public void windowOpened(WindowEvent windowEvent) {
                        // doesn't work on startup!
                        chatClientView.chatNameField.requestFocusInWindow();
                    }

                    public void windowClosing(WindowEvent windowEvent) {
                        chatClientView.chatClient.disconnect();
                        jframe.dispose();
                    }
                });

                jframe.setVisible(true);
            }
        });
    }
}
