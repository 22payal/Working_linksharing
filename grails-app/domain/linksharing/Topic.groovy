package linksharing

import enumeration.Seriousness
import enumeration.Visibility
import org.springframework.web.context.request.RequestContextHolder

import javax.servlet.http.HttpSession

class Topic {

    String topicName
    Date dateCreated
    Date lastUpdated
    User createdBy

    Visibility visibility


    static hasMany = [resource: Resource]

    static belongsTo = [createdBy: User]

    static constraints = {

        topicName(blank: false, nullable: false)
        createdBy(nullable: false)
        visibility(nullable: false)
    }

    static  mapping = {
        sort 'topicName':"asc"


    }


    void afterInsert() {
        log.info "<--------- After Insert event of topic------>"
        Topic.withNewSession
                {
                    println("creating default subscription")
                    Subscription subscription = new Subscription(
                                       topic: this,
                                       user: this.createdBy,
                                       seriousness: Seriousness.VERYSERIOUS
                                        )
                    subscription.save(flush: true, failOnError: true)
                    //this.addToSubscription(subscription)
                }

    }

    static getTrendingTopics() {
               List<Topic> trendingTopics = Resource.createCriteria().list{
                        projections {
                                groupProperty('topic')
                                count('topic.id', 'count')
                            }
                        order('count', 'desc')
                       maxResults(5)
                    }
        List <Topic> result=[]
        trendingTopics.each {result.add(it[0])}
                  return result
            }

   static Integer getSubscriptions(Topic topic)
    {
       return  Subscription.findAllByTopic(topic).size()
    }

    static Integer getPost(Topic topic)
    {
       return Resource.findAllByTopic(topic).size()
    }

    static List getSubscribedUsers(User user,Topic topic)
    {
        List <Subscription> subscribedTopics = Subscription.findAllByUser(user)

         subscribedTopics.topic.each {
             int subscribedUserscount = Subscription.countByTopic(it)

             return subscribedUserscount - 1
         }
    }


    boolean isPublic(String topicName)
    {

       if(Topic.findByTopicNameAndVisibility(topicName,Visibility.PUBLIC))
           return 1


        else
           return 0
    }

    boolean canViewBy(User user, Topic topic)
    {
        if(isPublic(topic.topicName) || Subscription.findByUserAndTopic(user,topic)||(user.admin))
        return 1

        else
            return 0

    }

    static List getCreatedTopics(User user) {
        List<Topic> createdTopics = Topic.findAllByCreatedBy(user)
        List<Topic> result = []

        createdTopics.each {

            result.add(it)
        }
        return result
    }

    static List <String> getTopicName(User user)
    {
        List <Topic> topic = Topic.findAllByCreatedBy(user)
        List <String>result = []

        topic.topicName.each {
                    result.add(it)
                }
        return  result
    }



    static transients = ['getSubscribedUsers']


    @Override
    public String toString() {
        return "Topic{" +
                "topicName='" + topicName + '\'' +
                '}'
    }

}

