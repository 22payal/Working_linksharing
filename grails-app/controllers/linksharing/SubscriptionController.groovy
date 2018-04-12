package linksharing

import enumeration.Seriousness

class SubscriptionController {

    ReadingItemService readingItemService
    def index() {}


    def subscriptionSave(Integer id) {
        Topic newtopic = Topic.get(params.id)
        Subscription subscription = new Subscription(user: session.user, topic: newtopic, seriousness: "SERIOUS")
        subscription.save()

      Boolean result =  readingItemService.createReadingItem(session.user,newtopic)
        if (result)
        {
            println("reading item added")
        }
        else
        {
            println("reading item not added")
        }

        if (subscription.hasErrors()) {
            flash.message="Error found while saving Subscription"

        } else {
            flash.error="Subscription successfully saved"
            redirect(controller:'user', action:'index')
        }
    }



    def subscriptionDelete() {

        Topic topic= Topic.get(params.id)

        Subscription  subscription = Subscription.findByTopic(topic)

        subscription.delete(flush:true)

        if (subscription.hasErrors()) {
            flash.error = "error"
            render("subscription could not be deleted")

        } else {
            flash.message = "success"
            render("subscription deleted successfully")
        }
    }


}

