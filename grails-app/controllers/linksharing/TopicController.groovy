package linksharing

import dto.EmailDTO
import enumeration.Seriousness
import enumeration.Visibility
import grails.converters.JSON


class TopicController {


    EmailService emailService
    TopicService topicService
    SubscriptionService subscriptionService

    def topicDelete(Integer id) {

        println("topic delete invoked with id ${params.topicId}")

        Topic topic = Topic.get(params.topicId)
        if (!topic) {
            flash.error = "topic not found"
          //  render ([message: "your topic could not be deleted "] as JSON)

        } else {
            topicService.delete(topic)
            flash.message = "topic deleted"
            //render ([message: "your topic is now deleted "] as JSON)
        }

    }


    def show() {
        Topic topic = Topic.findById(params.id)

        render(view: '/topic/_topicShow', model: [topic: topic])
    }

    def save() {

        Topic topic = new Topic(createdBy: session.user, visibility: Visibility.convert(params.visibility), topicName: params.topicName)


        if (topic.validate()) {
            topic.save()
            flash.message = "Topic is now saved"
            render("topic saved successfully")

            redirect(controller: 'User', action: 'index')
        } else {
            flash.error = "Topic is not saved"
            render("error during saving topic")
            topic.errors.allErrors.each { println(it) }

        }

    }

    def invite() {

        Topic topic = Topic.findByTopicName(params.topicName)

        if (topic && User.findByEmail(params.to)) {

            EmailDTO emailDTO = new EmailDTO(to: params.to, subject: "NEW INVITATION", from: "payalttn123@gmail.com", linkId: topic.id, content: "your new subscription")

            println(emailDTO.properties)

            emailService.sendInvitation(emailDTO)

        } else {
            flash.error = "Desired Topic not found or user not found"
        }
    }

    def join(Integer id) {
        Topic topic = Topic.findById(params.link)

        User user = User.findByEmail(params.email)

        Subscription subscription = new Subscription(topic: topic, user: user, seriousness: Seriousness.SERIOUS)

        if (subscription.validate()) {
            subscription.save()
            flash.message = "Subscription saved successfully"
            render("Subscription for that topic created successfully")
        } else {
            subscription.errors.allErrors.each { println(it) }
            flash.error = "subscription could not be saved"
            render("Subscription could not be saved")
        }

    }

    def search() {
        // println("in topic search with search params ${params.search}")


        List<Topic> topicNames = topicService.publicSearch(params.search)
        // List<Topic> adminView = topicService.globalSearch(params.search)
          println("in search waiting to send : ${topicNames}")

        if (topicNames) {
            //  println("sending...")
            render(view: "/topic/searchResult", model: [topicNames: topicNames])
//           render("hello ")
        } else {
            render("no such topic found")
        }


    }

    def changeTopicData() {
        if ((topicService.editTopicName(params)) && (topicService.update(params)) && (subscriptionService.update(params))) {
            flash.message = "Topic data Changed Successfully"
        } else {
            flash.error = "Error Changing Topic data"
        }
        redirect(controller: 'user', action: 'index')
    }

}
