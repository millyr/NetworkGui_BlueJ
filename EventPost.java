import java.util.ArrayList;

public class EventPost extends Post
{
    private String eventType; //multi-line message
    
    //constructor for objects of class MessagePost
    public EventPost(String author, String type)
    {
        super(author); 
        eventType = type;
    }
    
    // returns the text of the post
    public String getType()
    {
        return eventType;
    }
    
    //displays post
    public void display()
    {
        super.display();
        System.out.println("Event Type: " + eventType);
    }
    
}
