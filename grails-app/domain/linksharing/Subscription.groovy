package linksharing


import enumeration.Seriousness


class Subscription {
    Topic topic
    User user
    Date dateCreated
    Seriousness seriousness


    static belongsTo = [topic:Topic,user:User]

    static constraints = {
        user (nullable: false )
        topic(nullable: false , unique:'user')
        seriousness(nullable:false)

    }

    static mapping = {
        seriousness defaultValue: Seriousness.SERIOUS
        user fetch: 'join'
        topic fetch: 'join'
    }

    List getSubscribedUser(){
              List subscribedTopics=this.user.toList(){
                   maxResults(5)
               }
                 return subscribedTopics

            }

static transients = ['subscribedUser']

}
