package linksharing

class LinksharingTagLib {
    static defaultEncodeAs = [taglib:'text']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    static namespace = "ls"


    def toggleSubscribe={ attrs, body->

        Topic topic = Topic.get(attrs.id)

        Subscription subscription =Subscription.findByUserAndTopic(session.user,topic)
       if(subscription) {
//           out << "Unsubscribe"

          out<< "<a href='/subscription/subscriptionDelete/${attrs.id}'> Unsubscribe </a>"
       }
        else
       {
//          out<<"Subscribe"
           out<< "<a href='/subscription/subscriptionSave/${attrs.id}'> subscribe </a>"
       }

    }

    def markAsRead={attrs,body->

        if (ReadingItem.findByUser(session.user))
        {
            Resource resource1 = LinkResource.load(attrs.id)
            Resource resource2 = DocumentResource.load(attrs.id)

            if ((ReadingItem.findByResourceAndIsRead(resource1,true)) || ReadingItem.findByResourceAndIsRead(resource2, true))
            {
            out<< "mark as unread"
            }

            else {
                out<<" mark as read"

            }
        }

    }

    def canDeleteResource={attrs,body->

    }

    def subscriptionCount={attrs,body->
        out << Subscription.findAllByTopic(attrs.id).size()

    }

    def inboxSubscriptionCount={attrs,body->
        Topic topic = Topic.findById(attrs.id)
        out << Subscription.findAllByTopic(topic).size()

    }

    def inboxResourceCount={attrs,body->
        Topic topic = Topic.findById(attrs.id)
        out << Resource.findAllByTopic(topic).size()

    }
    def resourceCount={attrs,body->
        out << Resource.findAllByTopic(attrs.id).size()

    }

    def topicCount={
        out<< Topic.findAllByCreatedBy(session.user).size()
    }

    def userSubscriptionCount={
        out<< Subscription.findAllByUser(session.user).size()
    }

    def particularUserSubscriptionCount={
        attr,body->
            out<< Topic.findAllByCreatedBy(attr.id).size()

    }

//    def userImg={
//        attrs,body->
//            User.findById()
//    }

    def userImage = { attrs, body ->
        out << "<img src='${createLink(controller: 'user', action: 'fetchUserImage', params: [username: attrs.username])}' " +
                " height='${attrs.height}' width='${attrs.width}'>"
    }


}
