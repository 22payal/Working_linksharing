package linksharing

import enumeration.Seriousness
import enumeration.Visibility
import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification


class SubscriptionSpec extends Specification implements DomainUnitTest<Subscription> {

    def setup() {
    }

    def cleanup() {
    }

//    void "test something"() {
//        expect:"fix me"
//            true == false
//    }

    def "User should not be null"() {
        setup:
        String email = "payal.nigam@tothenew.com"
        String password = "payal123"
        User user = new User(
                email: email,
                userName: "payalNigam",
                password: password,
                firstName: "Payal",
                lastName: "Nigam",
                admin: false,
                active: true
        )
        user.save()

        Topic topic = new Topic()
        topic.createdBy = user
        topic.topicName = "first topic"
        topic.visibility = Visibility.PUBLIC

        topic.save()

        Subscription subscription1 = new Subscription()
        subscription1.user = user
        subscription1.topic = topic
        subscription1.seriousness = Seriousness.VerySerious


        Subscription subscription2=new Subscription()
        subscription2.user = null
        subscription2.topic= null
        subscription2.seriousness= Seriousness.VerySerious


        when:
        subscription1.save(flush: true)

        then:
        subscription1.count() == 1

        when:
        subscription2.save(flush:true)

        then:
        subscription2.errors.hasErrors()==true


    }

    def "Topic should not be null"() {
        setup:
        String email = "payal.nigam@tothenew.com"
        String password = 'payal123'
        User user = new User(
                email: email,
                userName: "payalNigam",
                password: password,
                firstName: "Payal",
                lastName: "Nigam",
                admin: false,
                active: true
        )
        user.save()
        Topic topic = new Topic(name: "grails", visibility: Visibility.PUBLIC, createdBy: user)
    topic.save()
        when:
        Subscription subscription = new Subscription(
                seriousness: Seriousness.VerySerious,
                user: user,
                topic: null
        )
        subscription.validate()
        topic.addToSubscription(subscription)
        user.addToTopic(topic)
        user.addToSubscription(subscription)
        user.save(flush: true)

        then:
        subscription.errors.hasErrors() == true
    }

    def "User should not be able to subscribe to topic multiple times "() {
        setup:
        String email = "payal.nigam@tothenew.com"
        String password = 'payal123'
        User user = new User
                (
                        email: email,
                        userName: "payalNigam",
                        password: password,
                        firstName: "Payal",
                        lastName: "Nigam",
                        admin: false,
                        active: true
                )
        user.save()

        Topic topic = new Topic(name: "grails", visibility: Visibility.PUBLIC, createdBy: user)
        topic.save()

        Subscription subscription1 = new Subscription(seriousness: Seriousness.VerySerious, user: user, topic: topic)
        Subscription subscription2 = new Subscription(seriousness: Seriousness.Serious, user: user, topic: topic)

        when:
        subscription1.save()
        then:
        subscription1.count==1

        when:
        subscription2.save()


        then:
        subscription2.errors.hasErrors() == true
    }

    def "Seriousness should not be null"() {

        setup:
        String email = "payal.nigam@tothenew.com"
        String password = "payal123"
        User user = new User
                (
                        email: email,
                        userName: "payalNigam",
                        password: password,
                        firstName: "Payal",
                        lastName: "Nigam",
                        admin: false,
                        active: true
                )

        user.save()
        Topic topic = new Topic(name: "grails", visibility: Visibility.PUBLIC, createdBy: user)
         topic.save()

        Subscription subscription1 = new Subscription(seriousness: Seriousness.VerySerious, user: user, topic: topic)
        Subscription subscription2 = new Subscription(seriousness: null, user: user, topic: topic)

        when:
        subscription1.save()
        then:
        subscription1.count == 1

        when:
       subscription2.save()
        then:
        subscription2.errors.hasErrors() == true

    }


}
