package linksharing

import enumeration.Visibility
import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ReadingItemSpec extends Specification implements DomainUnitTest<ReadingItem> {

    def setup() {
    }

    def cleanup() {
    }

//    void "test something"() {
//        expect:"fix me"
//            true == false
//    }

    def "isRead should not be null"(){
        setup:
        String email = "payal.nigam@tothenew.com"
        String password = 'payal123'
        User user = new User(
                email: email,
                userName:"payalNigam",
                password:password,
                firstName: "Payal",
                lastName: "Nigam",
                admin:false,
                active:true
        )
        user.save()
        Topic topic = new Topic(name:"sd",visibility: Visibility.PUBLIC,createdBy: user)
       topic.save()
        Resource resource=new LinkResource(url: "www.google.com",description: "abhabhab",user: user,topic: topic)
        resource.save()
        ReadingItem readingItem1=new ReadingItem(isRead: null,user:user,resource:resource)
        ReadingItem readingItem2=new ReadingItem(isRead:0,user:user,resource:resource)

        when:
        readingItem1.save()
        then:
        readingItem1.errors.getFieldErrorCount('isRead')==1
        readingItem1.errors.hasErrors()==true


        when:
        readingItem2.save()
        then:
        ReadingItem.count==1
    }
    def "user should not be null"() {
        setup:
        String email = "payal.nigam@tothenew.com"
        String password = 'payal123'
        User user = new User(
                email: email,
                userName:"payalNigam",
                password:password,
                firstName: "Payal",
                lastName: "Nigam",
                admin:false,
                active:true
        )
        user.save()
        Topic topic = new Topic(name:"sd",visibility: Visibility.PUBLIC,createdBy: user)
        topic.save()
        Resource resource=new LinkResource(url: "www.google.com",description: "abhabhab",user: user,topic: topic)
       resource.save()
        ReadingItem readingItem1 = new ReadingItem(isRead: true, user: null, resource: resource)
        ReadingItem readingItem2 = new ReadingItem(isRead: true, user: user, resource: resource)

        when:
        readingItem1.save()
        then:
        readingItem1.errors.getFieldErrorCount('user') == 1

        when:
        readingItem2.save()
        then:

        readingItem2.count==1

    }




    def "resource should not be null"(){
        setup:
        String email = "payal.nigam@tothenew.com"
        String password = 'payal123'
        User user = new User(
                email: email,
                userName:"payalNigam",
                password:password,
                firstName: "Payal",
                lastName: "Nigam",
                admin:false,
                active:true
        )
        user.save()

        Topic topic = new Topic(name:"sd",visibility: Visibility.PUBLIC,createdBy: user)
        topic.save()
        Resource resource=new LinkResource(url: "www.google.com",description: "abhabhab",user: user,topic: topic)
        resource.save()
        ReadingItem readingItem1=new ReadingItem(isRead: true,user:user,resource:null)
        ReadingItem readingItem2=new ReadingItem(isRead: true,user:user,resource:resource)


        when:
        readingItem1.save()
        then:
        readingItem1.errors.getFieldErrorCount('resource')==1
        readingItem1.hasErrors()==true

        when:
        readingItem2.save()
        then:
        readingItem2.count==1
    }

    def "Readingitem resource should be unique per user"(){
        setup:
        String email = "payal.nigam@tothenew.com"
        String password = 'payal123'
        User user = new User(
                email: email,
                userName:"payalNigam",
                password:password,
                firstName: "Payal",
                lastName: "Nigam",
                admin:false,
                active:true
        )
        user.save()
        Topic topic = new Topic(name:"sd",visibility: Visibility.PUBLIC,createdBy: user)
        topic.save()
        Resource resource=new LinkResource(url: "www.google.com",description: "abhabhab",user: user,topic: topic)
        resource.save()
        ReadingItem readingItem1=new ReadingItem(isRead: true,user:user,resource:resource)

        ReadingItem readingItem2=new ReadingItem(isRead: true,user:user,resource:resource)

        ReadingItem readingItem3=new ReadingItem(isRead: true,user:user,resource:resource)


        when:
        readingItem1.save()

        then:
        readingItem1.count==1


        when:
        readingItem2.save()
        then:
        readingItem2.errors.hasErrors()==true

        when:
        readingItem3.save()

        then:
        readingItem3.errors.hasErrors()==true

    }
}
