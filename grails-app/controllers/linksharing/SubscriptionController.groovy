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

    def update(Integer id, String seriousness) {

        seriousness = Seriousness.convertSeriousness(params.seriousness)
        Subscription subscription = Subscription.findById(params.id)
        if (subscription) {
            subscription.seriousness = seriousness
            if (subscription.save(flush: true)) {
                log.info("Saved Successfully : $subscription")
                render("SUCCESS")
            } else {
                log.error("Error while Saving : $subscription")
                render("FAILURE")
            }
        } else
            render("SUBSCRIPTION NOT FOUND")
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

