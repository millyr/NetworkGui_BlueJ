import java.util.ArrayList;

public class CommentedPost extends Post
{
    private int likes; 
    private ArrayList<String> comments;
    
    //constructs objects of class Post
    public CommentedPost(String author)
    {
        super(author);
        likes = 0;
        comments = new ArrayList<>();
    }
    // get likes, 
    int displayLikes;
    public String getLikes(){
        displayLikes = this.likes;
        return displayLikes + " ";
    }
    
    String displayComments;
    /*public String getComments(){
        //displayComments = this.comments;
        
    }*/
    //records a 'like' indication from a user
    public void like()
    {
        likes++;
    }
    
    public void unlike()
    {
        if (likes > 0) {
            likes--;
        }
    }
    
    //add a comment to selected post
    public void addComment(String text)
    {
        comments.add(text);
    }
    
    public void display()
    {
        super.display();
        
        if(likes > 0) {
            System.out.println("  -  " + likes + " people like this.");
        }
        else {
            System.out.println();
        }
        
        if(comments.isEmpty()) {
            System.out.println("   No comments.");
        }
        else {
            System.out.println("   " + comments.size() + " comment(s). Click here to view.");
        }
    }
}
