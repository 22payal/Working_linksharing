package linksharing

import enumeration.Seriousness

class SubscriptionController {

    def index() {}


    def subscriptionSave(Integer id) {
        Topic newtopic = Topic.get(params.id)
        Subscription subscription = new Subscription(user: session.user, topic: newtopic, seriousness: "SERIOUS")
        subscription.save()

        if (subscription.hasErrors()) {
            render("Error found while saving Subscription")

        } else {
            render("Subscription successfully saved")
        }
    }

    def subscriptionUpdate(Integer id, String seriousness) {
        Subscription subscription = Subscription.load(id)

        if ((subscription) && (Seriousness.convertSeriousness(seriousness))) {
            subscription.save()

            if (subscription.hasErrors()) {
                render("Error while saving Subscription ")
            } else {
                render(" Subscription saved without errors")
            }
        } else {
            render("error while updating subscription")
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

