import javax.swing.*; 
import java.awt.event.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javax.swing.border.*;

public class main extends JFrame
{
    private String author;
    private String message;
    private String filename;
    private String caption;
    //CommentedPost ref.
    //private int likes;

    //private ArrayList<String> comments;
    
    //EventPost
    private String type;
    
    //submit and show buttons
    JButton button1, button2;
    
    //Author Label, Message Label
    JLabel label1, label2;
    
    //Event type label
    JLabel label3;
    
    //photoPost filename 
    JLabel label4;
    
    //Caption Label
    JLabel label5;
    
    //Author textField, Message textField
    JTextField textField1, textField2;
    
    //Event Type textField
    JTextField textField3;
    
    //photoPost filename 
    JTextField textField4;
    
    //Caption TextField
    JTextField textField5;
    
    //event, message, and photo radio buttons 
    JRadioButton eventPost, messagePost, photoPost;
    
    //post will be displayed here 
    JTextArea textArea1;
    
    public static void main(String[] args) 
    {
        new main();
    }
    
    public main() 
    {
        
        
        this.setSize(600,650); 
        double fillIn = 0;
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Fourth Frame");
        JPanel thePanel = new JPanel();
        
        //needed to intake info in textField1
        //ListenForButton lForButton = new ListenForButton();
        
        //author label
        label1 = new JLabel("Author");
        thePanel.add(label1);
        
        //author textfield
        textField1 = new JTextField("",15);
        thePanel.add(textField1);
        
        //message label
        label2 = new JLabel("Message");
        thePanel.add(label2);
        
        //message textfield
        textField2 = new JTextField("", 15);
        thePanel.add(textField2);
        
        //event label
        label3 = new JLabel("\nEvent Type: ");
        thePanel.add(label3);
        
        
        //event textField
        textField3 = new JTextField("", 15);   
        thePanel.add(textField3);
        
        //photoPos label4
        label4 = new JLabel("filename: ");
        thePanel.add(label4);
        
        //photoPost textField4
        textField4 = new JTextField("", 15);
        thePanel.add(textField4);
        
        //Caption label5
        label5 = new JLabel("Caption ");
        thePanel.add(label5);
        
        //Caption textField5
        textField5 = new JTextField("", 15);
        thePanel.add(textField5);
        
        //radio buttons
        eventPost = new JRadioButton("Event");
        messagePost = new JRadioButton("Message");
        photoPost = new JRadioButton("Photo");
        
        ButtonGroup operation = new ButtonGroup();
        
        operation.add(eventPost);
        operation.add(messagePost);
        operation.add(photoPost);
        
        JPanel operPanel = new JPanel();
        
        Border operBorder = BorderFactory.createTitledBorder("Post");
        
        operPanel.setBorder(operBorder);
        
        operPanel.add(eventPost);
        operPanel.add(messagePost);
        operPanel.add(photoPost);
        
        eventPost.setSelected(true);
        
        thePanel.add(operPanel);
        
        //creating textArea1
        textArea1 = new JTextArea(15,20);
        textArea1.setText("Log of Posts \n");
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        
        
        //creating submit button to show the post content
        button1 = new JButton("submit");
        //needed to intake info in textField1
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        
        //creating show button to show comments and likes 
        button2 = new JButton("show");
        //needed to intake info in textField2
        ListenForButton lForButton2 = new ListenForButton();
        button2.addActionListener(lForButton2);
        
        //displays posts
        
        
        //adding buttons
        thePanel.add(button1);
        thePanel.add(button2);
        
        //adding textArea1
        thePanel.add(textArea1);
        
        this.add(thePanel);
        this.setVisible(true);
        
        textField1.requestFocus();
        
    }
    
    /**
     * show method
     *
     * @param  
     * @return    likes and comments
     */
    
    /*public int getLikes(){
        return displayLikes;
    }*/
    
    
    private class ListenForButton implements ActionListener{
        public void actionPerformed(ActionEvent e) 
        {
            if (e.getSource() == button1 && eventPost.isSelected())
            {
                type = textField3.getText(); 
                author = textField1.getText();
                
                textArea1.append("Author: " + author + "\n");
                textArea1.append("Event Type: " + type + "\n");
                new EventPost(author, type);
                
            } else if(e.getSource() == button1 && messagePost.isSelected()) {
                message = textField2.getText();
                author = textField1.getText();
                textArea1.append("Author: " + author + "\n");
                textArea1.append("Message: " + message + "\n");
                new MessagePost(author,message);
                
            } else if(e.getSource() == button1 && photoPost.isSelected()){
                filename = textField4.getText();
                caption = textField5.getText();
                author = textField1.getText();
                textArea1.append("Image :[" + filename + "]\n");
                textArea1.append("Caption: " + caption + "\nAuthor: " + 
                author);
                 new PhotoPost(author,filename,caption);
               
            }
            
            
            if (e.getSource() == button2 && eventPost.isSelected())
            {
                textArea1.append("- people like this\n ");
                textArea1.append("- comments");
                
            } else if (e.getSource() == button2 && messagePost.isSelected())
            {
               //String viewMessageComments = 
               String viewMessageLikes = new MessagePost(author,message).getLikes();
               textArea1.append("\n" + viewMessageLikes + "people like this\n");
            } else if(e.getSource() == button2 && photoPost.isSelected())
            {
                String viewPhotoLikes = new PhotoPost(author,filename,caption).getLikes();
                textArea1.append("\n" + viewPhotoLikes + "people like this\n");
            }
        }
    }
}   

