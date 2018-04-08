package linksharing

import enumeration.Seriousness
import enumeration.Visibility
import grails.util.Holders


class BootStrap {



    def init = { servletContext ->
        log.info("**********************************************")
        println(Holders.grailsApplication.config.server.contextPath)


        //Q3
//
//        log.info("Admin is valid- ${users.first().validate()}")
//        log.info("Admin has errors while validating- ${users.first().hasErrors()}")
//
//        log.info("User is valid- ${users.last().validate()}")
//        log.info("User has errors while validating- ${users.last().hasErrors()}")

        //Q4

        if (User.count() == 0) {
            println("Creating Users")
            createUsers()
            println("Done Creating Users")
        }
        println("Creating Topic")
        createTopic()
        println("Done Creating Topic")

        println("Creating Resource")
          createResource()
        println("done Creating Resource")

        println("Creating subscribe topic")
       subscribeTopic()
        println("done Creating subscribe topic")

        println("Creating reading item")
        createReadingItem()
        println("done Creating reading item")

        println("Creating resource rating")
        createResourceRating()
        println("done Creating resource rating")

    }
    def destroy = {
    }

    List<User> createUsers() {


        List<User> users = []

        User admin = new User(
                firstName:"Payal",
                lastName:"Nigam",
                userName:"payal.nigam",
                password:"payal123",
                email: "payal.nigam@tothenew.com",
                admin:true,
                active: true)

        // admin.topics = []

        /*  Q1
        if(admin.validate()){
            admin.save()
            users.add(admin)
            }
        */

        //Q2
        if (admin.validate()) {
            if (admin.hasErrors()) {
                println(admin.errors)
            }
            admin.save(flush: true, failOnError: true)
            users.add(admin)
        }

        User normal = new User(
                firstName:"pia ",
                lastName:  "mehra",
                userName:  "pia.mehra",
                password:  "pia123",
                email:  "pia.mehra1996@gmail.com",
                admin:false,
                active: true)


        // normal.topics = []

        /* Q1
        if(normal.validate()){
            normal.save()
            users.add(normal)
            }
        */

        //Q2
        if (normal.validate()) {
            if (normal.hasErrors()) {
                println(normal.errors)
            }
            normal.save(flush: true, failOnError: true)
            users.add(normal)
        }

        return users
    }


    def createTopic() {

        List<User> allusers = User.findAll()
        println(allusers)
      int topicCount =0
        allusers.each
                { user ->
                    println(user)
                    if (!(Topic.findByCreatedBy(user)))
                    {
                        5.times {

                            user.refresh()
                            println("Creating topic for user $user with name topic $topicCount")
                            Topic topic = new Topic(topicName:  "topic $topicCount", visibility: Visibility.PRIVATE, createdBy: user)
                            topic.validate()
                            if(topic.hasErrors()) {
                                println topic.errors
                            }
                            topic.save(flush: true, failOnError: true)
                            topicCount++
                        }
                        //   user.save(flush: true, failonerror: true)
                    }

                    user.save(flush: true, failonError: true)
                }

    }


    void createResource()
     {
          List<Topic> allTopics = Topic.getAll()

            allTopics.each {

                Topic temp=it

                if (Resource.findAllByTopic(temp).size()==0)
                {

                (1..2).eachWithIndex
                        {
                            index ,item ->
                                DocumentResource documentResource = new DocumentResource(
                                        createdBy: temp.createdBy,
                                        description: "This document resource with index $index is created by ${temp.createdBy.name} for topic ${temp.topicName}",
                                        topic: temp,
                                        filepath: "/${temp.createdBy.name}/${temp.topicName}/${it}")

                                if (documentResource.save(flush: true)) {
                                    temp.addToResource(documentResource)
                                    //temp.createdBy.addToResource(documentResource)
                                    temp.save(flush: true)
                                    log.info("Saved Successfully : $documentResource")
                                } else
                                    log.error("Error while saving : $documentResource")
                        }


                    (1..2).eachWithIndex { index ,item ->

                        LinkResource linkResource = new LinkResource(
                                createdBy: temp.createdBy,
                                description: "This link resource with index $index is created by ${temp.createdBy.name} for topic ${temp.topicName}",
                                topic: temp,
                                url: "www.${temp.topicName}.com")

                        if (linkResource.save(flush: true)) {
                            temp.addToResource(linkResource)

                            temp.save(flush: true)

                            log.info("Saved Successfully : $linkResource")
                        } else {
                            log.error("Error while saving : $linkResource")
                           // linkResource.errors.allErrors.each { println it }
                        }
                    }
                    // temp.save(flush: true)

                }

        }
    }

    void subscribeTopic() {

        List<User> userList = User.findAll()
        List<Topic> topicList = Topic.findAll()

        userList.each {
            User temp = it
            for (Topic topic : topicList) {
                if (topic.createdBy != temp) {
                    if (!Subscription.findByUserAndTopic(temp, topic)) {
                        Subscription subscription = new Subscription(user: temp, topic: topic, seriousness: Seriousness.SERIOUS)
                        if (!subscription.save(flush: true)) {
                            log.error("Error while saving : $subscription")
                        } else {
                            log.info("Saved Successfully : $subscription")

                        }
                    }
                }
            }
        }
    }

//    void createReadingItem() {
//        List<Subscription> subscriptionList = Subscription.findAll()
//        List<User> userList = User.findAll()
//        subscriptionList.each {
//            for (User user : userList) {
//                if (it.user == user && !user.topic.contains(it.topic))  {
//                    ReadingItem readingItem = new ReadingItem(user: user, isRead: false, resource:it.topic.resource[0] )
//
//                    if(ReadingItem.findAllByUserAndResource(user,it.topic.resource[0]).size()!=0)
//                    {
//                        readingItem.save()
//                    }
//
//                       if (!readingItem.save(flush: true))
//                       {
//                            log.error("Error while saving : $readingItem")
//                        } else {
//                            log.info("Saved Succesfully: $readingItem")
//
//
//
//                    }
//                }
//            }
//        }
//    }

    void createReadingItem() {
     List  <Resource> resourceList = Resource.findAll()

        List<User> userList = User.findAll()

        resourceList.each{
            for (User user : userList)
            {
            if((! Topic.findAllByCreatedByAndTopicName(user,it.topic.topicName)) && (Subscription.findAllByUserAndTopic(user,it.topic)))
            {
                ReadingItem readingItem = new ReadingItem(user: user, isRead: false, resource:it )

                if(ReadingItem.findAllByUserAndResource(user,it).size()==0) {
                    if (readingItem.validate()) {
                        readingItem.save(flush: true)
                        log.info("Saved Succesfully: $readingItem")

                    } else {
                        log.error("Error while saving : $readingItem")
                    }
                }
            }
            }
        }
    }



    void createResourceRating() {

        List<ReadingItem> readingItemList = ReadingItem.findAll()

        println(readingItemList.size())

        if (readingItemList.size()!=0) {
            readingItemList.each { itemList->

                if (!itemList.isRead) {

                    ResourceRating resourceRating = new ResourceRating(resource: itemList.resource, createdBy: itemList.user, score: Math.abs(new Random().nextInt() % 5) + 0)

                    resourceRating.save()
                    if (!resourceRating.save(flush: true)) {
                        println("not save")
                      log.error("Error while saving : $resourceRating")

                    }
                      else {
                        log.info("Saved Successfully : $resourceRating")
                        itemList.isRead = true
                        resourceRating.errors.allErrors.each { println it }
                    }
                }
            }
        }

    }

}





