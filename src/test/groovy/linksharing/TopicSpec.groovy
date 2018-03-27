package linksharing

import enumeration.Visibility
import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TopicSpec extends Specification implements DomainUnitTest<Topic> {

    def setup() {
    }

    def cleanup() {
    }

//    void "test something"() {
//        expect:"fix me"
//            true == false
//    }

    def "Topic name should be unique per user"() {

        setup:
        String email = "payal.nigam@tothenew.com"
        User user = new User(
                email: email,
                userName: "payalNigam",
                password: "payal123",
                firstName: "Payal",
                lastName: "Nigam",
                admin: false,
                active: true
        )
        user.save()

        String email1 = "payalnigam@tothenew.com"
        User user1 = new User(
                email: email,
                userName: "payalNigam1",
                password: "payal1234",
                firstName: "Payal",
                lastName: "Nigam",
                admin: false,
                active: true
        )
        user1.save()

        Topic topic1 = new Topic()
        topic1.createdBy = user
        topic1.topicName = "topic"
        topic1.visibility = Visibility.PRIVATE

        Topic topic2 = new Topic()
        topic2.topicName = "topic"
        topic2.createdBy = user1
        topic2.visibility = Visibility.PUBLIC


        when:
        topic1.save(flush: true)

        then:
        topic1.count == 1


        when:
        topic2.save()

        then:
        topic2.errors.hasErrors() == true

    }

    def "Topic name should not be null or blank"() {

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

        Topic topic1 = new Topic()
        topic1.createdBy = user
        topic1.topicName = "topic"
        topic1.visibility = Visibility.PRIVATE

        Topic topic2 = new Topic()
        topic2.topicName = " "
        topic2.createdBy = user
        topic2.visibility = Visibility.PUBLIC

        Topic topic3 = new Topic()
        topic3.topicName = null
        topic3.createdBy = user
        topic3.visibility = Visibility.PUBLIC


        when:

        topic1.save(flush: true)

        then:
        topic1.count == 1

        when:
        topic2.save(flush: true)

        then:
        topic2.errors.hasErrors() == true

        when:
        topic3.save(flush: true)

        then:
        topic3.errors.hasErrors() == true


    }

    def "Visiblity of topic should not be null"() {

        given:
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
        Topic topic1 = new Topic()
        topic1.createdBy = user
        topic1.topicName = "first topic"
        topic1.visibility = Visibility.PUBLIC

        Topic topic2 = new Topic()
        topic2.topicName = "second topic"
        topic2.createdBy = user
        topic2.visibility = null


        when:
        topic1.save()

        then:
        topic1.count == 1

        when:
        topic2.save()

        then:
        topic2.errors.hasErrors() == true

    }

    def "Created by should not be null"() {
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

        Topic topic1 = new Topic()
        topic1.createdBy = user
        topic1.topicName = "first topic"
        topic1.visibility = Visibility.PUBLIC

        Topic topic2 = new Topic()
        topic2.topicName = "second topic"
        topic2.createdBy = null
        topic2.visibility = Visibility.PRIVATE

        when:
        topic1.save()


        then:

        topic1.count == 1

        when:
        topic2.save()

        then:

        topic2.errors.hasErrors() == true

    }

}
