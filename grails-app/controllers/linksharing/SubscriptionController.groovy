package linksharing

import enumeration.Seriousness

class SubscriptionController {

    def index() {}


    def subscriptionSave(Integer id) {
        Topic newtopic = Topic.load(id)
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
        println(params.id)
       // println(params.id.createdBy)
       // println(params.id.id)
        Topic topic= Topic.findById(params.id)
        Subscription  subscription = Subscription.findByTopic(topic)
      //  Topic currentTopic=  Topic.findByCreatedByAndId(params.id.createdBy,params.id.id)

//        if(currentTopic)
//        {
//            currentTopic.delete()
//
//            if (currentTopic.hasErrors()) {
//                flash.error = "error"
//
//            } else {
//                flash.message = "success"
//            }
//        }
        subscription.delete()


       // render(text: "mjhmjxwdsdgj ${params.id}")

        if (subscription.hasErrors()) {
            flash.error = "error"
            render("subscription could not be deleted")

        } else {
            flash.message = "success"
            render("subscription deleted successfully")
        }
    }


}

