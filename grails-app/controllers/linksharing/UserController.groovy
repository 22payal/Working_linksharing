package linksharing

import enumeration.Visibility

class UserController {


    def index() {
        render("user dashboard")
    }

    def show(Integer id) {

        Topic topic = Topic.get(id)
        if (topic.visibility == Visibility.PUBLIC) {
            render("success")
        } else {
            if (Subscription.findByTopicAndUser(topic, session.user))
                render("Subscription Exists")
            else {
                flash.error = "Subscription does not exists"

            }

        }
    }
}
