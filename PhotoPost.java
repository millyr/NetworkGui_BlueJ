import java.util.ArrayList;

public class PhotoPost extends CommentedPost
{
    private String filename;
    private String caption;
    
    //constructor for objects of class PhotoPost 
    public PhotoPost(String author, String filename, String caption) 
    {
        super(author);
        this.filename = filename; 
        this.caption = caption;
    }
    
    //returns the file name of the image in the post
    public String getImageFile()
    {
        return filename;
    }
    
    //returns the image's caption
    public String getCaption()
    {
        return caption;
    }
    
    //displays details of post
    public void display()
    {
        System.out.println(" [" + filename + "]");
        System.out.println(" " + caption); 
        super.display(); 
    }
}
