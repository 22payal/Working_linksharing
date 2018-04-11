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
//            Resource resource =Resource.get(attrs.id)
            Resource resource1 = LinkResource.get(attrs.id)
            Resource resource2 = DocumentResource.get(attrs.id)

            if ((ReadingItem.findByResourceAndIsRead(resource1,true)) || ReadingItem.findByResourceAndIsRead(resource2, true))
            {
            //out<< "mark as unread"
                out<<"<a href='/ReadingItem/changeisRead/${attrs.id}/${0}'> mark as unread </a>"
            }

            else {
              //  out<<" mark as read"
             out<< "<a href='/ReadingItem/changeisRead /${attrs.id}/${1}'> mark as read  </a>"

            }
        }

    }

    def canDeleteResource={attrs,body->

    }

    def ToggleResource={attrs,body->
        Resource resource1 = LinkResource.get(attrs.id)
        Resource resource2 = DocumentResource.get(attrs.id)

        if(resource1)
        {
            out<<"view url"
        }

        if (resource2)
        {
            out<<"download "
        }

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


    def userImage = { attrs, body ->

        out << "<img src='${createLink(controller: 'user', action: 'fetchUserImage', params: [username: attrs.username])}' " +
                " height='${attrs.height}' width='${attrs.width}'>"
    }

    def adminPageSubscriptionCount={ attrs , body->
        User user = User.get(attrs.id)
       out<< Subscription.findAllByUser(user).size()

    }

    def adminPageTopicCount={ attrs , body->
        User user = User.get(attrs.id)
        out<< Topic.findAllByCreatedBy(user).size()

    }


}
