import java.util.ArrayList;

public class Post
{
    private String username; //the username of the post's author
    private long timestamp;
    
    //constructor for the objects of the class post
    public Post(String author)
    {
        username = author;
        timestamp = System.currentTimeMillis();
    }
    
    //returns the time of the creation of the post 
    public long getTimeStamp()
    {
        return timestamp;
    }
    
    //describes how long ago post was created
    public String timeString(long time)
    {
        long current = System.currentTimeMillis();
        long pastMillis = current - time;      // time passed in milliseconds
        long seconds = pastMillis/1000;
        long minutes = seconds/60;
        if(minutes > 0) {
            return minutes + " minutes ago";
        }
        else {
            return seconds + " seconds ago";
        }
    }
    
    //displays the details of post 
    public void display()
    {
        System.out.println(username);
        System.out.println(timeString(timestamp));
    }
}
