package com.lau.spider.repository;

import com.lau.spider.GithubSpider.dto.GitHubDTO;
import com.lau.spider.GithubSpider.dto.GitHubUserRepo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * MongoDB github用后仓库
 */
public interface GitHubRepository extends MongoRepository<GitHubUserRepo, Long> {
    /**
     * Like（模糊查询）
     * {"Name" : name} ( name as regex)
     * */
    List<GitHubUserRepo> findByNameLike(String Name);

    /**
     * Like（模糊查询）
     * {"Name" : name}
     * */
    List<GitHubUserRepo> findByName(String Name);

    /**
     * GreaterThan(大于)
     * {"age" : {"$gt" : age}}
     * */
    List<GitHubUserRepo> findByForksGreaterThan(int age);
    /**
     * LessThan（小于）
     * {"age" : {"$lt" : age}}
     * */
    List<GitHubUserRepo> findByForksLessThan(int age);
    /**
     * Between（在...之间）
     * {{"age" : {"$gt" : from, "$lt" : to}}
     * */
    List<GitHubUserRepo> findByForksBetween(int from, int to);

    /**
     * IsNotNull, NotNull（是否非空）
     *  {"Name" : {"$ne" : null}}
     * */
    List<GitHubUserRepo> findByNameNotNull();

    /**
     * IsNull, Null（是否为空）
     *   {"Name" : null}
     * */
    List<GitHubUserRepo> findByNameNull();


    /**
     * Not（不包含）
     *    {"Name" : {"$ne" : name}}
     * */
    List<GitHubUserRepo> findByNameNot(String name);



    /**
     *  Near（查询地理位置相近的）
     *  {"location" : {"$near" : [x,y]}}
     * */
    // findByLocationNear(Point point)


    /**
     * Within（在地理位置范围内的）
     *   {"location" : {"$within" : {"$center" : [ [x, y], distance]}}}
     * */
    //findByLocationWithin(Circle circle)


    /**
     *   Within（在地理位置范围内的）
     *     {"location" : {"$within" : {"$box" : [ [x1, y1], x2, y2]}}}
     * */
    // findByLocationWithin(Box box)
}
