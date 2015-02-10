package firstapp.core.services.impl;

import firstapp.core.models.entities.Blog;
import firstapp.core.models.entities.BlogEntry;
import firstapp.core.repositories.BlogEntryRepo;
import firstapp.core.repositories.BlogRepo;
import firstapp.core.services.BlogService;
import firstapp.core.services.exceptions.BlogNotFoundException;
import firstapp.core.services.util.BlogEntryList;
import firstapp.core.services.util.BlogList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Rhea on 2/9/15.
 */
@Service
@Transactional
public class BlogServiceImpl implements BlogService{

    @Autowired  //Autowired to repositories
    private BlogRepo blogRepo;

    @Autowired
    private BlogEntryRepo entryRepo;

    @Override
    public BlogEntry createBlogEntry(Long blogId, BlogEntry data){
        Blog blog = blogRepo.findBlog(blogId);
        if(blog == null)
        {
            throw new BlogNotFoundException();
        }
        BlogEntry entry = entryRepo.createBlogEntry(data);
        entry.setBlog(blog);
        return entry;
    }

    @Override
    public BlogList findAllBlogs(){
        return new BlogList(blogRepo.findAllBlogs());
    }

    @Override
    public BlogEntryList findAllBlogEntries(Long blogId){
        Blog blog = blogRepo.findBlog(blogId);
        if(blog == null)
        {
            throw new BlogNotFoundException();
        }
        return new BlogEntryList(blogId,entryRepo.findByBlogId(blogId));
    }

    @Override
    public Blog findBlog(Long id){
        return blogRepo.findBlog(id);
    }
}
