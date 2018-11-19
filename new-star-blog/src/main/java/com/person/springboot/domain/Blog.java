package com.person.springboot.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.elasticsearch.annotations.Document;

import com.github.rjeschke.txtmark.Processor;

/**
 * Blog 瀹炰綋
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�4鏈�7鏃�
 */
@Entity // 瀹炰綋
@Document(indexName = "blog", type = "blog")
public class Blog implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // 涓婚敭
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 鑷闀跨瓥鐣�
    private Long id; // 鐢ㄦ埛鐨勫敮涓�鏍囪瘑

    @NotEmpty(message = "鏍囬涓嶈兘涓虹┖")
    @Size(min = 2, max = 50)
    @Column(nullable = false, length = 50) // 鏄犲皠涓哄瓧娈碉紝鍊间笉鑳戒负绌�
    private String title;

    @NotEmpty(message = "鎽樿涓嶈兘涓虹┖")
    @Size(min = 2, max = 300)
    @Column(nullable = false) // 鏄犲皠涓哄瓧娈碉紝鍊间笉鑳戒负绌�
    private String summary;

    @Lob  // 澶у璞★紝鏄犲皠 MySQL 鐨� Long Text 绫诲瀷
    @Basic(fetch = FetchType.LAZY) // 鎳掑姞杞�
    @NotEmpty(message = "鍐呭涓嶈兘涓虹┖")
    @Size(min = 2)
    @Column(nullable = false) // 鏄犲皠涓哄瓧娈碉紝鍊间笉鑳戒负绌�
    private String content;

    @Lob  // 澶у璞★紝鏄犲皠 MySQL 鐨� Long Text 绫诲瀷
    @Basic(fetch = FetchType.LAZY) // 鎳掑姞杞�
    @NotEmpty(message = "鍐呭涓嶈兘涓虹┖")
    @Size(min = 2)
    @Column(nullable = false) // 鏄犲皠涓哄瓧娈碉紝鍊间笉鑳戒负绌�
    private String htmlContent; // 灏� md 杞负 html

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false) // 鏄犲皠涓哄瓧娈碉紝鍊间笉鑳戒负绌�
    @org.hibernate.annotations.CreationTimestamp  // 鐢辨暟鎹簱鑷姩鍒涘缓鏃堕棿
    private Timestamp createTime;

    @Column(name = "readSize")
    private Integer readSize = 0; // 璁块棶閲忋�侀槄璇婚噺

    @Column(name = "commentSize")
    private Integer commentSize = 0;  // 璇勮閲�

    @Column(name = "voteSize")
    private Integer voteSize = 0;  // 鐐硅禐閲�


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "blog_comment", joinColumns = @JoinColumn(name = "blog_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id", referencedColumnName = "id"))
    private List<Comment> comments;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "blog_vote", joinColumns = @JoinColumn(name = "blog_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "vote_id", referencedColumnName = "id"))
    private List<Vote> votes;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;

    @Column(name = "tags", length = 100)
    private String tags;  // 鏍囩

    protected Blog() {
        // TODO Auto-generated constructor stub
    }

    public Blog(String title, String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.htmlContent = Processor.process(content);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public String getHtmlContent() {
        return htmlContent;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
        this.commentSize = this.comments.size();
    }

    /**
     * 娣诲姞璇勮
     *
     * @param comment
     */
    public void addComment(Comment comment) {
        this.comments.add(comment);
        this.commentSize = this.comments.size();
    }

    /**
     * 鍒犻櫎璇勮
     *
     * @param comment
     */
    public void removeComment(Long commentId) {
        for (int index = 0; index < this.comments.size(); index++) {
            if (comments.get(index).getId() == commentId) {
                this.comments.remove(index);
                break;
            }
        }

        this.commentSize = this.comments.size();
    }

    /**
     * 鐐硅禐
     *
     * @param vote
     * @return
     */
    public boolean addVote(Vote vote) {
        boolean isExist = false;
        // 鍒ゆ柇閲嶅
        for (int index = 0; index < this.votes.size(); index++) {
            if (this.votes.get(index).getUser().getId() == vote.getUser().getId()) {
                isExist = true;
                break;
            }
        }

        if (!isExist) {
            this.votes.add(vote);
            this.voteSize = this.votes.size();
        }

        return isExist;
    }

    /**
     * 鍙栨秷鐐硅禐
     *
     * @param voteId
     */
    public void removeVote(Long voteId) {
        for (int index = 0; index < this.votes.size(); index++) {
            if (this.votes.get(index).getId() == voteId) {
                this.votes.remove(index);
                break;
            }
        }

        this.voteSize = this.votes.size();
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
        this.voteSize = this.votes.size();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

}
