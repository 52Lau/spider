package com.lau.spider.GithubSpider.dto;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "github")
@org.hibernate.annotations.Table(appliesTo = "github",comment="github")
public class GitHubDTOs implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer projectID;

    private String projectName;

    @Column(name = "Language")
    private String language;

    private Integer stars;

    private Integer forks;

    private Integer watchers;

    private String description;

    @Column(name = "`firstCommitDate`")
    private Date firstCommitDate;

    @Column(name = "`lastCommitDate`")
    private Date lastCommitDate;

    @Column(name = "Owner")
    private String owner;

    private Integer ownerID;

    private String ownerAvatarUrl;

    @Column(name = "`createDate`")
    private Date createdate;

}
