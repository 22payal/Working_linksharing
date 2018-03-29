package linksharing

import enumeration.Visibility
import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class LinkResourceSpec extends Specification implements DomainUnitTest<LinkResource> {

    def setup() {
    }

    def cleanup() {
    }

//    void "test something"() {
//        expect:"fix me"
//            true == false
//    }

    def "url field should contain valid url"() {
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
        Topic topic = new Topic(name: "Grails domain1", visibility: Visibility.PUBLIC, createdBy: user)
        topic.save()
        Resource resource=new LinkResource(url: "www.google.com",description: "abhabhab",user: user,topic: topic)
        resource.save()
        LinkResource linkResource1 = new LinkResource(url: "www.google.com", user: user, topic: topic, description: "aaaaaaa")
        LinkResource linkResource2 = new LinkResource(url: "www", user: user, topic: topic, description: "aaaaaaa")
        LinkResource linkResource3 = new LinkResource(url: " ", user: user, topic: topic, description: "aaaaaaa")
        LinkResource linkResource4 = new LinkResource(url:null, user: user, topic: topic, description: "aaaaaaa")


        when:
        linkResource1.save()

        then:
        LinkResource.count == 1

        when:
        linkResource2.save()
        then:
        linkResource2.errors.hasErrors()==1

        when:
        linkResource3.save()
        then:
        linkResource3.errors.hasErrors()==1

        when:
        linkResource4.save()
        then:
        linkResource4.errors.hasErrors()==1

    }
}
