package linksharing

import dto.EmailDTO
import enumeration.Seriousness
import enumeration.Visibility


class TopicController {


    EmailService emailService
    TopicService topicService


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



    def topicDelete(Integer id)
    {
//
        Topic topic = Topic.get(params.id)
        if (!topic)
        {
            flash.error="topic not found"
        }

        else
        {
            topicService.delete(topic)
            render(" topic deleted successfully")
            flash.message="topic deleted"
        }

    }

    //   def topicSave() { }


//     List topicShow(User user)
//    {
//        List<Topic> topics =Topic.findAllByCreatedBy(user)
//        render("${topics.topicName}")
//    }

   def show()
  {
      Topic topic = Topic.findById(params.id)

      render(view: '_topicShow', model: [topic: topic])
  }

    def save() {

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

    def invite()
    {
//        println(params.to)
//        println(params.topicName)
//        render("in topic invite")
        Topic topic = Topic.findByTopicName(params.topicName)

        if (topic && User.findByEmail(params.to))
        {
              //send invite
            println("in if")
            EmailDTO emailDTO = new EmailDTO(to: params.to, subject:"NEW INVITATION" ,from:"payalttn123@gmail.com" , linkId: topic.id , content: "your new subscription")

            println(emailDTO.properties)

            emailService.sendInvitation(emailDTO)

        }
        else
        {
            flash.error= "Desired Topic not found or user not found"
        }
    }

    def join(Integer id)
    {
        printf("in topic join action")

        println(params.link)
        println(params.email)

        Topic topic=Topic.findById(params.link)

        User user= User.findByEmail(params.email)

        Subscription subscription = new Subscription(topic: topic , user: user, seriousness: Seriousness.SERIOUS)

        if (subscription.validate())
        {
            subscription.save()
            flash.message="Subscription saved successfully"
            render("Subscription for that topic created successfully")
        }

        else
        {  subscription.errors.allErrors.each {println(it)}
            flash.error="subscription could not be saved"
            render("Subscription could not be saved")
        }

    }

//    def search()
//    {
//       List<Topic> topicNames = topicService.publicSearch(params.search)
//        List<Topic> adminView = topicService.globalSearch(params.search)
//
//       if(topicNames)
//       {
//        render(view:"searchResult" , model: [topicNames: topicNames])
//       }
//        else {
//           render("no such topic found")
//       }
//
//
//    }

    def changeName(){
        if(topicService.editTopicName(params)){
            flash.message = "Topic Name Changed Successfully"
        }else{
            flash.error= "Error Changing Topic Name"
        }
        redirect(controller: 'user',action: 'index')
    }

    def update(Integer id, String visibility) {

        visibility = Visibility.convertIntoEnum(params.visibility)

        Topic topic = Topic.findById(params.id)
        if (topic) {
            topic.visibility = visibility
            if (topic.validate()) {
                topic.save(flush: true)
                log.info("Saved Successfully : $topic")
                render("SUCCESS")
            } else {
                log.error("Error while Saving : $topic")
                render("FAILURE")
            }
        } else
            render("Topic Not Found")
    }

}
