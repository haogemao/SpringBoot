package com.person.springboot.domain.es;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;

import org.aspectj.apache.bcel.generic.FieldGen;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import com.person.springboot.domain.Blog;


/**
 * Blog.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�3鏈�5鏃�
 */
@Document(indexName = "blog", type = "blog")
@XmlRootElement // MediaType 杞负 XML
public class EsBlog implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id  // 涓婚敭
    private String id;
    //	@Field(index = FieldGen.not_analyzed)
    private Long blogId; // Blog 鐨� id

    private String title;

    private String summary;

    private String content;

    //	@Field(index = FieldIndex.not_analyzed)  // 涓嶅仛鍏ㄦ枃妫�绱㈠瓧娈�
    private String username;
    //	@Field(index = FieldIndex.not_analyzed)  // 涓嶅仛鍏ㄦ枃妫�绱㈠瓧娈�
    private String avatar;
    //	@Field(index = FieldIndex.not_analyzed)  // 涓嶅仛鍏ㄦ枃妫�绱㈠瓧娈�
    private Timestamp createTime;
    //	@Field(index = FieldIndex.not_analyzed)  // 涓嶅仛鍏ㄦ枃妫�绱㈠瓧娈�
    private Integer readSize = 0; // 璁块棶閲忋�侀槄璇婚噺
    //	@Field(index = FieldIndex.not_analyzed)  // 涓嶅仛鍏ㄦ枃妫�绱㈠瓧娈�
    private Integer commentSize = 0;  // 璇勮閲�
    //	@Field(index = FieldIndex.not_analyzed)  // 涓嶅仛鍏ㄦ枃妫�绱㈠瓧娈�
    private Integer voteSize = 0;  // 鐐硅禐閲�

    private String tags;  // 鏍囩

    protected EsBlog() {  // JPA 鐨勮鑼冭姹傛棤鍙傛瀯閫犲嚱鏁帮紱璁句负 protected 闃叉鐩存帴浣跨敤
    }

    public EsBlog(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public EsBlog(Long blogId, String title, String summary, String content, String username, String avatar, Timestamp createTime,
                  Integer readSize, Integer commentSize, Integer voteSize, String tags) {
        this.blogId = blogId;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.username = username;
        this.avatar = avatar;
        this.createTime = createTime;
        this.readSize = readSize;
        this.commentSize = commentSize;
        this.voteSize = voteSize;
        this.tags = tags;
    }

    public EsBlog(Blog blog) {
        this.blogId = blog.getId();
        this.title = blog.getTitle();
        this.summary = blog.getSummary();
        this.content = blog.getContent();
        this.username = blog.getUser().getUsername();
        this.avatar = blog.getUser().getAvatar();
        this.createTime = blog.getCreateTime();
        this.readSize = blog.getReadSize();
        this.commentSize = blog.getCommentSize();
        this.voteSize = blog.getVoteSize();
        this.tags = blog.getTags();
    }

    public void update(Blog blog) {
        this.blogId = blog.getId();
        this.title = blog.getTitle();
        this.summary = blog.getSummary();
        this.content = blog.getContent();
        this.username = blog.getUser().getUsername();
        this.avatar = blog.getUser().getAvatar();
        this.createTime = blog.getCreateTime();
        this.readSize = blog.getReadSize();
        this.commentSize = blog.getCommentSize();
        this.voteSize = blog.getVoteSize();
        this.tags = blog.getTags();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getReadSize() {
        return readSize;
    }

    public void setReadSize(Integer readSize) {
        this.readSize = readSize;
    }

    public Integer getCommentSize() {
        return commentSize;
    }

    public void setCommentSize(Integer commentSize) {
        this.commentSize = commentSize;
    }

    public Integer getVoteSize() {
        return voteSize;
    }

    public void setVoteSize(Integer voteSize) {
        this.voteSize = voteSize;
    }

    public String getTags() {
        return tags;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, title='%s', content='%s']",
                blogId, title, content);
    }
}
