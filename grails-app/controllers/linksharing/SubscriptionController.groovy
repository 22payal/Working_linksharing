package linksharing

import enumeration.Seriousness
import grails.converters.JSON

class SubscriptionController {

    ReadingItemService readingItemService
    def index() {}


    def subscriptionSave(Integer id) {
        Topic newtopic = Topic.get(params.id)
        Subscription subscription = new Subscription(user: session.user, topic: newtopic, seriousness: "SERIOUS")
        subscription.save()

      Boolean result =  readingItemService.createReadingItem(session.user,newtopic)

        if (subscription.hasErrors()) {
            flash.error="Error found while saving Subscription"
            render ([error: "your subscription could not be saved "] as JSON)

        } else {
            flash.message="Subscription successfully saved"
            render ([message: "your subscription saved successfully "] as JSON)
            //redirect(controller:'user', action:'index')
        }
    }



    def subscriptionDelete() {

        println("delte subs was invoked with id ${params.topicId}")

        Topic topic= Topic.get(params.topicId)

        Subscription  subscription = Subscription.findByTopic(topic)

        subscription.delete(flush:true)


        if (subscription.hasErrors()) {
            flash.error = "error"
            println("has error")
            render ([error: "your subscription could not be deleted "] as JSON)

        } else {
            flash.message = "success"
            println("delted")

            render ([message: "your subscription is now deleted "] as JSON)
        }


    }

    def updateSeriousness()
    {

        println("i was invoked with seriousness ${params.categoryId} and id ${params.id} ")

        Subscription subscription = Subscription.findBySeriousness()

        subscription.seriousness = (params.categoryId)
        subscription.save(flush:true)

        render subscription as JSON
    }


}

