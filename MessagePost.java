import java.util.ArrayList;

public class MessagePost extends CommentedPost
{
    private String message; // multi-line message
    
    //constructor for objects of class MessagePost
    public MessagePost(String author, String text)
    {
        super(author);
        message = text;
    }
    
    //returns the text of this post
    public String getText()
    {
        return message;
    }
    
    //displays post details
    public void display()
    {
        System.out.println(message);
        super.display();
    }
}
