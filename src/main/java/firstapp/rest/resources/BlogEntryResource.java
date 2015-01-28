package firstapp.rest.resources;

import firstapp.core.models.entities.BlogEntry;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Rhea on 1/24/15.
 */
public class BlogEntryResource extends ResourceSupport{
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BlogEntry toBlogEntry(){
        BlogEntry entry = new BlogEntry();
        entry.setTitle(title);
        return entry;
    }
}
