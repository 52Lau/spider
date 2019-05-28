package com.lau.spider.repository;

import com.lau.spider.GithubSpider.dto.GitHubUserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * MongoDB github 用户信息
 */
public interface GitHubUserRepository extends MongoRepository<GitHubUserInfo, Long> {
    /**
     * Like（模糊查询）
     * {"Name" : name} ( name as regex)
     * */
    List<GitHubUserInfo> findByLoginLike(String Name);

    /**
     * Like（模糊查询）
     * {"Name" : name}
     * */
    List<GitHubUserInfo> findByLogin(String Name);

    /**
     * GreaterThan(大于)
     * {"age" : {"$gt" : age}}
     * */
    List<GitHubUserInfo> findByFollowersGreaterThan(int age);
    /**
     * LessThan（小于）
     * {"age" : {"$lt" : age}}
     * */
    List<GitHubUserInfo> findByFollowersLessThan(int age);
    /**
     * Between（在...之间）
     * {{"age" : {"$gt" : from, "$lt" : to}}
     * */
    List<GitHubUserInfo> findByFollowersBetween(int from, int to);

    /**
     * IsNotNull, NotNull（是否非空）
     *  {"Name" : {"$ne" : null}}
     * */
    List<GitHubUserInfo> findByNameNotNull();

    /**
     * IsNull, Null（是否为空）
     *   {"Name" : null}
     * */
    List<GitHubUserInfo> findByNameNull();


    /**
     * Not（不包含）
     *    {"Name" : {"$ne" : name}}
     * */
    List<GitHubUserInfo> findByNameNot(String name);



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
