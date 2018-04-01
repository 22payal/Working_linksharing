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

        topicName(blank: false, nullable: false, unique: 'createdBy')
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
                                       seriousness: Seriousness.VerySerious
                                        )
                    subscription.save(flush: true, failOnError: true)
                    //this.addToSubscription(subscription)
                }

    }


    @Override
    public String toString() {
        return "Topic{" +
                "topicName='" + topicName + '\'' +
                '}';
    }
}

