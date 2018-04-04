package linksharing

import co.ResourceSearchCo
import enumeration.Visibility


class TopicController {

//    def index() {
//
//    }


//
//    def topicShow(ResourceSearchCo resourceSearchCo)
//    {
//        Topic topic = Resource.search(resourceSearchCo)
//        render("CreatedBy- $topic.createdBy.firstName having Topicname- $topic.topicName")
//
//
//    }



//    def topicDelete(Integer id)
//    {
//        Topic topic=Topic.load(id)
//    }
//
    //   def topicSave() { }

     List topicShow(User user)
    {
        List<Topic> topics =Topic.findAllByCreatedBy(user)
        render("${topics.topicName}")
    }


    def save() {

      //  render(params.topicName)
       //  render(visibility)
      //   render(params.visibility)
      // String visibility="public"

        Topic topic = new Topic(createdBy: session.user, visibility: Visibility.convertIntoEnum(params.visibility), topicName:params.topicName)


        if (topic.validate()) {
            topic.save()
            flash.message = "Topic is now saved"
            render("topic saved successfully")

            redirect(controller:'User', action:'index')
        } else {
            flash.error = "Topic is not saved"
            render("error during saving topic")
            topic.errors.allErrors.each {println(it)}

        }

    }


}
