package linksharing

class LinksharingTagLib {
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    static namespace = "ls"


    def toggleSubscribe={ attrs, body->
//        println(attrs.id.topicName)
//        println(attrs.id.createdBy.userName)

//        Subscription subscription =Subscription.findByUserAndTopic(attrs.id.createdBy,attrs.id)
//       if(subscription) {
//           out << "Unsubscribe"

//          out<< "<a href='/subscription/subscriptionDelete/${attrs.id}'> Unsubscribe </a>"
//       }
//        else
//       {
//          out<<"Subscribe"
//           out<<"<g:link controller='subscription' action='subscriptionDelete' id='${attrs.id}'> Subscribe </g:link>"
//       }

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


}
