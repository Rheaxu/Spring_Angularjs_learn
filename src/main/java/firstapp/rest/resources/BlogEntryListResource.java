package firstapp.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by Rhea on 1/24/15.
 */
public class BlogEntryListResource extends ResourceSupport{
    private List<BlogEntryResource> entries;

    public List<BlogEntryResource> getEntries() {
        return entries;
    }

    public void setEntries(List<BlogEntryResource> entries) {
        this.entries = entries;
    }
}
