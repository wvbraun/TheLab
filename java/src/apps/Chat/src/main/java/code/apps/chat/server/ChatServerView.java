package code.apps.chat.server;

import javax.swing.*;

import code.apps.chat.server.ChatServer;
import code.apps.chat.server.ChatServerView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * An instance of this class is the graphical or command-line front end for the
 * server of a chat room hosted on PORT_NUMBER.
 * <p/>
 * To execute it in graphical mode, call it with: java ChatServerView To execute
 * it in command-line mode, call it with: java ChatServerView
 * type-anything-at-all-here...
 * <p/>
 * In either case it will create an instance of ChatServer.
 * <p/>
 * This class depends on class ChatServer.
 */
public class ChatServerView {
    public static final int    DEFAULT_PORT_NUMBER = 15001;
    public static final String NEWLINE             = "\n";
    public static final int    FRAME_WIDTH         = 600; // pixels
    public static final int    FRAME_HEIGHT        = 600; // pixels


    private int       portNumber;
    private boolean   visual;
    private JFrame    frame;
    private JTextArea log;
    private JButton   startButton, stopButton;
    private ChatServer chatServer;
    private Thread     chatServerThread;

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

    public boolean isVisual() {
        return visual;
    }

    public void setVisual(boolean visual) {
        this.visual = visual;
    }

    public void setup() {
        if (!isVisual()) {
            chatServer = new ChatServer(this);
            chatServerThread = new Thread(chatServer);
            chatServerThread.start();
            report("***********chat server started***********");
            return;
        }

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                beginServing();
            }
        });
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                endServing();
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);

        log = new JTextArea("Log" + NEWLINE);
        log.setEditable(false);

        JPanel holderPanel = new JPanel();
        holderPanel.setLayout(new BorderLayout());
        holderPanel.add(buttonPanel, BorderLayout.NORTH);
        holderPanel.add(new JScrollPane(log), BorderLayout.CENTER);

        frame = new JFrame("C212 Chat Server");
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                if (chatServerThread != null) {
                    endServing();
                }
                frame.dispose();
                System.exit(0);
            }
        });

        frame.add(holderPanel);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);
    }

    private void beginServing() {
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
        chatServer = new ChatServer(this);
        chatServerThread = new Thread(chatServer);
        chatServerThread.start();
        report("***********chat server started***********");
    }

    private void endServing() {
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        chatServer.stop();
        chatServerThread.interrupt();
        chatServerThread = null;
        report("***********chat server stopped***********");
    }

    public void report(String string) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String time = timeFormat.format(new Date());
        String output = time + " " + string + NEWLINE;

        if (isVisual()) {
            log.append(output);
            log.setCaretPosition(log.getDocument().getLength());
        } else {
            System.out.println(output);
        }
    }

    public static void main(String[] args) throws Exception {
        ChatServerView chatServerView = new ChatServerView();
        chatServerView.setVisual(args.length <= 0);
        if (chatServerView.isVisual()) {
            chatServerView.setPortNumber(DEFAULT_PORT_NUMBER);
        } else {
            chatServerView.setPortNumber(Integer.parseInt(args[0]));
        }
        chatServerView.setup();
    }
}
