package linksharing

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class DocumentResourceSpec extends Specification implements DomainUnitTest<DocumentResource> {

    def setup() {
    }

    def cleanup() {
    }

//    void "test something"() {
//        expect:"fix me"
//            true == false
//    }

    def "filePath should not be null or blank"(){
        setup:
//        String email = "payal.nigam@tothenew.com"
//        String password = "payal123"
//        User user = new User()
//        user.email=email
//        user.password=password
//        user.userName ="payalNigam"
//        user.firstName="Payal"
//        user.lastName ="Nigam"
//        user.admin=false
//        user.active=true
//
//        user.save()
//
//        Topic topic1 = new Topic()
//        topic1.createdBy = user
//        topic1.topicName = "first topic"
//        topic1.visibility = Visibility.PUBLIC
//
//        topic1.save()

        DocumentResource documentResource1 = new DocumentResource()
        documentResource1.filepath= "payal/file.txt"

        DocumentResource documentResource2 = new DocumentResource()
        documentResource1.filepath= " "

        DocumentResource documentResource3 = new DocumentResource()
        documentResource1.filepath= null

        when:
        documentResource1.save()
        then:
        documentResource1.count==1

        when:
        documentResource2.save()
        then:
        documentResource2.errors.hasErrors()==true

        when:
        documentResource3.save()

        then:
        documentResource3.errors.hasErrors()==true

    }
}
